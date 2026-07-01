package ui;

import data.GestorServicios;
import model.ServicioTuristico;

/**
 * Clase principal del sistema (capa de interfaz / ui).
 * <p>
 * Es la <strong>unica capa autorizada a imprimir por consola</strong>. Toma la
 * coleccion polimorfica desde el {@link GestorServicios} y la recorre con un
 * bucle {@code for-each}, invocando {@link ServicioTuristico#mostrarInformacion()}
 * sobre referencias de tipo {@code ServicioTuristico}. Gracias al polimorfismo,
 * en cada iteracion se ejecuta automaticamente la version sobrescrita de la
 * subclase correspondiente, sin necesidad de usar {@code instanceof} ni
 * condicionales por tipo.
 * <p>
 * Al final muestra el registro de auditoria que las capas internas fueron
 * acumulando, demostrando el desacople entre la logica y la terminal.
 *
 * @author Olga Pamela Rivas Ahumada
 * @version 1.0 (Semana 7 - Polimorfismo y colecciones genericas)
 */
public class Main {

    /**
     * Constructor privado: {@code Main} es solo un punto de entrada y no debe
     * instanciarse.
     */
    private Main() {
    }

    /**
     * Punto de entrada del programa. Prepara la coleccion, la recorre de forma
     * polimorfica y muestra los resultados junto al registro de auditoria.
     *
     * @param args argumentos de linea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("   LLANQUIHUE TOUR - Gestion de Servicios (S7)");
        System.out.println("   Polimorfismo y colecciones genericas");
        System.out.println("====================================================\n");

        // 1. La capa de datos prepara la coleccion polimorfica (sin imprimir).
        GestorServicios gestor = new GestorServicios();
        gestor.cargarServiciosDemo();

        System.out.println("Servicios cargados: " + gestor.cantidadServicios() + "\n");
        System.out.println("----- RECORRIDO POLIMORFICO -----\n");

        // 2. Recorrido polimorfico: misma referencia, comportamiento distinto.
        int contador = 1;
        for (ServicioTuristico servicio : gestor.obtenerServicios()) {
            System.out.println(contador + ". " + servicio.mostrarInformacion());
            System.out.println();
            contador++;
        }

        // 3. Solo la capa ui decide mostrar el log que las capas internas
        //    acumularon, en lugar de que ellas impriman directamente.
        System.out.println("----- REGISTRO DE AUDITORIA -----");
        if (gestor.getAuditoria().estaVacio()) {
            System.out.println("Sin eventos registrados.");
        } else {
            for (String evento : gestor.getAuditoria().obtenerEventos()) {
                System.out.println(evento);
            }
        }

        System.out.println("\n====================================================");
        System.out.println("   Fin de la ejecucion");
        System.out.println("====================================================");
    }
}
