/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Productoclass;
import Conexion.Conexion;
import Modelo.FabricaProducto;
import Modelo.FabricaProductoConcreto;
import Modelo.Producto;
import Modelo.ServicioProductos;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Artorias<maxstell5549@hotmail.com>
 */
public class Agregarproductos extends javax.swing.JFrame {
    private DefaultTableModel modelo;
    private Ventas ventasPanel; // Referencia al panel de ventas o a la clase que tiene el método agregarProductoAlTicket

    /**
     * Creates new form Agregarproductos
     */
    public Agregarproductos() {
    // Inicializa los componentes de la interfaz gráfica
    initComponents();
    
    // Agrega un KeyListener global para capturar eventos de teclado en toda la interfaz
    agregarKeyListenerGlobal();
    
    // Crea un modelo de tabla para mostrar los productos
    modelo = new DefaultTableModel();
    modelo.addColumn("Id Producto");     // Agrega una columna para el ID del producto
    modelo.addColumn("Nombre");          // Agrega una columna para el nombre del producto
    modelo.addColumn("Precio Unitario"); // Agrega una columna para el precio unitario
    modelo.addColumn("Cantidad");        // Agrega una columna para la cantidad disponible
    modelo.addColumn("Categoría");       // Agrega una columna para la categoría del producto
    
    // Establece el modelo de la tabla 'Stock' para que use el modelo creado
    Stock.setModel(modelo);
    
    // Llena la tabla con productos disponibles
    llenarTabla();
    
    // Agrega un KeyListener al campo de texto 'Jtxtbusquedastock' para búsqueda en tiempo real
    Jtxtbusquedastock.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            // Captura el texto ingresado en el campo de búsqueda
            String searchText = Jtxtbusquedastock.getText();
            
            // Filtra los productos según el texto de búsqueda
            List<Productoclass> filteredProducts = getFilteredProducts(searchText);
            
            // Actualiza la tabla para mostrar solo los productos filtrados
            updateTable(filteredProducts);
        }
    });

    // Agrega un MouseListener a la tabla 'Stock' para seleccionar productos con doble clic
    Stock.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent evt) {
            // Verifica si el clic fue doble
            if (evt.getClickCount() == 2) {
                int selectedRow = Stock.getSelectedRow();
                
                // Si hay una fila seleccionada, obtiene el producto correspondiente
                if (selectedRow != -1) {
                    Productoclass selectedProduct = getProductFromTableRow(selectedRow);
                    
                    // Agrega el producto seleccionado al ticket de ventas
                    Ventas.getInstance().agregarProductoAlTicketstocl(selectedProduct);
                    
                    // Cierra la ventana actual
                    dispose();
                }
            }
        }
    });

    // Agrega un KeyListener para detectar la tecla Enter en la tabla 'Stock'
    Stock.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            // Verifica si se presionó la tecla Enter
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                int selectedRow = Stock.getSelectedRow();
                
                // Si hay una fila seleccionada, obtiene el producto correspondiente
                if (selectedRow != -1) {
                    Productoclass selectedProduct = getProductFromTableRow(selectedRow);
                    
                    // Agrega el producto seleccionado al ticket de ventas
                    Ventas.getInstance().agregarProductoAlTicketstocl(selectedProduct);
                    
                    // Cierra la ventana actual
                    dispose();
                }
            }
        }
    });
}

    
  public Productoclass getProductFromTableRow(int row) {
    // Obtiene los valores de la fila seleccionada de la tabla y los convierte al tipo adecuado
    int id = (int) modelo.getValueAt(row, 0);          // ID del producto (entero)
    String nombre = (String) modelo.getValueAt(row, 1); // Nombre del producto (cadena)
    double precio = (double) modelo.getValueAt(row, 2); // Precio unitario (decimal)
    int cantidad = (int) modelo.getValueAt(row, 3);     // Cantidad disponible (entero)
    String categoria = (String) modelo.getValueAt(row, 4); // Categoría del producto (cadena)

    // Crea una instancia de Productoclass y asigna los valores obtenidos
    Productoclass product = new Productoclass();
    product.setId(id);                  // Establece el ID del producto
    product.setNombre(nombre);          // Establece el nombre del producto
    product.setPrecio(precio);          // Establece el precio unitario
    product.setCantidad(cantidad);      // Establece la cantidad disponible
    product.setCategoria(categoria);    // Establece la categoría

    return product; // Devuelve el objeto product con los datos asignados
}

