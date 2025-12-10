/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Conexion.Conexion;
import Modelo.ComponenteProducto;
import Modelo.FabricaProducto;
import Modelo.FabricaProductoConcreto;
import Modelo.Productoclass;
import Vista.Metododepago;
import Modelo.Productosprecios;
import Modelo.Usuariosesion;
import Modelo.Venta;
import Modelo.Numeroseditor;
import Modelo.PaqueteDeProductos;
import Modelo.Producto;
import Modelo.ServicioProductos;
import Vista.Agregarproductos;
import java.sql.ResultSet;
import Vista.Clientesticket;
import com.sun.jdi.connect.spi.Connection;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import Modelo.StockObserver;
import Modelo.DetalleVenta;


/**
 *
 * @author maxst
 */
public class Ventas extends javax.swing.JPanel {
    
    private static Ventas instance;
    private DefaultTableModel modelo;
    private Venta ventadatos;
    public double total = 0.0;
    private double subtotalOriginal = 0.0;
    private double porcentajeDescuento = 0;
    private double porcentajeIVA = 16;
    private double contaventas;
    String clienteactual="General";
    private JPanel productosPanel = new JPanel();
    
    
    
    //OBSERVER INICIO
     private List<StockObserver> observadores = new ArrayList<>();
    
    public void agregarObservador(StockObserver observer) {
        observadores.add(observer);
    }

    public void notificarVenta() {
        for (StockObserver o : observadores) {
            o.actualizarStock();
        }
    }
    //OBSERVER FINAL
    
    
     public static Ventas getInstance() {
        if (instance == null) {
            instance = new Ventas();
        }
        return instance;
    }
    
      
    
    public Ventas() {
      
        initComponents();
       // agregarKeyListenerstock();                //  DESACTIVADO POR EL MOMENTO
        setLayout(new BorderLayout());
        
        cargarProductos();
        addTableModelListener();
        addDeleteRowListener();
        ajustarInterfazSegunRol(Usuariosesion.getInstance().getRol());
        agregarKeyListenerGlobal();
        inicializardatos();
        ventadatos= new Venta();
        ventadatos.setUsuario(Usuariosesion.getInstance().getNombrereal());
       
        if (clienteactual.equals("General")){
         ventadatos.setCliente(clienteactual);
        }
       
    }
    
    private void inicializardatos(){
    
        lblusuarioactual.setText("Le atiende: " + Usuariosesion.getInstance().getNombrereal());
        txtsubtotal.setText(" 0.00");
        txtdescuento.setText(" 0.00");
        txtimpuesto.setText(" 0.00");
        txtTotal.setText(" 0.00");
        
    }
    
    public void actualizarDatosUsuario() {
        ventadatos.setUsuario(Usuariosesion.getInstance().getNombrereal());
        inicializardatos();
    }

