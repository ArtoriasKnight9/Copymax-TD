package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase usada específicamente para crear productos desde ResultSet,
 * usada en la exportación a JSON.
 */
public class FabricaProductoDesdeResultSet implements FabricaProducto {

    @Override
    public Producto crearProducto(ResultSet rs) {
        try {
            Productoclass producto = new Productoclass();
            producto.setId(rs.getInt("idProductos"));
            producto.setNombre(rs.getString("Nombre_producto"));
            producto.setPrecio(rs.getDouble("Precio"));
            producto.setCantidad(rs.getInt("Cantidad"));
            producto.setCategoria(rs.getString("Categoria"));
            return producto;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
