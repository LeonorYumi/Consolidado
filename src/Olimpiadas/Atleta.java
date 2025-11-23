package Olimpiadas;

public class Atleta extends Participante {

    private String disciplina;

    public Atleta(int id, String nombre, String pais, String disciplina) {
        super(id, nombre, pais);
        this.disciplina = disciplina;
    }

    @Override
    public String mostrarTipo() {
        return "Atleta - Disciplina: " + disciplina;
    }
}
