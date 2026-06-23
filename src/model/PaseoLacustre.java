package model;

/**
 * Representa un paseo lacustre ofrecido por la agencia.
 * <p>
 * Extiende {@link ServicioTuristico}, agregando el atributo propio
 * {@code tipoEmbarcacion}, que indica el tipo de embarcación utilizada
 * durante el paseo.
 * </p>
 *
 * @author Olga Rivas Ahumada
 * @version 1.0
 */
public class PaseoLacustre extends ServicioTuristico {

    private String tipoEmbarcacion;

    /**
     * Crea un nuevo paseo lacustre.
     *
     * @param nombre nombre del servicio (heredado de {@code ServicioTuristico})
     * @param duracionHoras duración del servicio en horas (heredado de {@code ServicioTuristico})
     * @param tipoEmbarcacion tipo de embarcación utilizada en el paseo
     */
    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**
     * Obtiene el tipo de embarcación del paseo.
     *
     * @return tipo de embarcación
     */
    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    /**
     * Establece el tipo de embarcación del paseo.
     *
     * @param tipoEmbarcacion nuevo tipo de embarcación
     * @throws IllegalArgumentException si el valor es nulo o está vacío
     */
    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        if (!util.Validador.textoValido(tipoEmbarcacion)) {
            throw new IllegalArgumentException("El tipo de embarcación no puede estar vacío.");
        }
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**
     * Retorna una representación legible del paseo lacustre,
     * mostrando la información heredada más el tipo de embarcación.
     *
     * @return texto con nombre, duración y tipo de embarcación
     */
    @Override
    public String toString() {
        return super.toString() + " | Tipo: Paseo Lacustre | Embarcación: " + tipoEmbarcacion;
    }
}