    private void agregarKeyListenerGlobal() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_F5) {
                    //validarexistencias();
                    cobro();
                }
                
                return false;
            }
        });
    }
    
   
    
    
     private void agregarKeyListenerstock() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_F12) {
                    
                    Agregarproductos agregar = new Agregarproductos();
                    agregar.setVisible(true);
                    
                }
                
                return false;
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        Ticket = new javax.swing.JPanel();
        Cuenta = new javax.swing.JPanel();
        txtsubtotal = new javax.swing.JTextField();
        Labelsubtotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LabelTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Labeldescuento = new javax.swing.JLabel();
        txtdescuento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Jcheckdescuento = new javax.swing.JCheckBox();
        Jcheckimpuesto = new javax.swing.JCheckBox();
        txtimpuesto = new javax.swing.JTextField();
        BtnVenta = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableticket = new javax.swing.JTable();
        lblusuarioactual = new javax.swing.JLabel();
        Btnclientesseleccion = new javax.swing.JButton();
        lblcliente = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Btnformarpaquete = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setBackground(new java.awt.Color(255, 255, 255));

        Ticket.setBackground(new java.awt.Color(255, 255, 255));
        Ticket.setEnabled(false);
        Ticket.setPreferredSize(new java.awt.Dimension(370, 520));
        Ticket.setVerifyInputWhenFocusTarget(false);

        Cuenta.setBackground(new java.awt.Color(204, 204, 204));

        txtsubtotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtsubtotal.setEnabled(false);

        Labelsubtotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Labelsubtotal.setText("SUBTOTAL:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("MXN");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("MXN");

        LabelTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelTotal.setText("TOTAL:");

        txtTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtTotal.setEnabled(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("MXN");

        Labeldescuento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        txtdescuento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtdescuento.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("MXN");

        Jcheckdescuento.setBackground(new java.awt.Color(204, 204, 204));
        Jcheckdescuento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Jcheckdescuento.setText("DESCUENTO:");
        Jcheckdescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcheckdescuentoActionPerformed(evt);
            }
        });

        Jcheckimpuesto.setBackground(new java.awt.Color(204, 204, 204));
        Jcheckimpuesto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Jcheckimpuesto.setText("IMPUESTO:");
        Jcheckimpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcheckimpuestoActionPerformed(evt);
            }
        });

        txtimpuesto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtimpuesto.setEnabled(false);

        BtnVenta.setBackground(new java.awt.Color(204, 255, 255));
        BtnVenta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BtnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/marketing-directo (Custom).png"))); // NOI18N
        BtnVenta.setText("Venta");
        BtnVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CuentaLayout = new javax.swing.GroupLayout(Cuenta);
        Cuenta.setLayout(CuentaLayout);
        CuentaLayout.setHorizontalGroup(
            CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CuentaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(BtnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CuentaLayout.createSequentialGroup()
                            .addComponent(Labelsubtotal)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CuentaLayout.createSequentialGroup()
                            .addComponent(Jcheckdescuento)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CuentaLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CuentaLayout.createSequentialGroup()
                                .addComponent(LabelTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CuentaLayout.createSequentialGroup()
                                .addComponent(Jcheckimpuesto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtimpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))))
                .addGap(12, 12, 12)
                .addComponent(Labeldescuento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CuentaLayout.setVerticalGroup(
            CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CuentaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CuentaLayout.createSequentialGroup()
                        .addComponent(Labeldescuento)
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CuentaLayout.createSequentialGroup()
                        .addGroup(CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(CuentaLayout.createSequentialGroup()
                                .addGroup(CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Labelsubtotal)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(Jcheckdescuento)
                                    .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(Jcheckimpuesto)
                                    .addComponent(txtimpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(BtnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(CuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelTotal)
                            .addComponent(jLabel6))
                        .addContainerGap())))
        );

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 102, 255));
        jLabel9.setText("COPYMAX");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jTableticket.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableticket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Cantidad", "Producto", "P.Unitario", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableticket.setRowHeight(20);
        jTableticket.setRowSelectionAllowed(false);
        jTableticket.setSelectionBackground(new java.awt.Color(153, 204, 255));
        jTableticket.setShowGrid(true);
        modelo = new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Producto", "P.Unitario", "Total","ID"
            }
        ) {
            // Tus tipos de datos (agregamos Integer para el ID)
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false // El ID no debe ser editable
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };

        jTableticket.setModel(modelo);

        jTableticket.getColumnModel().getColumn(4).setMinWidth(0);
        jTableticket.getColumnModel().getColumn(4).setMaxWidth(0);
        jTableticket.getColumnModel().getColumn(4).setWidth(0);
        jScrollPane1.setViewportView(jTableticket);
        if (jTableticket.getColumnModel().getColumnCount() > 0) {
            jTableticket.getColumnModel().getColumn(0).setMinWidth(60);
            jTableticket.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableticket.getColumnModel().getColumn(0).setMaxWidth(78);
            jTableticket.getColumnModel().getColumn(1).setResizable(false);
            jTableticket.getColumnModel().getColumn(2).setMinWidth(60);
            jTableticket.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTableticket.getColumnModel().getColumn(2).setMaxWidth(70);
            jTableticket.getColumnModel().getColumn(3).setMinWidth(50);
            jTableticket.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTableticket.getColumnModel().getColumn(3).setMaxWidth(65);
        }
        jTableticket.getColumnModel().getColumn(0).setCellEditor(new Numeroseditor());

        jTableticket.setRowHeight(30);

        lblusuarioactual.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblusuarioactual.setText("Usuario:");

        Btnclientesseleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reclutamiento.png"))); // NOI18N
        Btnclientesseleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnclientesseleccionActionPerformed(evt);
            }
        });

        lblcliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblcliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblcliente.setText("Cliente: General");
        lblcliente.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logopng (Custom) (1).png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(240, 240, 240));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Btnformarpaquete.setBackground(new java.awt.Color(255, 255, 255));
        Btnformarpaquete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas (Custom) (Custom).png"))); // NOI18N
        Btnformarpaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnformarpaqueteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TicketLayout = new javax.swing.GroupLayout(Ticket);
        Ticket.setLayout(TicketLayout);
        TicketLayout.setHorizontalGroup(
            TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TicketLayout.createSequentialGroup()
                        .addComponent(lblusuarioactual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(TicketLayout.createSequentialGroup()
                        .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(Cuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(TicketLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btnclientesseleccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btnformarpaquete)
                        .addGap(15, 15, 15))))
        );
        TicketLayout.setVerticalGroup(
            TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicketLayout.createSequentialGroup()
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(TicketLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(TicketLayout.createSequentialGroup()
                                .addComponent(Btnclientesseleccion)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TicketLayout.createSequentialGroup()
                                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Btnformarpaquete, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcliente)
                            .addComponent(lblusuarioactual)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TicketLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 29, Short.MAX_VALUE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(440, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Ticket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
 * Aplica un descuento al total basado en un porcentaje especificado.
 * Calcula el valor del descuento y lo resta del total, luego actualiza los campos de texto correspondientes.
 */
private void aplicarDescuento() {
    double descuentoTotal = subtotalOriginal * (porcentajeDescuento / 100.0);
    total -= descuentoTotal;
    txtdescuento.setText(String.format("%.2f", descuentoTotal));
    txtTotal.setText(String.format("%.2f", total));
}

/**
 * Revierte un descuento previamente aplicado al total.
 * Restaura el valor original del total antes del descuento y actualiza el campo de descuento a 0.00.
 */
private void revertirDescuento() {
    double descuentoTotal = subtotalOriginal * (porcentajeDescuento / 100.0);
    total += descuentoTotal;
    txtdescuento.setText("0.00");
}

/**
 * Aplica el IVA al total basado en un porcentaje especificado.
 * Calcula el valor del IVA y lo suma al total, luego actualiza los campos de texto correspondientes.
 */
private void aplicarIVA() {
    double ivaTotal = subtotalOriginal * (porcentajeIVA / 100.0);
    total += ivaTotal;
    txtimpuesto.setText(String.format("%.2f", ivaTotal));
    txtTotal.setText(String.format("%.2f", total));
}

/**
 * Revierte el IVA previamente aplicado al total.
 * Restaura el valor original del total antes del IVA y actualiza el campo de impuesto a 0.00.
 */
private void revertirIVA() {
    double ivaTotal = subtotalOriginal * (porcentajeIVA / 100.0);
    total -= ivaTotal;
    txtimpuesto.setText("0.00");
}

/**
 * Maneja el evento de acción del checkbox de descuento.
 * Solicita al usuario ingresar un porcentaje de descuento, valida el valor y aplica o revierte el descuento según corresponda.
 */
    private void JcheckdescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcheckdescuentoActionPerformed
        
      if (Jcheckdescuento.isSelected()) {
        String input = JOptionPane.showInputDialog(this, "Ingrese el porcentaje de descuento (1-100):");
        try {
            int descuento = Integer.parseInt(input);
            if (descuento < 1 || descuento > 100) {
                JOptionPane.showMessageDialog(this, "Porcentaje de descuento debe estar entre 1 y 100.");
                Jcheckdescuento.setSelected(false);
                return;
            }
            porcentajeDescuento = descuento;
            aplicarDescuento();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Entrada no válida. Por favor ingrese un número.");
            Jcheckdescuento.setSelected(false);
        }
    } else {
        revertirDescuento();
        porcentajeDescuento = 0;
        txtTotal.setText(String.format("%.2f", total));
    }
    }//GEN-LAST:event_JcheckdescuentoActionPerformed
/**
 * Maneja el evento de acción del checkbox de impuesto.
 * Aplica o revierte el IVA según el estado del checkbox de IVA.
 */
    private void JcheckimpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcheckimpuestoActionPerformed
           if (Jcheckimpuesto.isSelected()) {
        aplicarIVA();
    } else {
        revertirIVA();
        txtTotal.setText(String.format("%.2f", total));
    }
    }//GEN-LAST:event_JcheckimpuestoActionPerformed
/**
 * Realiza el proceso de cobro al ejecutar una venta.
 * Recalcula y muestra el ticket en el JTable. Valida que haya productos en la tabla antes de proceder al cobro.
 */
    private void BtnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVentaActionPerformed
       
    cobro(); 
    
    System.out.println(obtenerItemsDeJTable());
        notificarVenta(); // 🔔 Aquí notificas a los observadores

    
    
    }//GEN-LAST:event_BtnVentaActionPerformed
    public void ActualizarinventarioBd() {
    int filas = modelo.getRowCount();
    Conexion conex = new Conexion();

    try {
        // Iniciar una transacción
        conex.getConnection().setAutoCommit(false);

        for (int i = 0; i < filas; i++) {
            String nombreProducto = (String) modelo.getValueAt(i, 1);
            int cantidadVendida = Integer.parseInt(modelo.getValueAt(i, 0).toString());

            // Actualizar la cantidad del producto en la base de datos
            String consulta = "UPDATE Productos SET cantidad = Cantidad - ? WHERE Nombre_producto = ?";
            try (PreparedStatement pst = conex.getConnection().prepareStatement(consulta)) {
                pst.setInt(1, cantidadVendida);
                pst.setString(2, nombreProducto);
                pst.executeUpdate();
            }
        }

        // Confirmar la transacción
        conex.getConnection().commit();
        notificarVenta(); //notifiicar la venta del observer
        
        
        JOptionPane.showMessageDialog(null, "Venta guardada y stock actualizado correctamente.");
    } catch (SQLException e) {
        try {
            // Revertir la transacción en caso de error
            conex.getConnection().rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Error al guardar la venta: " + e.toString());
    } finally {
        try {
            // Restaurar el modo de autocommit
            conex.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
  /**
 * Obtiene los datos de la venta actual en un objeto Venta.
 * Incluye los ítems del ticket, subtotal, descuento, impuesto, y total.
 * @return Un objeto Venta con los datos de la venta.
 */  
    public Venta getVentadatos(){
        ventadatos.setItems(obtenerItemsDeJTable());
        ventadatos.setSubtotal(subtotalOriginal);
        ventadatos.setDescuento(Double.valueOf(txtdescuento.getText()));
        ventadatos.setImpuesto(Double.valueOf(txtimpuesto.getText()));
        ventadatos.setTotal(total);
        return ventadatos;
                   
    }
   
/**
 * Realiza el proceso de cobro.
 * Verifica que haya productos en el ticket antes de abrir la ventana de métodos de pago.
 */
    
private void cobro() {
    ServicioProductos servicio = new ServicioProductos();
    FabricaProducto fabrica = new FabricaProductoConcreto();
    List<Producto> productos = servicio.obtenerProductosDesdeFabrica(fabrica);

    if (!validarStockEnTicket(productos)) {
        return;
    }
    jTableticket.repaint();
    jTableticket.revalidate();
    if (jTableticket.getRowCount() == 0) {
        JOptionPane.showMessageDialog(null, "Agregue un producto a la venta");
    } else {
        abrirMetodoPagoFrame();
    }
}    
    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
       JOptionPane.showMessageDialog(this, "Ventas del día: " + contaventas);
 
    }//GEN-LAST:event_jLabel9MouseClicked

    private void BtnclientesseleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnclientesseleccionActionPerformed
        Clientesticket clientesticket = new Clientesticket();
        clientesticket.setContexto("Ventas");
        clientesticket.setVisible(true);
        
    }//GEN-LAST:event_BtnclientesseleccionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RegistroClientes ventanaRegistroClientes = new RegistroClientes();
        ventanaRegistroClientes.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnformarpaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnformarpaqueteActionPerformed
        // Solicitar el nombre del paquete
        String nombrePaquete = JOptionPane.showInputDialog(this, "Ingrese el nombre del paquete:", "Crear Paquete", JOptionPane.PLAIN_MESSAGE);

        if (nombrePaquete == null || nombrePaquete.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre del paquete no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Calcular el total de todas las filas
        double total = calcularTotalTabla();

        // Crear el paquete (usando el patrón Composite)
        PaqueteDeProductos paquete = new PaqueteDeProductos(nombrePaquete);

        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) jTableticket.getModel();

        // Recorrer todas las filas para agregar los productos al paquete
        for (int i = 0; i < model.getRowCount(); i++) {
            Object valor = model.getValueAt(i, 1); // Columna 1: Descripción del producto
            if (valor instanceof ComponenteProducto) {
                ComponenteProducto producto = (ComponenteProducto) valor;
                paquete.agregarProducto(producto);
            }
        }

        // Limpiar la tabla
        limpiarTabla();

        int idPaqueteGenerico = 0; // O el ID que decidas usar para items que no son productos individuales

        Object[] nuevaFila = {
            1,              // Cantidad
            nombrePaquete,  // Descripción
            total,          // Precio Unitario
            total,          // Total
            idPaqueteGenerico // <--- AGREGAMOS LA 5ta COLUMNA (ID OCULTO)
        }; 

        model.addRow(nuevaFila);
        // Actualizar la tabla

    }//GEN-LAST:event_BtnformarpaqueteActionPerformed

    private double calcularTotalTabla() {
    DefaultTableModel model = (DefaultTableModel) jTableticket.getModel();
    double total = 0;

    for (int i = 0; i < model.getRowCount(); i++) {
        // Obtener el valor de la columna que contiene el total (ajusta el índice de la columna)
        Object valor = model.getValueAt(i, 3); // Columna 3: Total
        if (valor instanceof Double) {
            total += (Double) valor;
        }
    }

    return total;
}
    
     private void limpiarTabla() {
    DefaultTableModel model = (DefaultTableModel) jTableticket.getModel();
    model.setRowCount(0); // Eliminar todas las filas
}
    
   private void abrirMetodoPagoFrame() {
        double totalVenta = obtenerTotalVentaActual(); // Obtener el total de la venta actual
        Metododepago  metodoPagoFrame = new Metododepago(totalVenta,this);
        metodoPagoFrame.setVisible(true);
    }
   
    private double obtenerTotalVentaActual() { 
        contaventas +=total;
        
     
        return total;
    }
    
   
    
   public void cargarProductos() {
          
    Conexion conexion = new Conexion();
    List<Productosprecios> productos = conexion.obtenerProductos();
    
    // Crear un nuevo panel para los productos
    
    productosPanel.setLayout(new GridLayout(0, 2)); // Cambiar a GridLayout para una mejor organización

    for (Productosprecios producto : productos) {
        JButton botonProducto = new JButton("<html>" + producto.getNombre() + "<br>MXN $ " + producto.getPrecio() + "</html>");
           System.out.println("pro: "+producto.getNombre());
        String iconoPath = "/Iconosproductos/" + producto.getDireccionicon();
        if (iconoPath != null && !iconoPath.isEmpty()) {
            try {
                ImageIcon icono = new ImageIcon(getClass().getResource(iconoPath));
                botonProducto.setIcon(icono);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("No se pudo cargar el ícono para: " + producto.getNombre());
            }
        }

        botonProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProductoAlTicket(producto);
            }
        });
        
        botonProducto.setPreferredSize(new Dimension(200, 100)); // Ajusta la altura según sea necesario
        productosPanel.add(botonProducto);
    }

    // Crear JScrollPane que envuelve el panel Productos
    JScrollPane scrollPane = new JScrollPane(productosPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setPreferredSize(new Dimension(430, 500)); // Fijar el tamaño del JScrollPane

    // Asegurar que el JScrollPane reemplace el componente actual en el contenedor padre
    setLayout(new BorderLayout());
    add(Ticket, BorderLayout.WEST); // Mantener el panel de Ticket visible
    add(scrollPane, BorderLayout.CENTER); // Agregar el JScrollPane con los productos

    revalidate();
    repaint();
    
}
   
   

   public void cargarProductos(String filtro) {
    productosPanel.removeAll(); // Elimina todos los componentes del panel de productos

    // Obtener productos con el filtro aplicado
    Conexion conexion = new Conexion();
    List<Productosprecios> productos = conexion.obtenerProductos(filtro);

    for (Productosprecios producto : productos) {
        JButton botonProducto = new JButton("<html>" + producto.getNombre() + "<br>MXN $ " + producto.getPrecio() + "</html>");

        String iconoPath = "/Iconosproductos/" + producto.getDireccionicon();
        if (iconoPath != null && !iconoPath.isEmpty()) {
            try {
                ImageIcon icono = new ImageIcon(getClass().getResource(iconoPath));
                botonProducto.setIcon(icono);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("No se pudo cargar el ícono para: " + producto.getNombre());
            }
        }

        botonProducto.addActionListener(e -> agregarProductoAlTicket(producto));

        // Establecer el tamaño preferido del botón
        botonProducto.setPreferredSize(new Dimension(200, 100)); // Ajusta la altura según sea necesario

        productosPanel.add(botonProducto);
    }

    productosPanel.revalidate();
    productosPanel.repaint();
}

    
public void agregarProductoAlTicket(Productosprecios producto) {
    
      
    boolean productoExistente = false;
    
    int filas = modelo.getRowCount();
    
    // Buscar si el producto ya está en el ticket
    for (int i = 0; i < filas; i++) {
        String nombreProducto = (String) modelo.getValueAt(i, 1);
        if (nombreProducto.equals(producto.getNombre())) {
            // Producto ya está en el ticket, incrementar la cantidad
            int cantidadActual = (int) modelo.getValueAt(i, 0);
            cantidadActual++;
            modelo.setValueAt(cantidadActual, i, 0);

            // Actualizar el total del producto
            double precioProducto = (double) modelo.getValueAt(i, 2);
            double totalProducto = cantidadActual * precioProducto;
            modelo.setValueAt(totalProducto, i, 3);
            
            productoExistente = true;
            break;
        }
    }
    
    // Si el producto no existe, agregar una nueva fila
    if (!productoExistente) {
        int cantidad = 1;
        double totalProducto = cantidad * producto.getPrecio();
        
        // CAMBIO: Ahora el array es de 5 posiciones, no 4
        Object[] fila = new Object[5]; 
        
        fila[0] = cantidad;
        fila[1] = producto.getNombre();
        fila[2] = producto.getPrecio();
        fila[3] = totalProducto;
        System.out.println("Agregando producto ID: " + producto.getId());
        // CAMBIO: Aquí guardamos el ID
        // Asegúrate que tu clase producto tenga .getId()
        fila[4] = producto.getId(); 
        
        modelo.addRow(fila);
    }
    
    // Actualizar el subtotal y el total
    recalcularTotales();
} 
   
