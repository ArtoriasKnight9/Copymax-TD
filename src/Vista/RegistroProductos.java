package Vista;


import Conexion.Conexion;
import Modelo.FiltroNumerosDecimales;
import Modelo.Filtromayusculas;
import Modelo.Filtronumeros;
import Modelo.Productoclass;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import javax.swing.text.PlainDocument;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Artorias<maxstell5549@hotmail.com>
 */
public class RegistroProductos extends javax.swing.JFrame {
 
     Productoclass productos = new Productoclass();
     
    private String iconoFileName;
    
     
    public RegistroProductos() {
        agregarKeyListenerGlobal();
        initComponents();
        PlainDocument doc = (PlainDocument) TxtCantidad.getDocument();
        doc.setDocumentFilter(new Filtronumeros());
        PlainDocument docuni = (PlainDocument) TxtPreciouni.getDocument();
        docuni.setDocumentFilter(new FiltroNumerosDecimales());
        
        
                
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
        TxtPreciouni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BtnAgregar = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnadjuntarIcono = new javax.swing.JButton();
        iconoprueba = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre:");

        TxtNombre.setMinimumSize(new java.awt.Dimension(70, 30));
        TxtNombre.setPreferredSize(new java.awt.Dimension(70, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Registro Productos");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Precio Unitario:");

        TxtPreciouni.setMinimumSize(new java.awt.Dimension(70, 30));
        TxtPreciouni.setPreferredSize(new java.awt.Dimension(70, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Cantidad:");

        TxtCantidad.setMinimumSize(new java.awt.Dimension(70, 30));
        TxtCantidad.setPreferredSize(new java.awt.Dimension(70, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Categoría:");

        BtnAgregar.setBackground(new java.awt.Color(255, 255, 153));
        BtnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        BtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-usuario (2).png"))); // NOI18N
        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        Back.setBackground(new java.awt.Color(204, 255, 204));
        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha-izquierda.png"))); // NOI18N
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Copia / Impresion", "Papelería", "Servicio", " " }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Icono:");

        btnadjuntarIcono.setBackground(new java.awt.Color(102, 153, 255));
        btnadjuntarIcono.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnadjuntarIcono.setForeground(new java.awt.Color(0, 0, 0));
        btnadjuntarIcono.setText("Añadir Icono...");
        btnadjuntarIcono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadjuntarIconoActionPerformed(evt);
            }
        });

        iconoprueba.setMaximumSize(new java.awt.Dimension(60, 60));
        iconoprueba.setMinimumSize(new java.awt.Dimension(60, 60));
        iconoprueba.setPreferredSize(new java.awt.Dimension(60, 60));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(Back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(14, 25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtPreciouni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 140, Short.MAX_VALUE)
                            .addComponent(TxtCantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnadjuntarIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(BtnAgregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconoprueba, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtPreciouni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnadjuntarIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(iconoprueba, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnAgregar)
                .addContainerGap(20, Short.MAX_VALUE))
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
        
        Productos productoss = new Productos();
        productos.setNombre(TxtNombre.getText());
        productos.setCantidad(Integer.parseInt(TxtCantidad.getText()));
        productos.setPrecio(Double.parseDouble(TxtPreciouni.getText()));
        productos.setCategoria((String)jComboBox1.getSelectedItem());
        productos.setIcono(iconoFileName);
        
               
        limpiardatos();
            
        agregarProductoBD(productos); //metodoparaagregarproductos
        
        this.dispose();
        productoss.actualizarTabla();
        Ventas.getInstance().cargarProductos("");
        
       
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void btnadjuntarIconoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadjuntarIconoActionPerformed
    JFileChooser jFileChooser = new JFileChooser();
    FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
    jFileChooser.setFileFilter(filtrado);
    
    int result = jFileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = jFileChooser.getSelectedFile();
        iconoFileName = selectedFile.getName();
        File destinationFile = new File("src/Iconosproductos/" + iconoFileName);
        
        try {
            // Leer la imagen original
            BufferedImage originalImage = ImageIO.read(selectedFile);
            
            // Crear una nueva imagen compatible con el contexto gráfico actual
            GraphicsConfiguration gfxConfig = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
            BufferedImage resizedImage = gfxConfig.createCompatibleImage(60, 60, originalImage.getTransparency());
            
            // Redimensionar la imagen original y mantener su fondo
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(originalImage, 0, 0, 60, 60, null);
            g.dispose();
            
            // Guardar la imagen redimensionada en el directorio
            ImageIO.write(resizedImage, "png", destinationFile);
            
            // Crear un ImageIcon desde la imagen redimensionada
            ImageIcon icono = new ImageIcon(resizedImage);
            iconoprueba.setIcon(icono);
            
            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Icono adjuntado con éxito.");
            
            // Verificar si todos los campos están completos para activar o desactivar el botón de agregar
            if (camposCompletos()) {
                BtnAgregar.setEnabled(true);
            } else {
                BtnAgregar.setEnabled(false);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al copiar el archivo: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_btnadjuntarIconoActionPerformed
    
    private void agregarProductoBD(Productoclass producto) {
    Conexion conex = new Conexion();
    String consulta = "INSERT INTO Productos (Nombre_producto, Precio, Cantidad, Categoria, Icono) VALUES (?, ?, ?, ?,?)";
    try (
            PreparedStatement pst = conex.getConnection().prepareStatement(consulta)) { // Aquí se debe usar prepareStatement
        pst.setString(1, producto.getNombre());
        pst.setDouble(2, producto.getPrecio());
        pst.setInt(3, producto.getCantidad());
        pst.setString(4, producto.getCategoria());
        pst.setString(5,producto.getIcono());
        
        pst.executeUpdate(); // Usar executeUpdate para INSERT, UPDATE, DELETE

        JOptionPane.showMessageDialog(null, "Producto agregado con éxito!!!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al agregar producto: " + e.toString());
    }
}
    
    public void limpiardatos(){
        
        TxtNombre.setText("");
        TxtPreciouni.setText("");
        //filtro
        
        PlainDocument DOC =(PlainDocument) TxtCantidad.getDocument();
        DOC.setDocumentFilter(new Filtromayusculas());
        TxtCantidad.setText("");
         PlainDocument doc = (PlainDocument) TxtCantidad.getDocument();
        doc.setDocumentFilter(new Filtronumeros());

        jComboBox1.setSelectedIndex(1);
        
    } 
    
    private boolean camposCompletos() {
    if (TxtNombre.getText().isEmpty() || TxtPreciouni.getText().isEmpty() || TxtCantidad.getText().isEmpty() || iconoFileName == null) {
        BtnAgregar.disable();
    }
    return true;
}

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JTextField TxtCantidad;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtPreciouni;
    private javax.swing.JButton btnadjuntarIcono;
    private javax.swing.JLabel iconoprueba;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
