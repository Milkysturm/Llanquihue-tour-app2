package model;

/**
 * Clase base que representa un servicio turístico genérico ofrecido
 * por la agencia Llanquihue Tour.
 * <p>
 * Es la <b>superclase</b> de la jerarquía de herencia de la Semana 6.
 * Las subclases {@link RutaGastronomica}, {@link PaseoLacustre} y
 * {@link ExcursionCultural} extienden esta clase, agregando un atributo
 * propio según su categoría de servicio.
 * </p>
 * <p>
 * <b>Nota:</b> esta jerarquía es independiente de la clase {@link Tour}
 * (que aplica composición). {@code ServicioTuristico} representa los
 * tipos generales de experiencias que ofrece la agencia, mientras que
 * {@code Tour} representa una excursión concreta ya armada con sus
 * colaboradores (guía, proveedor, operador).
 * </p>
 *
 * @author Olga Rivas Ahumada
 * @version 1.0
 */
public class ServicioTuristico {

    private String nombre;
    private int duracionHoras;

    /**
     * Crea un nuevo servicio turístico.
     *
     * @param nombre nombre del servicio turístico
     * @param duracionHoras duración del servicio, expresada en horas
     */
    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    /**
     * Obtiene el nombre del servicio turístico.
     *
     * @return nombre del servicio
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del servicio turístico.
     *
     * @param nombre nuevo nombre del servicio
     * @throws IllegalArgumentException si el nombre es nulo o está vacío
     */
    public void setNombre(String nombre) {
        if (!util.Validador.textoValido(nombre)) {
            throw new IllegalArgumentException("El nombre del servicio no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene la duración del servicio en horas.
     *
     * @return duración en horas
     */
    public int getDuracionHoras() {
        return duracionHoras;
    }

    /**
     * Establece la duración del servicio en horas.
     *
     * @param duracionHoras nueva duración en horas
     * @throws IllegalArgumentException si el valor es negativo
     */
    public void setDuracionHoras(int duracionHoras) {
        if (!util.Validador.numeroNoNegativo(duracionHoras)) {
            throw new IllegalArgumentException("La duración no puede ser negativa.");
        }
        this.duracionHoras = duracionHoras;
    }

    /**
     * Retorna una representación legible del servicio turístico,
     * mostrando sus atributos comunes.
     * <p>
     * Las subclases sobrescriben este método para agregar su atributo
     * propio a la información mostrada.
     * </p>
     *
     * @return texto con nombre y duración del servicio
     */
    @Override
    public String toString() {
        return "Servicio: " + nombre + " | Duración: " + duracionHoras + " horas";
    }
}
