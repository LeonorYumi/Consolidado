package Olimpiadas;

public abstract class Participante {
    protected int id;
    protected String nombre;
    protected String pais;

    public Participante(int id, String nombre, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPais() { return pais; }

    public abstract String mostrarTipo();
}
