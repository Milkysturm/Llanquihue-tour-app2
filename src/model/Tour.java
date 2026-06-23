package model;

/**
 * Representa un tour ofrecido por la agencia Llanquihue Tour.
 * <p>
 * Esta clase aplica <b>composición triple</b>: cada {@code Tour} contiene
 * un {@link Guia}, un {@link Proveedor} y un {@link Operador}, reflejando
 * la red de colaboración descrita en el caso de la agencia.
 * </p>
 *
 * @author Olga Rivas Ahumada
 * @version 1.0
 */
public class Tour {

    private String nombre;
    private String tipo;
    private double precio;
    private int cuposDisponibles;
    private Guia guia;
    private Proveedor proveedor;
    private Operador operador;

    /**
     * Crea un nuevo tour con sus colaboradores asociados.
     *
     * @param nombre nombre del tour
     * @param tipo tipo de tour (gastronómico, lacustre, cultural, etc.)
     * @param precio precio del tour en pesos chilenos
     * @param cuposDisponibles cantidad de cupos disponibles
     * @param guia guía asignado al tour
     * @param proveedor proveedor de transporte del tour
     * @param operador operador local del tour
     */
    public Tour(String nombre, String tipo, double precio, int cuposDisponibles,
                Guia guia, Proveedor proveedor, Operador operador) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.cuposDisponibles = cuposDisponibles;
        this.guia = guia;
        this.proveedor = proveedor;
        this.operador = operador;
    }

    /**
     * Obtiene el nombre del tour.
     *
     * @return nombre del tour
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del tour.
     *
     * @param nombre nuevo nombre del tour
     * @throws IllegalArgumentException si el nombre es nulo o está vacío
     */
    public void setNombre(String nombre) {
        if (!util.Validador.textoValido(nombre)) {
            throw new IllegalArgumentException("El nombre del tour no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene el tipo de tour.
     *
     * @return tipo de tour
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de tour.
     *
     * @param tipo nuevo tipo de tour
     * @throws IllegalArgumentException si el valor es nulo o está vacío
     */
    public void setTipo(String tipo) {
        if (!util.Validador.textoValido(tipo)) {
            throw new IllegalArgumentException("El tipo de tour no puede estar vacío.");
        }
        this.tipo = tipo;
    }

    /**
     * Obtiene el precio del tour.
     *
     * @return precio del tour
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del tour.
     *
     * @param precio nuevo precio del tour
     * @throws IllegalArgumentException si el precio es negativo
     */
    public void setPrecio(double precio) {
        if (!util.Validador.numeroNoNegativo(precio)) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    /**
     * Obtiene los cupos disponibles del tour.
     *
     * @return cupos disponibles
     */
    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    /**
     * Establece los cupos disponibles del tour.
     *
     * @param cuposDisponibles nueva cantidad de cupos disponibles
     * @throws IllegalArgumentException si el valor es negativo
     */
    public void setCuposDisponibles(int cuposDisponibles) {
        if (!util.Validador.numeroNoNegativo(cuposDisponibles)) {
            throw new IllegalArgumentException("Los cupos disponibles no pueden ser negativos.");
        }
        this.cuposDisponibles = cuposDisponibles;
    }

    /**
     * Obtiene el guía asignado al tour.
     *
     * @return guía del tour
     */
    public Guia getGuia() {
        return guia;
    }

    /**
     * Establece el guía asignado al tour.
     *
     * @param guia nuevo guía del tour
     */
    public void setGuia(Guia guia) {
        this.guia = guia;
    }

    /**
     * Obtiene el proveedor de transporte del tour.
     *
     * @return proveedor del tour
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * Establece el proveedor de transporte del tour.
     *
     * @param proveedor nuevo proveedor del tour
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Obtiene el operador local del tour.
     *
     * @return operador del tour
     */
    public Operador getOperador() {
        return operador;
    }

    /**
     * Establece el operador local del tour.
     *
     * @param operador nuevo operador del tour
     */
    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    /**
     * Retorna una representación legible y desglosada del tour,
     * incluyendo la información de sus tres colaboradores compuestos.
     *
     * @return texto con todos los datos del tour
     */
    @Override
    public String toString() {
        return "Tour: " + nombre
                + " | Tipo: " + tipo
                + " | Precio: $" + precio
                + " | Cupos: " + cuposDisponibles
                + "\n   -> " + guia
                + "\n   -> " + proveedor
                + "\n   -> " + operador;
    }
}
