package clinicaveterinaria.interfaces;

import clinicaveterinaria.model.Veterinario;

public interface IVeterinarioCrudService extends IVeterinarioRegistro {
    void actualizarVeterinario(Veterinario veterinario);

    void eliminarVeterinario(int id);
}