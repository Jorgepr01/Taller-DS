package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.ITratamiento;


public class CalculadoraCostoTratamiento {
    public double calcularConImpuestos(ITratamiento tratamiento) {
        return tratamiento.calcularConImpuestos();
    }
}
