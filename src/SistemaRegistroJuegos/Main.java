package SistemaRegistroJuegos;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Juego> lista = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Registrar juego Mario Bros");
            System.out.println("2. Registrar juego de Carreras");
            System.out.println("3. Mostrar todos los juegos");
            System.out.println("4. Buscar juego por nombre");
            System.out.println("5. Filtrar por tipo de juego");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1 -> registrarMario();
                case 2 -> registrarCarrera();
                case 3 -> mostrarTodos();
                case 4 -> buscarPorNombre();
                case 5 -> filtrarPorTipo();
                case 6 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 6);
    }
    //Menu
    public static void registrarMario() {
        try {
            System.out.print("Nombre del juego: ");
            String nombre = sc.nextLine();
            System.out.print("Año del juego: ");
            int anio = leerEntero();
            System.out.print("Nivel inicial (1-10): ");
            int nivel = leerEntero();
            lista.add(new MarioBros(nombre, anio, nivel));
            System.out.println("Juego Mario Bros registrado con éxito.");
        } catch (DatoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void registrarCarrera() {
        try {
            System.out.print("Nombre del juego: ");
            String nombre = sc.nextLine();
            System.out.print("Año del juego: ");
            int anio = leerEntero();
            System.out.print("Cantidad de vehículos: ");
            int vehiculos = leerEntero();
            lista.add(new CarreraVehiculos(nombre, anio, vehiculos));
            System.out.println("Juego de Carreras registrado con éxito.");
        } catch (DatoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void mostrarTodos() {
        if (lista.isEmpty()) {
            System.out.println("No hay juegos registrados.");
            return;
        }
        System.out.println("\n===== JUEGOS REGISTRADOS =====");
        for (Juego j : lista) {
            System.out.println(j.mostrarDetalles());
            System.out.println("-----------------------------------");
        }
    }
    public static void buscarPorNombre() {
        System.out.print("Ingrese el nombre a buscar: ");
        String nombre = sc.nextLine();

        boolean encontrado = false;

        for (Juego j : lista) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(j.mostrarDetalles());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún juego con ese nombre.");
        }
    }
    public static void filtrarPorTipo() {
        System.out.println("1. Mostrar solo Mario Bros");
        System.out.println("2. Mostrar solo Carreras");
        System.out.print("Seleccione: ");
        int op = leerEntero();
        boolean encontrado = false;
        for (Juego j : lista) {
            if (op == 1 && j instanceof MarioBros) {
                System.out.println(j.mostrarDetalles());
                encontrado = true;
            } else if (op == 2 && j instanceof CarreraVehiculos) {
                System.out.println(j.mostrarDetalles());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay juegos del tipo seleccionado.");
        }
    }
    // validar enteros
    public static int leerEntero() {
        while (true) {
            try {
                int num = Integer.parseInt(sc.nextLine());
                return num;
            } catch (Exception e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }
}