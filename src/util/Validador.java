package util;

/**
 * Clase utilitaria con validaciones reutilizables del sistema.
 * <p>
 * Continua el patron iniciado en la Semana 5: centraliza las reglas de
 * validacion en metodos estaticos puros (sin estado y sin imprimir nada por
 * consola). Devuelven {@code true} o {@code false} y es la capa que llama quien
 * decide que hacer ante un dato invalido (por ejemplo, lanzar una excepcion
 * personalizada o registrar el evento en el log de auditoria).
 *
 * @author Olga Pamela Rivas Ahumada
 * @version 1.0 (Semana 7 - Polimorfismo y colecciones genericas)
 */
public final class Validador {

    /**
     * Constructor privado: es una clase de utilidades y no debe instanciarse.
     */
    private Validador() {
    }

    /**
     * Verifica que un texto no sea nulo ni quede vacio al quitar espacios.
     *
     * @param valor el texto a validar.
     * @return {@code true} si el texto tiene contenido util.
     */
    public static boolean textoValido(String valor) {
        return valor != null && !valor.trim().isEmpty();
    }

    /**
     * Verifica que un precio sea estrictamente mayor que cero.
     *
     * @param precio el valor a validar.
     * @return {@code true} si el precio es mayor que cero.
     */
    public static boolean precioValido(double precio) {
        return precio > 0;
    }

    /**
     * Verifica que una duracion en horas sea estrictamente mayor que cero.
     *
     * @param duracionHoras la duracion a validar.
     * @return {@code true} si la duracion es mayor que cero.
     */
    public static boolean duracionValida(int duracionHoras) {
        return duracionHoras > 0;
    }
}
