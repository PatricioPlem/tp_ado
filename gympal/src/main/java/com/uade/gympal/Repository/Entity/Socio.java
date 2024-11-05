package com.uade.gympal.Repository.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int edad;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private float peso;

    private int altura;
    private String username;
    private String password;
    //@ManyToOne
    //private Objetivo objetivo;

    //@OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    //private List<Trofeo> trofeos;

    private float masaMuscular;

    private float grasaCorporal;

    // Enum de sexo
    public enum Sexo {
        MASCULINO,
        FEMENINO
    }
}
