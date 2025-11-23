package Olimpiadas;
import java.util.ArrayList;

public class Evento {

    private String nombreEvento;
    private String fecha;
    private ArrayList<Participante> participantes;

    public Evento(String nombreEvento, String fecha) {
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.participantes = new ArrayList<>();
    }
    public String getNombreEvento() { return nombreEvento; }

    public void agregarParticipante(Participante p) throws DatosInvalidosException {
        if (p == null) {
            throw new DatosInvalidosException("Participante no válido.");
        }
        participantes.add(p);
    }
    public void mostrarParticipantes() {
        if (participantes.isEmpty()) {
            System.out.println("No hay participantes registrados.");
        } else {
            System.out.println("Participantes del evento " + nombreEvento + ":");
            for (Participante p : participantes) {
                System.out.println("- " + p.getNombre() + " | " + p.mostrarTipo());
            }
        }
    }
}
