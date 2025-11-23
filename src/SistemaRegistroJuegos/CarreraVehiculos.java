package SistemaRegistroJuegos;
public class CarreraVehiculos extends Juego {

    private int vehiculos;

    public CarreraVehiculos(String nombre, int anio, int vehiculos) throws DatoInvalidoException {
        super(nombre, anio);

        if (vehiculos <= 0) {
            throw new DatoInvalidoException("La cantidad de vehículos debe ser positiva.");
        }

        this.vehiculos = vehiculos;
    }

    @Override
    public String mostrarDetalles() {
        return "Carrera de Vehículos - Nombre: " + nombre +
                ", Año: " + anio +
                ", Vehículos: " + vehiculos;
    }
}