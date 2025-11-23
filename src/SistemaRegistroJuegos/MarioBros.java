package SistemaRegistroJuegos;
public class MarioBros extends Juego {

    private int nivelInicial;

    public MarioBros(String nombre, int anio, int nivelInicial) throws DatoInvalidoException {
        super(nombre, anio);

        if (nivelInicial < 1 || nivelInicial > 10) {
            throw new DatoInvalidoException("El nivel inicial debe estar entre 1 y 10.");
        }

        this.nivelInicial = nivelInicial;
    }

    @Override
    public String mostrarDetalles() {
        return "Juego Mario Bros - Nombre: " + nombre +
                ", Año: " + anio +
                ", Nivel Inicial: " + nivelInicial;
    }
}