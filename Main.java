public class Main {
    public static void main(String[] args) {
        try {
            CarritoDeCompras carrito = new CarritoDeCompras();

            Item camiseta = new Item("Camiseta", 20.99);
            Item pantalones = new Item("Pantalones", 34.99);

            carrito.agregarItem(camiseta, 2); // Añadimos 2 camisetas
            carrito.agregarItem(pantalones, 1);

            System.out.println(carrito.toString());

            // Prueba de eliminación y excepción
            // carrito.removerItem(new Item("Zapatos", 50)); // Esto lanzaría excepción
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}