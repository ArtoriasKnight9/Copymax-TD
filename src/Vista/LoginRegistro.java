
package Vista;

import Conexion.Conexion;
import Modelo.Usuariosclass;
import Modelo.Usuariosesion; 
import Modelo.Filtronumeros;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.BorderFactory;
import java.awt.Color;

/**
 *
 * @author maxst
 */
public class LoginRegistro extends javax.swing.JFrame {

    Usuariosclass usuarios = new Usuariosclass();
    
    
    public LoginRegistro() {
        initComponents();
       
        // Configurar el redondeo para txtfieldusuario1
       
     //  txtfieldusuario1.putClientProperty( "JComponent.roundRect", true );
     //   Jpassingreso.putClientProperty( "JComponent.roundRect", true ); 
    //    BtnIngresar.putClientProperty( "JButton.buttonType", "roundRect" );
    
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelIngreso = new javax.swing.JPanel();
        txtfieldusuario1 = new javax.swing.JTextField();
        BtnIngresar = new javax.swing.JButton();
        Logclose = new javax.swing.JLabel();
        Logpass = new javax.swing.JLabel();
        Loguser = new javax.swing.JLabel();
        Jpassingreso = new javax.swing.JPasswordField();
        PanelRegistroo = new javax.swing.JPanel();
        txtregistroNombre = new javax.swing.JTextField();
        txtfielregistrapellidos = new javax.swing.JTextField();
        txtregcelular = new javax.swing.JTextField();
        txtfieldregisNombreUsuario = new javax.swing.JTextField();
        ComboRol = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtregcontraseña = new javax.swing.JPasswordField();
        Logclose1 = new javax.swing.JLabel();
        BtnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Copymax");
        setBounds(new java.awt.Rectangle(10, 10, 0, 0));
        setResizable(false);

        PanelMain.setBackground(new java.awt.Color(255, 255, 255));
        PanelMain.setAlignmentX(15.0F);
        PanelMain.setAlignmentY(10.0F);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logopng (Custom).png"))); // NOI18N

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jTabbedPane1.setOpaque(false);

        PanelIngreso.setBackground(new java.awt.Color(255, 255, 255));
        PanelIngreso.setAutoscrolls(true);
        PanelIngreso.setFocusCycleRoot(true);
        PanelIngreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtfieldusuario1.setBackground(new java.awt.Color(255, 255, 255));
        txtfieldusuario1.setForeground(new java.awt.Color(204, 204, 204));
        txtfieldusuario1.setText("Nombre de usuario");
        txtfieldusuario1.putClientProperty("JTextField.borderColor", Color.GREEN); // Cambia a tu color preferido
        txtfieldusuario1.putClientProperty( "JComponent.roundRect", true );
        //txtfieldusuario1.putClientProperty("JComponent.outline", "warning"); // Opcional para destacar el borde
        txtfieldusuario1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfieldusuario1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfieldusuario1FocusLost(evt);
            }
        });
        PanelIngreso.add(txtfieldusuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 210, 30));

        BtnIngresar.setBackground(new java.awt.Color(153, 153, 153));
        BtnIngresar.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        BtnIngresar.setForeground(new java.awt.Color(0, 0, 0));
        BtnIngresar.setText("Ingresar");
        BtnIngresar.putClientProperty( "JButton.buttonType", "roundRect" );
        BtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresarActionPerformed(evt);
            }
        });
        PanelIngreso.add(BtnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 170, 40));

        Logclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar-ojo.png"))); // NOI18N
        Logclose.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                LogcloseFocusGained(evt);
            }
        });
        Logclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogcloseMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LogcloseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                LogcloseMouseReleased(evt);
            }
        });
        PanelIngreso.add(Logclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 30, 30));

        Logpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/candado.png"))); // NOI18N
        PanelIngreso.add(Logpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, 30));

        Loguser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        Loguser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelIngreso.add(Loguser, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, 30));

        Jpassingreso.setEchoChar('\u0000');
        Jpassingreso.setBackground(new java.awt.Color(255, 255, 255));
        Jpassingreso.setForeground(new java.awt.Color(204, 204, 204));
        Jpassingreso.setText("Contraseña");
        Jpassingreso.putClientProperty( "JComponent.roundRect", true );
        Jpassingreso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JpassingresoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JpassingresoFocusLost(evt);
            }
        });
        Jpassingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JpassingresoActionPerformed(evt);
            }
        });
        PanelIngreso.add(Jpassingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 210, 30));

        jTabbedPane1.addTab("     Ingreso     ", PanelIngreso);

        PanelRegistroo.setBackground(new java.awt.Color(255, 255, 255));

        txtregistroNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtregistroNombre.setForeground(new java.awt.Color(204, 204, 204));
        txtregistroNombre.setText("Nombre");
        txtregistroNombre.putClientProperty( "JComponent.roundRect", true );
        txtregistroNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtregistroNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtregistroNombreFocusLost(evt);
            }
        });

        txtfielregistrapellidos.setBackground(new java.awt.Color(255, 255, 255));
        txtfielregistrapellidos.setForeground(new java.awt.Color(204, 204, 204));
        txtfielregistrapellidos.setText("Apellidos");
        txtfielregistrapellidos.putClientProperty( "JComponent.roundRect", true );
        txtfielregistrapellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfielregistrapellidosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfielregistrapellidosFocusLost(evt);
            }
        });
        txtfielregistrapellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfielregistrapellidosActionPerformed(evt);
            }
        });

        txtregcelular.setBackground(new java.awt.Color(255, 255, 255));
        txtregcelular.setForeground(new java.awt.Color(204, 204, 204));
        txtregcelular.setText("Celular");
        txtregcelular.putClientProperty( "JComponent.roundRect", true );
        txtregcelular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtregcelularFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtregcelularFocusLost(evt);
            }
        });
        txtregcelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtregcelularActionPerformed(evt);
            }
        });

        txtfieldregisNombreUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtfieldregisNombreUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtfieldregisNombreUsuario.setText("Nombre de Usuario");
        txtfieldregisNombreUsuario.putClientProperty( "JComponent.roundRect", true );
        txtfieldregisNombreUsuario.setPreferredSize(new java.awt.Dimension(125, 22));
        txtfieldregisNombreUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfieldregisNombreUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfieldregisNombreUsuarioFocusLost(evt);
            }
        });
        txtfieldregisNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldregisNombreUsuarioActionPerformed(evt);
            }
        });

        ComboRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estandar", "Administrador" }));
        ComboRol.setToolTipText(null);
        ComboRol.putClientProperty( "JComponent.roundRect", true );
        ComboRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboRolActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Rol: ");

        txtregcontraseña.setEchoChar('\u0000');
        txtregcontraseña.setBackground(new java.awt.Color(255, 255, 255));
        txtregcontraseña.setForeground(new java.awt.Color(204, 204, 204));
        txtregcontraseña.setText("Contraseña");
        txtregcontraseña.putClientProperty( "JComponent.roundRect", true );
        txtregcontraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtregcontraseñaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtregcontraseñaFocusLost(evt);
            }
        });
        txtregcontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtregcontraseñaActionPerformed(evt);
            }
        });

        Logclose1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar-ojo.png"))); // NOI18N
        Logclose1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Logclose1FocusGained(evt);
            }
        });
        Logclose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Logclose1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Logclose1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Logclose1MouseReleased(evt);
            }
        });

        BtnRegistrar.setBackground(new java.awt.Color(102, 102, 255));
        BtnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        BtnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-usuario (2).png"))); // NOI18N
        BtnRegistrar.setText("Registrar");
        BtnRegistrar.putClientProperty( "JButton.buttonType", "roundRect" );
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelRegistrooLayout = new javax.swing.GroupLayout(PanelRegistroo);
        PanelRegistroo.setLayout(PanelRegistrooLayout);
        PanelRegistrooLayout.setHorizontalGroup(
            PanelRegistrooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistrooLayout.createSequentialGroup()
                .addGroup(PanelRegistrooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegistrooLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(PanelRegistrooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRegistrooLayout.createSequentialGroup()
                                .addGroup(PanelRegistrooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtregcontraseña, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(txtfielregistrapellidos, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtregistroNombre, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(PanelRegistrooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtregcelular)
                                    .addComponent(Logclose1)
                                    .addComponent(txtfieldregisNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(PanelRegistrooLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(ComboRol, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelRegistrooLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(BtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        PanelRegistrooLayout.setVerticalGroup(
            PanelRegistrooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistrooLayout.createSequentialGroup()
                .addGroup(PanelRegistrooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegistrooLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtfieldregisNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistrooLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtregistroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelRegistrooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfielregistrapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtregcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRegistrooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtregcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Logclose1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRegistrooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addComponent(BtnRegistrar)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("    Registro    ", PanelRegistroo);

        javax.swing.GroupLayout PanelMainLayout = new javax.swing.GroupLayout(PanelMain);
        PanelMain.setLayout(PanelMainLayout);
        PanelMainLayout.setHorizontalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMainLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel1)
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        PanelMainLayout.setVerticalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtfieldusuario1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfieldusuario1FocusGained
        
        if (txtfieldusuario1.getText().equals("Nombre de usuario")){
         txtfieldusuario1.setText("");
         txtfieldusuario1.setForeground(Color.black);
         
        }
    }//GEN-LAST:event_txtfieldusuario1FocusGained

    private void txtfieldusuario1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfieldusuario1FocusLost
        
       if (txtfieldusuario1.getText().isEmpty()){
        txtfieldusuario1.setForeground(new Color(204, 204, 204));
        txtfieldusuario1.setText("Nombre de usuario");
        } 
       
        
    }//GEN-LAST:event_txtfieldusuario1FocusLost

    private void LogcloseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LogcloseFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_LogcloseFocusGained

    private void LogcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogcloseMouseClicked
       
    }//GEN-LAST:event_LogcloseMouseClicked

    private void LogcloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogcloseMousePressed
       ImageIcon icono = new ImageIcon("src\\Imagenes\\vista.png");
       Logclose.setIcon(icono);
       Jpassingreso.setEchoChar('\u0000');
       
    }//GEN-LAST:event_LogcloseMousePressed

    private void LogcloseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogcloseMouseReleased
        ImageIcon icono = new ImageIcon("src\\Imagenes\\cerrar-ojo.png");
       Logclose.setIcon(icono);
       Jpassingreso.setEchoChar('*');
    }//GEN-LAST:event_LogcloseMouseReleased

    private void JpassingresoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JpassingresoFocusGained
         if(Jpassingreso.getText().equals("Contraseña")){
            Jpassingreso.setEchoChar('*');
            Jpassingreso.setText("");
            Jpassingreso.setForeground(Color.black);
        }
    }//GEN-LAST:event_JpassingresoFocusGained

    private void JpassingresoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JpassingresoFocusLost
                if (Jpassingreso.getText().isEmpty()){

            Jpassingreso.setForeground(new Color(204, 204, 204));
            Jpassingreso.setText("Contraseña");
        }
    }//GEN-LAST:event_JpassingresoFocusLost

    private void txtregistroNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtregistroNombreFocusGained
          
        if (txtregistroNombre.getText().equals("Nombre")){
         txtregistroNombre.setText("");
         txtregistroNombre.setForeground(Color.black);
        }
               
    }//GEN-LAST:event_txtregistroNombreFocusGained

    private void txtregistroNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtregistroNombreFocusLost
      if (txtregistroNombre.getText().isEmpty()){
        txtregistroNombre.setForeground(new Color(204, 204, 204));
        txtregistroNombre.setText("Nombre");
        } else if (txtregistroNombre.getText().isEmpty()){
            txtregistroNombre.setText("Nombre");
        }
    }//GEN-LAST:event_txtregistroNombreFocusLost

    private void txtfielregistrapellidosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfielregistrapellidosFocusGained
      if (txtfielregistrapellidos.getText().equals("Apellidos")){
         txtfielregistrapellidos.setText("");
        txtfielregistrapellidos.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtfielregistrapellidosFocusGained

    private void txtfielregistrapellidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfielregistrapellidosFocusLost
        if (txtfielregistrapellidos.getText().isEmpty()){
        txtfielregistrapellidos.setForeground(new Color(204, 204, 204));
        txtfielregistrapellidos.setText("Apellidos");
        } 
    }//GEN-LAST:event_txtfielregistrapellidosFocusLost

    private void txtfielregistrapellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfielregistrapellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfielregistrapellidosActionPerformed

    private void txtregcelularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtregcelularFocusGained
       if (txtregcelular.getText().equals("Celular")){
         txtregcelular.setText("");
        txtregcelular.setForeground(Color.black);
        
        PlainDocument doc = (PlainDocument) txtregcelular.getDocument();
        doc.setDocumentFilter(new Filtronumeros());
       }
       
    }//GEN-LAST:event_txtregcelularFocusGained

    private void txtregcelularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtregcelularFocusLost
        if (txtregcelular.getText().isEmpty()){
            
        txtregcelular.setForeground(new Color(204, 204, 204));
        txtregcelular.setText("Celular");
        }
    }//GEN-LAST:event_txtregcelularFocusLost

    private void txtregcelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtregcelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtregcelularActionPerformed

    private void txtfieldregisNombreUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfieldregisNombreUsuarioFocusGained
         if (txtfieldregisNombreUsuario.getText().equals("Nombre de Usuario")){
         txtfieldregisNombreUsuario.setText("");
         txtfieldregisNombreUsuario.setForeground(Color.black);
        }
               
    }//GEN-LAST:event_txtfieldregisNombreUsuarioFocusGained

    private void txtfieldregisNombreUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfieldregisNombreUsuarioFocusLost
        if (txtfieldregisNombreUsuario.getText().isEmpty()){
        txtfieldregisNombreUsuario.setForeground(new Color(204, 204, 204));
       txtfieldregisNombreUsuario.setText("Nombre de Usuario");
        } 
    }//GEN-LAST:event_txtfieldregisNombreUsuarioFocusLost

    private void txtfieldregisNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfieldregisNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfieldregisNombreUsuarioActionPerformed

    private void ComboRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboRolActionPerformed
       if(ComboRol.getSelectedIndex()==1){
           JTextField usuarioField = new JTextField();
                        JPasswordField passwordField = new JPasswordField();
                        Object[] message = {
                            "Usuario:", usuarioField,
                            "Contraseña:", passwordField
                        };

                        int option = JOptionPane.showConfirmDialog(null, message, "Ingrese autorizacion de Administrador", JOptionPane.OK_CANCEL_OPTION);
                        if (option == JOptionPane.OK_OPTION) {
                            String usuario = usuarioField.getText();
                            String contrasena = new String(passwordField.getPassword());

                            if (validarAdministrador(usuario, contrasena)) {
                                ComboRol.setSelectedIndex(1);
                            } else {
                                JOptionPane.showMessageDialog(null, "Credenciales incorrectas. No puede ser Administrador");
                                ComboRol.setSelectedIndex(0);
                            }
                        }
       }   
                  
       
    }//GEN-LAST:event_ComboRolActionPerformed

     public boolean validarAdministrador(String nombreUsuario, String contraseña) {
    Conexion conex = new Conexion();
    String consulta = "SELECT Nombreusuario, Rol FROM Usuario WHERE Nombreusuario = ? AND Contraseña = ?";
    try (PreparedStatement pst = conex.getConnection().prepareStatement(consulta)) {
        pst.setString(1, nombreUsuario);
        pst.setString(2, contraseña);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            String rol = rs.getString("Rol");
            return "Administrador".equals(rol);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al validar usuario: " + e.toString());
    }
    return false;
    }
    
    private void txtregcontraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtregcontraseñaFocusGained
       
      if (txtregcontraseña.getText().equals("Contraseña")){
        
          
          txtregcontraseña.setEchoChar('*');
          txtregcontraseña.setText("");
          txtregcontraseña.setForeground(Color.black);
      }
    }//GEN-LAST:event_txtregcontraseñaFocusGained

    private void txtregcontraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtregcontraseñaFocusLost
        if (txtregcontraseña.getText().isEmpty()){
        txtregcontraseña.setForeground(new Color(204, 204, 204));
        txtregcontraseña.setEchoChar('\u0000');
        txtregcontraseña.setText("Contraseña");
        } 
    }//GEN-LAST:event_txtregcontraseñaFocusLost

    private void JpassingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JpassingresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JpassingresoActionPerformed

    private void Logclose1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Logclose1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_Logclose1FocusGained

    private void Logclose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Logclose1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Logclose1MouseClicked

    private void Logclose1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Logclose1MousePressed
        ImageIcon icono = new ImageIcon("src\\Imagenes\\vista.png");
       Logclose1.setIcon(icono);
       txtregcontraseña.setEchoChar('\u0000');        // TODO add your handling code here:
    }//GEN-LAST:event_Logclose1MousePressed

    private void Logclose1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Logclose1MouseReleased
         ImageIcon icono = new ImageIcon("src\\Imagenes\\cerrar-ojo.png");
       Logclose1.setIcon(icono);
       txtregcontraseña.setEchoChar('*');
    }//GEN-LAST:event_Logclose1MouseReleased

    private void txtregcontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtregcontraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtregcontraseñaActionPerformed
   
    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
       usuarios.setNombre(txtregistroNombre.getText());
       usuarios.setApellidos(txtfielregistrapellidos.getText());
       usuarios.setNombreUsuario(txtfieldregisNombreUsuario.getText());
       usuarios.setCelular(txtregcelular.getText());
       usuarios.setContraseña(txtregcontraseña.getText());
       usuarios.setRol((String) ComboRol.getSelectedItem());
        
  /*     System.out.println(usuarios.getNombre());
       System.out.println(usuarios.getApellidos());
       System.out.println(usuarios.getNombreUsuario());
       System.out.println(usuarios.getCelular());
       System.out.println(usuarios.getContraseña());
       System.out.println(usuarios.getRol()); */
       limpiarEntradas();
       PanelIngreso.setVisible(true);
       agregarusuario(usuarios);
       
      
    }//GEN-LAST:event_BtnRegistrarActionPerformed

    private void limpiarEntradas(){
        
        txtregistroNombre.setText("Nombre de Usuario");
        txtregcelular.setText("Celular");
        txtfielregistrapellidos.setText("Apellidos");
        txtfieldregisNombreUsuario.setText("Nombre de Usuario");
        txtregcontraseña.setText("Contraseña");
        txtregcelular.setText("Celular");
        txtregcontraseña.setEchoChar('*');
    }
    
    private void BtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresarActionPerformed
   String nombreUsuario = txtfieldusuario1.getText();
    String contraseña = new String(Jpassingreso.getPassword());

    if (validarUsuario(nombreUsuario, contraseña)) {
        JOptionPane.showMessageDialog(null, "Ingreso exitoso");
        Ventas.getInstance().actualizarDatosUsuario();
      //  Interfazprincipal ventana = new Interfazprincipal();
      //  ventana.setVisible(true);
            Interfazprincipal mvc = new Interfazprincipal();
            mvc.setVisible(true);  
      
        this.dispose(); // Cerrar la ventana de login
        
    } else {
        JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
    }
    }//GEN-LAST:event_BtnIngresarActionPerformed

   private void agregarusuario(Usuariosclass usuario) {
    Conexion conex = new Conexion();
    String consulta = "INSERT INTO Usuario (Nombre, Apellidos, Nombreusuario, Celular, Contraseña, Rol) VALUES (?, ?, ?, ?, ?, ?)";
    try (
            PreparedStatement pst = conex.getConnection().prepareStatement(consulta)) {
        pst.setString(1, usuario.getNombre());
        pst.setString(2, usuario.getApellidos());
         pst.setString(3, usuario.getNombreUsuario());
        pst.setString(4, usuario.getCelular());
        pst.setString(5, usuario.getContraseña());
        pst.setString(6, usuario.getRol());
        
        pst.execute();
        JOptionPane.showMessageDialog(null, "Cliente Agregado Con Exito !!!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al agregar cliente: " + e.toString());
    }
}
   
   public boolean validarUsuario(String nombreUsuario, String contraseña) {
           
    Conexion conex = new Conexion();
    String consulta = "SELECT Nombreusuario, Rol, Nombre, idUsuario FROM Usuario WHERE Nombreusuario = ? AND Contraseña = ?";
    try (
        PreparedStatement pst = conex.getConnection().prepareStatement(consulta)) {
        pst.setString(1, nombreUsuario);
        pst.setString(2, contraseña);

        var rs = pst.executeQuery();
        if (rs.next()) {
            String nombre = rs.getString("Nombreusuario");
            String rol = rs.getString("Rol");
            String nombreal = rs.getString("Nombre");
            int idusuario = rs.getInt("idUsuario");
            Usuariosesion.getInstance(nombre, rol, nombreal, idusuario); // Guardar información del usuario en la sesión
            return true;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al validar usuario: " + e.toString());
    }
    return false;
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
      
         // Establece el estilo Flat Light
       
        //  FlatDarkLaf.setup();   //Look and feel Black 
        FlatLightLaf.setup();
      

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginRegistro().setVisible(true);
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JComboBox<String> ComboRol;
    private javax.swing.JPasswordField Jpassingreso;
    private javax.swing.JLabel Logclose;
    private javax.swing.JLabel Logclose1;
    private javax.swing.JLabel Logpass;
    private javax.swing.JLabel Loguser;
    private javax.swing.JPanel PanelIngreso;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JPanel PanelRegistroo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtfieldregisNombreUsuario;
    private javax.swing.JTextField txtfieldusuario1;
    private javax.swing.JTextField txtfielregistrapellidos;
    private javax.swing.JTextField txtregcelular;
    private javax.swing.JPasswordField txtregcontraseña;
    private javax.swing.JTextField txtregistroNombre;
    // End of variables declaration//GEN-END:variables
}
