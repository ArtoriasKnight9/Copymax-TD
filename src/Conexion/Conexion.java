package Conexion;

import Modelo.Productosprecios;
import Modelo.ProductosFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * Clase Conexion que gestiona la conexión a la base de datos y
 * permite realizar operaciones sobre ella, como obtener una lista de productos.
 */
public class Conexion {
    private Connection connection; // Conexión a la base de datos
    
    /**
     * Constructor que establece la conexión con la base de datos MySQL.
     * Si la conexión falla, muestra un mensaje de error.
     */
    public Conexion() {
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/Copymax";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos, error: " + e.toString());
        }
    }
    
    /**
     * Obtiene la conexión actual.
     * 
     * @return Connection la conexión actual a la base de datos.
     */
    public Connection getConnection() {
        return connection;
    }
    
    /**
     * Verifica si la conexión a la base de datos está activa y disponible.
     * 
     * @return boolean true si la conexión está activa; false si está cerrada o nula.
     */
    public boolean verificarConexion() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
    
            /**
         * Obtiene una lista de productos desde la base de datos.
         * Cada producto contiene nombre, precio e ícono.
         * 
         * @param sql
         * @return List<Productosprecios> una lista de objetos Productosprecios con los datos obtenidos de la base de datos.
         * 
         */
   
    public List<Productosprecios> obtenerProductosfiltro(String sql) {
        List<Productosprecios> productos = new ArrayList<>();
       
        try (Connection con = getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("Nombre_producto");
                double precio = rs.getDouble("Precio");
                String icono = rs.getString("Icono");
                productos.add(new Productosprecios(nombre, precio, icono)); // Agregar producto a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Imprimir el error de la excepción
        }

        return productos; // Retornar la lista de productos
    }
    
   
     public List<Productosprecios> obtenerProductos() {
        List<Productosprecios> productos = new ArrayList<>();
        String sql = "SELECT Nombre_producto, Precio, Icono FROM Productos WHERE Cantidad > 0 AND Categoria IN ('Copia / Impresion', 'Papelería', 'Engargolado');";

        try (Connection con = getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("Nombre_producto");
                double precio = rs.getDouble("Precio");
                String icono = rs.getString("Icono");
                productos.add(new Productosprecios(nombre, precio, icono)); // Agregar producto a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Imprimir el error de la excepción
        }

        return productos; // Retornar la lista de productos
    }
    
    
    public List<Productosprecios> obtenerProductos(String filtro) {
    List<Productosprecios> productos = new ArrayList<>();
    String sql = "SELECT Nombre_producto, Precio, Icono " +
                 "FROM Productos " +
                 "WHERE Cantidad > 0 " +
                 "AND Categoria IN ('Copia / Impresion', 'Papelería', 'Engargolado') " +
                 "AND Nombre_producto LIKE ?";

    try (Connection con = getConnection(); 
         PreparedStatement pst = con.prepareStatement(sql)) {
        
        // Agregar el filtro a la consulta (con comodines para búsqueda parcial)
        pst.setString(1, "%" + filtro + "%");

        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                String nombre = rs.getString("Nombre_producto");
                double precio = rs.getDouble("Precio");
                String icono = rs.getString("Icono");
               productos.add(ProductosFactory.getProducto(nombre, precio, icono)); // Agregar producto a la lista
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Imprimir el error de la excepción
    }

    
    return productos; // Retornar la lista de productos
}
    
    
}
