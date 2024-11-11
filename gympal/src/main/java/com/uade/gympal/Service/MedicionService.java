package com.uade.gympal.Service;
import com.uade.gympal.Repository.Entity.CurrentUserHolder;
import com.uade.gympal.Repository.Entity.Medicion;
import com.uade.gympal.Repository.Entity.Socio;
import com.uade.gympal.Repository.MedicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class MedicionService {

    @Autowired
    private MedicionRepository medicionRepository;

    public Medicion addMeasurement(Medicion medida) {
        if (CurrentUserHolder.getCurrentUser() != null){
            medida.setSocio(CurrentUserHolder.getCurrentUser());
            medida.setDateTime(LocalDateTime.now()); // Set the timestamp before saving

            if (esSocioCreido(CurrentUserHolder.getCurrentUser())) {
                // Notificar trofeo creido
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
}
