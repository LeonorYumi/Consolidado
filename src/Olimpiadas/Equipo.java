package Olimpiadas;

public class Equipo extends Participante {

    private int numeroIntegrantes;

    public Equipo(int id, String nombre, String pais, int numeroIntegrantes) {
        super(id, nombre, pais);
        this.numeroIntegrantes = numeroIntegrantes;
    }

    @Override
    public String mostrarTipo() {
        return "Equipo - Integrantes: " + numeroIntegrantes;
    }
}
