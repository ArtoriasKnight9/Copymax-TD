package Vista;

import Modelo.Clientesclass;
import Conexion.Conexion;
import Modelo.FiltroCelular;
import Modelo.FiltroCorreo;
import Modelo.FiltroLetras;
import Modelo.FiltroRFC;
import Modelo.Filtromayusculas;
import Modelo.Filtronumeros;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.text.PlainDocument;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroClientes extends javax.swing.JFrame {
    
    Clientesclass clientes = new Clientesclass();
 
    public RegistroClientes() {
        initComponents();
        agregarKeyListenerGlobal();
        
        PlainDocument doc = (PlainDocument) TxtCelular.getDocument();
        FiltroCelular cel = new FiltroCelular();
        doc.setDocumentFilter(cel);
        
        PlainDocument DOC = (PlainDocument) TxtRfc.getDocument();
        FiltroRFC filtrorfc = new FiltroRFC();
        DOC.setDocumentFilter(filtrorfc);
        
        
        PlainDocument docnombre =(PlainDocument) TxtNombre.getDocument();
        docnombre.setDocumentFilter(new FiltroLetras());
        
        PlainDocument docapellidos =(PlainDocument) TxtApellidos.getDocument();
        docapellidos.setDocumentFilter(new FiltroLetras());
        
        PlainDocument correo = (PlainDocument) Txtcorreo.getDocument();
        FiltroCorreo correofiltro = new FiltroCorreo();
        correo.setDocumentFilter(correofiltro);
        
               
    }
    
     private void agregarKeyListenerGlobal() {
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
        jLabel1 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtCelular = new javax.swing.JTextField();
        TxtRfc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BtnAgregar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Txtcorreo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Nombre:");

        TxtNombre.setMinimumSize(new java.awt.Dimension(70, 30));
        TxtNombre.setPreferredSize(new java.awt.Dimension(70, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Registro Clientes");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Apellidos:");

        TxtApellidos.setMinimumSize(new java.awt.Dimension(70, 30));
        TxtApellidos.setPreferredSize(new java.awt.Dimension(70, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Celular:");

        TxtCelular.setMinimumSize(new java.awt.Dimension(70, 30));
        TxtCelular.setPreferredSize(new java.awt.Dimension(70, 30));

        TxtRfc.setMinimumSize(new java.awt.Dimension(70, 30));
        TxtRfc.setPreferredSize(new java.awt.Dimension(70, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("RFC: ");

        BtnAgregar.setBackground(new java.awt.Color(255, 255, 153));
        BtnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-usuario (2).png"))); // NOI18N
        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Correo");

        Txtcorreo.setMinimumSize(new java.awt.Dimension(70, 30));
        Txtcorreo.setPreferredSize(new java.awt.Dimension(70, 30));
        Txtcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtcorreoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(BtnAgregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(BtnAgregar)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
         
        Clientes clien = new Clientes();
        clientes.setNombre(TxtNombre.getText());
        clientes.setApellidos(TxtApellidos.getText());
        clientes.setCelular(TxtCelular.getText());
        clientes.setRfc(TxtRfc.getText());
        clientes.setCorreo(Txtcorreo.getText());
                
        limpiardatos();

        // LOGICA MYSQL
        
        agregarClienteBD(clientes);
        this.dispose();
       clien.actualizarTabla();
       
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void TxtcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtcorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtcorreoActionPerformed
    
    private void agregarClienteBD(Clientesclass cliente) {
        Conexion conex = new Conexion();
        String consulta = "INSERT INTO Cliente (Nombre, Apellidos, Celular, RFC,Correo) VALUES (?, ?, ?, ?,?)";
        try (
                PreparedStatement pst = conex.getConnection().prepareCall(consulta)) {
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellidos());
            pst.setString(3, cliente.getCelular());
            pst.setString(4, cliente.getRfc());
            pst.setString(5, cliente.getCorreo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Cliente Agregado Con Exito !!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar cliente: " + e.toString());
        }
    }
    
    public void limpiardatos(){
        
        TxtNombre.setText("");
        TxtApellidos.setText("");
        //filtro
        
        PlainDocument DOC =(PlainDocument) TxtCelular.getDocument();
        DOC.setDocumentFilter(new Filtromayusculas());
        TxtCelular.setText("");
         PlainDocument doc = (PlainDocument) TxtCelular.getDocument();
        doc.setDocumentFilter(new Filtronumeros());
        
        TxtRfc.setText("");
        Txtcorreo.setText("");
        
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JTextField TxtApellidos;
    private javax.swing.JTextField TxtCelular;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtRfc;
    private javax.swing.JTextField Txtcorreo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
