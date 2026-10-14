package clinicaveterinaria.repository;


public class DirectoBaseDatos extends BaseDatos {
    @Override
    public void conectar() {
        System.out.println("Conectado a la base simulada con new DirectoBaseDatos().");
    }
}