public List<Productoclass> getFilteredProducts(String searchText) {
    // Crea una lista para almacenar los productos que cumplen con el criterio de búsqueda
    List<Productoclass> products = new ArrayList<>();
    
    // Consulta SQL para buscar productos por ID o nombre que coincidan parcialmente con el texto de búsqueda
    String query = "SELECT `idProductos`, `Nombre_producto`, `Cantidad`, `Precio`, `Categoria`, `Icono` " +
                   "FROM `productos` " +
                   "WHERE `idProductos` LIKE ? OR `Nombre_producto` LIKE ?";
    
    // Crea una conexión a la base de datos
    Conexion conex = new Conexion();
    
    try (Connection conn = conex.getConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
         
        // Asigna el texto de búsqueda al parámetro de la consulta SQL, usando comodines para búsqueda parcial
        ps.setString(1, "%" + searchText + "%");
        ps.setString(2, "%" + searchText + "%");

        // Ejecuta la consulta y almacena los resultados en un ResultSet
        ResultSet rs = ps.executeQuery();

        // Itera sobre cada resultado obtenido
        while (rs.next()) {
            // Crea una instancia de Productoclass para cada producto encontrado
            Productoclass product = new Productoclass();
            product.setId(rs.getInt("idProductos"));             // Asigna el ID del producto
            product.setNombre(rs.getString("Nombre_producto"));  // Asigna el nombre del producto
            product.setCantidad(rs.getInt("Cantidad"));          // Asigna la cantidad disponible
            product.setPrecio(rs.getDouble("Precio"));           // Asigna el precio unitario
            product.setCategoria(rs.getString("Categoria"));     // Asigna la categoría del producto
            product.setIcono(rs.getString("Icono"));             // Asigna el ícono o imagen del producto (si existe)
            
            // Agrega el producto a la lista
            products.add(product);
        }

    } catch (Exception e) {
        e.printStackTrace(); // Maneja cualquier excepción imprimiendo el error en la consola
    }

    return products; // Devuelve la lista de productos filtrados
}

public void updateTable(List<Productoclass> products) {
    modelo.setRowCount(0);  // Limpia la tabla actual eliminando todas las filas

    // Agrega cada producto a la tabla como una nueva fila
    for (Productoclass product : products) {
        // Crea un arreglo de objetos que representa una fila con los datos del producto
        Object[] fila = new Object[5];
        fila[0] = product.getId();         // ID del producto
        fila[1] = product.getNombre();     // Nombre del producto
        fila[2] = product.getPrecio();     // Precio unitario
        fila[3] = product.getCantidad();   // Cantidad disponible
        fila[4] = product.getCategoria();  // Categoría del producto
        
        // Agrega la fila al modelo de la tabla
        modelo.addRow(fila);
    }
}

 

 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Stock = new javax.swing.JTable();
        Jtxtbusquedastock = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        Stock.setBackground(new java.awt.Color(102, 204, 255));
        Stock.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Stock.setForeground(new java.awt.Color(0, 0, 0));
        Stock.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Stock);

        Jtxtbusquedastock.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
            .addComponent(Jtxtbusquedastock)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(Jtxtbusquedastock, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
public void llenarTabla() {
    ServicioProductos servicio = new ServicioProductos();
    List<Producto> productos = servicio.obtenerProductosDesdeFabrica(new FabricaProductoConcreto());


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


private void agregarKeyListenerGlobal() {
    // Agrega un despachador de eventos de teclado que escuche todas las teclas presionadas
    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            // Verifica si se presionó la tecla Escape (tecla de código VK_ESCAPE)
            if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                // Cierra la ventana actual si se presiona Escape
                dispose();
            }
            
            return false; // Retorna false para que el evento se procese normalmente después de capturarlo
        }
    });
}

    
    
    
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
            java.util.logging.Logger.getLogger(Agregarproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregarproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregarproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregarproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregarproductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Jtxtbusquedastock;
    private javax.swing.JTable Stock;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
