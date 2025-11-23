package Olimpiadas;
import java.util.ArrayList;

public class Olimpiada {
    private String nombre;
    private String sede;
    private int año;
    private ArrayList<Evento> eventos;
    public Olimpiada(String nombre, String sede, int año) {
        this.nombre = nombre;
        this.sede = sede;
        this.año = año;
        this.eventos = new ArrayList<>();
    }
    public void agregarEvento(Evento e) throws DatosInvalidosException {
        if (e == null) {
            throw new DatosInvalidosException("Evento no válido.");
        }
        eventos.add(e);
    }
    public ArrayList<Evento> getEventos() {
        return eventos;
    }
    public void mostrarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
        } else {
            System.out.println("Eventos registrados en la Olimpiada:");
            for (Evento e : eventos) {
                System.out.println("- " + e.getNombreEvento());
            }
        }
    }
}
