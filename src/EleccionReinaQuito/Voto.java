package EleccionReinaQuito;

import java.time.LocalDateTime;

public class Voto {

    private int idCandidata;
    private LocalDateTime fechaHora;

    public Voto(int idCandidata) {
        this.idCandidata = idCandidata;
        this.fechaHora = LocalDateTime.now();
    }

    public int getIdCandidata() {
        return idCandidata;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}