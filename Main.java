/**
 * Clase principal que simula la interacción de un usuario con el sistema de ventas.
 */
public class Main {
    /**
     * Punto de entrada de la aplicación.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        try {
            // Instanciación independiente del carrito
            CarritoDeCompras miCarrito = new CarritoDeCompras();

            // Creación de items
            Item item1 = new Item("Camiseta", 20.99);
            Item item2 = new Item("Pantalones", 34.99);

            // Operaciones
            miCarrito.agregarItem(item1, 3); // Compramos 3 camisetas
            miCarrito.agregarItem(item2, 1); // Compramos 1 pantalón

            // Impresión del detalle (usando el toString del carrito)
            System.out.println(miCarrito);

            // Ejemplo de manejo de error al eliminar algo inexistente
            // miCarrito.removerItem(new Item("Zapatos", 10.0));

        } catch (Exception e) {
            System.err.println("ERROR DEL SISTEMA: " + e.getMessage());
        }
    }
}
