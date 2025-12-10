
package Vista;

import Conexion.Conexion;
import Modelo.Clientesclass;
import Modelo.Filtronumeros;
import Modelo.Letraseditor;
import Modelo.Numeroseditor;
import Modelo.Pedidoclass;
import Modelo.Usuariosesion;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.PlainDocument;

/**
 *
 * @author maxst
 */
public class Pedido extends javax.swing.JFrame {
   
    private GenerarPedido generarPedido;
    private DefaultTableModel modelo;
    private static Pedido instance;
    public String apellidoglobal;
   private boolean isUpdating = false;  // Flag para evitar la recursión infinita
   
      
    
    public Pedido() {
       this.generarPedido = generarPedido;
        initComponents();
        FechaControl();
        // Agregar listeners
       
        Txttotal.setEditable(false); // El campo de total no se debe editar manualmente
        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");     //Columna para el Nombre
        modelo.addColumn("Apellidos");  //Columna para el Apellido
        modelo.addColumn("Celular");    //Columna para el Celular
        modelo.addColumn("RFC");        //Columna para el RFC
        modelo.addColumn("Correo");     //Columna para el Correo
        lblusuario.setText("LE ATIENDE: "+Usuariosesion.getInstance().getNombrereal());
        Tablaclientes.setModel(modelo); // Asigna el modelo de tabla a la tabla Tablaclientes
        llenarTabla();                  // Llena la tabla
        tabladiseño();                  // Llama al método para personalizar el diseño de la tabla
        generarNumeroPedido();
        configurarListeners();
        rellenarCombos(Combofrente, Comboatras, Comboarillo);
        RBunsololadocarta.setActionCommand("CARTA");
        RBunsololadooficio.setActionCommand("OFICIO");
        RBambosladoscarta.setActionCommand("CARTA");
        RBtambosladosoficio.setActionCommand("OFICIO");
        RBcentrar.setActionCommand("CENTRAR");
        RBtalcomoesta.setActionCommand("TAL COMO ESTA");
        RBcdospaginasenunahoja.setActionCommand("2 PAGINAS EN 1 HOJA");
        RBampliacion.setActionCommand("AMPLIACION");
        RBreduccion.setActionCommand("REDUCCION");
        RBengrapadas.setActionCommand("ENGRAPADAS");
        RBrecortadas.setActionCommand("RECORTADAS");
        
        agregarListenerengargolado(Txtnumpaginas);
        configurarCálculoAutomático();
        Comboarillo.addActionListener(e -> validarSeleccionArillo());
        agregarListenerFocusLost(Txtanticipo);
         bloquearcombos();
         
         
         
         
         
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
        private void bloquearcombos(){
        
         Txtnumpaginas.setEnabled(false);
                   Combofrente.setEnabled(false); // Deshabilitar la Opción 3
                   Comboatras.setEnabled(false);
                   Comboarillo.setEnabled(false);
                   Combofrente.setSelectedItem(-1);
                   Comboatras.setSelectedItem(-1);
                   Comboarillo.setSelectedItem(-1);
        }
    
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SeleccionClientes = new javax.swing.JDialog();
        panelseleccion = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtregclicelularbusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablaclientes = new javax.swing.JTable();
        Tipodecopiagroup = new javax.swing.ButtonGroup();
        Unladogroup = new javax.swing.ButtonGroup();
        Ambosladosgroup = new javax.swing.ButtonGroup();
        Amplireducciongroup = new javax.swing.ButtonGroup();
        Serviciogroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Idpedido = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Jdatentrega = new com.toedter.calendar.JDateChooser();
        Jdateemision = new com.toedter.calendar.JDateChooser();
        Horaemision = new javax.swing.JSpinner();
        Horaentrega = new javax.swing.JSpinner();
        Comboservicio = new javax.swing.JComboBox<>();
        Txtcantidad = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtNombrecompleto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        TxtCelular = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Txtmail = new javax.swing.JTextField();
        RBtalcomoesta = new javax.swing.JRadioButton();
        RBcdospaginasenunahoja = new javax.swing.JRadioButton();
        RBrecortadas = new javax.swing.JRadioButton();
        RBreduccion = new javax.swing.JRadioButton();
        RBampliacion = new javax.swing.JRadioButton();
        RBcentrar = new javax.swing.JRadioButton();
        RBengrapadas = new javax.swing.JRadioButton();
        RBunsololadocarta = new javax.swing.JRadioButton();
        RBunsololadooficio = new javax.swing.JRadioButton();
        RBambosladoscarta = new javax.swing.JRadioButton();
        RBtambosladosoficio = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        Txtnumpaginas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Combofrente = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        Comboatras = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtcartacantidad = new javax.swing.JTextField();
        txtoficiocantidad = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Txtcomentarios = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        Comboarillo = new javax.swing.JComboBox<>();
        Generarpedidobtn = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        Txttotal = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Txtanticipo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        Txtresto = new javax.swing.JTextField();
        lblusuario = new javax.swing.JLabel();
        TxtIdcliente = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        Combotamaño = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        Limpiarbtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        SeleccionClientes.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        SeleccionClientes.setTitle("Seleccion de Clientes");
        SeleccionClientes.setBackground(new java.awt.Color(204, 255, 255));
        SeleccionClientes.setResizable(false);
        SeleccionClientes.setSize(new java.awt.Dimension(750, 315));

        panelseleccion.setBackground(new java.awt.Color(204, 255, 255));
        panelseleccion.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clasificacion (Custom).png"))); // NOI18N
        jLabel7.setText("Seleccion de Cliente");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

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

        javax.swing.GroupLayout panelseleccionLayout = new javax.swing.GroupLayout(panelseleccion);
        panelseleccion.setLayout(panelseleccionLayout);
        panelseleccionLayout.setHorizontalGroup(
            panelseleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelseleccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelseleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelseleccionLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtregclicelularbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelseleccionLayout.setVerticalGroup(
            panelseleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelseleccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelseleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtregclicelularbusqueda))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
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

        javax.swing.GroupLayout SeleccionClientesLayout = new javax.swing.GroupLayout(SeleccionClientes.getContentPane());
        SeleccionClientes.getContentPane().setLayout(SeleccionClientesLayout);
        SeleccionClientesLayout.setHorizontalGroup(
            SeleccionClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelseleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SeleccionClientesLayout.setVerticalGroup(
            SeleccionClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelseleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("N° de Pedido:");

        Idpedido.setEditable(false);
        Idpedido.setBackground(new java.awt.Color(240, 240, 240));
        Idpedido.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Idpedido.setForeground(new java.awt.Color(0, 0, 0));
        Idpedido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Idpedido.setActionCommand("<Not Set>");
        Idpedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Idpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdpedidoActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(31, 132, 187));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Datos del Pedido");

        jLabel2.setBackground(new java.awt.Color(240, 240, 240));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tipo de Servicio: ");

        jLabel4.setBackground(new java.awt.Color(240, 240, 240));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha de Entrega: ");

        jLabel5.setBackground(new java.awt.Color(240, 240, 240));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cantidad: ");

        Jdatentrega.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        Jdateemision.setBackground(new java.awt.Color(240, 240, 240));
        Jdateemision.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jdateemision.setMaxSelectableDate(new java.util.Date(253370790111000L));

        Comboservicio.setBackground(new java.awt.Color(240, 240, 240));
        Comboservicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Copias", "Engargolados", "Folletos" }));
        Comboservicio.setSelectedIndex(-1);
        Comboservicio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String seleccion = (String) Comboservicio.getSelectedItem();

                // Bloquear o desbloquear según la selección del JComboBox
                if (seleccion.equals("Copias")) {
                    // Habilitar la Opción 1
                    bloquearcombos();
                } else if (seleccion.equals("Engargolados")) {
                    Combofrente.setEnabled(true); // Deshabilitar la Opción 3
                    Comboatras.setEnabled(true);
                    Comboarillo.setEnabled(true);
                    RBrecortadas.setEnabled(false);
                    RBengrapadas.setEnabled(false);// Deshabilitar la Opción 3
                    Combofrente.setSelectedItem(1);
                    Comboatras.setSelectedItem(1);
                    Comboarillo.setSelectedItem(1);
                } else if (seleccion.equals("Folletos")) {
                    bloquearcombos();

                    // Habilitar la Opción 3
                }
            }
        });

        Txtcantidad.setBackground(new java.awt.Color(240, 240, 240));
        Txtcantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jTextField3.setBackground(new java.awt.Color(31, 132, 187));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setText("Datos del Cliente");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(240, 240, 240));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nombre:");

        TxtNombrecompleto.setEditable(false);
        TxtNombrecompleto.setBackground(new java.awt.Color(240, 240, 240));
        TxtNombrecompleto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TxtNombrecompleto.setForeground(new java.awt.Color(0, 0, 0));
        TxtNombrecompleto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtNombrecompleto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TxtNombrecompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombrecompletoActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(240, 240, 240));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(240, 240, 240));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reclutamiento.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(240, 240, 240));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Celular:");

        TxtCelular.setEditable(false);
        TxtCelular.setBackground(new java.awt.Color(240, 240, 240));
        TxtCelular.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TxtCelular.setForeground(new java.awt.Color(0, 0, 0));
        TxtCelular.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setBackground(new java.awt.Color(240, 240, 240));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Mail:");

        Txtmail.setEditable(false);
        Txtmail.setBackground(new java.awt.Color(240, 240, 240));
        Txtmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Txtmail.setForeground(new java.awt.Color(0, 0, 0));
        Txtmail.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Txtmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tipodecopiagroup.add(RBtalcomoesta);
        RBtalcomoesta.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        RBtalcomoesta.setForeground(new java.awt.Color(0, 0, 0));
        RBtalcomoesta.setText("TAL COMO ESTA");

        Tipodecopiagroup.add(RBcdospaginasenunahoja);
        RBcdospaginasenunahoja.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        RBcdospaginasenunahoja.setForeground(new java.awt.Color(0, 0, 0));
        RBcdospaginasenunahoja.setText("DOS PAGINAS EN UNA HOJA");

        Serviciogroup.add(RBrecortadas);
        RBrecortadas.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        RBrecortadas.setForeground(new java.awt.Color(0, 0, 0));
        RBrecortadas.setText("RECORTADAS");

        Amplireducciongroup.add(RBreduccion);
        RBreduccion.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        RBreduccion.setForeground(new java.awt.Color(0, 0, 0));
        RBreduccion.setText("REDUCCION");

        Amplireducciongroup.add(RBampliacion);
        RBampliacion.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        RBampliacion.setForeground(new java.awt.Color(0, 0, 0));
        RBampliacion.setText("AMPLIACIÓN");
        RBampliacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBampliacionActionPerformed(evt);
            }
        });

        Tipodecopiagroup.add(RBcentrar);
        RBcentrar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        RBcentrar.setForeground(new java.awt.Color(0, 0, 0));
        RBcentrar.setText("CENTRAR");

        Serviciogroup.add(RBengrapadas);
        RBengrapadas.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        RBengrapadas.setForeground(new java.awt.Color(0, 0, 0));
        RBengrapadas.setText("ENGRAPADAS");

        Unladogroup.add(RBunsololadocarta);
        RBunsololadocarta.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        RBunsololadocarta.setForeground(new java.awt.Color(0, 0, 0));
        RBunsololadocarta.setText("CARTA");

        Unladogroup.add(RBunsololadooficio);
        RBunsololadooficio.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        RBunsololadooficio.setForeground(new java.awt.Color(0, 0, 0));
        RBunsololadooficio.setText("OFICIO");

        Ambosladosgroup.add(RBambosladoscarta);
        RBambosladoscarta.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        RBambosladoscarta.setForeground(new java.awt.Color(0, 0, 0));
        RBambosladoscarta.setText("CARTA");

        Ambosladosgroup.add(RBtambosladosoficio);
        RBtambosladosoficio.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        RBtambosladosoficio.setForeground(new java.awt.Color(0, 0, 0));
        RBtambosladosoficio.setText("OFICIO");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("UN SOLO LADO");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("AMBOS LADOS");

        jComboBox3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BORDE LARGO", "BORDE CORTO" }));
        jComboBox3.setSelectedIndex(-1);

        Txtnumpaginas.setBackground(new java.awt.Color(240, 240, 240));
        Txtnumpaginas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("N° DE HOJAS:");

        Combofrente.setBackground(new java.awt.Color(240, 240, 240));
        Combofrente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Combofrente.setForeground(new java.awt.Color(0, 0, 0));
        Combofrente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Combofrente.setSelectedIndex(-1);

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("FRENTE");

        Comboatras.setBackground(new java.awt.Color(240, 240, 240));
        Comboatras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Comboatras.setForeground(new java.awt.Color(0, 0, 0));
        Comboatras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Comboatras.setSelectedIndex(-1);

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("ATRAS");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("T/Carta/Oficio:");

        txtcartacantidad.setBackground(new java.awt.Color(240, 240, 240));
        txtcartacantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtcartacantidad.setForeground(new java.awt.Color(0, 0, 0));

        txtoficiocantidad.setBackground(new java.awt.Color(240, 240, 240));
        txtoficiocantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtoficiocantidad.setForeground(new java.awt.Color(0, 0, 0));

        Txtcomentarios.setBackground(new java.awt.Color(230, 230, 230));
        Txtcomentarios.setColumns(20);
        Txtcomentarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Txtcomentarios.setForeground(new java.awt.Color(0, 0, 0));
        Txtcomentarios.setLineWrap(true);
        Txtcomentarios.setRows(5);
        jScrollPane2.setViewportView(Txtcomentarios);

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("ARILLO");

        Comboarillo.setBackground(new java.awt.Color(240, 240, 240));
        Comboarillo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Comboarillo.setForeground(new java.awt.Color(0, 0, 0));
        Comboarillo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Comboarillo.setSelectedIndex(-1);

        Generarpedidobtn.setBackground(new java.awt.Color(153, 255, 153));
        Generarpedidobtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Generarpedidobtn.setForeground(new java.awt.Color(0, 0, 0));
        Generarpedidobtn.setText("GENERAR PEDIDO");
        Generarpedidobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarpedidobtnActionPerformed(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(153, 255, 204));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("TOTAL:");

        Txttotal.setBackground(new java.awt.Color(240, 240, 240));
        Txttotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel19.setBackground(new java.awt.Color(153, 255, 204));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("ANTICIPO:");

        Txtanticipo.setBackground(new java.awt.Color(240, 240, 240));
        Txtanticipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel20.setBackground(new java.awt.Color(153, 255, 204));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("RESTO:");

        Txtresto.setBackground(new java.awt.Color(240, 240, 240));
        Txtresto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        lblusuario.setBackground(new java.awt.Color(255, 255, 255));
        lblusuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblusuario.setForeground(new java.awt.Color(0, 0, 0));
        lblusuario.setText("LE ATIENDE: ");

        TxtIdcliente.setBackground(new java.awt.Color(240, 240, 240));
        TxtIdcliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TxtIdcliente.setForeground(new java.awt.Color(0, 0, 0));
        TxtIdcliente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtIdcliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TxtIdcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdclienteActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("TAMAÑO:");

        Combotamaño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carta", "Oficio", "Ambos", "Media Carta" }));
        Combotamaño.setSelectedIndex(-1);
        Combotamaño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombotamañoActionPerformed(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(31, 132, 187));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("Detalles del Pedido");

        Limpiarbtn.setBackground(new java.awt.Color(194, 204, 214));
        Limpiarbtn.setForeground(new java.awt.Color(0, 0, 0));
        Limpiarbtn.setText("Limpiar");
        Limpiarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarbtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Comentarios:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblusuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Idpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Comboservicio, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Jdateemision, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Horaemision, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Combotamaño, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Txtmail)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(TxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxtIdcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(TxtNombrecompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RBcdospaginasenunahoja)
                                    .addComponent(RBtalcomoesta)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(RBcentrar)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcartacantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtoficiocantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBrecortadas)
                            .addComponent(RBengrapadas)
                            .addComponent(RBreduccion)
                            .addComponent(RBampliacion))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(RBambosladoscarta))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(RBunsololadocarta)
                                        .addGap(37, 37, 37)
                                        .addComponent(RBunsololadooficio))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel8))
                                    .addComponent(RBtambosladosoficio)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Txtnumpaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(95, 95, 95)
                                .addComponent(jLabel14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Combofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Comboatras, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel17))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Comboarillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(Limpiarbtn))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Jdatentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Horaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Generarpedidobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel19))
                                    .addGap(6, 6, 6)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Txtresto, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Txtanticipo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Generarpedidobtn)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2)
                                    .addComponent(jButton1)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(TxtNombrecompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(TxtIdcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblusuario)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(Comboservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5)
                                            .addComponent(Txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(Idpedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(Txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Jdateemision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Horaemision, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                    .addComponent(jLabel21)
                                    .addComponent(Combotamaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtcartacantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtoficiocantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addComponent(RBcentrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RBtalcomoesta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RBcdospaginasenunahoja))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(RBampliacion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RBreduccion))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(RBunsololadocarta)
                                            .addComponent(RBunsololadooficio))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RBengrapadas)
                                    .addComponent(RBtambosladosoficio)
                                    .addComponent(RBambosladoscarta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RBrecortadas)
                                    .addComponent(jLabel11)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(Txtnumpaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Comboatras, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Combofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Comboarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Limpiarbtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)))
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(Txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(Txtanticipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(Txtresto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(Jdatentrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Horaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(8, Short.MAX_VALUE))
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

    private void IdpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdpedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdpedidoActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
        SeleccionClientes.setLocationRelativeTo(null);
        SeleccionClientes.setVisible(true);
                  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RegistroClientes ventanaRegistroClientes = new RegistroClientes();
        ventanaRegistroClientes.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TxtNombrecompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombrecompletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombrecompletoActionPerformed

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

    private void TablaclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaclientesMouseClicked
        datoscliente(Tablaclientes);
    }//GEN-LAST:event_TablaclientesMouseClicked

    private void GenerarpedidobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarpedidobtnActionPerformed
       //Variables
      llenardatos();
      
      double anticipo = Double.parseDouble(Txtanticipo.getText());
      
      if (anticipo == 0){
           JOptionPane.showMessageDialog(rootPane,"El anticipo no puede ser $ 0 ");
      }else {
          actualizarCaja(anticipo);
      }
        
      
    }//GEN-LAST:event_GenerarpedidobtnActionPerformed
  

    public void actualizarCaja(double anticipo) {
    Conexion conex = new Conexion();

    // Consultas SQL
    String obtenerTotalesSQL = "SELECT TotalPedidos, TotalCaja FROM caja WHERE DATE(FechaInicio) = CURDATE()";
    String actualizarCajaSQL = "UPDATE caja SET TotalPedidos = ?, TotalCaja = ? WHERE DATE(FechaInicio) = CURDATE()";

    try (Connection con = conex.getConnection();
         PreparedStatement pstObtener = con.prepareStatement(obtenerTotalesSQL);
         PreparedStatement pstActualizar = con.prepareStatement(actualizarCajaSQL)) {

        // Paso 1: Obtener los valores actuales de TotalPedidos y TotalCaja
        double totalPedidosActual = 0.0;
        double totalCajaActual = 0.0;

        try (ResultSet rs = pstObtener.executeQuery()) {
            if (rs.next()) {
                totalPedidosActual = rs.getDouble("TotalPedidos");
                totalCajaActual = rs.getDouble("TotalCaja");
            }
        }

        // Paso 2: Calcular los nuevos valores
        double nuevoTotalPedidos = totalPedidosActual + anticipo;
        double nuevoTotalCaja = totalCajaActual + anticipo;

        // Paso 3: Actualizar la tabla caja
        pstActualizar.setDouble(1, nuevoTotalPedidos);
        pstActualizar.setDouble(2, nuevoTotalCaja);

        int rowsUpdated = pstActualizar.executeUpdate();

        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "Caja actualizada exitosamente con el anticipo.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la caja.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al actualizar la caja: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    
// Método para agregar los listeners a los campos de texto
private void agregarListenerTexto(JTextField textField) {
    textField.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            if (!isUpdating) {
                calcularTotal();  // Actualiza el total cuando se ingresa texto y no está actualizándose
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (!isUpdating) {
                calcularTotal();  // Actualiza el total cuando se elimina texto y no está actualizándose
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            if (!isUpdating) {
                calcularTotal();  // Actualiza el total cuando el texto cambia
            }
        }
    });
}

private void calcularTotal() {
    try {
        // Validar si el combo de tamaño y tipo de servicio tienen valores seleccionados
        if (Combotamaño.getSelectedItem() == null || Combotamaño.getSelectedItem().toString().isEmpty() ||
            Comboservicio.getSelectedItem() == null || Comboservicio.getSelectedItem().toString().isEmpty()) {
            Txttotal.setText(""); // Limpiar el total si no hay selección
            return;
        }

        // Obtener los valores seleccionados
        String tamaño = Combotamaño.getSelectedItem().toString();
        String tipoServicio = Comboservicio.getSelectedItem().toString();

        // Leer la cantidad de copias de los campos txtcantidad y tamaño de copias
        double cantidad = obtenerValorNumerico(Txtcantidad);
        double numPaginas = 0;

        if (tamaño.equals("Carta")) {
            numPaginas = obtenerValorNumerico(txtcartacantidad) * obtenervalornum(Txtcantidad);
            System.out.println(numPaginas);
        } else if (tamaño.equals("Oficio")) {
            numPaginas = obtenerValorNumerico(txtoficiocantidad) * obtenervalornum(Txtcantidad);
            System.out.println("oficio= "+numPaginas);
        }

        // Si no hay cantidad o numPaginas inválidos, limpiar el total
        if (cantidad <= 0 || numPaginas <= 0) {
            Txttotal.setText(""); // Limpiar si los valores no son válidos
            return;
        }

        // Calcular el precio base de acuerdo al tamaño y la cantidad de copias
        double precio = obtenerPrecioPorTamaño(tamaño, (int) numPaginas); // Se pasa numPaginas al método de precio

        // Calcular el precio base según el tipo de servicio
        double precioTotal = precio * numPaginas;
        System.out.println("Total= $" + precioTotal);

        if (tipoServicio.equals("Engargolados")) {
            // Obtener el precio del arillo seleccionado
            String arilloSeleccionado = (String) Comboarillo.getSelectedItem();
            double precioArillo = obtenerPrecioPorArillo(arilloSeleccionado);

            if (precioArillo > 0) {
                // Sumar el precio del arillo al total
                precioTotal += cantidad * precioArillo; // Cobrar un arillo por cada engargolado
            } else {
               // JOptionPane.showMessageDialog(null, "No se pudo determinar el precio del arillo seleccionado. Verifica la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Mostrar el total en el campo Txttotal
        Txttotal.setText(String.format("%.2f", precioTotal));

        // Desactivar temporalmente la actualización del anticipo
        isUpdating = true;

        // Solo actualizamos el anticipo si el usuario no lo ha editado
        if (Txtanticipo.getText().isEmpty()) {
            // Mostrar automáticamente el anticipo como la mitad del total
            double anticipo = precioTotal / 2;
            Txtanticipo.setText(String.format("%.2f", anticipo));  // Setear la mitad del total como anticipo
        }

        // Rehabilitar la actualización
        isUpdating = false;             

        // Actualizar el resto
        actualizarRestante(precioTotal, Double.parseDouble(Txtanticipo.getText()));

    } catch (NumberFormatException e) {
        // Si algún valor no es válido, limpiar el campo total
        Txttotal.setText("");
        Txtanticipo.setText("0.00");
        Txtresto.setText("0.00");
    }
}

   // Método para agregar el listener de focusLost a Txtanticipo
private void agregarListenerFocusLost(JTextField textField) {
    Txtanticipo.addFocusListener(new FocusAdapter() {
        @Override
        public void focusLost(FocusEvent e) {
            // Solo actualizar el anticipo si no está editado manualmente
            if (!Txtanticipo.getText().isEmpty()) {
                double total = obtenerValorNumerico(Txttotal); // Obtener el total actualizado
                double anticipo = obtenerValorNumerico(Txtanticipo); // Obtener el anticipo actualizado

                // Validar que el anticipo no sea mayor que el total
                if (anticipo >= total) {
                    Txtresto.setText("0.00"); // Si el anticipo es igual o mayor al total, resto es 0
                } else {
                    actualizarRestante(total, anticipo); // Actualizamos el resto normalmente
                }
            }
        }
    });
}

        // Método para actualizar el resto
    private void actualizarRestante(double total, double anticipo) {
        double resto = total - anticipo;
        Txtresto.setText(String.format("%.2f", resto));  // Mostrar el resto actualizado
    }

// Método para obtener el precio de acuerdo al tamaño y número de páginas
private double obtenerPrecioPorTamaño(String tamaño, int cantidadCopias) {
    double precioPorCopia = 0;

    // Definir el precio base según el tamaño
    switch (tamaño) {
        case "Carta":
            // Determinar el precio basado en la cantidad de copias
            if (cantidadCopias >= 0 && cantidadCopias <= 10) {
                precioPorCopia = 0.50; // 50 centavos por copia para 0 a 10 copias
            } else if (cantidadCopias >= 11 && cantidadCopias <= 100) {
                precioPorCopia = 0.35; // 35 centavos por copia para 11 a 100 copias
            } else if (cantidadCopias > 100) {
                precioPorCopia = 0.30; // 35 centavos por copia para más de 100 copias
            }
            break;

        case "Oficio":
            if (cantidadCopias >= 0 && cantidadCopias <= 10) {
                precioPorCopia = 1; // 1 peso por copia para 0 a 10 copias oficio
            } else if (cantidadCopias >= 11 ) {
                precioPorCopia = 0.7; // 70 centavos por copia para 11 a 100 copias oficio
            }
            break;

        case "Media Carta":
            precioPorCopia = 0.35; // 35 centavos por copia para estos tamaños
            break;

        case "Folletos":
            precioPorCopia = 0.35; // 35 centavos por copia para estos tamaños
            break;

        default:
            precioPorCopia = 0; // Precio por defecto si no coincide
            break;
    }

    return precioPorCopia;
}



// Método para obtener el precio de un arillo desde la base de datos
private double obtenerPrecioPorArillo(String arillo) {
    double precio = 0;
    // Crear el nombre completo del producto
    String nombreProducto = "Engargolado " + arillo;

    String sql = "SELECT Precio FROM productos WHERE Nombre_producto = ? AND Categoria = 'Engargolado'";

    try (Connection con = new Conexion().getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {
        pst.setString(1, nombreProducto); // Usamos el nombre completo del producto
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                precio = rs.getDouble("Precio");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return precio;
}


// Método para obtener un valor numérico de un JTextField
private double obtenerValorNumerico(JTextField textField) {
    String texto = textField.getText().trim();
    if (texto.isEmpty()) {
        return 0; // Considerar vacío como 0
    }
    try {
        return Double.parseDouble(texto);
    } catch (NumberFormatException e) {
        return 0; // Si el valor no es un número válido, devolver 0
    }
}

// Configurar los listeners en la inicialización
private void configurarListeners() {
    agregarListenerTexto(Txtcantidad);        // Agregar el listener a Txtcantidad
    agregarListenerTexto(txtcartacantidad);   // Agregar el listener a txtcartacantidad
    agregarListenerTexto(txtoficiocantidad);  // Agregar el listener a txtoficiocantidad

    Combotamaño.addActionListener(e -> calcularTotal());  // Actualizar cuando cambie el combo
    
    agregarListenerTexto(Txtcantidad); // Para cantidad
    agregarListenerTexto(txtcartacantidad); // Para carta
    agregarListenerTexto(txtoficiocantidad); // Para oficio
    agregarListenerTexto(Txtanticipo); // Para el campo de anticipo
}




    
    private void TxtIdclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdclienteActionPerformed

    private void CombotamañoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombotamañoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CombotamañoActionPerformed

    private void RBampliacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBampliacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBampliacionActionPerformed

    private void LimpiarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarbtnActionPerformed
        
        Serviciogroup.clearSelection();
        Unladogroup.clearSelection();
        Ambosladosgroup.clearSelection();
        Amplireducciongroup.clearSelection();
        Tipodecopiagroup.clearSelection();
        txtcartacantidad.setText("");
        txtoficiocantidad.setText("");
        Txtcantidad.setText("");
        Txttotal.setText("");
        Txtanticipo.setText("");
        Txtresto.setText("");
        Combotamaño.setSelectedIndex(-1);
        Combofrente.setSelectedIndex(-1);
        Comboatras.setSelectedIndex(-1);
        Comboarillo.setSelectedIndex(-1);
        
                
    }//GEN-LAST:event_LimpiarbtnActionPerformed

public void FechaControl() { 
    // Fecha actual (hoy)
    Date hoy = new Date();

    // Configurar fecha de emisión como la fecha actual y deshabilitar edición
    Jdateemision.setDate(hoy);
    Jdateemision.setEnabled(false);
    Jdatentrega.setMinSelectableDate(hoy);

    // Configurar el modelo de hora para emisión
    SpinnerDateModel emisionModel = new SpinnerDateModel(hoy, null, null, Calendar.MINUTE);
    Horaemision.setModel(emisionModel);
    Horaemision.setEditor(new JSpinner.DateEditor(Horaemision, "hh:mm a"));
    Horaemision.setEnabled(false);

    // Configurar el modelo de hora para entrega
    SpinnerDateModel entregaModel = new SpinnerDateModel(hoy, null, null, Calendar.MINUTE);
    Horaentrega.setModel(entregaModel);
    Horaentrega.setEditor(new JSpinner.DateEditor(Horaentrega, "hh:mm a"));

    // Validar fecha de entrega para que no sea antes de la fecha de emisión
    Jdatentrega.getDateEditor().addPropertyChangeListener("date", evt -> {
        Date fechaEmision = Jdateemision.getDate();
        Date fechaEntrega = Jdatentrega.getDate();

        if (fechaEntrega != null && fechaEntrega.before(fechaEmision)) {
            // Ajustar automáticamente la fecha de entrega
            Jdatentrega.setDate(fechaEmision);
            Horaentrega.setValue(Horaemision.getValue()); // Sincronizar la hora de entrega
            JOptionPane.showMessageDialog(this, "La fecha de entrega no puede ser anterior a la fecha de emisión.");
        }
    });

    // Validar hora de entrega para que no sea anterior a la hora de emisión si las fechas son iguales
    Horaentrega.addChangeListener(evt -> {
        validarHoraEntrega();
    });

    // Validar hora de entrega también al perder el foco (asegura corrección al soltar el spinner)
    ((JSpinner.DefaultEditor) Horaentrega.getEditor()).getTextField().addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusLost(java.awt.event.FocusEvent e) {
            validarHoraEntrega();
        }
    });
}


private void validarHoraEntrega() {
    Date horaEmision = (Date) Horaemision.getValue();
    Date horaEntrega = (Date) Horaentrega.getValue();

    // Validar si las fechas de emisión y entrega son iguales
    if (Jdatentrega.getDate().equals(Jdateemision.getDate()) && horaEntrega.before(horaEmision)) {
        Horaentrega.setValue(horaEmision); // Ajustar automáticamente la hora de entrega
        JOptionPane.showMessageDialog(this, "La hora de entrega no puede ser anterior a la hora de emisión.");
    }
}

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
    
    
    public int obtenerIdCliente(String nombre, String apellido, String celular) {
    Conexion conex = new Conexion();
    String sql = "SELECT idCliente FROM Cliente WHERE Nombre = ? AND Apellidos = ? AND Celular = ?";
    int idCliente = -1; // Valor por defecto si no se encuentra el cliente

    try (Connection con = conex.getConnection(); 
         PreparedStatement pst = con.prepareStatement(sql)) {

        // Asignar parámetros de la consulta
        pst.setString(1, nombre);
        pst.setString(2, apellido);
        pst.setString(3, celular);
        
        // Ejecutar la consulta
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                idCliente = rs.getInt("idCliente"); // Recuperar el idCliente
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al recuperar idCliente: " + e.toString());
    }

    return idCliente; // Devuelve -1 si no se encontró o el idCliente correspondiente
}
    

public void datoscliente(JTable Tablaclientes) {
    try {
        int fila = Tablaclientes.getSelectedRow();
        if (fila >= 0) {
            // Obtener datos de la tabla seleccionada
            String nombre = Tablaclientes.getValueAt(fila, 0).toString();
            String apellido = Tablaclientes.getValueAt(fila, 1).toString();
            String num = Tablaclientes.getValueAt(fila, 2).toString();
            String correo = Tablaclientes.getValueAt(fila, 4).toString();
            apellidoglobal=apellido;
                    
            // Recuperar idCliente usando el método
            int idCliente = obtenerIdCliente(nombre, apellido, num);

            if (idCliente == -1) {
                JOptionPane.showMessageDialog(null, "No se pudo encontrar el idCliente para el cliente seleccionado.");
                return;
            }

            // Realiza la acción que necesites con estos valores
            String nombrecompleto = nombre + " " + apellido;        
            System.out.println("Desdedatoscliente: " + nombrecompleto + " " + num + " " + correo);

            // Asignar valores a los campos de texto
            TxtNombrecompleto.setText(nombrecompleto);
            TxtCelular.setText(num);
            Txtmail.setText(correo);
            TxtIdcliente.setText(String.valueOf(idCliente));  // Asignar el idCliente al TxtIdcliente

            // Cerrar el JDialog de selección de cliente
            SeleccionClientes.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros. Error: " + e.toString());
    }
}
 
 public void llenardatoscliente(String Nombrecompleto, String numero, String mail) {
    java.awt.EventQueue.invokeLater(() -> {
        TxtNombrecompleto.setText(Nombrecompleto);          
        TxtCelular.setText(numero);
        Txtmail.setText(mail);
        System.out.println("Desde llenar datos: "+ Nombrecompleto +" " + numero + " " + mail);
    });
}

    private void generarNumeroPedido() {
    Conexion conex = new Conexion();
    String query = "SELECT MAX(NumPedido) FROM pedido";
    try (PreparedStatement pst = conex.getConnection().prepareStatement(query)) {
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int ultimoId = rs.getInt(1);
            Idpedido.setText(String.valueOf(ultimoId + 1));
        } else {
            Idpedido.setText("1"); // Primer pedido
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al generar el número de pedido: " + e.getMessage());
    }
}
    
   private void rellenarCombos(JComboBox<String> comboFrente, JComboBox<String> comboAtras, JComboBox<String> comboarillo) {
    // Limpiar los elementos actuales de los combos
    comboFrente.removeAllItems();
    comboAtras.removeAllItems();
    comboarillo.removeAllItems();
    
    // Obtener las pastas desde la base de datos
    Pedidoclass pastas = new Pedidoclass();
    List<Pedidoclass> pastasList = pastas.obtenerPastas();
    List<Pedidoclass> arrillosList = pastas.obtenerarilloList();

    // Rellenar ambos combos con los nombres de las pastas
    for (Pedidoclass pasta : pastasList) {
        comboFrente.addItem(pasta.getPastafrente());
        comboAtras.addItem(pasta.getPastafrente());
    }
    for (Pedidoclass arillor : arrillosList){
        comboarillo.addItem(arillor.getArillo());
        
    }
    
    comboAtras.setSelectedIndex(-1);
    comboFrente.setSelectedIndex(-1);
    comboarillo.setSelectedIndex(-1);
    
}
    
private void llenardatos() {
    Conexion conex = new Conexion();

    try {
        // Validar las fechas y horas antes de usarlas
        java.util.Date fechaEmisionUtil = Jdateemision.getDate();
        java.sql.Date fechaEmision = fechaEmisionUtil != null ? new java.sql.Date(fechaEmisionUtil.getTime()) : null;

        java.util.Date horaEmisionUtil = (java.util.Date) Horaemision.getValue();
        java.sql.Time horaEmision = horaEmisionUtil != null ? new java.sql.Time(horaEmisionUtil.getTime()) : null;

        java.util.Date fechaEntregaUtil = Jdatentrega.getDate();
        java.sql.Date fechaEntrega = fechaEntregaUtil != null ? new java.sql.Date(fechaEntregaUtil.getTime()) : null;

        java.util.Date horaEntregaUtil = (java.util.Date) Horaentrega.getValue();
        java.sql.Time horaEntrega = horaEntregaUtil != null ? new java.sql.Time(horaEntregaUtil.getTime()) : null;

        // Construir la consulta SQL
        String query = "INSERT INTO `copymax`.`pedido`(`NumPedido`, `idUsuario`, `Nombre_Usuario`, `idCliente`, `Nombre_Cliente`, " +
                       "`Apellidos_Cliente`, `CelularCliente`, `Servicio`, `TipoDeCopia`, `Tamaño`, `Escala`, `FechaEmision`, " +
                       "`HoraEmision`, `FechaEntrega`, `HoraEntrega`, `NumeroDePag`, `Frente`, `Atras`, `Arillo`, `Comentarios`, " +
                       "`Total`, `Anticipo`, `Resto`, `Status`,`Cantidad`,`CantidadCarta`,`CantidadOficio`, `Servicioextra`) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

        try (PreparedStatement pst = conex.getConnection().prepareStatement(query)) {
            // Establecer valores, manejando los posibles valores nulos
            pst.setInt(1, Integer.parseInt(Idpedido.getText()));
            pst.setInt(2, Usuariosesion.getInstance().getIdUsuario());
            pst.setString(3, Usuariosesion.getInstance().getNombrereal());
            pst.setInt(4, TxtIdcliente.getText().isEmpty() ? 0 : Integer.parseInt(TxtIdcliente.getText()));
            pst.setString(5, TxtNombrecompleto.getText());
            pst.setString(6, apellidoglobal != null ? apellidoglobal : "No");
            pst.setString(7, TxtCelular.getText().isEmpty() ? "No" : TxtCelular.getText());
            pst.setString(8, Comboservicio.getSelectedItem() != null ? Comboservicio.getSelectedItem().toString() : "No");

            // Validar y obtener el valor del ButtonGroup de TipoDeCopia
            pst.setString(9, Tipodecopiagroup.getSelection() != null ? Tipodecopiagroup.getSelection().getActionCommand() : "No");

            // Validar y obtener el valor del ButtonGroup de Amplireduccion
            pst.setString(11, Amplireducciongroup.getSelection() != null ? Amplireducciongroup.getSelection().getActionCommand() : "No");

            pst.setString(10, Combotamaño.getSelectedItem() != null ? Combotamaño.getSelectedItem().toString() : "No especificado");
            pst.setDate(12, fechaEmision);
            pst.setTime(13, horaEmision);
            pst.setDate(14, fechaEntrega);
            pst.setTime(15, horaEntrega);
            pst.setInt(16, Txtnumpaginas.getText().isEmpty() ? 0 : Integer.parseInt(Txtnumpaginas.getText()));
            pst.setString(17, Combofrente.getSelectedItem() != null ? Combofrente.getSelectedItem().toString() : "No");
            pst.setString(18, Comboatras.getSelectedItem() != null ? Comboatras.getSelectedItem().toString() : "No");
            pst.setString(19, Comboarillo.getSelectedItem() != null ? Comboarillo.getSelectedItem().toString() : "No");
            pst.setString(20, Txtcomentarios.getText().isEmpty() ? "No especificado" : Txtcomentarios.getText());
            pst.setDouble(21, Txttotal.getText().isEmpty() ? 0.0 : Double.parseDouble(Txttotal.getText()));
            pst.setDouble(22, Txtanticipo.getText().isEmpty() ? 0.0 : Double.parseDouble(Txtanticipo.getText()));
            pst.setDouble(23, Txtresto.getText().isEmpty() ? 0.0 : Double.parseDouble(Txtresto.getText()));
            pst.setString(24, "Pendiente");
            pst.setInt(25, Txtcantidad.getText().isEmpty() ? 0 : Integer.parseInt(Txtcantidad.getText()));
            pst.setInt(26, txtcartacantidad.getText().isEmpty() ? 0 : Integer.parseInt(txtcartacantidad.getText()));
            pst.setInt(27, txtoficiocantidad.getText().isEmpty() ? 0 : Integer.parseInt(txtoficiocantidad.getText()));
            pst.setString(28, Serviciogroup.getSelection() != null ? Serviciogroup.getSelection().getActionCommand() : "No");

            // Ejecutar la consulta
            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(rootPane, "¡Pedido insertado exitosamente!");
                dispose();
            } else {
                System.out.println("No se pudo insertar el pedido.");
            }
        }
    } catch (Exception e) {
        // Manejo del error
        e.printStackTrace();
    }
}

private void configurarCálculoAutomático() {
    // Listener para el ComboBox de Tipo de Servicio
    Comboservicio.addActionListener(e -> calcularHojas());

    // Listeners para los JTextField de cantidad
    agregarListenerengargolado(txtcartacantidad);
    agregarListenerengargolado(txtoficiocantidad);

    // Listener para los radio buttons
    for (Enumeration<AbstractButton> buttons = Unladogroup.getElements(); buttons.hasMoreElements();) {
        buttons.nextElement().addActionListener(e -> calcularHojas());
    }
    for (Enumeration<AbstractButton> buttons = Ambosladosgroup.getElements(); buttons.hasMoreElements();) {
        buttons.nextElement().addActionListener(e -> calcularHojas());
    }
}

private void calcularHojas() {
    if (isUpdating) return; // Salir si ya se está actualizando
    isUpdating = true;

    try {
        // Verificar si el tipo de servicio es "Engargolados"
        String tipoServicio = Comboservicio.getSelectedItem() != null ? Comboservicio.getSelectedItem().toString() : "";
        if (!tipoServicio.equals("Engargolados")) {
            Txtnumpaginas.setText(""); // Limpiar si no es Engargolados
            return;
        }

        // Leer las cantidades de carta y oficio
        double cantidadCarta = obtenervalornum(txtcartacantidad);
        double cantidadOficio = obtenervalornum(txtoficiocantidad);

        // Determinar la cantidad total de páginas según el tamaño
        double cantidadTotal = Math.max(cantidadCarta, cantidadOficio); // Elegir el valor válido
        if (cantidadTotal == 0) {
            Txtnumpaginas.setText(""); // Limpiar si no hay cantidad válida
            return;
        }

        // Verificar qué botón del grupo está seleccionado
        if (Unladogroup.getSelection() != null) {
            String actionCommand = Unladogroup.getSelection().getActionCommand();
            if ("CARTA".equals(actionCommand) || "OFICIO".equals(actionCommand)) {
                // Si es un solo lado, la cantidad es la misma
                Txtnumpaginas.setText(String.valueOf((int) cantidadTotal));
                return;
            }
        }
        if (Ambosladosgroup.getSelection() != null) {
            String actionCommand = Ambosladosgroup.getSelection().getActionCommand();
            if ("CARTA".equals(actionCommand) || "OFICIO".equals(actionCommand)) {
                // Si son ambos lados, dividir entre 2 (redondeando hacia arriba)
                int hojasAmbosLados = (int) Math.ceil(cantidadTotal / 2);
                Txtnumpaginas.setText(String.valueOf(hojasAmbosLados));
                return;
            }
        }
    } catch (NumberFormatException e) {
        Txtnumpaginas.setText(""); // Limpiar en caso de error
    } finally {
        isUpdating = false; // Restablecer la bandera
    }
}

// Método para obtener un valor numérico de un JTextField
private double obtenervalornum(JTextField textField) {
    String texto = textField.getText().trim();
    if (texto.isEmpty()) {
        return 0; // Considerar vacío como 0
    }
    try {
        return Double.parseDouble(texto);
    } catch (NumberFormatException e) {
        return 0; // Si no es un número válido, devolver 0
    }
}

// Método para agregar listeners a los JTextField
private void agregarListenerengargolado(JTextField textField) {
    textField.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            calcularHojas();
            seleccionarArillo();
            
            
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            calcularHojas();
            seleccionarArillo();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            calcularHojas();
            seleccionarArillo();
        }
    });
}

