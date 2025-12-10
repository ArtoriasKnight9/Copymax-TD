
package Vista;

import Conexion.Conexion;
import Modelo.FabricaProducto;
import Modelo.FabricaProductoConcreto;
import Modelo.Productoclass;
import Modelo.Letraseditor;
import Modelo.Numerosdecimaleseditor;
import Modelo.Numeroseditor;
import Modelo.Producto;
import Modelo.ServicioProductos;
import Modelo.StockNotifier;
import Modelo.StockObserver;
import Vista.Metododepago;
import Vista.RegistroClientes;
import Vista.RegistroProductos;
import java.awt.Color;
import java.io.FileWriter;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.PlainDocument;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Productos extends javax.swing.JPanel implements StockObserver {
       
    private static Productos instance;    
    private DefaultTableModel modelo;
     
    public Productos() {
        initComponents();
        modelo = new DefaultTableModel();
        modelo.addColumn("Id Producto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Categoría");
        Tablacproductos.setModel(modelo);
        StockNotifier.getInstance().agregarObservador(this); //OBSERVER

        
        llenarTabla();
        tabladiseño();
    }
    
    public static Productos getInstance() {
        if (instance == null) {
            instance = new Productos();
        }
        return instance;
    }

    
    private void tabladiseño(){
    // Asignar el editor personalizado a las columnas específicas
        
        Tablacproductos.getColumnModel().getColumn(1).setCellEditor(new Letraseditor());
        Tablacproductos.getColumnModel().getColumn(2).setCellEditor(new Numerosdecimaleseditor());
        Tablacproductos.getColumnModel().getColumn(3).setCellEditor(new Numeroseditor());
        if (Tablacproductos.getColumnModel().getColumnCount() > 0) {
        
        Tablacproductos.getColumnModel().getColumn(0).setMaxWidth(90);
        Tablacproductos.getColumnModel().getColumn(1).setMaxWidth(195);       
        Tablacproductos.getColumnModel().getColumn(2).setMaxWidth(120);
        Tablacproductos.getColumnModel().getColumn(3).setMaxWidth(100); 
        Tablacproductos.getColumnModel().getColumn(4).setMaxWidth(140);
        
       Tablacproductos.setRowHeight(30);
     
}
    
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tablacproductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtregprocategoria = new javax.swing.JTextField();
        BtnNuevo = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        Btnactualizar = new javax.swing.JButton();
        BtnNuevo1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        Tablacproductos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Tablacproductos.setModel(new javax.swing.table.DefaultTableModel(
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
        Tablacproductos.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(Tablacproductos);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clasificacion (Custom).png"))); // NOI18N
        jLabel1.setText("Registro de Productos");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txtregprocategoria.setBackground(new java.awt.Color(204, 255, 255));
        txtregprocategoria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtregprocategoria.setText("Categoría a buscar");
        txtregprocategoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtregprocategoriaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtregprocategoriaFocusLost(evt);
            }
        });
        txtregprocategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtregprocategoriaActionPerformed(evt);
            }
        });

        BtnNuevo.setBackground(new java.awt.Color(102, 153, 255));
        BtnNuevo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-producto.png"))); // NOI18N
        BtnNuevo.setText("Nuevo");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        BtnModificar.setBackground(new java.awt.Color(153, 153, 255));
        BtnModificar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnEliminar.setBackground(new java.awt.Color(255, 102, 102));
        BtnEliminar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        Btnactualizar.setBackground(new java.awt.Color(153, 255, 153));
        Btnactualizar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar-flecha.png"))); // NOI18N
        Btnactualizar.setText("Actualizar");
        Btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnactualizarActionPerformed(evt);
            }
        });

        BtnNuevo1.setBackground(new java.awt.Color(102, 153, 255));
        BtnNuevo1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BtnNuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-producto.png"))); // NOI18N
        BtnNuevo1.setText("Exportar");
        BtnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(BtnNuevo)
                .addGap(18, 18, 18)
                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnNuevo1)
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(52, 52, 52)
                        .addComponent(txtregprocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtregprocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnNuevo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        txtregprocategoria.getDocument().addDocumentListener(new DocumentListener() {
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
    }// </editor-fold>//GEN-END:initComponents

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
      
    int selectedRow = Tablacproductos.getSelectedRow();
    if (selectedRow != -1) {
        // Obtener los valores de la fila seleccionada y convertirlos a los tipos correctos
        int idproducto = (int) modelo.getValueAt(selectedRow, 0);
        String nombre = (String) modelo.getValueAt(selectedRow, 1);
        
        // Convertir los valores a los tipos adecuados si no son del tipo esperado
        double precio;
        int cantidad;
        try {
            precio = Double.parseDouble(modelo.getValueAt(selectedRow, 2).toString());
            cantidad = Integer.parseInt(modelo.getValueAt(selectedRow, 3).toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en los datos: asegúrese de que el precio y la cantidad sean numéricos.");
            return;
        }
        
        String categoria = (String) modelo.getValueAt(selectedRow, 4);
       
        System.out.println(idproducto);
        System.out.println(nombre);
        System.out.println(precio);
        System.out.println(cantidad);
        System.out.println(categoria);
        
        // Actualizar en la base de datos
        Conexion conex = new Conexion();
        String consulta = "UPDATE Productos SET Nombre_producto = ?, Precio = ?, Cantidad = ?, Categoria = ? WHERE idProductos = ?";
        try (Connection con = conex.getConnection(); 
             PreparedStatement pst = con.prepareStatement(consulta)) {
          
            pst.setString(1, nombre);
            pst.setDouble(2, precio);
            pst.setInt(3, cantidad);
            pst.setString(4, categoria);
            pst.setInt(5, idproducto);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto Modificado Con Exito !!!");
            llenarTabla(); // Volver a llenar la tabla después de la actualización
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar producto: " + e.toString());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una fila para modificar.");
    }
        actualizarTabla();
        Ventas.getInstance().cargarProductos("");
    }//GEN-LAST:event_BtnModificarActionPerformed
    

    
    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
         int selectedRow = Tablacproductos.getSelectedRow();
        if (selectedRow != -1) {
            int idproducto = (int) modelo.getValueAt(selectedRow,  0);

            eliminarProductoBD(idproducto);
            modelo.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
        }
        
        Ventas.getInstance().cargarProductos("");
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void txtregprocategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtregprocategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtregprocategoriaActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
       
     RegistroProductos  regipro = new RegistroProductos();
     regipro.setVisible(true);
     actualizarTabla();
        
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void txtregprocategoriaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtregprocategoriaFocusGained
        if (txtregprocategoria.getText().equals("Categoría a buscar")){
        txtregprocategoria.setText("");
        txtregprocategoria.setForeground(Color.black);
        
       
       }
    }//GEN-LAST:event_txtregprocategoriaFocusGained

    private void txtregprocategoriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtregprocategoriaFocusLost
         if (txtregprocategoria.getText().isEmpty()){
        txtregprocategoria.setForeground(new Color(204, 204, 204));
        txtregprocategoria.setText("Categoría a buscar");
        }
    }//GEN-LAST:event_txtregprocategoriaFocusLost

    private void BtnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnactualizarActionPerformed
        actualizarTabla();
       
        Ventas.getInstance().cargarProductos("");
    }//GEN-LAST:event_BtnactualizarActionPerformed

    private void BtnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevo1ActionPerformed
        try {
        // Crear instancia del Adapter y del servicio
        Adapter.JsonAdapter<Producto> adapter = new Adapter.JsonAdapter<>();
        Modelo.FabricaProducto fabrica = new Modelo.FabricaProductoConcreto();
        Modelo.ServicioProductos servicio = Modelo.ServicioProductos.getInstancia();
        List<Producto> productos = servicio.obtenerProductosDesdeFabrica(fabrica);

        // Convertir productos a JSON
        String json = adapter.convertirAFormato(productos);

        // Guardar archivo JSON en la carpeta Descargas
        String ruta = System.getProperty("user.home") + "/Downloads/productos.json";
        FileWriter writer = new FileWriter(ruta);
        writer.write(json);
        writer.close();

        JOptionPane.showMessageDialog(this, "Productos exportados correctamente a:\n" + ruta);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al exportar productos: " + e.getMessage());
    }
    }//GEN-LAST:event_BtnNuevo1ActionPerformed
