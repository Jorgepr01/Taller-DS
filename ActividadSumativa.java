package modelos;

public abstract class ActividadSumativa {
    protected String titulo;
    protected double ponderacion;
    protected double notaMinima;

    public abstract double calcularNota();
}
