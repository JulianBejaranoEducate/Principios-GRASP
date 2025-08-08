package biblioteca.modelo;

public interface PrestamoInterface {
    /*
        Polimorfismo:
        
        Esta interfaz permite que diferentes tipos de préstamos (libros, revistas, etc.)
        implementen su propia logica para realizar prestamos.
        Cada tipo de elemento podría tener diferentes reglas pero usar la misma interfaz.
    */
    
    /*
        Variaciones Protegidas:
        
        Al definir una interfaz para los prestamos, estamos protegiendo el sistema contra
        cambios en la implementacion. Si necesitamos agregar nuevos tipos de elementos 
        prestables, solo necesitamos crear nuevas clases que implementen esta interfaz 
        sin modificar el codigo existente.
    */
    
    boolean realizarPrestamo();
    
    boolean validarPrestamo();
}
