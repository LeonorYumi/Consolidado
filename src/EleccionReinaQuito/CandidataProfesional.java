package EleccionReinaQuito;

public class CandidataProfesional extends Candidata {

    private String profesion;
    private int anioExperiencia;

    public CandidataProfesional(int id, String nombre, int edad, String distrito,
                                double puntajeJurado, String profesion, int anioExp)
            throws DatoInvalidoException {

        super(id, nombre, edad, distrito, puntajeJurado);
        this.profesion = profesion;
        this.anioExperiencia = anioExp;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("\n--- Candidata Profesional ---");
        System.out.println("Id: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("Distrito: " + getDistrito());
        System.out.println("Puntaje jurado: " + getPuntajeJurado());
        System.out.println("Profesión: " + profesion);
        System.out.println("Años de experiencia: " + anioExperiencia);
    }
}