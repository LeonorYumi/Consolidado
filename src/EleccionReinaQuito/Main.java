package EleccionReinaQuito;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Concurso concurso = new Concurso();

        int opcion = 0;
        do {
            try {
                System.out.println("================= CONCURSO REINA DE QUITO ===============");
                System.out.println("1. Registrar candidata");
                System.out.println("2. Listar todas");
                System.out.println("3. Buscar por nombre / ID");
                System.out.println("4. Filtrar por tipo / distrito");
                System.out.println("5. Simular voto / registrar voto manual");
                System.out.println("6. Mostrar resultados y ganadora(s)");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.println("------------ REGISTRO CANDIDATA ---------------");
                        System.out.println("1. Candidata Estudiante");
                        System.out.println("2. Candidata Profesional");
                        System.out.print("Ingrese una opción: ");
                        int opcion2 = sc.nextInt();
                        sc.nextLine();

                        if (opcion2 == 1) {
                            System.out.println("----- ESTUDIANTE -------");
                            System.out.print("Ingrese el ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();
                            System.out.print("Edad: ");
                            int edad = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Distrito: ");
                            String distrito = sc.nextLine();
                            System.out.print("Puntaje jurado: ");
                            double puntaje = sc.nextDouble();
                            sc.nextLine();
                            System.out.print("Universidad: ");
                            String universidad = sc.nextLine();
                            System.out.print("Carrera: ");
                            String carrera = sc.nextLine();
                            try {
                                CandidataEstudiante ce = new CandidataEstudiante(id, nombre, edad, distrito, puntaje, universidad);
                                concurso.registrarCandidata(ce);
                                System.out.println("Candidata estudiante registrada.");
                            } catch (DatoInvalidoException ex) {
                                System.out.println("ERROR: " + ex.getMessage());
                            }
                        } else if (opcion2 == 2) {

                            System.out.println("----- PROFESIONAL -------");
                            System.out.print("Ingrese el ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();
                            System.out.print("Edad: ");
                            int edad = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Distrito: ");
                            String distrito = sc.nextLine();
                            System.out.print("Puntaje jurado: ");
                            double puntaje = sc.nextDouble();
                            sc.nextLine();
                            System.out.print("Profesión: ");
                            String profesion = sc.nextLine();
                            System.out.print("Años de experiencia: ");
                            int aniosExp = sc.nextInt();
                            sc.nextLine();
                            try {
                                CandidataProfesional cp = new CandidataProfesional(id, nombre, edad, distrito, puntaje, profesion, aniosExp);
                                concurso.registrarCandidata(cp);
                                System.out.println("Candidata profesional registrada.");
                            } catch (DatoInvalidoException ex) {
                                System.out.println("ERROR: " + ex.getMessage());
                            }

                        } else {
                            System.out.println("Opción no válida.");
                        }
                        break;
                    case 2:
                        System.out.println("---------- LISTA DE CANDIDATAS -----------");
                        for (Candidata c : concurso.getListaCandidatas()) {
                            c.mostrarDetalles();
                        }
                        break;
                    case 3:
                        System.out.println("1. Buscar por ID");
                        System.out.println("2. Buscar por nombre");
                        System.out.print("Opción: ");
                        int op = sc.nextInt();
                        sc.nextLine();

                        if (op == 1) {
                            System.out.print("Ingrese ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            boolean encontrado = false;
                            for (Candidata c : concurso.getListaCandidatas()) {
                                if (c.getId() == id) {
                                    c.mostrarDetalles();
                                    encontrado = true;
                                }
                            }
                            if (!encontrado) System.out.println("No existe candidata con ese ID.");

                        } else if (op == 2) {
                            System.out.print("Nombre a buscar: ");
                            String nombre = sc.nextLine().toLowerCase();

                            boolean encontrado = false;
                            for (Candidata c : concurso.getListaCandidatas()) {
                                if (c.getNombre().toLowerCase().contains(nombre)) {
                                    c.mostrarDetalles();
                                    encontrado = true;
                                }
                            }
                            if (!encontrado) System.out.println("No existe candidata con ese nombre.");
                        }
                        break;
                    case 4:
                        System.out.println("1. Filtrar por tipo");
                        System.out.println("2. Filtrar por distrito");
                        System.out.print("Opción: ");
                        int f = sc.nextInt();
                        sc.nextLine();

                        if (f == 1) {
                            System.out.println("1. Estudiante");
                            System.out.println("2. Profesional");
                            int t = sc.nextInt();
                            sc.nextLine();

                            for (Candidata c : concurso.getListaCandidatas()) {
                                if (t == 1 && c instanceof CandidataEstudiante)
                                    c.mostrarDetalles();
                                else if (t == 2 && c instanceof CandidataProfesional)
                                    c.mostrarDetalles();
                            }

                        } else if (f == 2) {
                            System.out.print("Distrito: ");
                            String dis = sc.nextLine().toLowerCase();

                            for (Candidata c : concurso.getListaCandidatas()) {
                                if (c.getDistrito().toLowerCase().equals(dis)) {
                                    c.mostrarDetalles();
                                }
                            }
                        }
                        break;
                    case 5:
                        System.out.print("Ingrese ID de candidata para votar: ");
                        int idVoto = sc.nextInt();
                        sc.nextLine();
                        concurso.votar(idVoto);
                        System.out.println("Voto registrado.");
                        break;
                    case 6:
                        System.out.println("------ RESULTADOS ------");
                        System.out.println(concurso.contarVotos());

                        System.out.println("------ GANADORA(S) ------");
                        for (Candidata c : concurso.obtenerGanador()) {
                            c.mostrarDetalles();
                        }
                        break;

                    case 7:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("ERROR. Datos no válidos...");
                sc.nextLine(); // limpiar buffer si ocurre error
            }
        } while (opcion != 7);
        sc.close();
    }
}