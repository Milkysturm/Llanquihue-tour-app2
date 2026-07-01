package model;

import exception.ServicioInvalidoException;
import util.FormatoMoneda;

/**
 * Subclase concreta: Ruta Gastronomica.
 *
 * Anade un atributo propio (tipoCocina) y sobrescribe mostrarInformacion()
 * para presentar la informacion especifica de este tipo de servicio.
 */
public class RutaGastronomica extends ServicioTuristico {

    private String tipoCocina;

    public RutaGastronomica(String nombre, String ubicacion, double precio,
                            int duracionHoras, String tipoCocina)
            throws ServicioInvalidoException {
        // Reutiliza la validacion y asignacion de la superclase.
        super(nombre, ubicacion, precio, duracionHoras);
        this.tipoCocina = tipoCocina;
    }

    public String getTipoCocina() {
        return tipoCocina;
    }

    public void setTipoCocina(String tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    @Override
    public String getTipoServicio() {
        return "Ruta Gastronomica";
    }

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
