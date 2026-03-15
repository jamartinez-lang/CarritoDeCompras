/**
 * Representa un producto en la tienda.
 */
public class Item {
    private String nombre;
    private double precio;

    // Constante para límite de precio (Hiperparámetro)
    public static final double MAX_PRECIO_PERMITIDO = 5000.0;

    public Item(String nombre, double precio) {
        setNombre(nombre);
        setPrecio(precio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        if (precio > MAX_PRECIO_PERMITIDO) {
            throw new IllegalArgumentException("El precio supera el límite permitido de " + MAX_PRECIO_PERMITIDO);
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", nombre, precio);
    }

    // Sobrescribimos equals y hashCode para que el Map identifique correctamente los items
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return nombre.equals(item.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}