package model;

import util.Validador;

/**
 * Representa a un guía turístico de la agencia Llanquihue Tour.
 * <p>
 * Esta clase forma parte de una relación de <b>composición</b>: cada objeto
 * {@link Tour} contiene un objeto {@code Guia} como uno de sus atributos,
 * reflejando la relación de dominio "un tour tiene un guía asignado".
 * Los setters incluyen validaciones que protegen la integridad de los datos.
 *
 * @author Olga Rivas Ahumada
 * @version 2.0
 */
public class Guia {

    /** Nombre completo del guía. */
    private String nombre;

    /** Idioma principal en que el guía ofrece el tour. */
    private String idioma;

    /** Años de experiencia del guía. */
    private int aniosExperiencia;

    /**
     * Crea un nuevo guía con todos sus atributos.
     * Utiliza los setters para validar cada valor al construir el objeto.
     *
     * @param nombre           el nombre completo del guía
     * @param idioma           el idioma principal del guía
     * @param aniosExperiencia los años de experiencia del guía
     */
    public Guia(String nombre, String idioma, int aniosExperiencia) {
        setNombre(nombre);
        setIdioma(idioma);
        setAniosExperiencia(aniosExperiencia);
    }

    /**
     * Devuelve el nombre del guía.
     *
     * @return el nombre del guía
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del guía, validando que no esté vacío.
     *
     * @param nombre el nuevo nombre del guía
     * @throws IllegalArgumentException si el nombre es nulo o está vacío
     */
    public void setNombre(String nombre) {
        if (!Validador.textoValido(nombre)) {
            throw new IllegalArgumentException("El nombre del guia no puede estar vacio.");
        }
        this.nombre = nombre;
    }

    /**
     * Devuelve el idioma del guía.
     *
     * @return el idioma del guía
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Establece el idioma del guía, validando que no esté vacío.
     *
     * @param idioma el nuevo idioma del guía
     * @throws IllegalArgumentException si el idioma es nulo o está vacío
     */
    public void setIdioma(String idioma) {
        if (!Validador.textoValido(idioma)) {
            throw new IllegalArgumentException("El idioma del guia no puede estar vacio.");
        }
        this.idioma = idioma;
    }

    /**
     * Devuelve los años de experiencia del guía.
     *
     * @return los años de experiencia
     */
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    /**
     * Establece los años de experiencia, validando que no sean negativos.
     *
     * @param aniosExperiencia los nuevos años de experiencia
     * @throws IllegalArgumentException si el valor es negativo
     */
    public void setAniosExperiencia(int aniosExperiencia) {
        if (!Validador.numeroNoNegativo(aniosExperiencia)) {
            throw new IllegalArgumentException("Los anios de experiencia no pueden ser negativos.");
        }
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     * Devuelve una representación legible del guía.
     *
     * @return una cadena con los datos del guía
     */
    @Override
    public String toString() {
        return nombre + " (" + idioma + ", " + aniosExperiencia + " anios de experiencia)";
    }
}
