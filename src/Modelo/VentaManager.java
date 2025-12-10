
package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List; // <--- AGREGAR
import javax.swing.JOptionPane; // <--- AGREGAR
import Modelo.DetalleVenta;
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
    
    public boolean registrarVentaTransaccional(Venta ventaDatos, List<DetalleVenta> listaDetalles, String metodoPago, double recibido, double cambio) {
        Conexion conObj = new Conexion();
        Connection con = conObj.getConnection();

        PreparedStatement psVenta = null;
        PreparedStatement psDetalle = null;
        PreparedStatement psCaja = null;
        ResultSet rsKeys = null;
        ResultSet rsCaja = null;

        try {
            // 1. INICIAR TRANSACCIÓN (Apagar guardado automático)
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Error: No hay conexión a la base de datos.");
                return false;
            }
            con.setAutoCommit(false);

            // --- PASO A: Obtener el ID de la Caja abierta hoy ---
            int idCajaActual = 0;
            // Busca la caja del día actual. Si tienes turnos, esto toma la última creada hoy.
            String sqlCaja = "SELECT idCaja FROM caja WHERE DATE(FechaInicio) = CURDATE() ORDER BY idCaja DESC LIMIT 1";
            psCaja = con.prepareStatement(sqlCaja);
            rsCaja = psCaja.executeQuery();

            if (rsCaja.next()) {
                idCajaActual = rsCaja.getInt("idCaja");
            } else {
                // Opcional: Si quieres permitir ventas sin caja, comenta el throw y deja idCajaActual en 0
                // Pero para tu Dashboard financiero, esto es vital.
                throw new SQLException("No se detectó una Caja abierta (Corte) para el día de hoy.\nPor favor, inicie caja primero.");
            }

            // --- PASO B: Insertar la VENTA (Cabecera) ---
            // Nota: Aquí llenamos las columnas nuevas (idCaja, Cliente_idCliente) y las viejas (Strings)
            String sqlVenta = "INSERT INTO venta (Usuario_idUsuario, Cliente_idCliente, idCaja, Usuario, Cliente, Fecha, Items, Subtotal, Impuesto, Descuento, Total, Recibido, Cambio, Metodo_pago) "
                    + "VALUES (?, "
                    + "(SELECT idCliente FROM cliente WHERE CONCAT(Nombre, ' ', Apellidos) LIKE ? LIMIT 1), " // Intenta buscar el ID del cliente por nombre
                    + "?, ?, ?, NOW(), ?, ?, ?, ?, ?, ?, ?, ?)";

            psVenta = con.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS);

            // 1. ID Usuario (FK)
            psVenta.setInt(1, Usuariosesion.getInstance().getIdUsuario());
            
            // 2. Nombre Cliente (Para buscar el ID en el subquery)
            // Si es "General", el subquery podría dar NULL, lo cual es aceptable si la columna permite nulos.
            psVenta.setString(2, ventaDatos.getCliente() + "%"); 

            // 3. ID Caja (FK)
            psVenta.setInt(3, idCajaActual);

            // 4 y 5. Datos Legado (Texto)
            psVenta.setString(4, ventaDatos.getUsuario());
            psVenta.setString(5, ventaDatos.getCliente());

            // 6. Fecha (NOW() lo maneja SQL) - Saltamos al 7
            psVenta.setString(6, ventaDatos.getItems()); // String largo para el PDF
            psVenta.setDouble(7, ventaDatos.getSubtotal());
            psVenta.setDouble(8, ventaDatos.getImpuesto());
            psVenta.setDouble(9, ventaDatos.getDescuento());
            psVenta.setDouble(10, ventaDatos.getTotal());
            psVenta.setDouble(11, recibido);
            psVenta.setDouble(12, cambio);
            psVenta.setString(13, metodoPago);

            int filas = psVenta.executeUpdate();
            if (filas == 0) {
                throw new SQLException("No se pudo guardar la cabecera de la venta.");
            }

            // --- PASO C: Obtener el ID generado (ej. Venta #501) ---
            int idVentaGenerada = 0;
            rsKeys = psVenta.getGeneratedKeys();
            if (rsKeys.next()) {
                idVentaGenerada = rsKeys.getInt(1);
            } else {
                throw new SQLException("No se pudo obtener el ID de la venta.");
            }

            // --- PASO D: Insertar DETALLES (Bucle masivo) ---
            // OJO: Verifica que tu tabla se llame 'detalle_venta' o 'Detalle_venta' en tu BD
            String sqlDetalle = "INSERT INTO detalle_venta (idVenta, idProductos, Cantidad, PrecioUnitario) VALUES (?, ?, ?, ?)";
            psDetalle = con.prepareStatement(sqlDetalle);

            for (DetalleVenta item : listaDetalles) {
                psDetalle.setInt(1, idVentaGenerada);
                psDetalle.setInt(2, item.getIdProducto());
                psDetalle.setInt(3, item.getCantidad());
                psDetalle.setDouble(4, item.getPrecioUnitario());
                // Calculamos subtotal por renglón
                double subtotalRenglon = item.getCantidad() * item.getPrecioUnitario();
                

                psDetalle.addBatch(); // Agregamos al lote
            }

            psDetalle.executeBatch(); // Ejecutamos todas las inserciones juntas

            // --- ÉXITO: CONFIRMAR CAMBIOS (COMMIT) ---
            con.commit();
            // Sumar al total local (para tu lógica actual de corte)
            agregarVenta(ventaDatos.getTotal()); 
            
            System.out.println("Venta Transaccional Exitosa. ID: " + idVentaGenerada);
            return true;

        } catch (SQLException e) {
            // --- ERROR: DESHACER TODO (ROLLBACK) ---
            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("Se hizo Rollback por error.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error crítico en Base de Datos:\n" + e.getMessage());
            return false;
        } finally {
            // Cerrar recursos para no tumbar el servidor
            try { if (rsKeys != null) rsKeys.close(); } catch (Exception e) {}
            try { if (psCaja != null) psCaja.close(); } catch (Exception e) {}
            try { if (psVenta != null) psVenta.close(); } catch (Exception e) {}
            try { if (psDetalle != null) psDetalle.close(); } catch (Exception e) {}
            try { 
                if (con != null) {
                    con.setAutoCommit(true); // Restaurar estado normal
                    con.close(); 
                }
            } catch (Exception e) {}
        }
    }
 
   
    
}


