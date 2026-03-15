/**
 * Representa un producto individual dentro del catálogo de la tienda.
 * Esta clase asegura la integridad de los datos mediante validaciones en el constructor y setters.
 * * @author TuNombre
 * @version 1.0
 */
public class Item {
    /** Límite superior de precio para evitar errores de entrada o fraude. */
    public static final double MAX_PRECIO_PERMITIDO = 5000.0;
    
    private String nombre;
    private double precio;

    /**
     * Construye un nuevo Item con nombre y precio validados.
     * * @param nombre El nombre descriptivo del producto.
     * @param precio El costo unitario en la moneda local.
     * @throws IllegalArgumentException si el nombre es nulo/vacío o el precio es inválido.
     */
    public Item(String nombre, double precio) {
        setNombre(nombre);
        setPrecio(precio);
    }

    /** @return El nombre del item. */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del item.
     * @param nombre No puede ser nulo ni estar compuesto solo de espacios.
     * @throws IllegalArgumentException si el nombre es inválido.
     */
    public final void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    /** @return El precio unitario del item. */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del item validando rangos de negocio.
     * @param precio Debe ser mayor o igual a 0 y menor que {@value #MAX_PRECIO_PERMITIDO}.
     * @throws IllegalArgumentException si el precio es negativo o excesivo.
     */
    public final void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        if (precio > MAX_PRECIO_PERMITIDO) {
            throw new IllegalArgumentException("El precio indicado (" + precio + ") supera el límite de seguridad.");
        }
        this.precio = precio;
    }

    /**
     * Devuelve una representación textual del item.
     * @return Formato "Nombre - $Precio"
     */
    @Override
    public String toString() {
        return String.format("%s - %.2f", nombre, precio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return nombre.equalsIgnoreCase(item.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode();
    }
}
