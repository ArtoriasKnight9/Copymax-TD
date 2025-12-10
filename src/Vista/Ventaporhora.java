/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Ventaporhora {
    private Conexion conexion;

    public Ventaporhora() {
        this.conexion = new Conexion();
    }

    public Map<Integer, Double> obtenerVentasPorHora(LocalDate fecha) {
    Map<Integer, Double> ventasPorHora = new HashMap<>();
    String sql = "SELECT HOUR(Fecha) as hora, SUM(Total) as totalVentas FROM Venta WHERE DATE(Fecha) = ? GROUP BY hora ORDER BY hora";

    try (Connection con = conexion.getConnection(); 
         PreparedStatement pst = con.prepareStatement(sql)) {
        
        pst.setString(1, fecha.toString());
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            int hora = rs.getInt("hora");
            double totalVentas = rs.getDouble("totalVentas");
            ventasPorHora.put(hora, totalVentas);
            System.out.println("Hora: " + hora + ", Total Ventas: " + totalVentas);  // Debug
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener las ventas por hora: " + e.getMessage());
    }

    return ventasPorHora;
}

}
