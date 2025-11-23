package DispositivosElectronicos;

public class Dispositivo {
    private String marca;
    private String modelo;
    private double precio;

    public Dispositivo(String marca, String modelo, double precio) throws DatoInvalidoException {
        setMarca(marca);
        setModelo(modelo);
        setPrecio(precio);
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) throws DatoInvalidoException {
        if (marca == null || marca.trim().isEmpty()) {
            throw new DatoInvalidoException("La marca no puede estar vacía.");
        }
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) throws DatoInvalidoException {
        if (precio < 0) {
            throw new DatoInvalidoException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }
    public String mostrarInfo() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Precio: $" + precio;
    }
}