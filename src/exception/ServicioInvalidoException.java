package exception;

/**
 * Excepcion personalizada de tipo CHECKED.
 *
 * Se lanza cuando los datos con los que se intenta construir un
 * ServicioTuristico no cumplen las reglas de validacion del negocio
 * (por ejemplo: nombre vacio, precio negativo o duracion no valida).
 *
 * Al ser una excepcion comprobada (extends Exception), obliga a quien
 * crea un servicio a manejar explicitamente el caso de datos invalidos,
 * desacoplando la capa de modelo/datos de cualquier impresion por consola.
 */
public class ServicioInvalidoException extends Exception {

    public ServicioInvalidoException(String mensaje) {
        super(mensaje);
    }

    public ServicioInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
