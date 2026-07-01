package ui;

import data.GestorServicios;
import model.ServicioTuristico;

/**
 * Clase principal (capa de interfaz / ui).
 *
 * Es la UNICA capa del sistema autorizada a imprimir por consola. Toma la
 * coleccion polimorfica desde el GestorServicios y la recorre con un bucle
 * for-each, invocando mostrarInformacion() sobre referencias de tipo
 * ServicioTuristico. Gracias al polimorfismo, en cada iteracion se ejecuta
 * automaticamente la version sobrescrita de la subclase correspondiente,
 * sin necesidad de usar instanceof ni condicionales por tipo.
 *
 * Al final muestra el registro de auditoria que las capas internas fueron
 * acumulando, demostrando el desacople entre la logica y la terminal.
 */
public class Main {

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
