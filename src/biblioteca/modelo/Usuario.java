package biblioteca.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    
    private String nombre;
    private List<Prestamo> prestamos;
    private int maximoPrestamos;
    
    /*
        Experto en Informacion:
        
        La clase Usuario contiene la información sobre un usuario de la biblioteca,
        incluyendo sus prestamos actuales. Es experta en todo lo relacionado con
        los datos del usuario y su capacidad para solicitar nuevos prestamos.
    */
    
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.prestamos = new ArrayList<>();
        this.maximoPrestamos = 3; // Por defecto, un usuario puede tener hasta 3 préstamos
    }
    
    /*
        Verifica si el usuario puede solicitar más préstamos
    */
    public boolean puedePrestar() {
        return prestamos.size() < maximoPrestamos;
    }

    public boolean agregarPrestamo(Prestamo prestamo) {
        if (puedePrestar()) {
            prestamos.add(prestamo);
            return true;
        }
        return false;
    }

    public void eliminarPrestamo(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
    
    public int getMaximoPrestamos() {
        return maximoPrestamos;
    }
}
