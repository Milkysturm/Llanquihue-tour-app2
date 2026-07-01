package model;

import exception.ServicioInvalidoException;
import util.FormatoMoneda;

/**
 * Subclase concreta: Excursion Cultural.
 *
 * Anade el atributo propio (sitioHistorico) y sobrescribe mostrarInformacion()
 * con el detalle especifico de una excursion cultural.
 */
public class ExcursionCultural extends ServicioTuristico {

    private String sitioHistorico;

    public ExcursionCultural(String nombre, String ubicacion, double precio,
                             int duracionHoras, String sitioHistorico)
            throws ServicioInvalidoException {
        super(nombre, ubicacion, precio, duracionHoras);
        this.sitioHistorico = sitioHistorico;
    }

    public String getSitioHistorico() {
        return sitioHistorico;
    }

    public void setSitioHistorico(String sitioHistorico) {
        this.sitioHistorico = sitioHistorico;
    }

    @Override
    public String getTipoServicio() {
        return "Excursion Cultural";
    }

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
