package model;

/**
 * Representa una ruta gastronómica ofrecida por la agencia.
 * <p>
 * Extiende {@link ServicioTuristico}, agregando el atributo propio
 * {@code numeroDeParadas}, que indica cuántas paradas gastronómicas
 * incluye el recorrido.
 * </p>
 *
 * @author Olga Rivas Ahumada
 * @version 1.0
 */
public class RutaGastronomica extends ServicioTuristico {

    private int numeroDeParadas;

    /**
     * Crea una nueva ruta gastronómica.
     *
     * @param nombre nombre del servicio (heredado de {@code ServicioTuristico})
     * @param duracionHoras duración del servicio en horas (heredado de {@code ServicioTuristico})
     * @param numeroDeParadas cantidad de paradas gastronómicas que incluye la ruta
     */
    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    /**
     * Obtiene el número de paradas de la ruta.
     *
     * @return número de paradas
     */
    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    /**
     * Establece el número de paradas de la ruta.
     *
     * @param numeroDeParadas nuevo número de paradas
     * @throws IllegalArgumentException si el valor es negativo
     */
    public void setNumeroDeParadas(int numeroDeParadas) {
        if (!util.Validador.numeroNoNegativo(numeroDeParadas)) {
            throw new IllegalArgumentException("El número de paradas no puede ser negativo.");
        }
        this.numeroDeParadas = numeroDeParadas;
    }

    /**
     * Retorna una representación legible de la ruta gastronómica,
     * mostrando la información heredada más el número de paradas.
     *
     * @return texto con nombre, duración y número de paradas
     */
    @Override
    public String toString() {
        return super.toString() + " | Tipo: Ruta Gastronómica | Paradas: " + numeroDeParadas;
    }
}
