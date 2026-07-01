package model;

import exception.ServicioInvalidoException;
import util.FormatoMoneda;

/**
 * Subclase concreta que representa una <strong>Excursion Cultural</strong>.
 * <p>
 * Anade el atributo propio {@code sitioHistorico} y sobrescribe
 * {@link #mostrarInformacion()} con el detalle especifico de una excursion
 * cultural, reutilizando los atributos comunes de {@link ServicioTuristico}.
 *
 * @author Olga Pamela Rivas Ahumada
 * @version 1.0 (Semana 7 - Polimorfismo y colecciones genericas)
 */
public class ExcursionCultural extends ServicioTuristico {

    /** Sitio historico o patrimonial que se visita en la excursion. */
    private String sitioHistorico;

    /**
     * Construye una excursion cultural.
     *
     * @param nombre         nombre comercial del servicio.
     * @param ubicacion      localidad donde se realiza.
     * @param precio         valor en pesos chilenos; debe ser mayor que cero.
     * @param duracionHoras  duracion en horas; debe ser mayor que cero.
     * @param sitioHistorico sitio patrimonial visitado.
     * @throws ServicioInvalidoException si los datos comunes no son validos.
     */
    public ExcursionCultural(String nombre, String ubicacion, double precio,
                             int duracionHoras, String sitioHistorico)
            throws ServicioInvalidoException {
        super(nombre, ubicacion, precio, duracionHoras);
        this.sitioHistorico = sitioHistorico;
    }

    /**
     * Obtiene el sitio historico de la excursion.
     *
     * @return el sitio patrimonial visitado.
     */
    public String getSitioHistorico() {
        return sitioHistorico;
    }

    /**
     * Establece el sitio historico de la excursion.
     *
     * @param sitioHistorico el nuevo sitio patrimonial.
     */
    public void setSitioHistorico(String sitioHistorico) {
        this.sitioHistorico = sitioHistorico;
    }

    /**
     * {@inheritDoc}
     *
     * @return la etiqueta amigable "Excursion Cultural".
     */
    @Override
    public String getTipoServicio() {
        return "Excursion Cultural";
    }

    /**
     * Muestra la informacion especifica de la excursion cultural, incluyendo el
     * sitio historico y el precio en formato de peso chileno.
     *
     * @return una cadena formateada con los datos del servicio.
     */
    @Override
    public String mostrarInformacion() {
        return "[Excursion Cultural] " + getNombre()
                + "\n   Ubicacion : " + getUbicacion()
                + "\n   Sitio     : " + sitioHistorico
                + "\n   Duracion  : " + getDuracionHoras() + " h"
                + "\n   Precio    : " + FormatoMoneda.pesos(getPrecio())
                + "\n   Recorrido guiado por el patrimonio de Los Lagos.";
    }
}
