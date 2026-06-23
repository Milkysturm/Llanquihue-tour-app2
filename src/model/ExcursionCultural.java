package model;

/**
 * Representa una excursión cultural ofrecida por la agencia.
 * <p>
 * Extiende {@link ServicioTuristico}, agregando el atributo propio
 * {@code lugarHistorico}, que indica el lugar histórico o patrimonial
 * visitado durante la excursión.
 * </p>
 *
 * @author Olga Rivas Ahumada
 * @version 1.0
 */
public class ExcursionCultural extends ServicioTuristico {

    private String lugarHistorico;

    /**
     * Crea una nueva excursión cultural.
     *
     * @param nombre nombre del servicio (heredado de {@code ServicioTuristico})
     * @param duracionHoras duración del servicio en horas (heredado de {@code ServicioTuristico})
     * @param lugarHistorico lugar histórico o patrimonial que se visita
     */
    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    /**
     * Obtiene el lugar histórico visitado.
     *
     * @return lugar histórico
     */
    public String getLugarHistorico() {
        return lugarHistorico;
    }

    /**
     * Establece el lugar histórico visitado.
     *
     * @param lugarHistorico nuevo lugar histórico
     * @throws IllegalArgumentException si el valor es nulo o está vacío
     */
    public void setLugarHistorico(String lugarHistorico) {
        if (!util.Validador.textoValido(lugarHistorico)) {
            throw new IllegalArgumentException("El lugar histórico no puede estar vacío.");
        }
        this.lugarHistorico = lugarHistorico;
    }

    /**
     * Retorna una representación legible de la excursión cultural,
     * mostrando la información heredada más el lugar histórico.
     *
     * @return texto con nombre, duración y lugar histórico
     */
    @Override
    public String toString() {
        return super.toString() + " | Tipo: Excursión Cultural | Lugar histórico: " + lugarHistorico;
    }
}
