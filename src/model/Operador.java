package model;

import util.Validador;

/**
 * Representa a un operador local que colabora con la agencia
 * Llanquihue Tour.
 * <p>
 * Forma parte de una relación de <b>composición</b>: cada {@link Tour}
 * contiene un objeto {@code Operador} que representa al colaborador local
 * encargado de coordinar la experiencia en terreno. Los setters incluyen
 * validaciones que protegen la integridad de los datos.
 *
 * @author Olga Rivas Ahumada
 * @version 2.0
 */
public class Operador {

    /** Nombre del operador local. */
    private String nombre;

    /** Comuna o localidad donde opera. */
    private String comuna;

    /**
     * Crea un nuevo operador local.
     * Utiliza los setters para validar cada valor al construir el objeto.
     *
     * @param nombre el nombre del operador local
     * @param comuna la comuna o localidad donde opera
     */
    public Operador(String nombre, String comuna) {
        setNombre(nombre);
        setComuna(comuna);
    }

    /**
     * Devuelve el nombre del operador local.
     *
     * @return el nombre del operador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del operador, validando que no esté vacío.
     *
     * @param nombre el nuevo nombre del operador
     * @throws IllegalArgumentException si el nombre es nulo o está vacío
     */
    public void setNombre(String nombre) {
        if (!Validador.textoValido(nombre)) {
            throw new IllegalArgumentException("El nombre del operador no puede estar vacio.");
        }
        this.nombre = nombre;
    }

    /**
     * Devuelve la comuna donde opera.
     *
     * @return la comuna del operador
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * Establece la comuna del operador, validando que no esté vacía.
     *
     * @param comuna la nueva comuna del operador
     * @throws IllegalArgumentException si la comuna es nula o está vacía
     */
    public void setComuna(String comuna) {
        if (!Validador.textoValido(comuna)) {
            throw new IllegalArgumentException("La comuna del operador no puede estar vacia.");
        }
        this.comuna = comuna;
    }

    /**
     * Devuelve una representación legible del operador.
     *
     * @return una cadena con los datos del operador
     */
    @Override
    public String toString() {
        return nombre + " - " + comuna;
    }
}
