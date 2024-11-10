package com.uade.gympal.Repository.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "socio_id", nullable = false)
    private Socio socio; // Link al socio user

    private float MasaMuscular;
    private float GrasaCorporal;
    private float Peso;
    private LocalDateTime dateTime; // Timestamp
}
