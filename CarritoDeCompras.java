import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Gestor de la cesta de la compra. 
 * Utiliza un {@link LinkedHashMap} para garantizar una búsqueda eficiente (O(1)) 
 * y mantener el orden en que el cliente añade los productos.
 * * @author TuNombre
 * @version 1.0
 */
public class CarritoDeCompras {
    private static final String CABECERA = "--- RECIBO DE COMPRA ---";
    private static final String SIMBOLO_MONEDA = "€";

    /** Almacena el Item como clave y su cantidad entera como valor. */
    private final Map<Item, Integer> items;

    /**
     * Inicializa un carrito vacío.
     */
    public CarritoDeCompras() {
        this.items = new LinkedHashMap<>();
    }

    /**
     * Añade un item al carrito o incrementa su cantidad si ya existe.
     * * @param item El objeto Item a añadir.
     * @param cantidad Cantidad de unidades (debe ser > 0).
     * @throws IllegalArgumentException si la cantidad es menor o igual a cero.
     */
    public void agregarItem(Item item, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a añadir debe ser positiva.");
        }
        items.put(item, items.getOrDefault(item, 0) + cantidad);
    }

    /**
     * Elimina completamente un producto del carrito.
     * * @param item El item a remover.
     * @throws NoSuchElementException si el producto no se encuentra en el carrito.
     */
    public void removerItem(Item item) {
        if (!items.containsKey(item)) {
            throw new NoSuchElementException("No se puede eliminar: El producto '" + item.getNombre() + "' no está en el carrito.");
        }
        items.remove(item);
    }

    /**
     * Calcula el importe total sumando (precio * cantidad) de cada línea.
     * * @return El total acumulado del carrito.
     */
    public double calcularTotal() {
        double total = 0;
        for (Map.Entry<Item, Integer> linea : items.entrySet()) {
            total += linea.getKey().getPrecio() * linea.getValue();
        }
        return total;
    }

    /**
     * Genera un detalle visual de todos los items, sus cantidades y el total final.
     * Sobrescribe el método toString para evitar acoplamiento con la impresión por consola.
     * * @return Cadena formateada lista para ser impresa.
     */
    @Override
    public String toString() {
        if (items.isEmpty()) return "El carrito está vacío.";

        StringBuilder sb = new StringBuilder(CABECERA).append("\n");
        for (Map.Entry<Item, Integer> linea : items.entrySet()) {
            sb.append(String.format("- %-15s x%d: %s%.2f%n", 
                linea.getKey().getNombre(), 
                linea.getValue(), 
                SIMBOLO_MONEDA,
                linea.getKey().getPrecio() * linea.getValue()));
        }
        sb.append("------------------------\n");
        sb.append("TOTAL A PAGAR: ").append(SIMBOLO_MONEDA).append(String.format("%.2f", calcularTotal()));
        return sb.toString();
    }
}