public void llenarTabla() {
    ServicioProductos servicio = new ServicioProductos();
    FabricaProducto fabrica = new FabricaProductoConcreto();

    // Obtener la lista de productos usando el patrón combinado
    List<Producto> productos = servicio.obtenerProductosDesdeFabrica(fabrica);

    // Rellenar la tabla con los productos
    for (Producto producto : productos) {
        Object[] fila = new Object[5];
        fila[0] = producto.getId();
        fila[1] = producto.getNombre();
        fila[2] = producto.getPrecio();
        fila[3] = producto.getCantidad();
        fila[4] = producto.getCategoria();
        modelo.addRow(fila);
    }
}
      private void eliminarProductoBD(int idProducto) {
        Conexion conex = new Conexion();
        String consulta = "DELETE FROM Productos WHERE idProductos = ?";
        try (
                PreparedStatement pst = conex.getConnection().prepareCall(consulta)) {
            pst.setInt(1, idProducto);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto Eliminado Con Exito !!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e.toString());
        }
        
    }
     
public void actualizarTabla() {
    modelo.setRowCount(0);
    ServicioProductos servicio = new ServicioProductos();
    FabricaProducto fabrica = new FabricaProductoConcreto();
    List<Producto> productos = servicio.obtenerProductosDesdeFabrica(fabrica);

    for (Producto producto : productos) {
        Object[] fila = new Object[5];
        fila[0] = producto.getId();
        fila[1] = producto.getNombre();
        fila[2] = producto.getPrecio();
        fila[3] = producto.getCantidad();
        fila[4] = producto.getCategoria();
        modelo.addRow(fila);
    }
}

   private void actualizarTablabus() {
    String textoBusqueda = txtregprocategoria.getText();
    
    // Limpia la tabla
    DefaultTableModel modelo = (DefaultTableModel) Tablacproductos.getModel();
    modelo.setRowCount(0);
    
    // Obtener la lista actualizada de clientes
    Productoclass productoo = new Productoclass();
    List<Productoclass> Productos = productoo.obtenerClientesProductoscatego(textoBusqueda);
    
    // Agrega los registros encontrados a la tabla
      for (Productoclass producto : Productos) {
        Object[] fila = new Object[6];
            fila[0] = producto.getId();
            fila[1] = producto.getNombre();
            fila[2] = producto.getPrecio();
            fila[3] = producto.getCantidad();
            fila[4] = producto.getCategoria();
        modelo.addRow(fila);
    }
   
   }

   public void ajustarInterfazSegunRol(String rol) {
        if ("Estandar".equals(rol)) {
            BtnModificar.setEnabled(false);
            BtnEliminar.setEnabled(false);
            
        } else {
            BtnModificar.setEnabled(true);
            BtnEliminar.setEnabled(true);
        }
    }
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnEliminar;
    public javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JButton BtnNuevo1;
    private javax.swing.JButton Btnactualizar;
    private javax.swing.JTable Tablacproductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtregprocategoria;
    // End of variables declaration//GEN-END:variables

   @Override
 public void actualizarStock() {
    
    actualizarTabla();
}
}

