package util;

/**
 * Clase utilitaria con métodos de validación reutilizables.
 * <p>
 * Pertenece al paquete {@code util} y funciona como una pequeña
 * "librería personalizada" del proyecto: agrupa validaciones genéricas
 * que pueden usarse desde cualquier otra clase, evitando duplicar código.
 * Todos sus métodos son estáticos, por lo que no es necesario instanciar
 * la clase para utilizarlos.
 *
 * @author Olga Rivas Ahumada
 * @version 1.0
 */
public class Validador {

    /**
     * Verifica que un texto no sea nulo ni esté vacío.
     *
     * @param texto el texto a validar
     * @return {@code true} si el texto tiene contenido; {@code false} en caso contrario
     */
    public static boolean textoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    /**
     * Verifica que un número entero no sea negativo.
     *
     * @param numero el número a validar
     * @return {@code true} si el número es cero o positivo; {@code false} si es negativo
     */
    public static boolean numeroNoNegativo(int numero) {
        return numero >= 0;
    }

    /**
     * Verifica que una línea de datos tenga la cantidad de campos esperada.
     *
     * @param campos         el arreglo de campos obtenido al separar la línea
     * @param cantidadEsperada la cantidad de campos que debe tener
     * @return {@code true} si la cantidad coincide; {@code false} en caso contrario
     */
    public static boolean cantidadCamposValida(String[] campos, int cantidadEsperada) {
        return campos != null && campos.length == cantidadEsperada;
    }
}
