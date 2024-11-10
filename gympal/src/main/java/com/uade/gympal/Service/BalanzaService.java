package com.uade.gympal.Service;

import com.uade.gympal.Repository.Enums.Sexo;

public class BalanzaService {
    public static double calcularIMC(double peso, double altura) {
        double alturaMetros = altura / 100.0;
        return peso / (alturaMetros * alturaMetros);
    }

    public static double calcularIMM(int edad, double altura, double peso, Sexo sex, double porcentajeMusculo) {
        return (calcularIMC(peso, altura) * porcentajeMusculo) / 100;
    }

    public static double calcularPorcentajeGrasaCorporal(int edad, double altura, double peso, Sexo sexo) {
        double imc = calcularIMC(peso, altura);

        // Factor de género
        int factorGenero = (sexo == Sexo.MASCULINO) ? 1 : 0;

        // Fórmula de Deurenberg
        return 1.2 * imc + 0.23 * edad - 10.8 * factorGenero - 5.4;
    }
}
