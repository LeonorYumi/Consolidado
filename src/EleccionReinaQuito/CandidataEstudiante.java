package EleccionReinaQuito;

public class CandidataEstudiante extends Candidata {

    private String universidad;
    private String carrera;

    public CandidataEstudiante(int id, String nombre, int edad, String distrito,
                               double puntajeJurado, String universidad)
            throws DatoInvalidoException {

        super(id, nombre, edad, distrito, puntajeJurado);
        this.universidad = universidad;
        this.carrera = carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getUniversidad() {
        return universidad;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("\n--- Candidata Estudiante ---");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Distrito: " + distrito);
        System.out.println("Puntaje Jurado: " + puntajeJurado);
        System.out.println("Universidad: " + universidad);
        System.out.println("Carrera: " + carrera);
    }
}