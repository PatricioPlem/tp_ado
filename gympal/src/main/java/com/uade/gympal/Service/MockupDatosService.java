package com.uade.gympal.Service;

import com.uade.gympal.Repository.Entity.Ejercicio;
import com.uade.gympal.Repository.Enums.ExigenciaMuscularEnum;
import com.uade.gympal.Repository.Enums.GrupoMuscularEnum;
import com.uade.gympal.Repository.EjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MockupDatosService {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    public void iniciarDatos() {

        List<Ejercicio> ejercicios = Arrays.asList(
                // Ejercicios de brazo
                Ejercicio.builder().nombre("Curl de Biceps").nivelAerobico(3).exigenciaMuscular(ExigenciaMuscularEnum.MEDIA).series(3).repeticiones(12).peso(10.0).grupoMuscular(GrupoMuscularEnum.BRAZO).completado(false).build(),
                Ejercicio.builder().nombre("Martillo").nivelAerobico(2).exigenciaMuscular(ExigenciaMuscularEnum.BAJA).series(4).repeticiones(10).peso(8.0).grupoMuscular(GrupoMuscularEnum.BRAZO).completado(false).build(),
                Ejercicio.builder().nombre("Curl Concentrado").nivelAerobico(5).exigenciaMuscular(ExigenciaMuscularEnum.ALTA).series(3).repeticiones(15).peso(12.0).grupoMuscular(GrupoMuscularEnum.BRAZO).completado(false).build(),
                Ejercicio.builder().nombre("Triceps en Polea").nivelAerobico(3).exigenciaMuscular(ExigenciaMuscularEnum.MEDIA).series(4).repeticiones(12).peso(14.0).grupoMuscular(GrupoMuscularEnum.BRAZO).completado(false).build(),

                // Ejercicios de pierna
                Ejercicio.builder().nombre("Sentadilla").nivelAerobico(6).exigenciaMuscular(ExigenciaMuscularEnum.ALTA).series(4).repeticiones(12).peso(20.0).grupoMuscular(GrupoMuscularEnum.PIERNA).completado(false).build(),
                Ejercicio.builder().nombre("Prensa de Piernas").nivelAerobico(4).exigenciaMuscular(ExigenciaMuscularEnum.MEDIA).series(5).repeticiones(15).peso(25.0).grupoMuscular(GrupoMuscularEnum.PIERNA).completado(false).build(),
                Ejercicio.builder().nombre("Extensión de Pierna").nivelAerobico(1).exigenciaMuscular(ExigenciaMuscularEnum.BAJA).series(3).repeticiones(20).peso(10.0).grupoMuscular(GrupoMuscularEnum.PIERNA).completado(false).build(),
                Ejercicio.builder().nombre("Zancadas").nivelAerobico(7).exigenciaMuscular(ExigenciaMuscularEnum.ALTA).series(4).repeticiones(10).peso(15.0).grupoMuscular(GrupoMuscularEnum.PIERNA).completado(false).build(),

                // Ejercicios de espalda
                Ejercicio.builder().nombre("Pull-Ups").nivelAerobico(3).exigenciaMuscular(ExigenciaMuscularEnum.MEDIA).series(4).repeticiones(12).peso(18.0).grupoMuscular(GrupoMuscularEnum.ESPALDA).completado(false).build(),
                Ejercicio.builder().nombre("Remo con Mancuerna").nivelAerobico(2).exigenciaMuscular(ExigenciaMuscularEnum.BAJA).series(3).repeticiones(10).peso(12.0).grupoMuscular(GrupoMuscularEnum.ESPALDA).completado(false).build(),
                Ejercicio.builder().nombre("Peso Muerto").nivelAerobico(6).exigenciaMuscular(ExigenciaMuscularEnum.ALTA).series(4).repeticiones(12).peso(22.0).grupoMuscular(GrupoMuscularEnum.ESPALDA).completado(false).build(),
                Ejercicio.builder().nombre("Dominadas").nivelAerobico(7).exigenciaMuscular(ExigenciaMuscularEnum.ALTA).series(3).repeticiones(15).peso(25.0).grupoMuscular(GrupoMuscularEnum.ESPALDA).completado(false).build(),

                // Ejercicios de pecho
                Ejercicio.builder().nombre("Press de Banca").nivelAerobico(2).exigenciaMuscular(ExigenciaMuscularEnum.BAJA).series(3).repeticiones(12).peso(15.0).grupoMuscular(GrupoMuscularEnum.PECHO).completado(false).build(),
                Ejercicio.builder().nombre("Aperturas con Mancuernas").nivelAerobico(4).exigenciaMuscular(ExigenciaMuscularEnum.MEDIA).series(4).repeticiones(10).peso(18.0).grupoMuscular(GrupoMuscularEnum.PECHO).completado(false).build(),
                Ejercicio.builder().nombre("Press Inclinado").nivelAerobico(5).exigenciaMuscular(ExigenciaMuscularEnum.ALTA).series(4).repeticiones(12).peso(20.0).grupoMuscular(GrupoMuscularEnum.PECHO).completado(false).build(),
                Ejercicio.builder().nombre("Fondos en Paralelas").nivelAerobico(6).exigenciaMuscular(ExigenciaMuscularEnum.ALTA).series(3).repeticiones(15).peso(30.0).grupoMuscular(GrupoMuscularEnum.PECHO).completado(false).build(),

                // Ejercicios de hombros
                Ejercicio.builder().nombre("Elevaciones Laterales").nivelAerobico(3).exigenciaMuscular(ExigenciaMuscularEnum.MEDIA).series(3).repeticiones(12).peso(10.0).grupoMuscular(GrupoMuscularEnum.HOMBROS).completado(false).build(),
                Ejercicio.builder().nombre("Press Militar").nivelAerobico(5).exigenciaMuscular(ExigenciaMuscularEnum.ALTA).series(4).repeticiones(15).peso(18.0).grupoMuscular(GrupoMuscularEnum.HOMBROS).completado(false).build(),
                Ejercicio.builder().nombre("Elevación Frontal").nivelAerobico(1).exigenciaMuscular(ExigenciaMuscularEnum.BAJA).series(3).repeticiones(10).peso(12.0).grupoMuscular(GrupoMuscularEnum.HOMBROS).completado(false).build(),
                Ejercicio.builder().nombre("Press Arnold").nivelAerobico(4).exigenciaMuscular(ExigenciaMuscularEnum.MEDIA).series(4).repeticiones(12).peso(15.0).grupoMuscular(GrupoMuscularEnum.HOMBROS).completado(false).build(),
                Ejercicio.builder().nombre("Curl de Bíceps Alterno").nivelAerobico(5).exigenciaMuscular(ExigenciaMuscularEnum.MEDIA).series(4).repeticiones(12).peso(12.0).grupoMuscular(GrupoMuscularEnum.BRAZO).completado(false).build(),
                Ejercicio.builder().nombre("Press Francés").nivelAerobico(3).exigenciaMuscular(ExigenciaMuscularEnum.ALTA).series(3).repeticiones(10).peso(15.0).grupoMuscular(GrupoMuscularEnum.BRAZO).completado(false).build(),
                Ejercicio.builder().nombre("Fondos de Tríceps").nivelAerobico(6).exigenciaMuscular(ExigenciaMuscularEnum.BAJA).series(3).repeticiones(15).peso(0.0).grupoMuscular(GrupoMuscularEnum.BRAZO).completado(false).build(),
                Ejercicio.builder().nombre("Patada de Tríceps").nivelAerobico(2).exigenciaMuscular(ExigenciaMuscularEnum.MEDIA).series(4).repeticiones(12).peso(8.0).grupoMuscular(GrupoMuscularEnum.BRAZO).completado(false).build(),
                Ejercicio.builder().nombre("Sentadilla Profunda").nivelAerobico(7).exigenciaMuscular(ExigenciaMuscularEnum.ALTA).series(5).repeticiones(10).peso(30.0).grupoMuscular(GrupoMuscularEnum.PIERNA).completado(false).build(),
                Ejercicio.builder().nombre("Peso Muerto").nivelAerobico(4).exigenciaMuscular(ExigenciaMuscularEnum.MEDIA).series(3).repeticiones(12).peso(40.0).grupoMuscular(GrupoMuscularEnum.PIERNA).completado(false).build(),
                Ejercicio.builder().nombre("Prensa de Pierna").nivelAerobico(3).exigenciaMuscular(ExigenciaMuscularEnum.ALTA).series(4).repeticiones(10).peso(60.0).grupoMuscular(GrupoMuscularEnum.PIERNA).completado(false).build(),
                Ejercicio.builder().nombre("Lunges").nivelAerobico(2).exigenciaMuscular(ExigenciaMuscularEnum.BAJA).series(3).repeticiones(15).peso(20.0).grupoMuscular(GrupoMuscularEnum.PIERNA).completado(false).build(),
                Ejercicio.builder().nombre("Remo con Barra").nivelAerobico(4).exigenciaMuscular(ExigenciaMuscularEnum.MEDIA).series(4).repeticiones(10).peso(30.0).grupoMuscular(GrupoMuscularEnum.ESPALDA).completado(false).build(),
                Ejercicio.builder().nombre("Dominadas Asistidas").nivelAerobico(6).exigenciaMuscular(ExigenciaMuscularEnum.ALTA).series(3).repeticiones(8).peso(0.0).grupoMuscular(GrupoMuscularEnum.ESPALDA).completado(false).build(),
                Ejercicio.builder().nombre("Pull Over").nivelAerobico(2).exigenciaMuscular(ExigenciaMuscularEnum.MEDIA).series(3).repeticiones(12).peso(15.0).grupoMuscular(GrupoMuscularEnum.ESPALDA).completado(false).build(),
                Ejercicio.builder().nombre("Peso Muerto Rumano").nivelAerobico(5).exigenciaMuscular(ExigenciaMuscularEnum.ALTA).series(3).repeticiones(10).peso(25.0).grupoMuscular(GrupoMuscularEnum.ESPALDA).completado(false).build(),
                Ejercicio.builder().nombre("Press Plano con Barra").nivelAerobico(1).exigenciaMuscular(ExigenciaMuscularEnum.BAJA).series(3).repeticiones(15).peso(20.0).grupoMuscular(GrupoMuscularEnum.PECHO).completado(false).build(),
                Ejercicio.builder().nombre("Press Inclinado con Mancuernas").nivelAerobico(7).exigenciaMuscular(ExigenciaMuscularEnum.ALTA).series(4).repeticiones(12).peso(25.0).grupoMuscular(GrupoMuscularEnum.PECHO).completado(false).build(),
                Ejercicio.builder().nombre("Press Declinado").nivelAerobico(2).exigenciaMuscular(ExigenciaMuscularEnum.MEDIA).series(4).repeticiones(10).peso(18.0).grupoMuscular(GrupoMuscularEnum.PECHO).completado(false).build(),
                Ejercicio.builder().nombre("Aperturas en Banco Plano").nivelAerobico(3).exigenciaMuscular(ExigenciaMuscularEnum.ALTA).series(3).repeticiones(12).peso(12.0).grupoMuscular(GrupoMuscularEnum.PECHO).completado(false).build(),
                Ejercicio.builder().nombre("Press Militar").nivelAerobico(5).exigenciaMuscular(ExigenciaMuscularEnum.MEDIA).series(3).repeticiones(10).peso(15.0).grupoMuscular(GrupoMuscularEnum.HOMBROS).completado(false).build(),
                Ejercicio.builder().nombre("Elevaciones Laterales").nivelAerobico(2).exigenciaMuscular(ExigenciaMuscularEnum.BAJA).series(4).repeticiones(15).peso(8.0).grupoMuscular(GrupoMuscularEnum.HOMBROS).completado(false).build(),
                Ejercicio.builder().nombre("Pájaro para Deltoides Posterior").nivelAerobico(3).exigenciaMuscular(ExigenciaMuscularEnum.MEDIA).series(4).repeticiones(12).peso(10.0).grupoMuscular(GrupoMuscularEnum.HOMBROS).completado(false).build(),
                Ejercicio.builder().nombre("Press Arnold").nivelAerobico(4).exigenciaMuscular(ExigenciaMuscularEnum.ALTA).series(4).repeticiones(12).peso(15.0).grupoMuscular(GrupoMuscularEnum.HOMBROS).completado(false).build()

                // Puedes continuar hasta completar 40 ejercicios, variando nombre, nivelAerobico y otros parámetros
        );

        ejercicioRepository.saveAll(ejercicios);
    }
}
