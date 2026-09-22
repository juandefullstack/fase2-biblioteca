public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes");
        Libro libro2 = new Libro("Cien Años de Soledad", "Gabriel García Márquez");

        libro1.mostrarInfo();
        libro2.mostrarInfo();

        libro1.prestar();
        libro1.mostrarInfo();
    }
}