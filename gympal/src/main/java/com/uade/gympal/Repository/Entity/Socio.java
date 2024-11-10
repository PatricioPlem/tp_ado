package com.uade.gympal.Repository.Entity;

import com.uade.gympal.Repository.Enums.SexoEnum;
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
    private SexoEnum sexo;

    private float peso;

    private int altura;

    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
    private Objetivo objetivo;

    //@OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    //private List<Trofeo> trofeos;

    private float masaMuscular;

    private float grasaCorporal;


}
