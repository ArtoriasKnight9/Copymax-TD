package Modelo;

import Conexion.Conexion;
import java.sql.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.table.DefaultTableModel;

public class DashboardManager {

    // --- MÉTODO AUXILIAR: EL CEREBRO DEL FILTRO ---
    // Este método construye la condición WHERE dinámicamente.
    // Si esMes = true, filtra por el número de mes (1=Enero).
    // Si esMes = false, filtra por los últimos X días.
    private String obtenerCondicionFecha(int valorFiltro, boolean esMes) {
        if (esMes) {
            // Filtra por el Mes seleccionado del año actual
            // Ejemplo: WHERE MONTH(v.Fecha) = 10 AND YEAR(v.Fecha) = 2023
            return "WHERE MONTH(v.Fecha) = " + valorFiltro + " AND YEAR(v.Fecha) = YEAR(NOW()) ";
        } else {
            // Filtra por los últimos X días
            // Ejemplo: WHERE v.Fecha >= DATE_SUB(NOW(), INTERVAL 7 DAY)
            return "WHERE v.Fecha >= DATE_SUB(NOW(), INTERVAL " + valorFiltro + " DAY) ";
        }
    }

    // 1. TOP 5 PRODUCTOS (Barras)
    public DefaultCategoryDataset obtenerTopProductos(int filtro, boolean esMes) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Conexion con = new Conexion();
        
        // Obtenemos el WHERE dinámico
        String whereClause = obtenerCondicionFecha(filtro, esMes);
        
        String sql = "SELECT p.Nombre_producto, SUM(dv.Cantidad) as Unidades " +
                     "FROM detalle_venta dv " +
                     "JOIN productos p ON dv.idProductos = p.idProductos " +
                     "JOIN venta v ON dv.idVenta = v.idVenta " +
                     whereClause + // <--- AQUÍ SE INYECTA EL FILTRO
                     "GROUP BY p.Nombre_producto " +
                     "ORDER BY Unidades DESC LIMIT 5";

        try (Connection c = con.getConnection();
             PreparedStatement pst = c.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                dataset.setValue(rs.getInt("Unidades"), "Unidades", rs.getString("Nombre_producto"));
            }
        } catch (SQLException e) { System.err.println("Error Top Productos: " + e.getMessage()); }
        return dataset;
    }

    // 2. VENTAS POR CATEGORÍA (Pastel)
    public DefaultPieDataset obtenerVentasPorCategoria(int filtro, boolean esMes) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Conexion con = new Conexion();

        String whereClause = obtenerCondicionFecha(filtro, esMes);

        String sql = "SELECT p.Categoria, SUM(dv.Cantidad * dv.PrecioUnitario) as Total " +
                     "FROM detalle_venta dv " +
                     "JOIN productos p ON dv.idProductos = p.idProductos " +
                     "JOIN venta v ON dv.idVenta = v.idVenta " +
                     whereClause +
                     "GROUP BY p.Categoria";

        try (Connection c = con.getConnection();
             PreparedStatement pst = c.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                dataset.setValue(rs.getString("Categoria"), rs.getDouble("Total"));
            }
        } catch (SQLException e) { System.err.println("Error Categorías: " + e.getMessage()); }
        return dataset;
    }

    // 3. HORAS PICO (Barras - Tráfico)
    public DefaultCategoryDataset obtenerVentasPorHora(int filtro, boolean esMes) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Conexion con = new Conexion();
        
        String whereClause = obtenerCondicionFecha(filtro, esMes);
        
        // Nota: Agregamos el alias 'v' a la tabla venta para que coincida con el helper
        String sql = "SELECT HOUR(v.Fecha) as Hora, COUNT(*) as Transacciones " +
                     "FROM venta v " + 
                     whereClause +
                     "GROUP BY HOUR(v.Fecha) ORDER BY Hora ASC";

        try (Connection c = con.getConnection();
             PreparedStatement pst = c.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int hora = rs.getInt("Hora");
                // Formatear hora (ej. 14:00)
                String etiquetaHora = String.format("%02d:00", hora);
                dataset.setValue(rs.getInt("Transacciones"), "Ventas", etiquetaHora);
            }
        } catch (SQLException e) { System.err.println("Error Horas Pico: " + e.getMessage()); }
        return dataset;
    }

    // 4. TENDENCIA DE VENTAS (Línea)
    public DefaultCategoryDataset obtenerTendenciaVentas(int filtro, boolean esMes) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Conexion con = new Conexion();

        String whereClause = obtenerCondicionFecha(filtro, esMes);

        String sql = "SELECT DATE(v.Fecha) as Dia, SUM(v.Total) as TotalDia " +
                     "FROM venta v " +
                     whereClause +
                     "GROUP BY DATE(v.Fecha) ORDER BY Dia ASC";

        try (Connection c = con.getConnection();
             PreparedStatement pst = c.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                dataset.setValue(rs.getDouble("TotalDia"), "Ventas", rs.getString("Dia"));
            }
        } catch (SQLException e) { System.err.println("Error Tendencia: " + e.getMessage()); }
        return dataset;
    }

    // 5. ALERTA STOCK BAJO (Tabla) - No requiere filtro de fecha, es estado actual
    public DefaultTableModel obtenerStockBajo() {
        String[] columnas = {"Producto", "Stock"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        Conexion con = new Conexion();
        
        String sql = "SELECT Nombre_producto, Cantidad FROM productos " +
                     "WHERE Cantidad <= 5 AND Cantidad >= 0 " +
                     "ORDER BY Cantidad ASC LIMIT 20";
        
        try (Connection c = con.getConnection();
             PreparedStatement pst = c.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString(1), rs.getInt(2)});
            }
        } catch (SQLException e) { System.err.println("Error Stock: " + e.getMessage()); }
        return modelo;
    }

    // 6. KPI TICKET PROMEDIO (Histórico General)
    public double obtenerTicketPromedio() {
        double promedio = 0.0;
        Conexion con = new Conexion();
        String sql = "SELECT AVG(Total) FROM venta";

        try (Connection c = con.getConnection();
             PreparedStatement pst = c.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                promedio = rs.getDouble(1);
            }
        } catch (SQLException e) { System.err.println("Error KPI: " + e.getMessage()); }
        return promedio;
    }
}