// Método para validar que las cantidades en el ticket no excedan el stock disponible
public boolean validarStockEnTicket(List<Producto> productos) {
    int filas = modelo.getRowCount();
    boolean stockValido = true;

    for (int i = 0; i < filas; i++) {
        String nombreProductoTicket = (String) modelo.getValueAt(i, 1);
        int cantidadSolicitada;

        try {
            cantidadSolicitada = Integer.parseInt(modelo.getValueAt(i, 0).toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                "La cantidad en la fila " + (i + 1) + " no es un número válido.", 
                "Error de Formato", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombreProductoTicket)) {
                int stockActual = producto.getCantidad();
                
                // 1. Si la cantidad excede el stock, ajustar al máximo disponible
                if (cantidadSolicitada > stockActual) {
                    modelo.setValueAt(stockActual, i, 0); // Ajusta a la cantidad máxima disponible
                    JOptionPane.showMessageDialog(null, 
                        "Cantidad ajustada. Solo hay " + stockActual + " unidades de '" + nombreProductoTicket + "'", 
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                    cantidadSolicitada = stockActual; // Actualizamos la variable para las validaciones
                }
                
                // 2. Alertas de estado de stock (solo si hay al menos 1 unidad)
                if (stockActual > 0) {
                    if (stockActual >= 1 && stockActual <= 9) {
                        JOptionPane.showMessageDialog(null, 
                            "¡STOCK BAJO! '" + nombreProductoTicket + "' tiene solo " + stockActual + " unidades.",
                            "Alerta", JOptionPane.WARNING_MESSAGE);
                    } 
                    else if (stockActual >= 10 && stockActual <= 20) {
                        JOptionPane.showMessageDialog(null, 
                            "¡STOCK CRÍTICO! '" + nombreProductoTicket + "' tiene " + stockActual + " unidades.",
                            "Alerta", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    }
    return stockValido;
}
    
    public void agregarProductoAlTicketstocl(Productoclass producto) {
    boolean productoExistente = false;
    int filas = modelo.getRowCount();
    
    // Buscar si el producto ya está en el ticket
    for (int i = 0; i < filas; i++) {
        String nombreProducto = (String) modelo.getValueAt(i, 1);
        if (nombreProducto.equals(producto.getNombre())) {
            // Producto ya está en el ticket, incrementar la cantidad
            int cantidadActual = (int) modelo.getValueAt(i, 0);
            cantidadActual++;
            modelo.setValueAt(cantidadActual, i, 0);

            // Actualizar el total del producto
            double precioProducto = (double) modelo.getValueAt(i, 2);
            double totalProducto = cantidadActual * precioProducto;
            modelo.setValueAt(totalProducto, i, 3);
            
            productoExistente = true;
            break;
        }
    }
    
    
    if (!productoExistente) {
        int cantidad = 1;
        double totalProducto = cantidad * producto.getPrecio();
        
        // --- CORRECCIÓN AQUÍ ---
        Object[] fila = new Object[5]; // Cambiamos de 4 a 5
        fila[0] = cantidad;
        fila[1] = producto.getNombre();
        fila[2] = producto.getPrecio();
        fila[3] = totalProducto;
        fila[4] = producto.getId(); // <--- AGREGAMOS EL ID
        
        modelo.addRow(fila);
    }
    recalcularTotales();
}

   
   
    private void recalcularTotales() {
    subtotalOriginal = 0;
    int filas = modelo.getRowCount();
    for (int i = 0; i < filas; i++) {
        double totalProducto = (double) modelo.getValueAt(i, 3);
        subtotalOriginal += totalProducto;
    }
    total = subtotalOriginal;  // Inicialmente, el total es el subtotal
    txtsubtotal.setText(String.format("%.2f", subtotalOriginal));
    actualizarTotal();
    }
    
    public void limpiarentradas(){
        modelo.setRowCount(0);
        txtTotal.setText("");
        txtdescuento.setText("");
        txtimpuesto.setText("");
        txtTotal.setText("");
        txtsubtotal.setText("");
        subtotalOriginal=0.0;
        txtsubtotal.setText("0.00");
        txtdescuento.setText("0.00");
        txtimpuesto.setText("0.00");
        txtTotal.setText("0.00");
        lblcliente.setText("Cliente: General");
        ventadatos.setCliente("General");
        
     }
  
   
    private void addTableModelListener() {
              modelo.addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent e) {
            if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 0) { // Si se cambia la cantidad
                int row = e.getFirstRow();
                Object value = modelo.getValueAt(row, 0);
                int cantidad = 0;
                if (value instanceof String) {
                    cantidad = Integer.parseInt((String) value);
                } else if (value instanceof Integer) {
                    cantidad = (int) value;
                }
                double precioUnitario = (double) modelo.getValueAt(row, 2);
                double nuevoTotalProducto = cantidad * precioUnitario;
                double totalAnteriorProducto = (double) modelo.getValueAt(row, 3);
                modelo.setValueAt(nuevoTotalProducto, row, 3); // Actualiza el total del producto
                
                subtotalOriginal -= totalAnteriorProducto;
                subtotalOriginal += nuevoTotalProducto;
                actualizarSubtotal();
            }
        }
    });
    }
    
  
  private void addDeleteRowListener() {
    jTableticket.getSelectionModel().addListSelectionListener(e -> {
        // Dejar esto vacío o agregar lógica adicional si se necesita
    });

    // Agregar KeyListener para detectar Backspace y Suprimir
    jTableticket.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                int selectedRow = jTableticket.getSelectedRow();
                if (selectedRow != -1) {
                    String rolActual = Usuariosesion.getInstance().getRol();

                    if ("Administrador".equals(rolActual)) {
                        eliminarProducto(selectedRow);
                    } else {
                        JTextField usuarioField = new JTextField();
                        JPasswordField passwordField = new JPasswordField();
                        Object[] message = {
                            "Usuario:", usuarioField,
                            "Contraseña:", passwordField
                        };

                        int option = JOptionPane.showConfirmDialog(null, message, "Ingrese credenciales de administrador", JOptionPane.OK_CANCEL_OPTION);
                        if (option == JOptionPane.OK_OPTION) {
                            String usuario = usuarioField.getText();
                            String contrasena = new String(passwordField.getPassword());

                            if (validarAdministrador(usuario, contrasena)) {
                                eliminarProducto(selectedRow);
                            } else {
                                JOptionPane.showMessageDialog(null, "Credenciales incorrectas. No se puede eliminar el producto.");
                            }
                        }
                    }
                }
            }
        }
    });
    }

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

    private void eliminarProducto(int row) {
        double totalProducto = (double) modelo.getValueAt(row, 3);
        subtotalOriginal -= totalProducto;
        modelo.removeRow(row);
        actualizarSubtotal();
        JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.");
    }
    
    private void actualizarSubtotal() {
      total = subtotalOriginal;
      txtsubtotal.setText(String.format("%.2f", subtotalOriginal));
      actualizarTotal();
    }
    
   private void actualizarTotal() {
        if (Jcheckdescuento.isSelected()) {
        aplicarDescuento();
    }
    if (Jcheckimpuesto.isSelected()) {
        aplicarIVA();
    }
    txtTotal.setText(String.format("%.2f", total));
    }
     
   
   public void ajustarnombre(String nombrereal){
        
           lblusuarioactual.setText("Le atiende: "+ nombrereal );
           System.out.println(Usuariosesion.getInstance().getNombrereal());
        
    }
     
   public void ajustarInterfazSegunRol(String rol) {
           
        if ("Estandar".equals(rol)) {
           
            Jcheckdescuento.setEnabled(false);
            
        } else {
            Jcheckdescuento.setEnabled(true);
            System.out.println("Rol del usuario: " + rol);
        }
    }
       
   public void seleccioncliente(JTable Tablaclientes) {
        try {
            int fila = Tablaclientes.getSelectedRow();
            if (fila >= 0) {
                String nombre = Tablaclientes.getValueAt(fila, 0).toString();
                String apellido = Tablaclientes.getValueAt(fila, 1).toString();
                String correo =Tablaclientes.getValueAt(fila,4).toString();
                // Realiza la acción que necesites con estos valores
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);

                // Por ejemplo, actualiza un JLabel o guarda los valores en algún lugar
                Ventas.getInstance().actualizarClienteSeleccionado(nombre, apellido);
                
                ventadatos.setCliente(nombre);
                ventadatos.setCorreo(correo);
                
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros. Error: " + e.toString());
        }
       
    }
   
    public void actualizarClienteSeleccionado(String nombre, String apellido) {
        lblcliente.setText("Cliente: " + nombre + " " + apellido);
        
    }
    
 public String obtenerItemsDeJTable() {
    StringBuilder items = new StringBuilder();
    DefaultTableModel model = (DefaultTableModel) jTableticket.getModel();
    int numRows = model.getRowCount();

    int descripcionMaxLength = 20;

    // Agregar las filas de la tabla
    for (int row = 0; row < numRows; row++) {
        String cantidad = model.getValueAt(row, 0).toString();
        String descripcion = model.getValueAt(row, 1).toString();
        String precioUnitario = model.getValueAt(row, 2).toString();
        String importe = model.getValueAt(row, 3).toString();

        // Dividir la descripción en varias líneas si es necesario
        List<String> lineasDescripcion = dividirDescripcionEnLineas(descripcion, descripcionMaxLength);

        // Agregar la primera línea con todos los datos
        items.append(String.format("%-4s|%-20s|%-5s|%-5s\n", cantidad, lineasDescripcion.get(0), precioUnitario, importe));

        // Agregar el resto de las líneas de la descripción sin los otros datos
        for (int i = 1; i < lineasDescripcion.size(); i++) {
            items.append(String.format("%-4s|%-20s|%-5s|%-5s\n", "", lineasDescripcion.get(i), "", ""));
        }
    }

    return items.toString();
}

