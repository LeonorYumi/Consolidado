package DispositivosElectronicos;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Dispositivo> lista = new ArrayList<>();

        try {
            lista.add(new Laptop("HP", "Pavilion", 850, 16));
            lista.add(new Telefono("Samsung", "Galaxy A54", 420, 6.5));
            lista.add(new Laptop("Lenovo", "ThinkPad", 1200, 32));
            lista.add(new Telefono("Apple", "iPhone 14", 999, 6.1));

            // Ejemplo con datos inválidos
            lista.add(new Laptop("", "GamerX", -500, 16)); // Lanzará excepción

        } catch (DatoInvalidoException e) {
            System.out.println("Error al crear dispositivo: " + e.getMessage());
        }

        // Mostrar todos los dispositivos usando POLIMORFISMO
        System.out.println("\nLISTA DE DISPOSITIVOS REGISTRADOS:");
        for (Dispositivo d : lista) {
            System.out.println(d.mostrarInfo());
        }
    }
}