package SistemaRegistroJuegos;

public abstract class Juego {
    protected String nombre;
    protected int anio;

    public Juego(String nombre, int anio) throws DatoInvalidoException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatoInvalidoException("El nombre no puede estar vacío.");
        }
        if (anio <= 0) {
            throw new DatoInvalidoException("El año debe ser positivo.");
        }
        this.nombre = nombre;
        this.anio = anio;
    }
    public String getNombre() {
        return nombre;
    }
    public int getAnio() {
        return anio;
    }
    // metodo abstracto
    public abstract String mostrarDetalles();
}