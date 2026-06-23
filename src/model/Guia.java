package model;

/**
 * Representa al guía turístico asignado a un {@link Tour}.
 * <p>
 * Esta clase forma parte de la composición de {@code Tour}: cada tour
 * "tiene un" guía responsable de conducir la experiencia turística.
 * </p>
 *
 * @author Olga Rivas Ahumada
 * @version 1.0
 */
public class Guia {

    private String nombre;
    private String idioma;
    private int aniosExperiencia;

    /**
     * Crea un nuevo guía turístico.
     *
     * @param nombre nombre completo del guía
     * @param idioma idioma principal en el que el guía atiende a los turistas
     * @param aniosExperiencia años de experiencia del guía en el rubro
     */
    public Guia(String nombre, String idioma, int aniosExperiencia) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     * Obtiene el nombre del guía.
     *
     * @return nombre del guía
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del guía.
     *
     * @param nombre nuevo nombre del guía
     * @throws IllegalArgumentException si el nombre es nulo o está vacío
     */
    public void setNombre(String nombre) {
        if (!util.Validador.textoValido(nombre)) {
            throw new IllegalArgumentException("El nombre del guía no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene el idioma principal del guía.
     *
     * @return idioma del guía
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Establece el idioma principal del guía.
     *
     * @param idioma nuevo idioma del guía
     * @throws IllegalArgumentException si el idioma es nulo o está vacío
     */
    public void setIdioma(String idioma) {
        if (!util.Validador.textoValido(idioma)) {
            throw new IllegalArgumentException("El idioma del guía no puede estar vacío.");
        }
        this.idioma = idioma;
    }

    /**
     * Obtiene los años de experiencia del guía.
     *
     * @return años de experiencia
     */
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    /**
     * Establece los años de experiencia del guía.
     *
     * @param aniosExperiencia nueva cantidad de años de experiencia
     * @throws IllegalArgumentException si el valor es negativo
     */
    public void setAniosExperiencia(int aniosExperiencia) {
        if (!util.Validador.numeroNoNegativo(aniosExperiencia)) {
            throw new IllegalArgumentException("Los años de experiencia no pueden ser negativos.");
        }
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     * Retorna una representación legible del guía.
     *
     * @return texto con nombre, idioma y años de experiencia
     */
    @Override
    public String toString() {
        return "Guía: " + nombre + " | Idioma: " + idioma + " | Experiencia: " + aniosExperiencia + " años";
    }
}
