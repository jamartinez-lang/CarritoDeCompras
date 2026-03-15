import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Gestiona la colección de items y las operaciones del carrito.
 */
public class CarritoDeCompras {
    // Constantes (Hiperparámetros)
    private static final String CABECERA = "--- DETALLES DEL CARRITO ---";
    private static final String SIMBOLO_MONEDA = "€";

    // Uso de Map para escalabilidad y gestión de cantidades (Item -> Cantidad)
    private final Map<Item, Integer> items;

    public CarritoDeCompras() {
        this.items = new LinkedHashMap<>();
    }

    public void agregarItem(Item item, int cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        items.put(item, items.getOrDefault(item, 0) + cantidad);
    }

    public void removerItem(Item item) {
        if (!items.containsKey(item)) {
            throw new NoSuchElementException("El item '" + item.getNombre() + "' no existe en el carrito.");
        }
        items.remove(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (Map.Entry<Item, Integer> entrada : items.entrySet()) {
            total += entrada.getKey().getPrecio() * entrada.getValue();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(CABECERA).append("\n");
        for (Map.Entry<Item, Integer> entrada : items.entrySet()) {
            sb.append(entrada.getKey().toString())
              .append(" x")
              .append(entrada.getValue())
              .append("\n");
        }
        sb.append("Total: ").append(SIMBOLO_MONEDA).append(String.format("%.2f", calcularTotal()));
        return sb.toString();
    }
}