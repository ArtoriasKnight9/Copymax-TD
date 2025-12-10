package Modelo;
public class FabricaEngargolado implements FabricaProductos{
    @Override
    public Producto crearProducto(int id, String nombre, double precio, int cantidad) {
        Productoclass producto = new Productoclass();
        producto.setId(id);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.setCategoria("Engargolado");
        return producto;
    }
}
