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
 * Servicio encargado de la lógica de gestión de tours.
 * <p>
 * Pertenece al paquete {@code service}. Se encarga de leer los datos desde
 * el archivo de texto, construir los objetos {@link Tour} (cada uno con su
 * {@link Guia}, {@link Proveedor} y {@link Operador}, aplicando composición)
 * y almacenarlos en una colección. Además ofrece operaciones de búsqueda y
 * filtrado sobre la colección cargada.
 *
 * @author Olga Rivas Ahumada
 * @version 2.0
 */
public class GestorTours {

    /** Colección dinámica que almacena los tours cargados. */
    private ArrayList<Tour> tours;

    /**
     * Crea un nuevo gestor con una colección de tours vacía.
     */
    public GestorTours() {
        this.tours = new ArrayList<>();
    }

    /**
     * Lee un archivo de texto y carga los tours en la colección interna.
     * <p>
     * Cada línea debe contener once campos separados por punto y coma
     * ({@code ;}) en el orden: nombre, tipo, precio, cupos, nombre del guía,
     * idioma del guía, años de experiencia del guía, empresa proveedora,
     * tipo de transporte, nombre del operador y comuna del operador. Las
     * líneas vacías o con un número incorrecto de campos se omiten.
     *
     * @param rutaArchivo la ruta del archivo de texto que se va a leer
     */
    public void cargarTours(String rutaArchivo) {
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = lector.readLine()) != null) {

                // Ignora líneas vacías
                if (!Validador.textoValido(linea)) {
                    continue;
                }

                // Separa los campos de la línea
                String[] datos = linea.split(";");

                // Valida que la línea tenga los 11 campos esperados
                if (!Validador.cantidadCamposValida(datos, 11)) {
                    System.out.println("Linea ignorada por formato incorrecto: " + linea);
                    continue;
                }

                // Datos del tour
                String nombre = datos[0];
                String tipo = datos[1];
                int precio = Integer.parseInt(datos[2]);
                int cupos = Integer.parseInt(datos[3]);

                // Datos del guía (composición)
                Guia guia = new Guia(datos[4], datos[5], Integer.parseInt(datos[6]));

                // Datos del proveedor de transporte (composición)
                Proveedor proveedor = new Proveedor(datos[7], datos[8]);

                // Datos del operador local (composición)
                Operador operador = new Operador(datos[9], datos[10]);

                // Crea el tour que contiene a los tres colaboradores
                Tour tour = new Tour(nombre, tipo, precio, cupos, guia, proveedor, operador);

                tours.add(tour);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de los datos numericos: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validacion en los datos: " + e.getMessage());
        }
    }

    /**
     * Devuelve la colección completa de tours cargados.
     *
     * @return un {@link ArrayList} con todos los tours
     */
    public ArrayList<Tour> getTours() {
        return tours;
    }

    /**
     * Busca los tours de un tipo determinado.
     *
     * @param tipo el tipo de tour a buscar (no distingue mayúsculas)
     * @return una lista con los tours que coinciden con el tipo
     */
    public ArrayList<Tour> buscarPorTipo(String tipo) {
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
     * @param nombre el nombre del tour a buscar (no distingue mayúsculas)
     * @return el {@link Tour} encontrado, o {@code null} si no existe
     */
    public Tour buscarPorNombre(String nombre) {
        for (Tour tour : tours) {
            if (tour.getNombre().equalsIgnoreCase(nombre)) {
                return tour;
            }
        }
        return null;
    }

    /**
     * Busca los tours cuyo precio sea menor o igual al máximo indicado.
     *
     * @param precioMaximo el precio máximo a considerar
     * @return una lista con los tours que cumplen la condición
     */
    public ArrayList<Tour> buscarPorPrecioMaximo(int precioMaximo) {
        ArrayList<Tour> resultado = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getPrecio() <= precioMaximo) {
                resultado.add(tour);
            }
        }
        return resultado;
    }

    /**
     * Elimina de la colección el tour cuyo nombre coincida con el indicado.
     * <p>
     * Recorre la lista buscando una coincidencia exacta de nombre (sin
     * distinguir mayúsculas). Si lo encuentra, lo elimina y devuelve
     * {@code true}; si no existe, devuelve {@code false} sin modificar la
     * colección. Esta operación completa el conjunto de operaciones sobre
     * la colección: inserción, acceso, recorrido, búsqueda y eliminación.
     *
     * @param nombre el nombre del tour que se desea eliminar
     * @return {@code true} si se eliminó un tour; {@code false} si no se encontró
     */
    public boolean eliminarPorNombre(String nombre) {
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).getNombre().equalsIgnoreCase(nombre)) {
                tours.remove(i);
                return true;
            }
        }
        return false;
    }
}
