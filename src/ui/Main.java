package ui;

import data.GestorServicios;
import model.ServicioTuristico;
import model.Tour;
import service.GestorTours;

import java.util.ArrayList;

/**
 * Punto de entrada del sistema Llanquihue Tour.
 * <p>
 * Ejecuta dos flujos independientes:
 * </p>
 * <ul>
 *   <li><b>Tours</b> (Semana 4 y 5): carga {@link Tour} desde {@code tours.txt}
 *       usando {@link GestorTours}, y muestra el catálogo junto con búsquedas
 *       por tipo, nombre y precio.</li>
 *   <li><b>Servicios turísticos</b> (Semana 6): carga la jerarquía de
 *       {@link ServicioTuristico} desde {@code servicios.txt} usando
 *       {@link GestorServicios}, y muestra cada instancia por consola.</li>
 * </ul>
 *
 * @author Olga Rivas Ahumada
 * @version 2.0
 */
public class Main {

    /**
     * Método principal que ejecuta el sistema completo.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        // ===================================================
        // PARTE 1: Tours (Semana 4 y 5) — composición
        // ===================================================
        System.out.println("==========================================");
        System.out.println(" LLANQUIHUE TOUR - CATALOGO DE TOURS");
        System.out.println("==========================================\n");

        GestorTours gestorTours = new GestorTours();
        ArrayList<Tour> tours = gestorTours.cargarTours("src/resources/tours.txt");

        System.out.println("--- Catálogo completo de tours (" + tours.size() + ") ---\n");
        for (Tour tour : tours) {
            System.out.println(tour);
            System.out.println();
        }

        System.out.println("--- Búsqueda por tipo: Lacustre ---\n");
        ArrayList<Tour> lacustres = gestorTours.buscarPorTipo(tours, "Lacustre");
        for (Tour tour : lacustres) {
            System.out.println(tour);
            System.out.println();
        }

        System.out.println("--- Búsqueda por nombre: \"Ruta de los Volcanes\" ---\n");
        Tour encontrado = gestorTours.buscarPorNombre(tours, "Ruta de los Volcanes");
        if (encontrado != null) {
            System.out.println(encontrado);
        } else {
            System.out.println("No se encontró el tour solicitado.");
        }
        System.out.println();

        System.out.println("--- Búsqueda por precio máximo: $26000 ---\n");
        ArrayList<Tour> economicos = gestorTours.buscarPorPrecioMaximo(tours, 26000);
        for (Tour tour : economicos) {
            System.out.println(tour);
            System.out.println();
        }

        // ===================================================
        // PARTE 2: Servicios turísticos (Semana 6) — herencia
        // ===================================================
        System.out.println("==========================================");
        System.out.println(" LLANQUIHUE TOUR - SERVICIOS TURISTICOS");
        System.out.println(" (Jerarquia de herencia)");
        System.out.println("==========================================\n");

        GestorServicios gestorServicios = new GestorServicios();
        ArrayList<ServicioTuristico> servicios = gestorServicios.cargarServicios("src/resources/servicios.txt");

        System.out.println("--- Listado de servicios turísticos (" + servicios.size() + ") ---\n");
        for (ServicioTuristico servicio : servicios) {
            System.out.println(servicio);
        }
    }
}
