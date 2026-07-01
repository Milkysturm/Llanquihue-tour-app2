package util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Utilidad para dar formato de moneda chilena a los precios.
 *
 * En Chile el peso no usa decimales y el separador de miles es el punto,
 * por lo que 25000 se muestra como "$25.000". Esta clase centraliza ese
 * formato para que la capa de interfaz (ui) lo aplique de forma consistente.
 */
public final class FormatoMoneda {

    // Simbolos con punto como separador de miles (estilo chileno).
    private static final DecimalFormatSymbols SIMBOLOS =
            new DecimalFormatSymbols(Locale.of("es", "CL"));

    private static final DecimalFormat FORMATO;

    static {
        SIMBOLOS.setGroupingSeparator('.');
        FORMATO = new DecimalFormat("#,###", SIMBOLOS);
    }

    // Clase de utilidades: no se instancia.
    private FormatoMoneda() {
    }

    /**
     * Convierte un valor numerico a formato de peso chileno.
     *
     * @param valor monto a formatear (por ejemplo, 25000).
     * @return el monto como texto, por ejemplo "$25.000".
     */
    public static String pesos(double valor) {
        return "$" + FORMATO.format(valor);
    }
}
