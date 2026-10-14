package clinicaveterinaria.interfaces;

import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Tratamiento;
import clinicaveterinaria.model.Veterinario;

import java.util.List;
import java.util.Map;

public interface IBaseDatos {
    void conectar();

    List<Mascota> getMascotas();

    List<Veterinario> getVeterinarios();

    List<Cita> getCitas();

    List<Tratamiento> getTratamientos();

    List<Factura> getFacturas();

    Map<String, Integer> getAuditoria();
}