private List<String> dividirDescripcionEnLineas(String descripcion, int maxLength) {
    List<String> lineas = new ArrayList<>();
    int length = descripcion.length();
    for (int i = 0; i < length; i += maxLength) {
        lineas.add(descripcion.substring(i, Math.min(length, i + maxLength)));
    }
    return lineas;
}

public List<DetalleVenta> obtenerDetallesParaGuardar() {
    List<DetalleVenta> listaDetalles = new ArrayList<>();
    
    for (int i = 0; i < modelo.getRowCount(); i++) {
        try {
            // 1. Obtener Cantidad
            Object cantObj = modelo.getValueAt(i, 0);
            int cantidad = (cantObj != null) ? Integer.parseInt(cantObj.toString()) : 0;

            // 2. Obtener Precio
            Object precObj = modelo.getValueAt(i, 2);
            double precio = (precObj != null) ? Double.parseDouble(precObj.toString()) : 0.0;
            
            // 3. Obtener ID (Aquí es donde fallaba)
            Object idObj = modelo.getValueAt(i, 4); // Columna 4 (Índice 5ta columna)
            int idProd = 0;
            
            if (idObj != null) {
                idProd = Integer.parseInt(idObj.toString());
            } else {
                // Si es nulo, es un error de programación (olvidamos poner el ID al agregar la fila)
                System.out.println("ALERTA: Fila " + i + " tiene ID nulo. Se asignará 0.");
                // Opcional: Lanzar error para avisar al programador
                // throw new RuntimeException("Producto sin ID en la fila " + i);
            }
            
            listaDetalles.add(new DetalleVenta(idProd, cantidad, precio));
            
        } catch (Exception e) {
            System.out.println("Error al leer la fila " + i + ": " + e.getMessage());
        }
    }
    
    return listaDetalles;
}


   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnVenta;
    private javax.swing.JButton Btnclientesseleccion;
    private javax.swing.JButton Btnformarpaquete;
    private javax.swing.JPanel Cuenta;
    private javax.swing.JCheckBox Jcheckdescuento;
    private javax.swing.JCheckBox Jcheckimpuesto;
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JLabel Labeldescuento;
    private javax.swing.JLabel Labelsubtotal;
    private javax.swing.JPanel Ticket;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableticket;
    private javax.swing.JLabel lblcliente;
    private javax.swing.JLabel lblusuarioactual;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtdescuento;
    private javax.swing.JTextField txtimpuesto;
    private javax.swing.JTextField txtsubtotal;
    // End of variables declaration//GEN-END:variables
}
