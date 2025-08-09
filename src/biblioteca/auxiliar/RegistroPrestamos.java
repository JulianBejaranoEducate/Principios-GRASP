package biblioteca.auxiliar;

import biblioteca.modelo.Prestamo;

import java.util.List;

public class RegistroPrestamos {
    
    /*
        Fabricacion Pura:
        
        Esta clase se ha creado exclusivamente para manejar la presentacion
        y registro de los prestamos, sin tener responsabilidades de negocio.
        Su unico propósito es presentar informacion de manera adecuada.
    */
    
    public String generarResumenPrestamos(List<Prestamo> prestamos) {
        StringBuilder resumen = new StringBuilder();
        resumen.append("===== RESUMEN DE PRESTAMOS ACTIVOS =====\n");
        
        int activos = 0;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.isActivo()) {
                activos++;
                resumen.append("Libro: ").append(prestamo.getLibro().getTitulo())
                       .append(" - Usuario: ").append(prestamo.getUsuario().getNombre())
                       .append("\n");
            }
        }
        
        if (activos == 0) {
            resumen.append("No hay prestamos activos actualmente.\n");
        }
        
        return resumen.toString();
    }
    
    public String generarComprobantePrestamo(Prestamo prestamo) {
        StringBuilder comprobante = new StringBuilder();
        comprobante.append("===== COMPROBANTE DE PRESTAMO =====\n");
        
        if (prestamo != null && prestamo.isActivo()) {
            comprobante.append("Libro: ").append(prestamo.getLibro().getTitulo()).append("\n");
            comprobante.append("Usuario: ").append(prestamo.getUsuario().getNombre()).append("\n");
        } else {
            comprobante.append("No se pudo generar el comprobante para este prestamo.\n");
        }
        
        return comprobante.toString();
    }
}
