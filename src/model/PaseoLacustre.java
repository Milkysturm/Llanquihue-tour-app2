package model;

import exception.ServicioInvalidoException;
import util.FormatoMoneda;

/**
 * Subclase concreta: Paseo Lacustre.
 *
 * Anade el atributo propio (nombreLago) y sobrescribe mostrarInformacion()
 * con el detalle especifico de un paseo por el lago.
 */
public class PaseoLacustre extends ServicioTuristico {

    private String nombreLago;

    public PaseoLacustre(String nombre, String ubicacion, double precio,
                         int duracionHoras, String nombreLago)
            throws ServicioInvalidoException {
        super(nombre, ubicacion, precio, duracionHoras);
        this.nombreLago = nombreLago;
    }

    public String getNombreLago() {
        return nombreLago;
    }

    public void setNombreLago(String nombreLago) {
        this.nombreLago = nombreLago;
    }

    @Override
    public String getTipoServicio() {
        return "Paseo Lacustre";
    }

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
