package clinicaveterinaria.interfaces;

import clinicaveterinaria.model.Veterinario;

public interface IVeterinarioRegistro {
    void crearVeterinario(Veterinario veterinario);

    Veterinario obtenerVeterinario(int id);
}