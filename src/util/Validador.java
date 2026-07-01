package util;

/**
 * Clase utilitaria de validaciones reutilizables.
 *
 * Continua el patron iniciado en la Semana 5: centraliza las reglas de
 * validacion en metodos estaticos puros (sin estado y sin imprimir nada
 * por consola). Devuelven true/false y es la capa que llama quien decide
 * que hacer ante un dato invalido (por ejemplo, lanzar una excepcion
 * personalizada o registrar el evento en el log de auditoria).
 */
public final class Validador {

    // Constructor privado: es una clase de utilidades, no se instancia.
    private Validador() {
    }

    /** Un texto es valido si no es nulo ni queda vacio al quitar espacios. */
    public static boolean textoValido(String valor) {
        return valor != null && !valor.trim().isEmpty();
    }

    /** Un precio es valido si es estrictamente mayor que cero. */
    public static boolean precioValido(double precio) {
        return precio > 0;
    }

    /** Una duracion (en horas) es valida si es estrictamente mayor que cero. */
    public static boolean duracionValida(int duracionHoras) {
        return duracionHoras > 0;
    }
}
