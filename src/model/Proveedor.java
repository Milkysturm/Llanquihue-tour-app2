package model;

import util.Validador;

/**
 * Representa a un proveedor de transporte vinculado a la agencia
 * Llanquihue Tour.
 * <p>
 * Forma parte de una relación de <b>composición</b>: cada {@link Tour}
 * contiene un objeto {@code Proveedor} que indica qué empresa entrega el
 * servicio de transporte para esa experiencia turística. Los setters
 * incluyen validaciones que protegen la integridad de los datos.
 *
 * @author Olga Rivas Ahumada
 * @version 2.0
 */
public class Proveedor {

    /** Nombre de la empresa proveedora. */
    private String empresa;

    /** Tipo de transporte ofrecido (por ejemplo: bus, van, embarcacion). */
    private String tipoTransporte;

    /**
     * Crea un nuevo proveedor de transporte.
     * Utiliza los setters para validar cada valor al construir el objeto.
     *
     * @param empresa        el nombre de la empresa proveedora
     * @param tipoTransporte el tipo de transporte ofrecido
     */
    public Proveedor(String empresa, String tipoTransporte) {
        setEmpresa(empresa);
        setTipoTransporte(tipoTransporte);
    }

    /**
     * Devuelve el nombre de la empresa proveedora.
     *
     * @return el nombre de la empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Establece el nombre de la empresa, validando que no esté vacío.
     *
     * @param empresa el nuevo nombre de la empresa
     * @throws IllegalArgumentException si la empresa es nula o está vacía
     */
    public void setEmpresa(String empresa) {
        if (!Validador.textoValido(empresa)) {
            throw new IllegalArgumentException("El nombre de la empresa proveedora no puede estar vacio.");
        }
        this.empresa = empresa;
    }

    /**
     * Devuelve el tipo de transporte ofrecido.
     *
     * @return el tipo de transporte
     */
    public String getTipoTransporte() {
        return tipoTransporte;
    }

    /**
     * Establece el tipo de transporte, validando que no esté vacío.
     *
     * @param tipoTransporte el nuevo tipo de transporte
     * @throws IllegalArgumentException si el tipo es nulo o está vacío
     */
    public void setTipoTransporte(String tipoTransporte) {
        if (!Validador.textoValido(tipoTransporte)) {
            throw new IllegalArgumentException("El tipo de transporte no puede estar vacio.");
        }
        this.tipoTransporte = tipoTransporte;
    }

    /**
     * Devuelve una representación legible del proveedor.
     *
     * @return una cadena con los datos del proveedor
     */
    @Override
    public String toString() {
        return empresa + " (" + tipoTransporte + ")";
    }
}
