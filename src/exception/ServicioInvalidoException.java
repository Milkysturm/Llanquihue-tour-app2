package exception;

/**
 * Excepcion personalizada de tipo <strong>comprobada</strong> (checked).
 * <p>
 * Se lanza cuando los datos con los que se intenta construir un
 * {@code ServicioTuristico} no cumplen las reglas de validacion del negocio
 * (por ejemplo: nombre vacio, precio negativo o duracion no valida).
 * <p>
 * Al extender {@link Exception}, obliga a quien crea un servicio a manejar
 * explicitamente el caso de datos invalidos, desacoplando la capa de modelo y
 * de datos de cualquier impresion por consola.
 *
 * @author Olga Pamela Rivas Ahumada
 * @version 1.0 (Semana 7 - Polimorfismo y colecciones genericas)
 */
public class ServicioInvalidoException extends Exception {

    /**
     * Crea la excepcion con un mensaje descriptivo del error.
     *
     * @param mensaje detalle de la regla de validacion incumplida.
     */
    public ServicioInvalidoException(String mensaje) {
        super(mensaje);
    }

    /**
     * Crea la excepcion con un mensaje y la causa original que la provoco.
     *
     * @param mensaje detalle de la regla de validacion incumplida.
     * @param causa   excepcion original encadenada como causa.
     */
    public ServicioInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
