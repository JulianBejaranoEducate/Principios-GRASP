/*Julian Francisco Bejarano García*/

package biblioteca.main;

import biblioteca.controller.BibliotecaController;
import biblioteca.modelo.Libro;
import biblioteca.modelo.Prestamo;
import biblioteca.modelo.Usuario;
import biblioteca.auxiliar.RegistroPrestamos;

/*
    Clase principal que demuestra el uso de los patrones GRASP
    en un sistema de biblioteca simplificado.
*/
public class Main {
    
    public static void main(String[] args) {
        // Crear el controlador (patron Controlador)
        BibliotecaController controller = new BibliotecaController();
        
        // Crear un objeto para generar informes (patron Fabricacion Pura)
        RegistroPrestamos registro = new RegistroPrestamos();
        
        // Obtener referencias a libros y usuarios
        Libro libro = controller.getLibros().get(0);
        Usuario usuario1 = controller.getUsuarios().get(0);
        Usuario usuario2 = controller.getUsuarios().get(1);
        
        System.out.println("===== SISTEMA DE BIBLIOTECA =====");
        
        // Realizar prestamo (usando patron Indireccion)
        System.out.println("\n[1] Realizando préstamo para " + usuario1.getNombre());
        Prestamo prestamo = controller.crearPrestamo(libro, usuario1);
        
        if (prestamo != null) {
            // Usar la fabricacion pura para generar el comprobante
            System.out.println(registro.generarComprobantePrestamo(prestamo));
        }
        
        // Devolver el libro
        System.out.println("\n[2] Devolviendo libro");
        if (controller.devolverLibro(libro, usuario1)) {
            System.out.println("Libro devuelto con éxito");
        }
        
        // Realizar otro prestamo con otro usuario
        System.out.println("\n[3] Realizando préstamo para " + usuario2.getNombre());
        prestamo = controller.crearPrestamo(libro, usuario2);
        
        if (prestamo != null) {
            System.out.println(registro.generarComprobantePrestamo(prestamo));
            // Mostrar el resumen de prestamos
            System.out.println("\n" + registro.generarResumenPrestamos(controller.getPrestamos()));
        }
    }
}
