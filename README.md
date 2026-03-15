# 🛒 Carrito de Compras - Refactorización Pro

Este proyecto es una versión mejorada y refactorizada de un sistema de carrito de compras básico en Java. El objetivo principal ha sido aplicar principios de diseño orientado a objetos (**SOLID**), mejorar la escalabilidad y asegurar la integridad de los datos.

---

## 🚀 Mejoras Implementadas

### 1. Arquitectura y Responsabilidades
- **Entidad Propia**: Se separó la lógica del carrito (`CarritoDeCompras`) del punto de entrada de la aplicación (`Main`).
- **Encapsulamiento**: La clase `Item` ahora protege sus atributos mediante `private` y ofrece acceso controlado a través de *getters* y *setters*.

### 2. Escalabilidad y Rendimiento
- **Estructura de Datos**: Se sustituyó el `ArrayList` original por un `LinkedHashMap<Item, Integer>`. 
    - **Por qué**: Permite búsquedas y eliminaciones en tiempo constante $O(1)$ y facilita la gestión de **cantidades** por producto sin duplicar objetos.
- **Gestión de Cantidades**: Ahora es posible añadir múltiples unidades de un mismo ítem de forma eficiente.

### 3. Robustez y Validación
- **Manejo de Excepciones**: 
    - Se lanzan errores si se intenta crear un producto con precio negativo o superior al límite de seguridad.
    - Se gestionan errores mediante `NoSuchElementException` si se intenta eliminar un producto que no existe.
- **Constantes (Hiperparámetros)**: El símbolo de moneda, los encabezados y los límites de precio están definidos como constantes para facilitar el mantenimiento.

### 4. Desacoplamiento y Limpieza
- **DRY (Don't Repeat Yourself)**: Se eliminó la duplicación de código en la impresión.
- **Sobrescritura de `toString()`**: Tanto el `Item` como el `Carrito` gestionan su propia representación textual, reduciendo el acoplamiento entre clases.

---

## 📁 Estructura del Proyecto

```text
CarritoDeCompras/
│
├── src/
│   ├── Main.java              # Punto de entrada y prueba del sistema
│   ├── CarritoDeCompras.java  # Lógica de negocio y gestión de items
│   └── Item.java              # Modelo de datos con validaciones
│
├── doc/                       # Documentación Javadoc generada
└── README.md                  # Descripción del proyecto
