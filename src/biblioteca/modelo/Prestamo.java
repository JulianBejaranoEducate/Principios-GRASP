package biblioteca.modelo;

public class Prestamo implements PrestamoInterface {
    
    private Libro libro;
    private Usuario usuario;
    private boolean activo;
    
    /*
        Alta Cohesión:
        
        La clase Prestamo tiene una responsabilidad clara y bien definida: Esta gestiona
        la informacion y las operaciones relacionadas con un prestamo de libro.
        Todas sus propiedades y metodos estan estrechamente relacionados con esta
        responsabilidad, provocanda una alta cohesion.
    */
    
    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.activo = false; // Será true cuando se confirme el préstamo
    }

    @Override
    public boolean realizarPrestamo() {
        if (validarPrestamo()) {
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
        // Validar que el libro esté disponible y que el usuario pueda pedir prestado
        return libro.estaDisponible() && usuario.puedePrestar();
    }
    
    // Getters
    public Libro getLibro() {
        return libro;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public boolean isActivo() {
        return activo;
    }
}
