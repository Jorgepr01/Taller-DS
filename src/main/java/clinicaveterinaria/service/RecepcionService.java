package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.ICitaService;
import clinicaveterinaria.interfaces.IMascotaService;
import clinicaveterinaria.interfaces.IVeterinarioRegistro;
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Veterinario;

public class RecepcionService {
    private final IMascotaService mascotaService;
    private final IVeterinarioRegistro veterinarioService;
    private final ICitaService citaService;

    public RecepcionService(IMascotaService mascotaService,
                            IVeterinarioRegistro veterinarioService,
                            ICitaService citaService) {
        this.mascotaService = mascotaService;
        this.veterinarioService = veterinarioService;
        this.citaService = citaService;
    }

    public void crearMascota(Mascota mascota) {
        mascotaService.crearMascota(mascota);
    }

    public Mascota obtenerMascota(int id) {
        return mascotaService.obtenerMascota(id);
    }

    public void actualizarMascota(Mascota mascota) {
        mascotaService.actualizarMascota(mascota);
    }

    public void eliminarMascota(int id) {
        mascotaService.eliminarMascota(id);
    }

    public void crearVeterinario(Veterinario veterinario) {
        veterinarioService.crearVeterinario(veterinario);
    }

    public Veterinario obtenerVeterinario(int id) {
        return veterinarioService.obtenerVeterinario(id);
    }

    public void crearCita(Cita cita) {
        citaService.crearCita(cita);
    }

    public Cita obtenerCita(int id) {
        return citaService.obtenerCita(id);
    }

    public void cancelarCita(int id) {
        citaService.cancelarCita(id);
    }
}
