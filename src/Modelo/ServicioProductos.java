package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class ServicioProductos {
        // ---------------------- SINGLETON ------------------------
    private static ServicioProductos instancia;

    public ServicioProductos() {
        // Constructor privado
    }

    public static ServicioProductos getInstancia() {
        if (instancia == null) {
            instancia = new ServicioProductos();
        }
        return instancia;
    }
    // --------------------------------------------------------


    public List<Producto> obtenerProductosDesdeFabrica(FabricaProducto fabrica) {
        List<Producto> productos = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT idProductos, Nombre_producto, Precio, Cantidad, Categoria FROM Productos";

        try (Connection con = conex.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Producto producto = fabrica.crearProducto(rs);
                productos.add(producto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener productos: " + e.toString());
        }

        return productos;
    }
}