package cl.dsy1102.fonda;

import java.util.ArrayList;
import java.util.List;

public class GestorFonda {
    private List<Bebida> bebidas;

    public GestorFonda() {
        this.bebidas = new ArrayList<>();
    }

    public void registrar(Bebida bebida) {
        if (bebida != null) {
            bebidas.add(bebida);
        }
    }

    public List<Bebida> buscarPorNombre(String nombre) {
        List<Bebida> resultados = new ArrayList<>();
        if (nombre == null) return resultados;

        for (Bebida b : bebidas) {
            if (b.getNombre().equalsIgnoreCase(nombre.trim())) {
                resultados.add(b);
            }
        }
        return resultados;
    }

    public boolean vender(String nombre, int cantidad) {
        List<Bebida> encontradas = buscarPorNombre(nombre);

        if (encontradas.isEmpty()) {
            System.out.println("ERROR DE VENTA: No se encontró la bebida \"" + nombre + "\".");
            return false;
        }

        Bebida bebidaAVender = encontradas.get(0);

        if (bebidaAVender instanceof ConsumoResponsable) {
            ConsumoResponsable cr = (ConsumoResponsable) bebidaAVender;

            if (cr.tieneVentaRestringida()) {
                System.out.println("RECHAZADO: La bebida \"" + bebidaAVender.getNombre() + "\" tiene la venta restringida.");
                return false;
            }

            if (cr.superaLimite(cantidad)) {
                System.out.println("RECHAZADO: La cantidad solicitada (" + cantidad + ") supera el límite máximo de " + ConsumoResponsable.LIMITE_UNIDADES_POR_CLIENTE + " unidades por cliente.");
                return false;
            }
        }

        if (bebidaAVender.getStock() < cantidad) {
            System.out.println("RECHAZADO: Stock insuficiente para " + bebidaAVender.getNombre() + ". Disponible: " + bebidaAVender.getStock() + ", Solicitado: " + cantidad);
            return false;
        }

        bebidaAVender.setStock(bebidaAVender.getStock() - cantidad);
        double total = bebidaAVender.calcularPrecio() * cantidad;
        System.out.println("VENTA EXITOSA: " + cantidad + " x " + bebidaAVender.getNombre() + " | Total: $" + String.format("%.0f", total));
        return true;
    }

    public List<Bebida> obtenerTodas() {
        return bebidas;
    }
}
