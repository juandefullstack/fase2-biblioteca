public class Profesor extends Usuario {
    public Profesor(String nombre) {
        super(nombre);
    }

    @Override
    public int diasPrestamo() {
        return 30;
    }
}
