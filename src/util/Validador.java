package util;

/**
 * Librería de utilidades propia con métodos estáticos de validación
 * reutilizables en todo el sistema Llanquihue Tour.
 * <p>
 * Centraliza las reglas de validación para evitar duplicar lógica
 * en cada clase del paquete {@code model}.
 * </p>
 *
 * @author Olga Rivas Ahumada
 * @version 1.0
 */
public class Validador {

    /**
     * Constructor privado: esta clase solo expone métodos estáticos
     * y no está pensada para ser instanciada.
     */
    private Validador() {
    }

    /**
     * Verifica que un texto no sea nulo ni esté vacío (ni compuesto
     * solo de espacios en blanco).
     *
     * @param texto texto a validar
     * @return {@code true} si el texto es válido, {@code false} en caso contrario
     */
    public static boolean textoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    /**
     * Verifica que un número (entero o decimal) no sea negativo.
     *
     * @param numero número a validar
     * @return {@code true} si el número es mayor o igual a cero
     */
    public static boolean numeroNoNegativo(double numero) {
        return numero >= 0;
    }

    /**
     * Verifica que un arreglo de campos tenga exactamente la cantidad
     * esperada de elementos, útil al parsear líneas de un archivo de texto.
     *
     * @param campos arreglo de campos obtenido al dividir una línea
     * @param cantidadEsperada cantidad de campos que debería tener la línea
     * @return {@code true} si la cantidad de campos coincide con la esperada
     */
    public static boolean cantidadCamposValida(String[] campos, int cantidadEsperada) {
        return campos != null && campos.length == cantidadEsperada;
    }
}
