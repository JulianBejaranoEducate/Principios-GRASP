package biblioteca.controller;

import biblioteca.modelo.Libro;
import biblioteca.modelo.Prestamo;
import biblioteca.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaController {
    
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;
    
    /*
        Controlador:
        
        Esta clase actua como intermediario entre la interfaz de usuario (Main)
        y las clases del modelo (Libro, Usuario, Prestamo). Se encarga de coordinar
        las operaciones de negocio y delegar responsabilidades a los objetos adecuados.
    */
    
    /*
        Indireccion:
        Este controlador proporciona una capa de indirección entre los objetos
        del modelo y la interfaz de usuario, permitiendo que estos componente
        esten desacoplados. Cualquier cambio en el modelo no afectara directamente
        a la interfaz de usuario y viceversa.
    */
    
    /*
        Creador:
        
        El controlador es responsable de crear instancias de Libro, Usuario y Prestamo,
        ya que tiene toda la información necesaria para su creación y mantiene
        un registro de estos objetos.
    */
    
    public BibliotecaController() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        
        // Inicializamos la biblioteca con algunos datos de ejemplo
        inicializarDatos();
    }
    
    private void inicializarDatos() {
        // Crear algunos libros de ejemplo
        crearLibro("El Principito", "Antoine de Saint-Exupéry", 2);
        crearLibro("Cien años de soledad", "Gabriel García Márquez", 1);
        
        // Crear algunos usuarios de ejemplo
        crearUsuario("Juan Pérez");
        crearUsuario("Ana García");
    }
    
    // Métodos para crear objetos "Creator"
    public Libro crearLibro(String titulo, String autor, int ejemplares) {
        Libro libro = new Libro(titulo, autor, ejemplares);
        libros.add(libro);
        return libro;
    }
    
    public Usuario crearUsuario(String nombre) {
        Usuario usuario = new Usuario(nombre);
        usuarios.add(usuario);
        return usuario;
    }
    
    public Prestamo crearPrestamo(Libro libro, Usuario usuario) {
        if (libro != null && usuario != null) {
            Prestamo prestamo = new Prestamo(libro, usuario);
            
            if (prestamo.realizarPrestamo()) {
                prestamos.add(prestamo);
                return prestamo;
            }
        }
        
        return null;
    }
    
    // Métodos para realizar operaciones
    public boolean devolverLibro(Libro libro, Usuario usuario) {
        // Buscar el préstamo activo para este libro y usuario
        for (Prestamo prestamo : prestamos) {
            if (prestamo.isActivo() &&
                prestamo.getLibro() == libro &&
                prestamo.getUsuario() == usuario) {
                
                // Devolver el libro
                if (prestamo.devolverLibro()) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    // Getters para las listas
    public List<Libro> getLibros() {
        return libros;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}
