package DispositivosElectronicos;

public class Telefono extends Dispositivo {
    private double pulgadasPantalla;
    public Telefono(String marca, String modelo, double precio, double pulgadasPantalla)
            throws DatoInvalidoException {
        super(marca, modelo, precio);
        this.pulgadasPantalla = pulgadasPantalla;
    }
    @Override
    public String mostrarInfo() {
        return "Teléfono = " + super.mostrarInfo() +
                ", Pantalla: " + pulgadasPantalla + " pulgadas";
    }
}