package biblioteca.modelo;

public class Prestamo implements PrestamoInterface {
    
    private Libro libro;
    private Usuario usuario;
    private boolean activo;
    
    /*
        Alta Cohesion:
        
        La clase Prestamo tiene una responsabilidad clara y bien definida: gestionar
        la informacion y las operaciones relacionadas con un prestamo de libro.
        Todas sus propiedades y metodos estan estrechamente relacionados con esta
        responsabilidad, logrando una alta cohesion.
    */
    
    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.activo = false;
    }

    @Override
    public boolean realizarPrestamo() {
        if (libro.getEjemplaresDisponibles() > 0) {
            if (libro.prestar() && usuario.agregarPrestamo(this)) {
                this.activo = true;
                return true;
            }
        }
        return false;
    }
    
    public boolean devolverLibro() {
        if (activo) {
            libro.devolver();
            usuario.eliminarPrestamo(this);
            activo = false;
            return true;
        }
        return false;
    }
    
    @Override
    public boolean validarPrestamo() {
        return libro.getEjemplaresDisponibles() > 0;
    }
    
    // Getters
    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }
    public boolean isActivo() { return activo; }
}
