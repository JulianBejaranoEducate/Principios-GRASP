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
        y las clases del modelo. Se encarga de coordinar las operaciones de negocio.
    */
    
    /*
        Indireccion:
        
        Este controlador proporciona una capa de indireccion entre el modelo
        y la interfaz de usuario, permitiendo que estos componentes esten desacoplados.
    */
    
    /*
        Creador:
        
        El controlador es responsable de crear instancias de Libro, Usuario y Prestamo,
        ya que tiene toda la informacion necesaria para su creacion.
    */
    
    public BibliotecaController() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        
        // Inicializamos con datos de ejemplo
        crearLibro("El Principito", "Antoine de Saint Exupery", 2);
        crearLibro("Cien años de soledad", "Gabriel Garcia Marquez", 1);
        crearUsuario("Juan Perez");
        crearUsuario("Ana Garcia");
    }
    
    // Metodos para crear objetos "Creator"
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
    
    public boolean devolverLibro(Libro libro, Usuario usuario) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.isActivo() && 
                prestamo.getLibro() == libro && 
                prestamo.getUsuario() == usuario) {
                return prestamo.devolverLibro();
            }
        }
        return false;
    }
    
    // Getters para las listas
    public List<Libro> getLibros() { return libros; }
    public List<Usuario> getUsuarios() { return usuarios; }
    public List<Prestamo> getPrestamos() { return prestamos; }
}
