public class Usuario {
    protected String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
    return nombre;
}

    public int diasPrestamo() {
        return 15;
    }

    public void mostrarInfo() {
        System.out.println(nombre + " - préstamo de " + diasPrestamo() + " días");
    }
}
