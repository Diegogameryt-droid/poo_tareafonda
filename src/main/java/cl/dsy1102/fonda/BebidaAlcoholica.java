package cl.dsy1102.fonda;

public class BebidaAlcoholica {
    private int LimitePorCliente;
    private double gradosAlcohol;
    private boolean certificada;
    private boolean ventaRestringida;
    private String nombre;

    public BebidaAlcoholica(String nombre, int LimitePorCliente, double gradosAlcohol) {
        this.LimitePorCliente = LimitePorCliente;
        this.gradosAlcohol = gradosAlcohol;
        this.certificada = false;
        this.ventaRestringida = false;
        this.nombre = nombre;
    }

    public int getLimitePorCliente() {
        return LimitePorCliente;
    }

    public void setLimitePorCliente(int limitePorCliente) {
        LimitePorCliente = limitePorCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVentaRestringida() {
        return ventaRestringida;
    }

    public void setVentaRestringida(boolean ventaRestringida) {
        this.ventaRestringida = ventaRestringida;
    }

    public boolean isCertificada() {
        return certificada;
    }

    public void setCertificada(boolean certificada) {
        this.certificada = certificada;
    }

    public double getGradosAlcohol() {
        return gradosAlcohol;
    }

    public void setGradosAlcohol(double gradosAlcohol) {
        this.gradosAlcohol = gradosAlcohol;
    }
}

