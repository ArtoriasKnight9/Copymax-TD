/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Clientesclass;
import Modelo.Filtronumeros;
import Modelo.Letraseditor;
import Modelo.Numeroseditor;
import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Artorias<maxstell5549@hotmail.com>
 */
public class Clientesticket extends javax.swing.JFrame {

      private DefaultTableModel modelo;
      private String contexto; // Variable para identificar el contexto actual
      
    public Clientesticket() {
        setContexto(contexto);
        initComponents();
        // Crea un modelo de tabla para mostrar los productos
        modelo = new DefaultTableModel();
        agregarKeyListenerGlobal();
        modelo.addColumn("Nombre");     //Columna para el Nombre
        modelo.addColumn("Apellidos");  //Columna para el Apellido
        modelo.addColumn("Celular");    //Columna para el Celular
        modelo.addColumn("RFC");        //Columna para el RFC
        modelo.addColumn("Correo");     //Columna para el Correo
        Tablaclientes.setModel(modelo); // Asigna el modelo de tabla a la tabla Tablaclientes
        llenarTabla();                  // Llena la tabla
        tabladiseño();                  // Llama al método para personalizar el diseño de la tabla
        
    }
    
    public void setContexto(String contexto) {
    this.contexto = contexto;
    }
    
    private void tabladiseño(){
      // Asigna editores personalizados a las columnas para restringir el tipo de entrada
        Tablaclientes.getColumnModel().getColumn(0).setCellEditor(new Letraseditor()); 
        Tablaclientes.getColumnModel().getColumn(1).setCellEditor(new Letraseditor());
        Tablaclientes.getColumnModel().getColumn(2).setCellEditor(new Numeroseditor());
        if (Tablaclientes.getColumnModel().getColumnCount() > 0) {
      // Ajusta el ancho máximo de cada columna para mejorar la presentación
        Tablaclientes.getColumnModel().getColumn(0).setMaxWidth(110);
        Tablaclientes.getColumnModel().getColumn(1).setMaxWidth(150);       
        Tablaclientes.getColumnModel().getColumn(2).setMaxWidth(120);
        Tablaclientes.getColumnModel().getColumn(3).setMaxWidth(160); 
        Tablaclientes.getColumnModel().getColumn(4).setMaxWidth(220);
        
       Tablaclientes.setRowHeight(30);
     
}
    
    }
    
  private void agregarKeyListenerGlobal() {
       // Agrega un despachador de eventos de teclado que escuche todas las teclas presionadas si se presiona ESC se cierra automaticamente la ventana 
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();;
                }
                
                return false;
            }
        });
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablaclientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtregclicelularbusqueda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(54, 170, 219));

        Tablaclientes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Tablaclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tablaclientes.setColumnSelectionAllowed(true);
        Tablaclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaclientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tablaclientes);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clasificacion (Custom).png"))); // NOI18N
        jLabel1.setText("Seleccion de Cliente");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txtregclicelularbusqueda.setBackground(new java.awt.Color(204, 255, 255));
        txtregclicelularbusqueda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtregclicelularbusqueda.setText("Numero a buscar");
        txtregclicelularbusqueda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtregclicelularbusquedaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtregclicelularbusquedaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtregclicelularbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtregclicelularbusqueda)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        txtregclicelularbusqueda.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarTablabus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarTablabus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarTablabus();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     /**
 * Llena la tabla de clientes con datos obtenidos desde la base de datos.
 * Recorre la lista de clientes y agrega una fila en la tabla para cada cliente.
 */
    private void llenarTabla() {
        Clientesclass clientee = new Clientesclass();
        List<Clientesclass> clientes = clientee.obtenerClientes();
        
        for (Clientesclass cliente : clientes) {
            Object[] fila = new Object[5]; // Cambiar a 5 ya que solo tienes 5 columnas
            fila[0] = cliente.getNombre();
            fila[1] = cliente.getApellidos();
            fila[2] = cliente.getCelular();
            fila[3] = cliente.getRfc();
            fila[4] = cliente.getCorreo();
            modelo.addRow(fila);
        }
    }
    
    /**
 * Actualiza la tabla de clientes. Borra los datos actuales y rellena la tabla con información actualizada desde la base de datos.
 */
    public void actualizarTabla() {
       // Limpiar el modelo de la tabla
        modelo.setRowCount(0);
        
        // Obtener la lista actualizada de clientes
        Clientesclass clientee = new Clientesclass();
        List<Clientesclass> clientes = clientee.obtenerClientes();
        
        // Agregar las nuevas filas al modelo de la tabla
        for (Clientesclass cliente : clientes) {
            Object[] fila = new Object[5]; // Cambiar a 5 ya que solo tienes 5 columnas
            fila[0] = cliente.getNombre();
            fila[1] = cliente.getApellidos();
            fila[2] = cliente.getCelular();
            fila[3] = cliente.getRfc();
            fila[4] = cliente.getCorreo();
            modelo.addRow(fila);
        }
}
    
    /**
 * Actualiza la tabla de clientes según el texto de búsqueda ingresado.
 * Filtra clientes en la base de datos que coincidan con el número ingresado en txtregclicelularbusqueda y actualiza la tabla.
 */
    private void actualizarTablabus() {
     String textoBusqueda = txtregclicelularbusqueda.getText();
        
        // Limpia la tabla
        modelo.setRowCount(0);

        // Realiza una consulta a la base de datos para obtener los registros que coincidan con el texto de búsqueda
        Clientesclass clientee = new Clientesclass();
        List<Clientesclass> clientes = clientee.obtenerClientesPorNumero(textoBusqueda);
        
        // Agrega los registros encontrados a la tabla
        for (Clientesclass cliente : clientes) {
            Object[] fila = new Object[5]; // 
            fila[0] = cliente.getNombre();
            fila[1] = cliente.getApellidos();
            fila[2] = cliente.getCelular();
            fila[3] = cliente.getRfc();
            fila[4] = cliente.getCorreo();
            modelo.addRow(fila);
        }
   
   }
    
    
    private void TablaclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaclientesMouseClicked
       
        Ventas.getInstance().seleccioncliente(Tablaclientes);
        this.dispose(); // Cierra la ventana después de seleccionar un cliente

    }//GEN-LAST:event_TablaclientesMouseClicked

    private void txtregclicelularbusquedaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtregclicelularbusquedaFocusGained
        if (txtregclicelularbusqueda.getText().equals("Numero a buscar")){
            txtregclicelularbusqueda.setText("");
            txtregclicelularbusqueda.setForeground(Color.black);

            PlainDocument doc = (PlainDocument)  txtregclicelularbusqueda.getDocument();
            doc.setDocumentFilter(new Filtronumeros());
        }
    }//GEN-LAST:event_txtregclicelularbusquedaFocusGained

    private void txtregclicelularbusquedaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtregclicelularbusquedaFocusLost
        if (txtregclicelularbusqueda.getText().isEmpty()){
            txtregclicelularbusqueda.setForeground(new Color(204, 204, 204));
            txtregclicelularbusqueda.setText("Numero a buscar");
        }
    }//GEN-LAST:event_txtregclicelularbusquedaFocusLost

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Clientesticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientesticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientesticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientesticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientesticket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tablaclientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtregclicelularbusqueda;
    // End of variables declaration//GEN-END:variables
}
