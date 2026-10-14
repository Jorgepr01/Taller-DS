package clinicaveterinaria.model;

public class CirujiaTratamiento extends Tratamiento {
    public CirujiaTratamiento(int id, String descripcion, double costo) {
        super(id, TipoTratamiento.CIRUGIA, descripcion, costo);
    }

    @Override
    public double calcularCostoFinal() {
        return getCosto() * 1.25 + 80.0;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Ayuno previo y control postoperatorio.";
    }

    @Override
    public String CondicionesSala() {
        return "Preparar quirofano y anestesia.";
    }

    @Override
    public double calcularConImpuestos() {
        return getCosto() * 1.35;
    }
}
