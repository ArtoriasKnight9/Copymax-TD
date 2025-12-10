package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface FabricaProducto {
    Producto crearProducto(ResultSet rs) throws SQLException;
}