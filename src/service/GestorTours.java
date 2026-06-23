package service;

import model.Guia;
import model.Operador;
import model.Proveedor;
import model.Tour;
import util.Validador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servicio encargado de leer el archivo {@code tours.txt}, construir los
 * objetos {@link Tour} junto con sus colaboradores compuestos, y ofrecer
 * operaciones de búsqueda y eliminación sobre la colección resultante.
 *
 * @author Olga Rivas Ahumada
 * @version 1.0
 */
public class GestorTours {

    /** Cantidad de campos esperados por línea en el archivo de datos. */
    private static final int CAMPOS_POR_LINEA = 11;

    /**
     * Lee el archivo de tours indicado y construye la lista de objetos
     * {@link Tour}, junto con sus respectivos {@link Guia}, {@link Proveedor}
     * y {@link Operador}.
     *
     * @param rutaArchivo ruta del archivo {@code tours.txt}
     * @return lista de tours cargados desde el archivo
     */
    public ArrayList<Tour> cargarTours(String rutaArchivo) {
        ArrayList<Tour> tours = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] campos = linea.split(";");

                if (!Validador.cantidadCamposValida(campos, CAMPOS_POR_LINEA)) {
                    System.out.println("Línea con formato inválido, se omite: " + linea);
                    continue;
                }

                try {
                    String nombre = campos[0];
                    String tipo = campos[1];
                    double precio = Double.parseDouble(campos[2]);
                    int cupos = Integer.parseInt(campos[3]);

                    Guia guia = new Guia(campos[4], campos[5], Integer.parseInt(campos[6]));
                    Proveedor proveedor = new Proveedor(campos[7], campos[8]);
                    Operador operador = new Operador(campos[9], campos[10]);

                    Tour tour = new Tour(nombre, tipo, precio, cupos, guia, proveedor, operador);
                    tours.add(tour);

                } catch (NumberFormatException e) {
                    System.out.println("Error de formato numérico en línea, se omite: " + linea);
                } catch (IllegalArgumentException e) {
                    System.out.println("Dato inválido en línea, se omite: " + linea + " (" + e.getMessage() + ")");
                }
            }
        } catch (IOException e) {
            System.out.println("No fue posible leer el archivo: " + rutaArchivo + " (" + e.getMessage() + ")");
        }

        return tours;
    }

    /**
     * Busca tours que coincidan exactamente con el tipo indicado.
     *
     * @param tours lista de tours sobre la cual buscar
     * @param tipo tipo de tour a buscar
     * @return lista de tours que coinciden con el tipo
     */
    public ArrayList<Tour> buscarPorTipo(ArrayList<Tour> tours, String tipo) {
        ArrayList<Tour> resultado = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(tour);
            }
        }
        return resultado;
    }

    /**
     * Busca un tour por su nombre exacto.
     *
     * @param tours lista de tours sobre la cual buscar
     * @param nombre nombre del tour a buscar
     * @return el tour encontrado, o {@code null} si no existe
     */
    public Tour buscarPorNombre(ArrayList<Tour> tours, String nombre) {
        for (Tour tour : tours) {
            if (tour.getNombre().equalsIgnoreCase(nombre)) {
                return tour;
            }
        }
        return null;
    }

    /**
     * Busca tours cuyo precio sea menor o igual al precio máximo indicado.
     *
     * @param tours lista de tours sobre la cual buscar
     * @param precioMaximo precio máximo a considerar
     * @return lista de tours dentro del rango de precio
     */
    public ArrayList<Tour> buscarPorPrecioMaximo(ArrayList<Tour> tours, double precioMaximo) {
        ArrayList<Tour> resultado = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getPrecio() <= precioMaximo) {
                resultado.add(tour);
            }
        }
        return resultado;
    }

    /**
     * Elimina de la lista el primer tour cuyo nombre coincida con el indicado.
     *
     * @param tours lista de tours sobre la cual eliminar
     * @param nombre nombre del tour a eliminar
     * @return {@code true} si se eliminó un tour, {@code false} si no se encontró
     */
    public boolean eliminarPorNombre(ArrayList<Tour> tours, String nombre) {
        Tour tour = buscarPorNombre(tours, nombre);
        if (tour != null) {
            tours.remove(tour);
            return true;
        }
        return false;
    }
}
