package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Registro de auditoria (log) del sistema.
 * <p>
 * En lugar de imprimir mensajes con {@code System.out.println} dentro de las
 * capas de datos o de logica, estas capas acumulan aqui sus mensajes (eventos,
 * advertencias y errores). Mas tarde, unicamente la capa de interfaz (ui)
 * decide como y cuando mostrar este registro por consola.
 * <p>
 * De esta forma las capas de servicio quedan completamente desacopladas de la
 * terminal, tal como recomendo el profesor.
 *
 * @author Olga Pamela Rivas Ahumada
 * @version 1.0 (Semana 7 - Polimorfismo y colecciones genericas)
 */
public class RegistroAuditoria {

    /** Lista interna donde se acumulan los eventos registrados. */
    private final List<String> eventos;

    /**
     * Crea un registro de auditoria vacio.
     */
    public RegistroAuditoria() {
        this.eventos = new ArrayList<>();
    }

    /**
     * Registra un evento informativo.
     *
     * @param mensaje texto descriptivo del evento.
     */
    public void registrarInfo(String mensaje) {
        eventos.add("[INFO]  " + mensaje);
    }

    /**
     * Registra una advertencia (una situacion recuperable).
     *
     * @param mensaje texto descriptivo de la advertencia.
     */
    public void registrarAdvertencia(String mensaje) {
        eventos.add("[WARN]  " + mensaje);
    }

    /**
     * Registra un error (algo que impidio completar una operacion).
     *
     * @param mensaje texto descriptivo del error.
     */
    public void registrarError(String mensaje) {
        eventos.add("[ERROR] " + mensaje);
    }

    /**
     * Devuelve una copia inmutable del registro, para que la capa ui pueda
     * leerlo sin poder alterar el log interno.
     *
     * @return una vista de solo lectura con todos los eventos registrados.
     */
    public List<String> obtenerEventos() {
        return Collections.unmodifiableList(new ArrayList<>(eventos));
    }

    /**
     * Indica si el registro no contiene eventos.
     *
     * @return {@code true} si no hay eventos registrados.
     */
    public boolean estaVacio() {
        return eventos.isEmpty();
    }

    /**
     * Indica cuantos eventos hay registrados.
     *
     * @return la cantidad de eventos acumulados.
     */
    public int cantidadEventos() {
        return eventos.size();
    }
}
