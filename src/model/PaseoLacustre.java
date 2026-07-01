package model;

import exception.ServicioInvalidoException;
import util.FormatoMoneda;

/**
 * Subclase concreta que representa un <strong>Paseo Lacustre</strong>.
 * <p>
 * Anade el atributo propio {@code nombreLago} y sobrescribe
 * {@link #mostrarInformacion()} con el detalle especifico de un paseo por el
 * lago, reutilizando los atributos comunes de {@link ServicioTuristico}.
 *
 * @author Olga Pamela Rivas Ahumada
 * @version 1.0 (Semana 7 - Polimorfismo y colecciones genericas)
 */
public class PaseoLacustre extends ServicioTuristico {

    /** Nombre del lago donde se realiza la navegacion. */
    private String nombreLago;

    /**
     * Construye un paseo lacustre.
     *
     * @param nombre        nombre comercial del servicio.
     * @param ubicacion     localidad donde se realiza.
     * @param precio        valor en pesos chilenos; debe ser mayor que cero.
     * @param duracionHoras duracion en horas; debe ser mayor que cero.
     * @param nombreLago    nombre del lago de la travesia.
     * @throws ServicioInvalidoException si los datos comunes no son validos.
     */
    public PaseoLacustre(String nombre, String ubicacion, double precio,
                         int duracionHoras, String nombreLago)
            throws ServicioInvalidoException {
        super(nombre, ubicacion, precio, duracionHoras);
        this.nombreLago = nombreLago;
    }

    /**
     * Obtiene el nombre del lago.
     *
     * @return el nombre del lago de la travesia.
     */
    public String getNombreLago() {
        return nombreLago;
    }

    /**
     * Establece el nombre del lago.
     *
     * @param nombreLago el nuevo nombre del lago.
     */
    public void setNombreLago(String nombreLago) {
        this.nombreLago = nombreLago;
    }

    /**
     * {@inheritDoc}
     *
     * @return la etiqueta amigable "Paseo Lacustre".
     */
    @Override
    public String getTipoServicio() {
        return "Paseo Lacustre";
    }

    /**
     * Muestra la informacion especifica del paseo lacustre, incluyendo el lago
     * y el precio en formato de peso chileno.
     *
     * @return una cadena formateada con los datos del servicio.
     */
    @Override
    public String mostrarInformacion() {
        return "[Paseo Lacustre] " + getNombre()
                + "\n   Ubicacion : " + getUbicacion()
                + "\n   Lago      : " + nombreLago
                + "\n   Duracion  : " + getDuracionHoras() + " h"
                + "\n   Precio    : " + FormatoMoneda.pesos(getPrecio())
                + "\n   Navegacion con vista a los volcanes de la region.";
    }
}
