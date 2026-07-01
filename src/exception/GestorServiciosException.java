package exception;

/**
 * Excepcion personalizada de tipo UNCHECKED.
 *
 * Se lanza ante errores de configuracion o de programacion que NO
 * dependen de la entrada del usuario, por ejemplo, intentar registrar
 * un servicio nulo en el gestor de la coleccion.
 *
 * Al extender RuntimeException no obliga a su captura, ya que representa
 * una condicion que no deberia ocurrir si el sistema esta bien construido.
 */
public class GestorServiciosException extends RuntimeException {

    public GestorServiciosException(String mensaje) {
        super(mensaje);
    }

    public GestorServiciosException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
