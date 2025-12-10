package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Productoclass implements Producto, ClonableProducto{

    int id,cantidad;
    String Nombre,Categoria,icono;
    double precio;
    
    @Override
    public int getId() {
        return id;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return Nombre;
    }

    @Override
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
        @Override
    public Producto clonar() {
        Productoclass clon = new Productoclass();
        clon.setId(this.id);
        clon.setNombre(this.Nombre);
        clon.setPrecio(this.precio);
        clon.setCantidad(this.cantidad);
        clon.setCategoria(this.Categoria);
        return clon;
    }
    
    // No mover se usa con abstract y fabrica
    public List<Producto> obtenerProductos() {
    List<Producto> productos = new ArrayList<>();
    Conexion conex = new Conexion();
    String sql = "SELECT idProductos, Nombre_producto, Precio, Cantidad, Categoria FROM Productos";
    FabricaProducto fabrica = new FabricaProductoConcreto();

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
// no mover arriba iguak se ocupa para abstract
    
    public List<Productoclass> obtenerClientesProductoscatego(String categoria) {
        List<Productoclass> productos = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT idProductos, Nombre_producto, Precio, Cantidad, Categoria FROM Productos WHERE Categoria LIKE ?";
        try (Connection con = conex.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            // Configurar el parámetro de la consulta con el número de celular proporcionado
            pst.setString(1, "%" + categoria + "%");
            
            // Ejecutar la consulta
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                     Productoclass producto = new Productoclass();
            
            producto.setId(rs.getInt("idProductos")); // Asegúrate que "idProductos" es el nombre correcto de la columna
            producto.setNombre(rs.getString("Nombre_producto")); // Usa el nombre exacto de la columna
            producto.setPrecio(rs.getDouble("Precio")); // Obtén el precio de la columna "Precio"
            producto.setCantidad(rs.getInt("Cantidad")); // Obtén la cantidad de la columna "Cantidad"
            producto.setCategoria(rs.getString("Categoria")); // Obtén la categoría de la columna "Categoria"
            productos.add(producto);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener productos por cateroria: " + e.toString());
        }
        return productos;
    }
        @Override
    public String toString() {
        return "Productoclass{" +
                "id=" + id +
                ", nombre='" + Nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", categoria='" + Categoria + '\'' +
                ", icono='" + icono + '\'' +
                '}';
    }    
    
}
