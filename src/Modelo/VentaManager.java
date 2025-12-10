
package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author Artorias<maxstell5549@hotmail.com>
 */
public class VentaManager {
    private static VentaManager instance;
    private double totalVentasDelDia;

    private VentaManager() {
        totalVentasDelDia = 0.0;
    }

    public static VentaManager getInstance() {
        if (instance == null) {
            instance = new VentaManager();
        }
        return instance;
    }

    public void agregarVenta(double monto) {
        totalVentasDelDia += monto;
    }

    public double getTotalVentasDelDia() {
        return totalVentasDelDia;
    }
    
    public void cortecaja() {
        totalVentasDelDia = 0;
    }
    
     // Método para agregar una venta con validación de corte de caja
    public int agregarVenta(String usuario, String cliente, String items, double subTotal, double impuesto, double descuento, double total, double recibido, double cambio,String Metodopago) {
        Conexion conexion = new Conexion();
        
        String insertSQL = "INSERT INTO venta (Usuario, Cliente, Fecha, Items, Subtotal, Impuesto, Descuento, Total, Recibido, Cambio, Metodo_pago, Usuario_idUsuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = conexion.getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {
             
            pstmt.setString(1, usuario);
            pstmt.setString(2, cliente);
            pstmt.setObject(3, java.time.LocalDateTime.now()); 
            pstmt.setString(4, items);
            pstmt.setDouble(5, subTotal);
            pstmt.setDouble(6, impuesto);
            pstmt.setDouble(7, descuento);
            pstmt.setDouble(8, total);
            pstmt.setDouble(9, recibido);
            pstmt.setDouble(10, cambio);
            pstmt.setString(11,Metodopago );
            pstmt.setInt(12, Usuariosesion.getInstance().getIdUsuario());
            

            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID de la venta.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    } 
 
   
    
}


