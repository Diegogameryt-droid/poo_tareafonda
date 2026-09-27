package cl.dsy1102.fonda;

public class BebidaSinAlcohol extends Bebida {
    private double azucarPorLitro;

    public BebidaSinAlcohol(String nombre, int volumenML, int stock, double azucarPorLitro) {
        super(nombre, volumenML, stock);
        setAzucarPorLitro(azucarPorLitro);
    }

    @Override
    public double calcularPrecio() {
        double precioBase = getVolumenML() * 1.8;
        if (azucarPorLitro > 80.0) {
            precioBase *= 1.10; // Recargo del 10% si supera 80 g/L de azúcar
        }
        return precioBase;
    }

    @Override
    public String obtenerDetalle() {
        return "Bebida Sin Alcohol: " + getNombre() +
                "\nVolumen: " + getVolumenML() + " mL" +
                "\nStock: " + getStock() +
                "\nAzúcar: " + azucarPorLitro + " g/L" +
                "\nPrecio Final: $" + String.format("%.0f", calcularPrecio());
    }

    public double getAzucarPorLitro() {
        return azucarPorLitro;
    }

    public void setAzucarPorLitro(double azucarPorLitro) {
        if (azucarPorLitro < 0) {
            throw new IllegalArgumentException("El contenido de azúcar no puede ser negativo.");
        }
        this.azucarPorLitro = azucarPorLitro;
    }
}
