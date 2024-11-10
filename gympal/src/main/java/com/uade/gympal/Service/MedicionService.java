package com.uade.gympal.Service;
import com.uade.gympal.Repository.Entity.CurrentUserHolder;
import com.uade.gympal.Repository.Entity.Medicion;
import com.uade.gympal.Repository.MedicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class MedicionService {

    @Autowired
    private MedicionRepository medicionRepository;

    public Medicion addMeasurement(Medicion medida) {
        medida.setId(CurrentUserHolder.getCurrentUser().getId());
        medida.setDateTime(LocalDateTime.now()); // Set the timestamp before saving
        return medicionRepository.save(medida);
    }

    public List<Medicion> getMeasurements() {
        return medicionRepository.findBySocioId(CurrentUserHolder.getCurrentUser().getId());
    }
}
