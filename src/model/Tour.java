package model;

import util.Validador;

/**
 * Representa un Tour ofrecido por la agencia Llanquihue Tour.
 * <p>
 * Cada objeto Tour corresponde a una línea del archivo de datos
 * {@code tours.txt}. Además de sus atributos simples, aplica
 * <b>composición</b> al contener tres objetos como atributos: un
 * {@link Guia}, un {@link Proveedor} de transporte y un {@link Operador}
 * local. Los setters incluyen validaciones que protegen la integridad
 * de los datos.
 *
 * @author Olga Rivas Ahumada
 * @version 4.0
 */
public class Tour {

    /** Nombre del tour. */
    private String nombre;

    /** Tipo de tour (por ejemplo: gastronomico, lacustre, cultural). */
    private String tipo;

    /** Precio del tour expresado en pesos chilenos. */
    private int precio;

    /** Cantidad de cupos disponibles para el tour. */
    private int cupos;

    /** Guía asignado al tour (composición). */
    private Guia guia;

    /** Proveedor de transporte del tour (composición). */
    private Proveedor proveedor;

    /** Operador local del tour (composición). */
    private Operador operador;

    /**
     * Crea un nuevo Tour con todos sus atributos y sus colaboradores.
     * Utiliza los setters para validar cada valor al construir el objeto.
     *
     * @param nombre    el nombre del tour
     * @param tipo      el tipo de tour (gastronomico, lacustre, cultural, etc.)
     * @param precio    el precio del tour en pesos chilenos
     * @param cupos     la cantidad de cupos disponibles
     * @param guia      el guía asignado al tour
     * @param proveedor el proveedor de transporte del tour
     * @param operador  el operador local del tour
     */
    public Tour(String nombre, String tipo, int precio, int cupos,
                Guia guia, Proveedor proveedor, Operador operador) {
        setNombre(nombre);
        setTipo(tipo);
        setPrecio(precio);
        setCupos(cupos);
        setGuia(guia);
        setProveedor(proveedor);
        setOperador(operador);
    }

    /**
     * Devuelve el nombre del tour.
     *
     * @return el nombre del tour
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del tour, validando que no esté vacío.
     *
     * @param nombre el nuevo nombre del tour
     * @throws IllegalArgumentException si el nombre es nulo o está vacío
     */
    public void setNombre(String nombre) {
        if (!Validador.textoValido(nombre)) {
            throw new IllegalArgumentException("El nombre del tour no puede estar vacio.");
        }
        this.nombre = nombre;
    }

    /**
     * Devuelve el tipo del tour.
     *
     * @return el tipo del tour
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo del tour, validando que no esté vacío.
     *
     * @param tipo el nuevo tipo del tour
     * @throws IllegalArgumentException si el tipo es nulo o está vacío
     */
    public void setTipo(String tipo) {
        if (!Validador.textoValido(tipo)) {
            throw new IllegalArgumentException("El tipo del tour no puede estar vacio.");
        }
        this.tipo = tipo;
    }

    /**
     * Devuelve el precio del tour.
     *
     * @return el precio del tour en pesos chilenos
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del tour, validando que no sea negativo.
     *
     * @param precio el nuevo precio del tour en pesos chilenos
     * @throws IllegalArgumentException si el precio es negativo
     */
    public void setPrecio(int precio) {
        if (!Validador.numeroNoNegativo(precio)) {
            throw new IllegalArgumentException("El precio del tour no puede ser negativo.");
        }
        this.precio = precio;
    }

    /**
     * Devuelve la cantidad de cupos disponibles.
     *
     * @return la cantidad de cupos disponibles
     */
    public int getCupos() {
        return cupos;
    }

    /**
     * Establece la cantidad de cupos, validando que no sea negativa.
     *
     * @param cupos la nueva cantidad de cupos disponibles
     * @throws IllegalArgumentException si los cupos son negativos
     */
    public void setCupos(int cupos) {
        if (!Validador.numeroNoNegativo(cupos)) {
            throw new IllegalArgumentException("Los cupos del tour no pueden ser negativos.");
        }
        this.cupos = cupos;
    }

    /**
     * Devuelve el guía asignado al tour.
     *
     * @return el objeto {@link Guia} asignado
     */
    public Guia getGuia() {
        return guia;
    }

    /**
     * Establece el guía asignado, validando que no sea nulo.
     *
     * @param guia el nuevo guía asignado
     * @throws IllegalArgumentException si el guía es nulo
     */
    public void setGuia(Guia guia) {
        if (guia == null) {
            throw new IllegalArgumentException("El tour debe tener un guia asignado.");
        }
        this.guia = guia;
    }

    /**
     * Devuelve el proveedor de transporte del tour.
     *
     * @return el objeto {@link Proveedor} asignado
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * Establece el proveedor, validando que no sea nulo.
     *
     * @param proveedor el nuevo proveedor asignado
     * @throws IllegalArgumentException si el proveedor es nulo
     */
    public void setProveedor(Proveedor proveedor) {
        if (proveedor == null) {
            throw new IllegalArgumentException("El tour debe tener un proveedor asignado.");
        }
        this.proveedor = proveedor;
    }

    /**
     * Devuelve el operador local del tour.
     *
     * @return el objeto {@link Operador} asignado
     */
    public Operador getOperador() {
        return operador;
    }

    /**
     * Establece el operador, validando que no sea nulo.
     *
     * @param operador el nuevo operador asignado
     * @throws IllegalArgumentException si el operador es nulo
     */
    public void setOperador(Operador operador) {
        if (operador == null) {
            throw new IllegalArgumentException("El tour debe tener un operador asignado.");
        }
        this.operador = operador;
    }

    /**
     * Devuelve una representación legible del tour, incluyendo los datos
     * de su guía, proveedor y operador.
     *
     * @return una cadena con los datos del tour
     */
    @Override
    public String toString() {
        return "Tour{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=$" + precio +
                ", cupos=" + cupos +
                ", guia=" + guia +
                ", proveedor=" + proveedor +
                ", operador=" + operador +
                '}';
    }
}
