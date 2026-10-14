package clinicaveterinaria.model;

public class MedicamenteTratamiento extends Tratamiento {
    public MedicamenteTratamiento(int id, String descripcion, double costo) {
        super(id, TipoTratamiento.MEDICAMENTO, descripcion, costo);
    }

    @Override
    public double calcularCostoFinal() {
        return getCosto() * 1.10;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Administrar segun receta.";
    }

    @Override
    public String CondicionesSala() {
        return "Preparar receta y dosis.";
    }

    @Override
    public double calcularConImpuestos() {
        return getCosto() * 1.08;
    }
}
