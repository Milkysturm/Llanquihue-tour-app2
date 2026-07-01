package data;

import exception.GestorServiciosException;
import exception.ServicioInvalidoException;
import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import model.ServicioTuristico;
import util.RegistroAuditoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Gestor de la coleccion polimorfica de servicios turisticos.
 * <p>
 * Mantiene una {@code List<ServicioTuristico>} que almacena objetos de
 * distintas subclases de forma indistinta (polimorfismo de inclusion). Esta
 * clase <strong>no imprime nada por consola</strong>: cada evento, advertencia
 * o error se acumula en un {@link RegistroAuditoria}, dejando que sea la capa
 * de interfaz (ui) quien decida como mostrar esa informacion. De esta forma la
 * capa de datos queda desacoplada de la terminal, segun la recomendacion del
 * profesor.
 *
 * @author Olga Pamela Rivas Ahumada
 * @version 1.0 (Semana 7 - Polimorfismo y colecciones genericas)
 */
public class GestorServicios {

    /** Coleccion polimorfica que almacena los servicios turisticos. */
    private final List<ServicioTuristico> servicios;

    /** Registro donde se acumulan los eventos en lugar de imprimirlos. */
    private final RegistroAuditoria auditoria;

    /**
     * Crea un gestor con una coleccion vacia y su propio registro de auditoria.
     */
    public GestorServicios() {
        this.servicios = new ArrayList<>();
        this.auditoria = new RegistroAuditoria();
    }

    /**
     * Agrega un servicio a la coleccion y registra el evento en la auditoria.
     *
     * @param servicio el servicio a agregar; no puede ser nulo.
     * @throws GestorServiciosException si el servicio es nulo, lo que
     *                                  representaria un error de programacion.
     */
    public void agregarServicio(ServicioTuristico servicio) {
        if (servicio == null) {
            throw new GestorServiciosException(
                    "No se puede agregar un servicio nulo a la coleccion.");
        }
        servicios.add(servicio);
        auditoria.registrarInfo("Servicio agregado: " + servicio.getNombre()
                + " (" + servicio.getTipoServicio() + ").");
    }

    /**
     * Carga en la coleccion seis servicios de ejemplo combinando las distintas
     * subclases (cumpliendo el minimo de cinco requerido).
     * <p>
     * Los datos se crean manualmente, segun lo pedido esta semana. Si algun
     * dato resultara invalido, se captura la excepcion personalizada y se
     * registra en la auditoria, sin detener la carga del resto ni imprimir por
     * consola.
     */
    public void cargarServiciosDemo() {
        agregarSeguro(() -> new RutaGastronomica(
                "Sabores de Llanquihue", "Llanquihue",
                25000, 4, "Cocina del sur de Chile"));

        agregarSeguro(() -> new PaseoLacustre(
                "Navegacion al atardecer", "Puerto Varas",
                18000, 2, "Lago Llanquihue"));

        agregarSeguro(() -> new ExcursionCultural(
                "Huellas alemanas", "Frutillar",
                15000, 3, "Museo Colonial Aleman"));

        agregarSeguro(() -> new RutaGastronomica(
                "Ruta del cordero patagonico", "Cochamo",
                32000, 5, "Asados y productos del campo"));

        agregarSeguro(() -> new PaseoLacustre(
                "Travesia Todos los Santos", "Petrohue",
                28000, 4, "Lago Todos los Santos"));

        agregarSeguro(() -> new ExcursionCultural(
                "Senda patrimonial", "Puerto Octay",
                12000, 2, "Casco historico de Puerto Octay"));
    }

    /**
     * Interfaz funcional interna para crear un servicio que puede fallar con
     * una excepcion comprobada. Permite centralizar el manejo de errores de
     * datos en un unico lugar ({@link #agregarSeguro(CreadorServicio)}).
     */
    @FunctionalInterface
    private interface CreadorServicio {
        /**
         * Crea un servicio turistico.
         *
         * @return el servicio creado.
         * @throws ServicioInvalidoException si los datos no son validos.
         */
        ServicioTuristico crear() throws ServicioInvalidoException;
    }

    /**
     * Intenta crear y agregar un servicio. Si los datos son invalidos, en vez
     * de propagar el error o imprimirlo, lo registra en la auditoria y
     * continua. Demuestra el desacople entre la logica y la consola.
     *
     * @param creador funcion que construye el servicio a agregar.
     */
    private void agregarSeguro(CreadorServicio creador) {
        try {
            agregarServicio(creador.crear());
        } catch (ServicioInvalidoException e) {
            auditoria.registrarError("No se pudo crear el servicio: "
                    + e.getMessage());
        }
    }

    /**
     * Devuelve la lista de servicios como referencias de la superclase, lista
     * para recorrerse polimorficamente. La lista es de solo lectura para
     * proteger la coleccion interna.
     *
     * @return una vista inmutable de la coleccion de servicios.
     */
    public List<ServicioTuristico> obtenerServicios() {
        return Collections.unmodifiableList(servicios);
    }

    /**
     * Indica cuantos servicios hay almacenados en la coleccion.
     *
     * @return la cantidad de servicios cargados.
     */
    public int cantidadServicios() {
        return servicios.size();
    }

    /**
     * Entrega el registro de auditoria para que la capa ui pueda mostrarlo.
     *
     * @return el registro de auditoria del gestor.
     */
    public RegistroAuditoria getAuditoria() {
        return auditoria;
    }
}
