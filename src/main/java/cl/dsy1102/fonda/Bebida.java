package cl.dsy1102.fonda;

public abstract class Bebida {
    private String nombre;
    private int volumenML;
    private int stock;

    public Bebida(String nombre, int volumenML, int stock) {
        setNombre(nombre);
        setVolumenML(volumenML);
        setStock(stock);
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
    }

    public void setVolumenML(int volumenML) {
        if (volumenML < 100 || volumenML > 3000) {
            throw new IllegalArgumentException("El volumen debe estar entre 100 y 3000 ml.");
        }
        this.volumenML = volumenML;
    }

    public void setStock(int stock) {
        if (stock <= 0) {
            throw new IllegalArgumentException("El stock debe ser un valor mayor que cero.");
        }
        this.stock = stock;
    }
    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Volumen: " + volumenML + " ml";
    }
}
