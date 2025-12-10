package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
public class FabricaProductoConcreto implements FabricaProducto {
    @Override
    public Producto crearProducto(ResultSet rs) throws SQLException {
        int id = rs.getInt("idProductos");
        String nombre = rs.getString("Nombre_producto");
        double precio = rs.getDouble("Precio");
        int cantidad = rs.getInt("Cantidad");
        String categoria = rs.getString("Categoria");

        return FabricaProductoGeneral.crearProducto(id, nombre, precio, cantidad, categoria);
    }
}