package Olimpiadas;
import java.util.Scanner;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static Olimpiada olimpiada = new Olimpiada("Olimpiadas Mundiales", "París", 2024);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== MENÚ OLIMPIADAS =====");
            System.out.println("1. Registrar evento");
            System.out.println("2. Registrar atleta");
            System.out.println("3. Registrar equipo");
            System.out.println("4. Mostrar eventos");
            System.out.println("5. Mostrar participantes de un evento");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            try {
                switch (opcion) {
                    case 1:
                        registrarEvento();
                        break;
                    case 2:
                        registrarAtleta();
                        break;
                    case 3:
                        registrarEquipo();
                        break;
                    case 4:
                        olimpiada.mostrarEventos();
                        break;
                    case 5:
                        mostrarParticipantesEvento();
                        break;
                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (DatosInvalidosException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } while (opcion != 6);
    }

    // MÉTODOS DEL MENÚ

    public static void registrarEvento() throws DatosInvalidosException {
        System.out.print("Nombre del evento: ");
        String nombre = sc.nextLine();

        System.out.print("Fecha (dd/mm/aaaa): ");
        String fecha = sc.nextLine();

        Evento e = new Evento(nombre, fecha);
        olimpiada.agregarEvento(e);

        System.out.println("Evento registrado correctamente.");
    }
    public static void registrarAtleta() throws DatosInvalidosException {
        System.out.print("ID del atleta: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre del atleta: ");
        String nombre = sc.nextLine();
        System.out.print("País: ");
        String pais = sc.nextLine();
        System.out.print("Disciplina: ");
        String disciplina = sc.nextLine();
        Atleta atleta = new Atleta(id, nombre, pais, disciplina);
        Evento evento = seleccionarEvento();
        evento.agregarParticipante(atleta);
        System.out.println("Atleta registrado en el evento.");
    }
    public static void registrarEquipo() throws DatosInvalidosException {
        System.out.print("ID del equipo: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre del equipo: ");
        String nombre = sc.nextLine();
        System.out.print("País: ");
        String pais = sc.nextLine();
        System.out.print("Número de integrantes: ");
        int integr = sc.nextInt();
        sc.nextLine();
        Equipo equipo = new Equipo(id, nombre, pais, integr);
        Evento evento = seleccionarEvento();
        evento.agregarParticipante(equipo);
        System.out.println("Equipo registrado en el evento.");
    }
    public static Evento seleccionarEvento() throws DatosInvalidosException {
        System.out.print("Nombre del evento donde desea registrar: ");
        String nombreBuscado = sc.nextLine();
        for (Evento e : olimpiada.getEventos()) {
            if (e.getNombreEvento().equalsIgnoreCase(nombreBuscado)) {
                return e;
            }
        }
        throw new DatosInvalidosException("El evento no existe.");
    }
    public static void mostrarParticipantesEvento() throws DatosInvalidosException {
        Evento evento = seleccionarEvento();
        evento.mostrarParticipantes();
    }
}