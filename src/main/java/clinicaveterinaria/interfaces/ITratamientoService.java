package clinicaveterinaria.interfaces;

import clinicaveterinaria.model.Tratamiento;

public interface ITratamientoService {
    void crearTratamiento(Tratamiento tratamiento);

    double calcularTratamiento(Tratamiento tratamiento);
}