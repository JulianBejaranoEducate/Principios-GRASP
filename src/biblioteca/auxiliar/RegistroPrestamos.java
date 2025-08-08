package biblioteca.auxiliar;

import biblioteca.modelo.Prestamo;

import java.util.List;

public class RegistroPrestamos {
    
    /*
        Fabricación Pura:
        
        Esta clase se ha creado exclusivamente para manejar la presentacion
        y registro de los prestamos, sin tener responsabilidades de negocio.
        Su unico propósito es presentar información de manera adecuada, 
        descargando esta responsabilidad de las clases principales del modelo.
    */
    
    public String generarResumenPrestamos(List<Prestamo> prestamos) {
        StringBuilder resumen = new StringBuilder();
        resumen.append("===== RESUMEN DE PRÉSTAMOS ACTIVOS =====\n");
        
        int prestamosActivos = 0;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.isActivo()) {
                prestamosActivos++;
                resumen.append("Libro: ").append(prestamo.getLibro().getTitulo())
                       .append(" por ").append(prestamo.getLibro().getAutor()).append("\n");
                resumen.append("Usuario: ").append(prestamo.getUsuario().getNombre()).append("\n");
                resumen.append("------------------------------------\n");
            }
        }
        
        if (prestamosActivos == 0) {
            resumen.append("No hay préstamos activos actualmente.\n");
        }
        
        return resumen.toString();
    }
    
    public String generarComprobantePrestamo(Prestamo prestamo) {
        StringBuilder comprobante = new StringBuilder();
        comprobante.append("===== COMPROBANTE DE PRÉSTAMO =====\n");
        
        if (prestamo != null && prestamo.isActivo()) {
            comprobante.append("Libro: ").append(prestamo.getLibro().getTitulo()).append("\n");
            comprobante.append("Autor: ").append(prestamo.getLibro().getAutor()).append("\n");
            comprobante.append("Usuario: ").append(prestamo.getUsuario().getNombre()).append("\n");
            comprobante.append("Ejemplares disponibles: ").append(prestamo.getLibro().getEjemplaresDisponibles()).append("\n");
        } else {
            comprobante.append("No se pudo generar el comprobante para este préstamo.\n");
        }
        
        return comprobante.toString();
    }
}
