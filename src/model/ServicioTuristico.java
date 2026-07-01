package model;

import exception.ServicioInvalidoException;
import util.Validador;

/**
 * Superclase abstracta de la jerarquia de servicios turisticos de la agencia
 * Llanquihue Tour.
 * <p>
 * Se declara {@code abstract} porque un "servicio turistico generico" no
 * representa una experiencia real que la agencia pueda vender: solo tienen
 * sentido sus tipos concretos ({@link RutaGastronomica}, {@link PaseoLacustre}
 * y {@link ExcursionCultural}). Por ello no debe poder instanciarse
 * directamente.
 * <p>
 * Define el metodo abstracto {@link #mostrarInformacion()}, que cada subclase
 * debe sobrescribir con el detalle propio de su tipo de servicio. Esta es la
 * base del polimorfismo: una referencia de tipo {@code ServicioTuristico}
 * ejecuta, en tiempo de ejecucion, la version del metodo correspondiente al
 * objeto real.
 * <p>
 * La validacion de los datos se realiza en el constructor y, ante datos
 * invalidos, se lanza una excepcion personalizada
 * ({@link ServicioInvalidoException}) en lugar de imprimir por consola,
 * manteniendo el modelo desacoplado de la terminal.
 *
 * @author Olga Pamela Rivas Ahumada
 * @version 1.0 (Semana 7 - Polimorfismo y colecciones genericas)
 */
public abstract class ServicioTuristico {

    /** Nombre comercial del servicio. */
    private String nombre;

    /** Comuna o localidad donde se realiza el servicio. */
    private String ubicacion;

    /** Valor del servicio en pesos chilenos. */
    private double precio;

    /** Duracion estimada del servicio, expresada en horas. */
    private int duracionHoras;

    /**
     * Construye un servicio turistico validando sus datos antes de asignarlos.
     *
     * @param nombre        nombre comercial del servicio; no puede ser nulo ni vacio.
     * @param ubicacion     localidad del servicio; no puede ser nula ni vacia.
     * @param precio        valor en pesos chilenos; debe ser mayor que cero.
     * @param duracionHoras duracion en horas; debe ser mayor que cero.
     * @throws ServicioInvalidoException si alguno de los datos no cumple las
     *                                   reglas de validacion del negocio.
     */
    public ServicioTuristico(String nombre, String ubicacion,
                             double precio, int duracionHoras)
            throws ServicioInvalidoException {

        if (!Validador.textoValido(nombre)) {
            throw new ServicioInvalidoException(
                    "El nombre del servicio no puede estar vacio.");
        }
        if (!Validador.textoValido(ubicacion)) {
            throw new ServicioInvalidoException(
                    "La ubicacion del servicio no puede estar vacia.");
        }
        if (!Validador.precioValido(precio)) {
            throw new ServicioInvalidoException(
                    "El precio debe ser mayor que cero (recibido: " + precio + ").");
        }
        if (!Validador.duracionValida(duracionHoras)) {
            throw new ServicioInvalidoException(
                    "La duracion debe ser mayor que cero (recibido: "
                            + duracionHoras + ").");
        }

        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.duracionHoras = duracionHoras;
    }

    /**
     * Metodo abstracto que cada subclase sobrescribe (con {@code @Override})
     * para mostrar la informacion especifica de su tipo de servicio de forma
     * polimorfica.
     *
     * @return una cadena con la informacion formateada del servicio.
     */
    public abstract String mostrarInformacion();

    /**
     * Devuelve el nombre legible del tipo de servicio.
     * <p>
     * Por defecto usa el nombre simple de la clase; las subclases pueden
     * sobrescribirlo para entregar una etiqueta mas amigable.
     *
     * @return el nombre del tipo de servicio.
     */
    public String getTipoServicio() {
        return this.getClass().getSimpleName();
    }

    /**
     * Obtiene el nombre del servicio.
     *
     * @return el nombre comercial del servicio.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del servicio.
     *
     * @param nombre el nuevo nombre comercial.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la ubicacion del servicio.
     *
     * @return la comuna o localidad del servicio.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicacion del servicio.
     *
     * @param ubicacion la nueva comuna o localidad.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene el precio del servicio.
     *
     * @return el valor en pesos chilenos.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del servicio.
     *
     * @param precio el nuevo valor en pesos chilenos.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la duracion del servicio.
     *
     * @return la duracion en horas.
     */
    public int getDuracionHoras() {
        return duracionHoras;
    }

    /**
     * Establece la duracion del servicio.
     *
     * @param duracionHoras la nueva duracion en horas.
     */
    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    /**
     * Devuelve una representacion textual completa del objeto, util para
     * depuracion y registros.
     *
     * @return una cadena con el tipo y todos los atributos del servicio.
     */
    @Override
    public String toString() {
        return getTipoServicio() + "{nombre='" + nombre + "', ubicacion='"
                + ubicacion + "', precio=" + precio
                + ", duracionHoras=" + duracionHoras + "}";
    }
}
