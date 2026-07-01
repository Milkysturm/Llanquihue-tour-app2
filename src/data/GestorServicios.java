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
 *
 * Mantiene una List<ServicioTuristico> que almacena objetos de distintas
 * subclases de forma indistinta (polimorfismo de inclusion). Esta clase
 * NO imprime nada por consola: cada evento, advertencia o error se acumula
 * en un RegistroAuditoria, dejando que sea la capa ui quien decida como
 * mostrar esa informacion. Asi la capa de datos queda desacoplada de la
 * terminal, segun la recomendacion del profesor.
 */
public class GestorServicios {

    private final List<ServicioTuristico> servicios;
    private final RegistroAuditoria auditoria;

    public GestorServicios() {
        this.servicios = new ArrayList<>();
        this.auditoria = new RegistroAuditoria();
    }

    /**
     * Agrega un servicio a la coleccion.
     *
     * @throws GestorServiciosException (unchecked) si el servicio es nulo,
     *         lo que representaria un error de programacion, no de datos.
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
     * Carga en la coleccion al menos cinco servicios de ejemplo combinando
     * las distintas subclases. Los datos se crean manualmente (no se leen de
     * archivo, segun lo pedido esta semana).
     *
     * Si algun dato resultara invalido, se captura la excepcion personalizada
     * y se registra en la auditoria, sin detener la carga del resto ni
     * imprimir por consola.
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
     * datos en un solo lugar (agregarSeguro).
     */
    @FunctionalInterface
    private interface CreadorServicio {
        ServicioTuristico crear() throws ServicioInvalidoException;
    }

    /**
     * Intenta crear y agregar un servicio. Si los datos son invalidos, en vez
     * de propagar el error o imprimirlo, lo registra en la auditoria y
     * continua. Esto demuestra el desacople entre logica y consola.
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
     * para recorrerse polimorficamente.
     */
    public List<ServicioTuristico> obtenerServicios() {
        return Collections.unmodifiableList(servicios);
    }

    public int cantidadServicios() {
        return servicios.size();
    }

    public RegistroAuditoria getAuditoria() {
        return auditoria;
    }
}
