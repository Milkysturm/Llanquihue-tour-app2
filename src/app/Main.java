package app;

import model.Tour;
import service.GestorTours;

import java.util.ArrayList;

/**
 * Clase principal de la aplicación Llanquihue Tour (Semana 5).
 * <p>
 * Pertenece al paquete {@code app}. Coordina el flujo del programa:
 * solicita la carga de los tours al {@link service.GestorTours}, muestra
 * el catálogo completo y ejecuta distintas operaciones de búsqueda y
 * filtrado, presentando los resultados por consola.
 *
 * @author Olga Rivas Ahumada
 * @version 2.0
 */
public class Main {

    /**
     * Punto de entrada del programa.
     *
     */
    static void main() {

        // Ruta del archivo de datos dentro de la carpeta resources
        String rutaArchivo = "src/resources/tours.txt";

        // Crea el gestor y carga los tours
        GestorTours gestor = new GestorTours();
        gestor.cargarTours(rutaArchivo);

        // ----- 1. CATÁLOGO COMPLETO -----
        System.out.println("=== CATALOGO COMPLETO DE TOURS ===");
        for (Tour tour : gestor.getTours()) {
            System.out.println(tour);
        }
        System.out.println("\nTotal de tours cargados: " + gestor.getTours().size());

        // ----- 2. BÚSQUEDA POR TIPO -----
        System.out.println("\n=== BUSQUEDA: TOURS GASTRONOMICOS ===");
        ArrayList<Tour> gastronomicos = gestor.buscarPorTipo("gastronomico");
        for (Tour tour : gastronomicos) {
            System.out.println(tour);
        }

        // ----- 3. BÚSQUEDA POR PRECIO -----
        System.out.println("\n=== BUSQUEDA: TOURS ECONOMICOS (precio <= $20.000) ===");
        ArrayList<Tour> economicos = gestor.buscarPorPrecioMaximo(20000);
        for (Tour tour : economicos) {
            System.out.println(tour);
        }

        // ----- 4. BÚSQUEDA POR NOMBRE Y DETALLE DE COLABORADORES -----
        System.out.println("\n=== BUSQUEDA POR NOMBRE: 'Excursion Volcan Osorno' ===");
        Tour encontrado = gestor.buscarPorNombre("Excursion Volcan Osorno");
        if (encontrado != null) {
            System.out.println("Tour encontrado: " + encontrado.getNombre());
            System.out.println("  Guia a cargo : " + encontrado.getGuia());
            System.out.println("  Transporte   : " + encontrado.getProveedor());
            System.out.println("  Operador     : " + encontrado.getOperador());
        } else {
            System.out.println("No se encontro el tour buscado.");
        }

        // ----- 5. ELIMINACION DE UN TOUR DE LA COLECCION -----
        System.out.println("\n=== ELIMINACION: quitar 'City Tour Puerto Varas' ===");
        System.out.println("Tours antes de eliminar: " + gestor.getTours().size());
        boolean eliminado = gestor.eliminarPorNombre("City Tour Puerto Varas");
        if (eliminado) {
            System.out.println("El tour fue eliminado correctamente.");
        } else {
            System.out.println("No se encontro el tour a eliminar.");
        }
        System.out.println("Tours despues de eliminar: " + gestor.getTours().size());
    }
}
