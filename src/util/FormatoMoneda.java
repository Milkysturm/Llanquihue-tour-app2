package util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Clase utilitaria para dar formato de moneda chilena a los precios.
 * <p>
 * En Chile el peso no usa decimales y el separador de miles es el punto, por lo
 * que 25000 se muestra como {@code $25.000}. Esta clase centraliza ese formato
 * para que la capa de interfaz (ui) lo aplique de manera consistente.
 *
 * @author Olga Pamela Rivas Ahumada
 * @version 1.0 (Semana 7 - Polimorfismo y colecciones genericas)
 */
public final class FormatoMoneda {

    /** Simbolos de formato configurados para el estilo chileno. */
    private static final DecimalFormatSymbols SIMBOLOS =
            new DecimalFormatSymbols(Locale.of("es", "CL"));

    /** Formateador que aplica el patron de miles sin decimales. */
    private static final DecimalFormat FORMATO;

    static {
        SIMBOLOS.setGroupingSeparator('.');
        FORMATO = new DecimalFormat("#,###", SIMBOLOS);
    }

    /**
     * Constructor privado: es una clase de utilidades y no debe instanciarse.
     */
    private FormatoMoneda() {
    }

    /**
     * Convierte un valor numerico a formato de peso chileno.
     *
     * @param valor monto a formatear (por ejemplo, 25000).
     * @return el monto como texto con el simbolo peso, por ejemplo "$25.000".
     */
    public static String pesos(double valor) {
        return "$" + FORMATO.format(valor);
    }
}
