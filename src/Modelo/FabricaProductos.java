package Modelo;
public interface FabricaProductos {
    Producto crearProducto(int id, String nombre, double precio, int cantidad);
}
