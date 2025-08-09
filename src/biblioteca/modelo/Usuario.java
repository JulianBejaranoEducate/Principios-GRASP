package biblioteca.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    
    private String nombre;
    private List<Prestamo> prestamos;
    private int maximoPrestamos = 3; // Por defecto, máximo 3 préstamos
    
    /*
        Experto en Informacion:
        
        La clase Usuario contiene la informacion sobre un usuario de la biblioteca,
        incluyendo sus préstamos actuales. Es experta en todo lo relacionado con
        los datos del usuario y su capacidad para solicitar nuevos préstamos.
    */
    
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.prestamos = new ArrayList<>();
    }
    
    public boolean agregarPrestamo(Prestamo prestamo) {
        if (prestamos.size() < maximoPrestamos) {
            prestamos.add(prestamo);
            return true;
        }
        return false;
    }

    public void eliminarPrestamo(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }
    
    // Getters
    public String getNombre() { return nombre; }
}
