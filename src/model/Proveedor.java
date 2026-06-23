package model;

/**
 * Representa al proveedor de transporte asociado a un {@link Tour}.
 * <p>
 * Esta clase forma parte de la composición de {@code Tour}: cada tour
 * "tiene un" proveedor encargado del traslado de los turistas.
 * </p>
 *
 * @author Olga Rivas Ahumada
 * @version 1.0
 */
public class Proveedor {

    private String empresa;
    private String tipoTransporte;

    /**
     * Crea un nuevo proveedor de transporte.
     *
     * @param empresa nombre de la empresa proveedora
     * @param tipoTransporte tipo de transporte que ofrece (bus, van, lancha, etc.)
     */
    public Proveedor(String empresa, String tipoTransporte) {
        this.empresa = empresa;
        this.tipoTransporte = tipoTransporte;
    }

    /**
     * Obtiene el nombre de la empresa proveedora.
     *
     * @return nombre de la empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Establece el nombre de la empresa proveedora.
     *
     * @param empresa nuevo nombre de la empresa
     * @throws IllegalArgumentException si el nombre es nulo o está vacío
     */
    public void setEmpresa(String empresa) {
        if (!util.Validador.textoValido(empresa)) {
            throw new IllegalArgumentException("El nombre de la empresa no puede estar vacío.");
        }
        this.empresa = empresa;
    }

    /**
     * Obtiene el tipo de transporte ofrecido.
     *
     * @return tipo de transporte
     */
    public String getTipoTransporte() {
        return tipoTransporte;
    }

    /**
     * Establece el tipo de transporte ofrecido.
     *
     * @param tipoTransporte nuevo tipo de transporte
     * @throws IllegalArgumentException si el valor es nulo o está vacío
     */
    public void setTipoTransporte(String tipoTransporte) {
        if (!util.Validador.textoValido(tipoTransporte)) {
            throw new IllegalArgumentException("El tipo de transporte no puede estar vacío.");
        }
        this.tipoTransporte = tipoTransporte;
    }

    /**
     * Retorna una representación legible del proveedor.
     *
     * @return texto con empresa y tipo de transporte
     */
    @Override
    public String toString() {
        return "Proveedor: " + empresa + " | Transporte: " + tipoTransporte;
    }
}
