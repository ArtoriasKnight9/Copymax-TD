/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Conexion.Conexion;
import Modelo.Usuariosesion;
import Vista.Corte;
import com.formdev.flatlaf.FlatLightLaf;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
 /*
 * @author Artorias<maxstell5549@hotmail.com>
 */
public class MVC extends javax.swing.JFrame {

    Interfazprincipal interfazprincipal;
     
   /*
    
    Clase donde se inician los componentes y se verifica el tipo de usuario al momento de ingresar en la 
    ventana principal
       
    
    */
    
    
    public MVC() {
        initComponents();
         createCharts();
         ajusterol(Usuariosesion.getInstance().getRol());
    }
    
    
    
    @Override
public void setVisible(boolean visible) {
    super.setVisible(visible);
    if (visible) {
        createCharts();
    }
}
    public void ajusterol(String rol){
       if ("Estandar".equals(rol)){
            
           BtnProductos.setEnabled(false);
           Btnusuarios.setEnabled(false);
           btnvtasdia.setEnabled(false);
           BtnEstadísticas.setEnabled(false);
           
       
       } else {
           BtnProductos.setEnabled(true);
           Btnusuarios.setEnabled(true);
           btnvtasdia.setEnabled(true);
           BtnEstadísticas.setEnabled(true);
       }
    }

     // Método para crear los gráficos
   private void createCharts() {
    // Gráfico de ventas del día
    JFreeChart barChart = ChartFactory.createBarChart(
            "Ventas del Día",
            "Categoría",
            "Monto",
            createDatasetVentasDelDia()
    );
    ChartPanel barChartPanel = new ChartPanel(barChart);
    barChartPanel.setPreferredSize(new Dimension(195, 570)); // Tamaño preferido para el primer gráfico

    // Gráfico del producto más vendido
    JFreeChart pieChart = ChartFactory.createPieChart(
            "Producto Más Vendido",
            createDatasetProductoMasVendido(),
            true,
            true,
            false
    );
    ChartPanel pieChartPanel = new ChartPanel(pieChart);
    pieChartPanel.setPreferredSize(new Dimension(200, 570)); // Tamaño preferido para el segundo gráfico

    // Añadir los gráficos al panel principal
    chartPanel.setLayout(new GridLayout(1, 2));
    chartPanel.removeAll();
    chartPanel.add(barChartPanel);
    chartPanel.add(pieChartPanel);
    chartPanel.revalidate();
    chartPanel.repaint();
}

    // Método para crear el dataset de las ventas del día
    private DefaultCategoryDataset createDatasetVentasDelDia() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = new Conexion().getConnection();
            String query = "SELECT Fecha, SUM(Total) as Total FROM venta WHERE Fecha = CURDATE() GROUP BY Fecha";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                String fecha = rs.getString("Fecha");
                double total = rs.getDouble("Total");
                dataset.addValue(total, "Ventas", fecha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return dataset;
    }

    // Método para crear el dataset del producto más vendido
    private DefaultPieDataset createDatasetProductoMasVendido() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = new Conexion().getConnection();
            String query = "SELECT Productos.Nombre_producto, SUM(venta.Items) as CantidadVendida FROM venta " +
                    "JOIN Productos ON venta.idVenta = Productos.idProductos " +
                    "GROUP BY Productos.Nombre_producto ORDER BY CantidadVendida DESC LIMIT 1";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                String nombreProducto = rs.getString("Nombre_producto");
                int cantidadVendida = rs.getInt("CantidadVendida");
                dataset.setValue(nombreProducto, cantidadVendida);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return dataset;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        s = new javax.swing.JMenuItem();
        Panelmain = new javax.swing.JPanel();
        BtnClientes = new javax.swing.JButton();
        BtnVenta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BtnCerrarsesion = new javax.swing.JButton();
        BtnProductos = new javax.swing.JButton();
        Btnusuarios = new javax.swing.JButton();
        btnvtasdia = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BtnEstadísticas = new javax.swing.JButton();
        chartPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        s.setText("jMenuItem1");
        jPopupMenu1.add(s);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panelmain.setBackground(new java.awt.Color(204, 204, 204));

