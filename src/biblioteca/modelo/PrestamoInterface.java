package biblioteca.modelo;

public interface PrestamoInterface {
    /*
        Polimorfismo:
        
        Esta interfaz permite que diferentes tipos de préstamos implementen
        su propia logica para realizar prestamos.
    */
    
    /*
        Variaciones Protegidas:
        
        Al definir una interfaz para los prestamos, protegemos el sistema contra
        cambios en la implementacion. Si necesitamos agregar nuevos tipos de elementos 
        prestables, solo necesitamos crear nuevas clases que implementen esta interfaz.
    */
    
    boolean realizarPrestamo();
    boolean validarPrestamo();
}
