public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes");
        Libro libro2 = new Libro("Cien Años de Soledad", "Gabriel García Márquez");

        libro1.mostrarInfo();
        libro2.mostrarInfo();

        libro1.prestar();
        libro1.mostrarInfo();

        Usuario u1 = new Usuario("Juan (estudiante)");
        Usuario u2 = new Profesor("Ana (profesora)");

        u1.mostrarInfo();
        u2.mostrarInfo();
    }
}