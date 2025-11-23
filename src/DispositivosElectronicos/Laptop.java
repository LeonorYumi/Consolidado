package DispositivosElectronicos;

public class Laptop extends Dispositivo {
    private int ram;
    public Laptop(String marca, String modelo, double precio, int ram)
            throws DatoInvalidoException {
        super(marca, modelo, precio);
        this.ram = ram;
    }
    @Override
    public String mostrarInfo() {
        return "Laptop = " + super.mostrarInfo() + ", RAM: " + ram + "GB";
    }
}