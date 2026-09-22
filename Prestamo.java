import java.time.LocalDate;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = fechaPrestamo.plusDays(usuario.diasPrestamo());
        libro.prestar();
    }

    public void mostrarInfo() {
        System.out.println(libro.getTitulo() + " -> " + usuario.getNombre()
                + " | prestado: " + fechaPrestamo + " | devolver antes de: " + fechaDevolucion);
    }
}