package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Registro de auditoria (log) del sistema.
 *
 * En lugar de imprimir mensajes con System.out.println dentro de las capas
 * de datos o de logica, estas capas ACUMULAN aqui sus mensajes (eventos,
 * advertencias y errores). Mas tarde, unicamente la capa de interfaz (ui)
 * decide como y cuando mostrar este registro por consola.
 */
public class RegistroAuditoria {

    private final List<String> eventos;

    public RegistroAuditoria() {
        this.eventos = new ArrayList<>();
    }

    /** Registra un evento informativo. */
    public void registrarInfo(String mensaje) {
        eventos.add("[INFO]  " + mensaje);
    }

    /** Registra una advertencia (algo recuperable). */
    public void registrarAdvertencia(String mensaje) {
        eventos.add("[WARN]  " + mensaje);
    }

    /** Registra un error (algo que impidio completar una operacion). */
    public void registrarError(String mensaje) {
        eventos.add("[ERROR] " + mensaje);
    }

    /**
     * Devuelve una copia inmutable del registro, para que la capa ui pueda
     * leerlo sin poder alterar el log interno.
     */
    public List<String> obtenerEventos() {
        return Collections.unmodifiableList(new ArrayList<>(eventos));
    }

    public boolean estaVacio() {
        return eventos.isEmpty();
    }

    public int cantidadEventos() {
        return eventos.size();
    }
}