        BtnClientes.setBackground(new java.awt.Color(204, 255, 255));
        BtnClientes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnClientes.setForeground(new java.awt.Color(0, 0, 0));
        BtnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clasificacion (Custom).png"))); // NOI18N
        BtnClientes.setText("Clientes");
        BtnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClientesActionPerformed(evt);
            }
        });

        BtnVenta.setBackground(new java.awt.Color(204, 255, 255));
        BtnVenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnVenta.setForeground(new java.awt.Color(0, 0, 0));
        BtnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas (Custom).png"))); // NOI18N
        BtnVenta.setText("Venta");
        BtnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVentaActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.setToolTipText("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/90x90.png"))); // NOI18N

        BtnCerrarsesion.setBackground(new java.awt.Color(255, 0, 0));
        BtnCerrarsesion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BtnCerrarsesion.setForeground(new java.awt.Color(255, 255, 255));
        BtnCerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        BtnCerrarsesion.setText("Cerrar Sesión");
        BtnCerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarsesionActionPerformed(evt);
            }
        });

        BtnProductos.setBackground(new java.awt.Color(255, 255, 255));
        BtnProductos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BtnProductos.setForeground(new java.awt.Color(0, 0, 0));
        BtnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/papeleria (Custom).png"))); // NOI18N
        BtnProductos.setText("Productos");
        BtnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProductosActionPerformed(evt);
            }
        });

        Btnusuarios.setBackground(new java.awt.Color(255, 255, 255));
        Btnusuarios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Btnusuarios.setForeground(new java.awt.Color(0, 0, 0));
        Btnusuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios.png"))); // NOI18N
        Btnusuarios.setText("Usuarios");
        Btnusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnusuariosActionPerformed(evt);
            }
        });

        btnvtasdia.setBackground(new java.awt.Color(255, 255, 255));
        btnvtasdia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnvtasdia.setForeground(new java.awt.Color(0, 0, 0));
        btnvtasdia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas.png"))); // NOI18N
        btnvtasdia.setText("Ventas del día ");
        btnvtasdia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvtasdiaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Copymax");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btnusuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnCerrarsesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnvtasdia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(48, 48, 48)
                .addComponent(btnvtasdia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btnusuarios)
                .addGap(18, 18, 18)
                .addComponent(BtnProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(BtnCerrarsesion)
                .addGap(17, 17, 17))
        );

        BtnEstadísticas.setBackground(new java.awt.Color(204, 255, 255));
        BtnEstadísticas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnEstadísticas.setForeground(new java.awt.Color(0, 0, 0));
        BtnEstadísticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/entrega-de-pedidos (Custom).png"))); // NOI18N
        BtnEstadísticas.setText("Estadísticas");
        BtnEstadísticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEstadísticasActionPerformed(evt);
            }
        });

        chartPanel.setLayout(new GridLayout(1, 2));

        chartPanel.setPreferredSize(new Dimension(570, 395));

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        chartPanelLayout.setVerticalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Date myDate = new Date();
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Copymax punto de venta " +new SimpleDateFormat("dd-MM-yyyy").format(myDate));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Bienvenido");

        javax.swing.GroupLayout PanelmainLayout = new javax.swing.GroupLayout(Panelmain);
        Panelmain.setLayout(PanelmainLayout);
        PanelmainLayout.setHorizontalGroup(
            PanelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelmainLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelmainLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(PanelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelmainLayout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabel4))
                            .addGroup(PanelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(PanelmainLayout.createSequentialGroup()
                                    .addComponent(BtnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(BtnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtnEstadísticas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelmainLayout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel2)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        PanelmainLayout.setVerticalGroup(
            PanelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelmainLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addGroup(PanelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnVenta)
                    .addGroup(PanelmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnClientes)
                        .addComponent(BtnEstadísticas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panelmain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panelmain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVentaActionPerformed
        interfazprincipal = new Interfazprincipal();
        
        interfazprincipal.setVisible(true);
        interfazprincipal.mostrarventa();
        dispose();
    }//GEN-LAST:event_BtnVentaActionPerformed

    private void BtnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClientesActionPerformed
        interfazprincipal = new Interfazprincipal();
        
        interfazprincipal.setVisible(true);
        interfazprincipal.mostrarclientes();
        dispose();
    }//GEN-LAST:event_BtnClientesActionPerformed

    private void BtnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProductosActionPerformed
        interfazprincipal = new Interfazprincipal();
        
        interfazprincipal.setVisible(true);
        interfazprincipal.mostrarproductos();
        dispose();
    }//GEN-LAST:event_BtnProductosActionPerformed

    private void BtnEstadísticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEstadísticasActionPerformed

        interfazprincipal = new Interfazprincipal();
        
        interfazprincipal.setVisible(true);
        interfazprincipal.mostrarestadistica();
        dispose();
    }//GEN-LAST:event_BtnEstadísticasActionPerformed

    private void BtnCerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarsesionActionPerformed
        LoginRegistro login = new LoginRegistro();
        login.setVisible(true);
        Usuariosesion.getInstance().cerrarSesion();
        dispose();
    }//GEN-LAST:event_BtnCerrarsesionActionPerformed

    private void BtnusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnusuariosActionPerformed
       interfazprincipal = new Interfazprincipal();
        
        interfazprincipal.setVisible(true);
        interfazprincipal.mostrarusuarios();
        dispose();
    }//GEN-LAST:event_BtnusuariosActionPerformed

    private void btnvtasdiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvtasdiaActionPerformed
        Corte corte = new Corte();
        
        corte.setVisible(true);
        
        
    }//GEN-LAST:event_btnvtasdiaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
          FlatLightLaf.setup();
      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MVC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCerrarsesion;
    private javax.swing.JButton BtnClientes;
    private javax.swing.JButton BtnEstadísticas;
    private javax.swing.JButton BtnProductos;
    private javax.swing.JButton BtnVenta;
    private javax.swing.JButton Btnusuarios;
    private javax.swing.JPanel Panelmain;
    private javax.swing.JButton btnvtasdia;
    private javax.swing.JPanel chartPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenuItem s;
    // End of variables declaration//GEN-END:variables
}
