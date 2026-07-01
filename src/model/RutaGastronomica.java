package model;

import exception.ServicioInvalidoException;
import util.FormatoMoneda;

/**
 * Subclase concreta que representa una <strong>Ruta Gastronomica</strong>.
 * <p>
 * Anade el atributo propio {@code tipoCocina} y sobrescribe
 * {@link #mostrarInformacion()} para presentar la informacion especifica de
 * este tipo de servicio, reutilizando la validacion y los atributos comunes
 * heredados de {@link ServicioTuristico}.
 *
 * @author Olga Pamela Rivas Ahumada
 * @version 1.0 (Semana 7 - Polimorfismo y colecciones genericas)
 */
public class RutaGastronomica extends ServicioTuristico {

    /** Estilo o tipo de cocina que ofrece la ruta. */
    private String tipoCocina;

    /**
     * Construye una ruta gastronomica.
     *
     * @param nombre        nombre comercial del servicio.
     * @param ubicacion     localidad donde se realiza.
     * @param precio        valor en pesos chilenos; debe ser mayor que cero.
     * @param duracionHoras duracion en horas; debe ser mayor que cero.
     * @param tipoCocina    estilo de cocina ofrecido.
     * @throws ServicioInvalidoException si los datos comunes no son validos.
     */
    public RutaGastronomica(String nombre, String ubicacion, double precio,
                            int duracionHoras, String tipoCocina)
            throws ServicioInvalidoException {
        super(nombre, ubicacion, precio, duracionHoras);
        this.tipoCocina = tipoCocina;
    }

    /**
     * Obtiene el tipo de cocina de la ruta.
     *
     * @return el estilo de cocina ofrecido.
     */
    public String getTipoCocina() {
        return tipoCocina;
    }

    /**
     * Establece el tipo de cocina de la ruta.
     *
     * @param tipoCocina el nuevo estilo de cocina.
     */
    public void setTipoCocina(String tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    /**
     * {@inheritDoc}
     *
     * @return la etiqueta amigable "Ruta Gastronomica".
     */
    @Override
    public String getTipoServicio() {
        return "Ruta Gastronomica";
    }

    /**
     * Muestra la informacion especifica de la ruta gastronomica, incluyendo el
     * tipo de cocina y el precio en formato de peso chileno.
     *
     * @return una cadena formateada con los datos del servicio.
     */
    @Override
    public String mostrarInformacion() {
        return "[Ruta Gastronomica] " + getNombre()
                + "\n   Ubicacion : " + getUbicacion()
                + "\n   Cocina    : " + tipoCocina
                + "\n   Duracion  : " + getDuracionHoras() + " h"
                + "\n   Precio    : " + FormatoMoneda.pesos(getPrecio())
                + "\n   Incluye degustaciones en productores locales.";
    }
}
