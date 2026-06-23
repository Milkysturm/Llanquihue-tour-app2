package data;

import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import model.ServicioTuristico;
import util.Validador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Encargada de crear instancias de prueba de la jerarquía
 * {@link ServicioTuristico}, leyéndolas desde el archivo
 * {@code servicios.txt}.
 * <p>
 * Cada línea del archivo tiene el formato:
 * {@code nombre;duracionHoras;tipoSubclase;atributoEspecifico}, donde
 * {@code tipoSubclase} es uno de {@code RutaGastronomica},
 * {@code PaseoLacustre} o {@code ExcursionCultural}, y
 * {@code atributoEspecifico} corresponde al atributo propio de esa
 * subclase (número de paradas, tipo de embarcación o lugar histórico).
 * </p>
 *
 * @author Olga Rivas Ahumada
 * @version 1.0
 */
public class GestorServicios {

    /** Cantidad de campos esperados por línea en el archivo de datos. */
    private static final int CAMPOS_POR_LINEA = 4;

    /**
     * Lee el archivo de servicios indicado y construye la lista de objetos
     * {@link ServicioTuristico}, instanciando la subclase correspondiente
     * según el tipo indicado en cada línea.
     *
     * @param rutaArchivo ruta del archivo {@code servicios.txt}
     * @return lista de servicios turísticos cargados desde el archivo
     */
    public ArrayList<ServicioTuristico> cargarServicios(String rutaArchivo) {
        ArrayList<ServicioTuristico> servicios = new ArrayList<>();

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
                    int duracionHoras = Integer.parseInt(campos[1]);
                    String tipoSubclase = campos[2];
                    String atributoEspecifico = campos[3];

                    ServicioTuristico servicio = crearServicio(nombre, duracionHoras, tipoSubclase, atributoEspecifico);

                    if (servicio != null) {
                        servicios.add(servicio);
                    } else {
                        System.out.println("Tipo de servicio desconocido, se omite: " + linea);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error de formato numérico en línea, se omite: " + linea);
                } catch (IllegalArgumentException e) {
                    System.out.println("Dato inválido en línea, se omite: " + linea + " (" + e.getMessage() + ")");
                }
            }
        } catch (IOException e) {
            System.out.println("No fue posible leer el archivo: " + rutaArchivo + " (" + e.getMessage() + ")");
        }

        return servicios;
    }

    /**
     * Crea la instancia de la subclase de {@link ServicioTuristico} que
     * corresponda según el tipo indicado.
     *
     * @param nombre nombre del servicio
     * @param duracionHoras duración del servicio en horas
     * @param tipoSubclase tipo de subclase a instanciar
     * @param atributoEspecifico valor del atributo propio de la subclase
     * @return la instancia creada, o {@code null} si el tipo no es reconocido
     */
    private ServicioTuristico crearServicio(String nombre, int duracionHoras,
                                             String tipoSubclase, String atributoEspecifico) {
        switch (tipoSubclase) {
            case "RutaGastronomica":
                int numeroDeParadas = Integer.parseInt(atributoEspecifico);
                return new RutaGastronomica(nombre, duracionHoras, numeroDeParadas);

            case "PaseoLacustre":
                return new PaseoLacustre(nombre, duracionHoras, atributoEspecifico);

            case "ExcursionCultural":
                return new ExcursionCultural(nombre, duracionHoras, atributoEspecifico);

            default:
                return null;
        }
    }
}