private void seleccionarArillo() {
    try {
        // Verificar si Txtnumpaginas está vacío antes de intentar leer su valor
        String textoNumpaginas = Txtnumpaginas.getText().trim();
        if (textoNumpaginas.isEmpty()) {
            return; // No hacer nada si el campo está vacío
        }

        // Leer el número de hojas del campo Txtnumpaginas
        int numHojas = Integer.parseInt(textoNumpaginas);

        // Determinar el arillo adecuado según el número de hojas
        String arilloRecomendado = obtenerArilloAdecuado(numHojas);

        if (arilloRecomendado == null) {
            JOptionPane.showMessageDialog(null, "El número de hojas excede la capacidad máxima de los arillos disponibles.", 
                                          "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Seleccionar automáticamente el arillo recomendado en Comboarillo
        Comboarillo.setSelectedItem(arilloRecomendado);
    } catch (NumberFormatException e) {
        // Si el valor no es válido o está en medio de una entrada, no mostrar el error
        // Evitar bloquear la interacción del usuario
    }
}

private String obtenerArilloAdecuado(int numHojas) {
    // Tabla de capacidades y tamaños
    String[] tamaños = {"# 4", "# 6", "# 8", "# 10", "# 12", "# 14", "# 16", "# 20", "# 22", "# 24"};
    int[] capacidades = {  33,    74,   110,    140,    160,    190,    220,    250,    340,    440};

    for (int i = 0; i < capacidades.length; i++) {
        if (numHojas <= capacidades[i]) {
            return tamaños[i];
        }
    }
    return null; // Si el número de hojas excede la capacidad máxima
}

private void validarSeleccionArillo() {
    try {
        // Leer el número de hojas del campo Txtnumpaginas
        String textoNumpaginas = Txtnumpaginas.getText().trim();
        if (textoNumpaginas.isEmpty()) {
            return; // No hacer nada si el campo está vacío
        }

        int numHojas = Integer.parseInt(textoNumpaginas);
        String arilloSeleccionado = (String) Comboarillo.getSelectedItem();

        // Obtener la capacidad del arillo seleccionado
        int capacidadSeleccionada = obtenerCapacidadPorTamaño(arilloSeleccionado);

        // Obtener el arillo recomendado según el número de hojas
        String arilloRecomendado = obtenerArilloAdecuado(numHojas);

        // Si el arillo seleccionado no es adecuado, mostrar advertencia y devolver al recomendado
        if (numHojas > capacidadSeleccionada) {
            JOptionPane.showMessageDialog(null, 
                "El arillo seleccionado no soporta la cantidad de hojas. Se cambiará al arillo recomendado: " + arilloRecomendado, 
                "Advertencia", JOptionPane.WARNING_MESSAGE);
            
            // Cambiar automáticamente al arillo recomendado
            Comboarillo.setSelectedItem(arilloRecomendado);
        }
    } catch (NumberFormatException e) {
        // Manejar excepciones de formato si el texto no es un número válido
        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido de páginas.", 
                                      "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private int obtenerCapacidadPorTamaño(String tamaño) {
    // Tabla de capacidades y tamaños
    String[] tamaños = {"# 4", "# 6", "# 8", "# 10", "# 12", "# 14", "# 16", "# 20", "# 22", "# 24"};
    int[] capacidades = {33,      74,   110,    140,    160,    190,    220,    250,    340,    440};

    for (int i = 0; i < tamaños.length; i++) {
        if (tamaños[i].equals(tamaño)) {
            return capacidades[i];
        }
    }
    return 0; // Si el tamaño no coincide con la tabla
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
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GenerarPedido generarPedido = new GenerarPedido();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Ambosladosgroup;
    private javax.swing.ButtonGroup Amplireducciongroup;
    private javax.swing.JComboBox<String> Comboarillo;
    private javax.swing.JComboBox<String> Comboatras;
    private javax.swing.JComboBox<String> Combofrente;
    private javax.swing.JComboBox<String> Comboservicio;
    private javax.swing.JComboBox<String> Combotamaño;
    private javax.swing.JButton Generarpedidobtn;
    private javax.swing.JSpinner Horaemision;
    private javax.swing.JSpinner Horaentrega;
    private javax.swing.JTextField Idpedido;
    private com.toedter.calendar.JDateChooser Jdateemision;
    private com.toedter.calendar.JDateChooser Jdatentrega;
    private javax.swing.JButton Limpiarbtn;
    private javax.swing.JRadioButton RBambosladoscarta;
    private javax.swing.JRadioButton RBampliacion;
    private javax.swing.JRadioButton RBcdospaginasenunahoja;
    private javax.swing.JRadioButton RBcentrar;
    private javax.swing.JRadioButton RBengrapadas;
    private javax.swing.JRadioButton RBrecortadas;
    private javax.swing.JRadioButton RBreduccion;
    private javax.swing.JRadioButton RBtalcomoesta;
    private javax.swing.JRadioButton RBtambosladosoficio;
    private javax.swing.JRadioButton RBunsololadocarta;
    private javax.swing.JRadioButton RBunsololadooficio;
    private javax.swing.JDialog SeleccionClientes;
    private javax.swing.ButtonGroup Serviciogroup;
    private javax.swing.JTable Tablaclientes;
    private javax.swing.ButtonGroup Tipodecopiagroup;
    private javax.swing.JTextField TxtCelular;
    private javax.swing.JTextField TxtIdcliente;
    private javax.swing.JTextField TxtNombrecompleto;
    private javax.swing.JTextField Txtanticipo;
    private javax.swing.JTextField Txtcantidad;
    private javax.swing.JTextArea Txtcomentarios;
    private javax.swing.JTextField Txtmail;
    private javax.swing.JTextField Txtnumpaginas;
    private javax.swing.JTextField Txtresto;
    private javax.swing.JTextField Txttotal;
    private javax.swing.ButtonGroup Unladogroup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblusuario;
    private javax.swing.JPanel panelseleccion;
    private javax.swing.JTextField txtcartacantidad;
    private javax.swing.JTextField txtoficiocantidad;
    private javax.swing.JTextField txtregclicelularbusqueda;
    // End of variables declaration//GEN-END:variables
}
