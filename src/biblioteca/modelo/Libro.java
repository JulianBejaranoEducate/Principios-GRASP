package biblioteca.modelo;

public class Libro {
    
    private String titulo;
    private String autor;
    private int ejemplaresDisponibles;
    
    /*
        Experto en Informacion:
        
        La clase Libro contiene toda la información relacionada con un libro,
        por lo que es la experta para cualquier operacion que necesite estos datos.
        Por ejemplo, verificar disponibilidad o actualizar el numero de ejemplares.
    */
    
    public Libro(String titulo, String autor, int ejemplaresDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }
    
    public boolean prestar() {
        if (ejemplaresDisponibles > 0) {
            ejemplaresDisponibles--;
            return true;
        }
        return false;
    }
    
    public void devolver() {
        ejemplaresDisponibles++;
    }
    
    // Getters
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getEjemplaresDisponibles() { return ejemplaresDisponibles; }
}
