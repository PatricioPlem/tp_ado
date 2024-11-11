package com.uade.gympal.Service;
import com.uade.gympal.Repository.Entity.CurrentUserHolder;
import com.uade.gympal.Repository.Entity.Medicion;
import com.uade.gympal.Repository.Entity.Observer.IObservable;
import com.uade.gympal.Repository.Entity.Observer.Observador;
import com.uade.gympal.Repository.Entity.Socio;
import com.uade.gympal.Repository.Entity.Trofeos.TrofeoCreido;
import com.uade.gympal.Repository.MedicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class MedicionService implements IObservable {

    @Autowired
    private MedicionRepository medicionRepository;

    @Transient
    private List<Observador> observers;

    public MedicionService() {
        observers = new ArrayList<Observador>();
        agregar(new TrofeoCreido());
    }

    public Medicion addMeasurement(Medicion medida) {
        if (CurrentUserHolder.getCurrentUser() != null){
            medida.setSocio(CurrentUserHolder.getCurrentUser());
            medida.setDateTime(LocalDateTime.now()); // Set the timestamp before saving

            if (esSocioCreido(CurrentUserHolder.getCurrentUser())) {
                notificarObservadores();
            }

            return medicionRepository.save(medida);
        }
        throw new RuntimeException("UNAUTHORIZED");
    }

    public List<Medicion> getMeasurements() {
        if (CurrentUserHolder.getCurrentUser()!= null){
            return medicionRepository.findBySocioId(CurrentUserHolder.getCurrentUser().getId());
        }
        throw new RuntimeException("UNAUTHORIZED");

    }

    public boolean esSocioCreido(Socio socio) {
        LocalDateTime haceUnMes = LocalDateTime.now().minusMonths(1);
        List<Medicion> mediciones = medicionRepository.findBySocioIdAndDateTimeAfter(socio.getId(), haceUnMes);
        return mediciones.size() > 3;
    }

    @Override
    public void agregar(Observador observador) {
    observers.add(observador);
    }

    @Override
    public void eliminar(Observador observador) {
        observers.remove(observador);
    }

    public void clearObservers() {
        observers.clear();
    }

    @Override
    public void notificarObservadores() {
        for (Observador observer: observers) {
            if (observer instanceof TrofeoCreido) {
                observer.serNotificado();
            }
        }
    }
}
