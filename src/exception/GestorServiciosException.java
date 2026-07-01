package exception;

/**
 * Excepcion personalizada de tipo <strong>no comprobada</strong> (unchecked).
 * <p>
 * Se lanza ante errores de configuracion o de programacion que no dependen de
 * la entrada del usuario; por ejemplo, intentar registrar un servicio nulo en
 * el gestor de la coleccion.
 * <p>
 * Al extender {@link RuntimeException} no obliga a su captura, ya que
 * representa una condicion que no deberia ocurrir si el sistema esta bien
 * construido.
 *
 * @author Olga Pamela Rivas Ahumada
 * @version 1.0 (Semana 7 - Polimorfismo y colecciones genericas)
 */
public class GestorServiciosException extends RuntimeException {

    /**
     * Crea la excepcion con un mensaje descriptivo del error.
     *
     * @param mensaje detalle del error de uso del gestor.
     */
    public GestorServiciosException(String mensaje) {
        super(mensaje);
    }

    /**
     * Crea la excepcion con un mensaje y la causa original que la provoco.
     *
     * @param mensaje detalle del error de uso del gestor.
     * @param causa   excepcion original encadenada como causa.
     */
    public GestorServiciosException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
