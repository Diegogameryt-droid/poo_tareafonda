package cl.dsy1102.fonda;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorFonda gestor = new GestorFonda();

        // 1. Instanciación de productos
        BebidaAlcoholica chichaAlc = new BebidaAlcoholica("Chicha", 1000, 40, 12.0, false);
        BebidaAlcoholica piscoSour = new BebidaAlcoholica("Pisco Sour", 500, 25, 18.0, true);
        BebidaSinAlcohol chichaSinAlc = new BebidaSinAlcohol("Chicha", 1000, 60, 95);
        BebidaSinAlcohol mote = new BebidaSinAlcohol("Mote con Huesillo", 400, 50, 70);

        // 2. Restricción de venta de la chicha alcohólica
        chichaAlc.restringirVenta();

        // 3. Registro en la colección
        gestor.registrar(chichaAlc);
        gestor.registrar(piscoSour);
        gestor.registrar(chichaSinAlc);
        gestor.registrar(mote);

        // 4. Búsqueda por nombre
        System.out.println("=== BÚSQUEDA POR NOMBRE: \"Chicha\" ===");
        List<Bebida> busqueda = gestor.buscarPorNombre("Chicha");
        for (Bebida b : busqueda) {
            System.out.println(b.obtenerDetalle());
            System.out.println("----------------------------------------");
        }

        // 5. Simulación de Ventas
        System.out.println("\n=== REGISTRO DE VENTAS ===");
        gestor.vender("Pisco Sour", 2);
        gestor.vender("Pisco Sour", 5);
        gestor.vender("Chicha", 1);
        gestor.vender("Mote con Huesillo", 6);

        // 6. Listado Resumido con toString()
        System.out.println("\n=== LISTADO RESUMIDO ===");
        for (Bebida b : gestor.obtenerTodas()) {
            System.out.println(b.toString());
        }
    }
}
