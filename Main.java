import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Libro> biblioteca = new ArrayList<>();
        biblioteca.add(new Libro("El Quijote", "Miguel de Cervantes"));
        biblioteca.add(new Libro("Cien años de soledad", "Gabriel García Márquez"));
        biblioteca.add(new Libro("1984", "George Orwell"));

        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

do {
    System.out.println("\n--- Menú Biblioteca ---");
    System.out.println("1. Listar libros");
    System.out.println("2. Prestar un libro");
    System.out.println("3. Devolver un libro");
    System.out.println("4. Añadir un libro");
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
                int indicePrestar = Integer.parseInt(scanner.nextLine());
                biblioteca.get(indicePrestar).prestar();
                break;
            case 3:
                System.out.print("Índice del libro a devolver: ");
                int indiceDevolver = Integer.parseInt(scanner.nextLine());
                biblioteca.get(indiceDevolver).devolver();
                break;
            case 4:
                System.out.print("Título: ");
                String titulo = scanner.nextLine();
                System.out.print("Autor: ");
                String autor = scanner.nextLine();
                biblioteca.add(new Libro(titulo, autor));
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
        System.out.println("No existe ningún libro con ese índice.");
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
}