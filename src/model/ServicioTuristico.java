package model;

import exception.ServicioInvalidoException;
import util.Validador;

/**
 * Superclase ABSTRACTA de la jerarquia de servicios turisticos.
 *
 * Se declara abstracta porque un "servicio turistico generico" no representa
 * una experiencia real que la agencia pueda vender: solo tienen sentido sus
 * tipos concretos (RutaGastronomica, PaseoLacustre, ExcursionCultural). Por
 * eso no debe poder instanciarse directamente.
 *
 * Define el metodo abstracto mostrarInformacion(), que cada subclase DEBE
 * sobrescribir con el detalle propio de su tipo de servicio. Esto es la base
 * del polimorfismo: una referencia de tipo ServicioTuristico ejecutara, en
 * tiempo de ejecucion, la version del metodo correspondiente al objeto real.
 *
 * La validacion de los datos se realiza en el constructor y, ante datos
 * invalidos, se lanza una excepcion personalizada (ServicioInvalidoException)
 * en lugar de imprimir por consola, manteniendo el modelo desacoplado de la
 * terminal.
 */
public abstract class ServicioTuristico {

    private String nombre;
    private String ubicacion;
    private double precio;
    private int duracionHoras;

    /**
     * Construye un servicio turistico validando sus datos.
     *
     * @throws ServicioInvalidoException si algun dato no cumple las reglas.
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
     * Metodo ABSTRACTO. Cada subclase lo sobrescribe (@Override) para mostrar
     * la informacion especifica de su tipo de servicio de forma polimorfica.
     *
     * @return una cadena con la informacion formateada del servicio.
     */
    public abstract String mostrarInformacion();

    /**
     * Devuelve el tipo de servicio. Las subclases pueden sobrescribirlo;
     * por defecto usa el nombre simple de la clase.
     */
    public String getTipoServicio() {
        return this.getClass().getSimpleName();
    }

    // ---- Getters y setters (encapsulamiento) ----

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    @Override
    public String toString() {
        return getTipoServicio() + "{nombre='" + nombre + "', ubicacion='"
                + ubicacion + "', precio=" + precio
                + ", duracionHoras=" + duracionHoras + "}";
    }
}
