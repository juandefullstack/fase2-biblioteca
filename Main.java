import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Libro> biblioteca = new ArrayList<>();
        biblioteca.add(new Libro("El Quijote", "Miguel de Cervantes"));
        biblioteca.add(new Libro("Cien años de soledad", "Gabriel García Márquez"));
        biblioteca.add(new Libro("1984", "George Orwell"));

        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Juan (estudiante)"));
        usuarios.add(new Profesor("Ana (profesora)"));

        ArrayList<Prestamo> prestamos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n--- Menú Biblioteca ---");
            System.out.println("1. Listar libros");
            System.out.println("2. Prestar un libro (directo)");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Añadir un libro");
            System.out.println("5. Registrar préstamo con usuario");
            System.out.println("6. Listar préstamos");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        listarLibros(biblioteca);
                        break;
                    case 2:
                        System.out.print("Índice del libro a prestar: ");
                        biblioteca.get(Integer.parseInt(scanner.nextLine())).prestar();
                        break;
                    case 3:
                        System.out.print("Índice del libro a devolver: ");
                        biblioteca.get(Integer.parseInt(scanner.nextLine())).devolver();
                        break;
                    case 4:
                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();
                        biblioteca.add(new Libro(titulo, autor));
                        break;
                    case 5:
                        listarLibros(biblioteca);
                        System.out.print("Índice del libro: ");
                        int indiceLibro = Integer.parseInt(scanner.nextLine());

                        listarUsuarios(usuarios);
                        System.out.print("Índice del usuario: ");
                        int indiceUsuario = Integer.parseInt(scanner.nextLine());

                        Prestamo nuevoPrestamo = new Prestamo(biblioteca.get(indiceLibro), usuarios.get(indiceUsuario));
                        prestamos.add(nuevoPrestamo);
                        System.out.println("Préstamo registrado.");
                        break;
                    case 6:
                        for (Prestamo prestamo : prestamos) {
                            prestamo.mostrarInfo();
                        }
                        break;
                    case 0:
                        System.out.println("Hasta luego.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Eso no era un número. Inténtalo de nuevo.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("No existe nada con ese índice.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    static void listarLibros(ArrayList<Libro> biblioteca) {
        for (int i = 0; i < biblioteca.size(); i++) {
            System.out.print(i + ". ");
            biblioteca.get(i).mostrarInfo();
        }
    }

    static void listarUsuarios(ArrayList<Usuario> usuarios) {
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.print(i + ". ");
            usuarios.get(i).mostrarInfo();
        }
    }
}