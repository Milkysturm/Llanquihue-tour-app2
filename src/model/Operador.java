package model;

/**
 * Representa al operador local asociado a un {@link Tour}.
 * <p>
 * Esta clase forma parte de la composición de {@code Tour}: cada tour
 * "tiene un" operador que coordina la actividad en terreno.
 * </p>
 *
 * @author Olga Rivas Ahumada
 * @version 1.0
 */
public class Operador {

    private String nombre;
    private String comuna;

    /**
     * Crea un nuevo operador local.
     *
     * @param nombre nombre del operador o empresa operadora
     * @param comuna comuna de la Región de Los Lagos donde opera
     */
    public Operador(String nombre, String comuna) {
        this.nombre = nombre;
        this.comuna = comuna;
    }

    /**
     * Obtiene el nombre del operador.
     *
     * @return nombre del operador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del operador.
     *
     * @param nombre nuevo nombre del operador
     * @throws IllegalArgumentException si el nombre es nulo o está vacío
     */
    public void setNombre(String nombre) {
        if (!util.Validador.textoValido(nombre)) {
            throw new IllegalArgumentException("El nombre del operador no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene la comuna donde opera.
     *
     * @return comuna del operador
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * Establece la comuna donde opera.
     *
     * @param comuna nueva comuna del operador
     * @throws IllegalArgumentException si el valor es nulo o está vacío
     */
    public void setComuna(String comuna) {
        if (!util.Validador.textoValido(comuna)) {
            throw new IllegalArgumentException("La comuna no puede estar vacía.");
        }
        this.comuna = comuna;
    }

    /**
     * Retorna una representación legible del operador.
     *
     * @return texto con nombre y comuna
     */
    @Override
    public String toString() {
        return "Operador: " + nombre + " | Comuna: " + comuna;
    }
}
