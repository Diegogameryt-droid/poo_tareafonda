package cl.dsy1102.fonda;

public class BebidaAlcoholica extends Bebida implements ConsumoResponsable {
    private double gradosAlcohol;
    private boolean certificada;
    private boolean ventaRestringida;

    public BebidaAlcoholica(String nombre, int volumenML, int stock, double gradosAlcohol, boolean certificada) {
        super(nombre, volumenML, stock);
        setGradosAlcohol(gradosAlcohol);
        setCertificada(certificada);
        this.ventaRestringida = false;
    }

    @Override
    public double calcularPrecio() {
        double precioBase = getVolumenML() * 2.5;
        if (!certificada) {
            precioBase *= 1.20; // Recargo del 20% si no está certificada
        }
        return precioBase;
    }

    @Override
    public String obtenerDetalle() {
        return "Bebida Alcohólica: " + getNombre() +
                "\nVolumen: " + getVolumenML() + " mL" +
                "\nStock: " + getStock() +
                "\nGraduación: " + gradosAlcohol + "°" +
                "\nCertificada: " + (certificada ? "Sí" : "No") +
                "\nVenta Restringida: " + (ventaRestringida ? "Sí" : "No") +
                "\nPrecio Final: $" + String.format("%.0f", calcularPrecio());
    }

    @Override
    public boolean tieneVentaRestringida() {
        return ventaRestringida;
    }

    @Override
    public void restringirVenta() {
        this.ventaRestringida = true;
    }

    @Override
    public boolean superaLimite(int unidades) {
        return unidades > LIMITE_UNIDADES_POR_CLIENTE;
    }

    public double getGradosAlcohol() {
        return gradosAlcohol;
    }

    public void setGradosAlcohol(double gradosAlcohol) {
        if (gradosAlcohol <= 0 || gradosAlcohol > 60) {
            throw new IllegalArgumentException("Los grados de alcohol deben ser mayores a 0° y hasta 60°.");
        }
        this.gradosAlcohol = gradosAlcohol;
    }

    public boolean isCertificada() {
        return certificada;
    }

    public void setCertificada(boolean certificada) {
        this.certificada = certificada;
    }
}
