package EleccionReinaQuito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concurso {

    private ArrayList<Candidata> listaCandidatas = new ArrayList<>();
    private ArrayList<Voto> votos = new ArrayList<>();

    public ArrayList<Candidata> getListaCandidatas() {
        return listaCandidatas;
    }

    public void registrarCandidata(Candidata c) {
        listaCandidatas.add(c);
    }

    public void votar(int idCandidata) {
        votos.add(new Voto(idCandidata));
    }

    public Map<Integer, Integer> contarVotos() {
        Map<Integer, Integer> conteo = new HashMap<>();

        for (Voto v : votos) {
            int id = v.getIdCandidata();
            conteo.put(id, conteo.getOrDefault(id, 0) + 1);
        }
        return conteo;
    }

    public List<Candidata> obtenerGanador() {

        Map<Integer, Integer> conteo = contarVotos();

        int maxVotos = 0;
        List<Candidata> ganadoras = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : conteo.entrySet()) {

            int id = entry.getKey();
            int cantidad = entry.getValue();

            if (cantidad > maxVotos) {
                maxVotos = cantidad;
                ganadoras.clear();
            }

            if (cantidad == maxVotos) {
                for (Candidata c : listaCandidatas) {
                    if (c.getId() == id) {
                        ganadoras.add(c);
                    }
                }
            }
        }

        return ganadoras;
    }
}