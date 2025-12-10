package Vista;

import Conexion.Conexion;
import Modelo.Clientesclass;
import Modelo.ConcreteClientesMediator;
import Modelo.Usuariosesion;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import rojerusan.RSAnimation;
import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Interfazprincipal extends javax.swing.JFrame {

    private static Interfazprincipal instance;
    private CardLayout cardLayout;
    private Clientes clientesPanel;
    private Ventas ventaspanel;
    public Double totalVentasDelDia = 0.0;
    private boolean pantallaCompleta = false;
    private Clientesclass clientesClass;
    public ConcreteClientesMediator clientesMediator;

    public void registrarVenta(double totalVenta) {
        this.totalVentasDelDia += totalVenta;
    }

    public double getContadorVenta() {
        return totalVentasDelDia;
    }

    public static Interfazprincipal getInstance() {
        if (instance == null) {
            instance = new Interfazprincipal();
        }
        return instance;
    }

    public Interfazprincipal() {

        initComponents();

        setLocationRelativeTo(null);
        //  agregarKeyListenerGlobal();
        agregarKeyListenerCorte();
        ajustarInterfazSegunRol(Usuariosesion.getInstance().getRol());

        inicializarComponentesClienteMediator();
        inicializarCardLayout();

        Jtxtbusquedaproductos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                ventaspanel.getInstance().cargarProductos(Jtxtbusquedaproductos.getText());
            }

        });

    }

    private void inicializarComponentesClienteMediator() {
        // 1. Crear instancias
        clientesPanel = new Clientes();
        clientesClass = new Clientesclass();
        clientesMediator = new ConcreteClientesMediator();

        // 2. Registrar componentes
        clientesMediator.registrarClientePanel(clientesPanel);
        clientesMediator.registrarClientesClass(clientesClass);

        // 3. Setear el mediator en el panel 
        clientesPanel.setMediator(clientesMediator);
    }

    private void inicializarCardLayout() {

        // Inicializar CardLayout y agregar paneles
        cardLayout = new CardLayout();
    Panelacambiar.setLayout(cardLayout);

    Productos productos = Productos.getInstance(); // singleton
    //clientesPanel = new Clientes();
    ventaspanel = Ventas.getInstance();
    ventaspanel.agregarObservador(productos); // observador

    Estadistica pedidoesta = new Estadistica();
    Usuariospan usuariopanel = new Usuariospan();
    GenerarPedido pedido = new GenerarPedido();
    Reportes reporte = new Reportes();

    Panelacambiar.add(ventaspanel, "Ventas");
    Panelacambiar.add(productos, "Productos");
    Panelacambiar.add(clientesPanel, "Clientes");
    Panelacambiar.add(pedidoesta, "Estadistica");
    Panelacambiar.add(usuariopanel, "Usuario");
    Panelacambiar.add(pedido, "Pedido");
    Panelacambiar.add(reporte, "Reportes");
}

    
    private void agregarKeyListenerGlobal() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_F9) {
                    // Solicitar nombre de usuario y contraseña
                    JTextField usuarioField = new JTextField();
                    JPasswordField contraseñaField = new JPasswordField();
                    Object[] message = {
                        "Nombre de usuario:", usuarioField,
                        "Contraseña:", contraseñaField
                    };
                    int option = JOptionPane.showConfirmDialog(null, message, "Corte de Caja", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) {
                        String nombreUsuario = usuarioField.getText();
                        String contraseña = new String(contraseñaField.getPassword());
                        String nombreCompletoAdmin = validarAdministradorenBD(nombreUsuario, contraseña);
                        if (nombreCompletoAdmin != null) {
                            // Autenticación exitosa, generar reporte
                            //        generarReporte(nombreCompletoAdmin);
                        } else {
                            JOptionPane.showMessageDialog(null, "Acceso denegado. No eres administrador o las credenciales son incorrectas.");
                        }
                    }
                }
                return false;
            }
        });
    }

    private void agregarKeyListenerCorte() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_F10) {

                    cambiarSesion();

                }
                return false;
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menuabajo = new javax.swing.JPanel();
        BtnEstadísticas = new javax.swing.JButton();
        Btnusuarios = new javax.swing.JButton();
        btnvtasdia = new javax.swing.JButton();
        BtnProductos = new javax.swing.JButton();
        BtnCerrarsesion = new javax.swing.JButton();
        Panelacambiar = new javax.swing.JPanel();
        PanelPadre = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BtnVenta = new javax.swing.JButton();
        BtnClientes = new javax.swing.JButton();
        Contraer = new javax.swing.JButton();
        Jtxtbusquedaproductos = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        JMenuArqueoitem = new javax.swing.JMenuItem();
        JmenuCorteitem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Copymax 1.0");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menuabajo.setBackground(new java.awt.Color(204, 204, 255));
        Menuabajo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BtnEstadísticas.setBackground(new java.awt.Color(204, 255, 255));
        BtnEstadísticas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnEstadísticas.setForeground(new java.awt.Color(0, 0, 0));
        BtnEstadísticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/entrega-de-pedidos (Custom).png"))); // NOI18N
        BtnEstadísticas.setText("Estadísticas");
        BtnEstadísticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEstadísticasActionPerformed(evt);
            }
        });

        Btnusuarios.setBackground(new java.awt.Color(153, 204, 255));
        Btnusuarios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Btnusuarios.setForeground(new java.awt.Color(0, 0, 0));
        Btnusuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios.png"))); // NOI18N
        Btnusuarios.setText("Usuarios");
        Btnusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnusuariosActionPerformed(evt);
            }
        });

        btnvtasdia.setBackground(new java.awt.Color(255, 204, 255));
        btnvtasdia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnvtasdia.setForeground(new java.awt.Color(0, 0, 0));
        btnvtasdia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas.png"))); // NOI18N
        btnvtasdia.setText("Ventas del día ");
        btnvtasdia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvtasdiaActionPerformed(evt);
            }
        });

        BtnProductos.setBackground(new java.awt.Color(204, 255, 204));
        BtnProductos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BtnProductos.setForeground(new java.awt.Color(0, 0, 0));
        BtnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/papeleria (Custom).png"))); // NOI18N
        BtnProductos.setText("Productos");
        BtnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProductosActionPerformed(evt);
            }
        });

        BtnCerrarsesion.setBackground(new java.awt.Color(255, 102, 102));
        BtnCerrarsesion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BtnCerrarsesion.setForeground(new java.awt.Color(0, 0, 0));
        BtnCerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        BtnCerrarsesion.setText("Cerrar Sesión");
        BtnCerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarsesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuabajoLayout = new javax.swing.GroupLayout(Menuabajo);
        Menuabajo.setLayout(MenuabajoLayout);
        MenuabajoLayout.setHorizontalGroup(
            MenuabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuabajoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnvtasdia, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(BtnEstadísticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btnusuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnCerrarsesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        MenuabajoLayout.setVerticalGroup(
            MenuabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuabajoLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(Btnusuarios)
                .addGap(18, 18, 18)
                .addComponent(BtnProductos)
                .addGap(18, 18, 18)
                .addComponent(BtnEstadísticas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnvtasdia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnCerrarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(Menuabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -300, 190, 300));

        Panelacambiar.setBackground(new java.awt.Color(0, 0, 0));
        Panelacambiar.setName(""); // NOI18N
        Panelacambiar.setOpaque(false);
        Panelacambiar.setPreferredSize(new java.awt.Dimension(600, 520));

        javax.swing.GroupLayout PanelacambiarLayout = new javax.swing.GroupLayout(Panelacambiar);
        Panelacambiar.setLayout(PanelacambiarLayout);
        PanelacambiarLayout.setHorizontalGroup(
            PanelacambiarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        PanelacambiarLayout.setVerticalGroup(
            PanelacambiarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        getContentPane().add(Panelacambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 870, 540));

        PanelPadre.setBackground(new java.awt.Color(54, 170, 219));
        PanelPadre.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 102)));
        PanelPadre.setMaximumSize(new java.awt.Dimension(1920, 1080));
        PanelPadre.setPreferredSize(new java.awt.Dimension(600, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logopng (Custom) (1).png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        BtnVenta.setBackground(new java.awt.Color(204, 255, 255));
        BtnVenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnVenta.setForeground(new java.awt.Color(0, 0, 0));
        BtnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas (Custom).png"))); // NOI18N
        BtnVenta.setText("Venta");
        BtnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVentaActionPerformed(evt);
            }
        });

        BtnClientes.setBackground(new java.awt.Color(204, 255, 255));
        BtnClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnClientes.setForeground(new java.awt.Color(0, 0, 0));
        BtnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clasificacion (Custom).png"))); // NOI18N
        BtnClientes.setText("Clientes");
        BtnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClientesActionPerformed(evt);
            }
        });

        Contraer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuraciones.png"))); // NOI18N
        Contraer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraerActionPerformed(evt);
            }
        });

        Jtxtbusquedaproductos.setBackground(new java.awt.Color(255, 204, 255));
        Jtxtbusquedaproductos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Jtxtbusquedaproductos.setForeground(new java.awt.Color(0, 0, 0));
        Jtxtbusquedaproductos.setText("Producto a buscar");
        Jtxtbusquedaproductos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JtxtbusquedaproductosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JtxtbusquedaproductosFocusLost(evt);
            }
        });

        javax.swing.GroupLayout PanelPadreLayout = new javax.swing.GroupLayout(PanelPadre);
        PanelPadre.setLayout(PanelPadreLayout);
        PanelPadreLayout.setHorizontalGroup(
            PanelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPadreLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Contraer)
                .addGap(18, 18, 18)
                .addComponent(BtnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(BtnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addComponent(Jtxtbusquedaproductos, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelPadreLayout.setVerticalGroup(
            PanelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPadreLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(PanelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Jtxtbusquedaproductos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Contraer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(PanelPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 60));

        jMenu1.setText("Venta");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas (Custom) (Custom).png"))); // NOI18N
        jMenuItem4.setText("Venta");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator1);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        jMenuItem5.setText("Pedido");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Gestión de Personal");
        jMenuBar1.add(jMenu2);

        jMenu4.setText("Caja");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem7.setText("Fondo Inicial");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem10.setText("Retiro");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        JMenuArqueoitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        JMenuArqueoitem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/impuestos.png"))); // NOI18N
        JMenuArqueoitem.setText("Arqueo de Caja");
        JMenuArqueoitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuArqueoitemActionPerformed(evt);
            }
        });
        jMenu4.add(JMenuArqueoitem);

        JmenuCorteitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        JmenuCorteitem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas.png"))); // NOI18N
        JmenuCorteitem.setText("Corte de Caja");
        JmenuCorteitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmenuCorteitemActionPerformed(evt);
            }
        });
        jMenu4.add(JmenuCorteitem);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Pantalla Completa");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        jMenuItem1.setText("Pantalla Completa");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem2.setText("Ventana ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void mostrarventa() {
        cardLayout.show(Panelacambiar, "Ventas");
    }

    public void mostrarpedido() {
        cardLayout.show(Panelacambiar, "Pedido");

    }

    public void mostrarestadistica() {
        cardLayout.show(Panelacambiar, "Estadistica");
    }

    public void mostrarclientes() {
        cardLayout.show(Panelacambiar, "Clientes");
    }

    public void mostrarusuarios() {
        cardLayout.show(Panelacambiar, "Usuario");
    }

    public void mostrarproductos() {
        cardLayout.show(Panelacambiar, "Productos");
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        pantallacompleta();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        alternarPantallaCompleta();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void BtnCerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarsesionActionPerformed
        LoginRegistro login = new LoginRegistro();
        login.setVisible(true);
        Usuariosesion.getInstance().cerrarSesion();
        dispose();
    }//GEN-LAST:event_BtnCerrarsesionActionPerformed

    private void BtnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProductosActionPerformed
        mostrarproductos();
    }//GEN-LAST:event_BtnProductosActionPerformed

    private void btnvtasdiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvtasdiaActionPerformed

        Corte corte = new Corte();
        corte.setVisible(true);

    }//GEN-LAST:event_btnvtasdiaActionPerformed

    private void BtnusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnusuariosActionPerformed
        mostrarusuarios();

    }//GEN-LAST:event_BtnusuariosActionPerformed

    private void BtnEstadísticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEstadísticasActionPerformed

        cardLayout.show(Panelacambiar, "Estadistica");
    }//GEN-LAST:event_BtnEstadísticasActionPerformed

    private void JtxtbusquedaproductosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JtxtbusquedaproductosFocusLost
        if (Jtxtbusquedaproductos.getText().isEmpty()) {
            Jtxtbusquedaproductos.setForeground(Color.black);
            Jtxtbusquedaproductos.setText("Producto a buscar");
        }
    }//GEN-LAST:event_JtxtbusquedaproductosFocusLost

    private void JtxtbusquedaproductosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JtxtbusquedaproductosFocusGained
        if (Jtxtbusquedaproductos.getText().equals("Producto a buscar")) {
            Jtxtbusquedaproductos.setText("");
            Jtxtbusquedaproductos.setForeground(Color.black);

        }
    }//GEN-LAST:event_JtxtbusquedaproductosFocusGained

    private void ContraerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraerActionPerformed

        int posicion = this.Menuabajo.getY();
        System.out.println(posicion);
        if (posicion < -1) {

            RSAnimation.setBajar(-360, 60, 1, 2, Menuabajo);
        } else {
            RSAnimation.setSubir(60, -360, 1, 2, Menuabajo);
        }
    }//GEN-LAST:event_ContraerActionPerformed

    private void BtnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClientesActionPerformed
        cardLayout.show(Panelacambiar, "Clientes");
    }//GEN-LAST:event_BtnClientesActionPerformed

    private void BtnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVentaActionPerformed

        mostrarventa();
    }//GEN-LAST:event_BtnVentaActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        MVC mvc = new MVC();
        mvc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // Crear campos para el JOptionPane
        JTextField usuarioField = new JTextField();
        JPasswordField contraseñaField = new JPasswordField();

        Object[] message = {
            "Nombre de usuario:", usuarioField,
            "Contraseña:", contraseñaField
        };

        // Mostrar JOptionPane con los campos de usuario y contraseña
        int option = JOptionPane.showConfirmDialog(null, message, "Autenticación de Administrador", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String nombreUsuario = usuarioField.getText();
            String contraseña = new String(contraseñaField.getPassword());

            // Validar credenciales con el método de autenticación
            String nombreCompletoAdmin = validarAdministradorenBD(nombreUsuario, contraseña);

            if (nombreCompletoAdmin != null) {
                // Autenticación exitosa
                JOptionPane.showMessageDialog(null, "Bienvenido, " + nombreCompletoAdmin + ". Puedes continuar.");
                registrarFondoInicial(); // Llamar al método para registrar el fondo inicial
            } else {
                // Autenticación fallida
                JOptionPane.showMessageDialog(null, "Acceso denegado. No eres administrador o las credenciales son incorrectas.",
                        "Error de autenticación", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Cancelación del JOptionPane
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // Crear campos para el JOptionPane
        JTextField usuarioField = new JTextField();
        JPasswordField contraseñaField = new JPasswordField();

        Object[] message = {
            "Nombre de usuario:", usuarioField,
            "Contraseña:", contraseñaField
        };

        // Mostrar JOptionPane con los campos de usuario y contraseña
        int option = JOptionPane.showConfirmDialog(null, message, "Autenticación de Administrador", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String nombreUsuario = usuarioField.getText();
            String contraseña = new String(contraseñaField.getPassword());

            // Validar credenciales con el método de autenticación
            String nombreCompletoAdmin = validarAdministradorenBD(nombreUsuario, contraseña);

            if (nombreCompletoAdmin != null) {
                // Autenticación exitosa
                JOptionPane.showMessageDialog(null, "Bienvenido, " + nombreCompletoAdmin + ". Puedes continuar.");
                registrarretiro(); // Llamar al método para registrar el fondo inicial
            } else {
                // Autenticación fallida
                JOptionPane.showMessageDialog(null, "Acceso denegado. No eres administrador o las credenciales son incorrectas.",
                        "Error de autenticación", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Cancelación del JOptionPane
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void JmenuCorteitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmenuCorteitemActionPerformed

        String reportPath = "src/Reportes/Diario1.jasper"; // RUTA DEL REPORTE

        // Solicitar nombre de usuario y contraseña
        JTextField usuarioField = new JTextField();
        JPasswordField contraseñaField = new JPasswordField();
        Object[] message = {
            "Nombre de usuario:", usuarioField,
            "Contraseña:", contraseñaField
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Corte de Caja", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nombreUsuario = usuarioField.getText();
            String contraseña = new String(contraseñaField.getPassword());
            String nombreCompletoAdmin = validarAdministradorenBD(nombreUsuario, contraseña);
            if (nombreCompletoAdmin != null) {
                // Autenticación exitosa, generar reporte
                actualizarCorteDeCaja();
                generarReporte(nombreCompletoAdmin, reportPath);
            } else {
                JOptionPane.showMessageDialog(null, "Acceso denegado. No eres administrador o las credenciales son incorrectas.");
            }
        }


    }//GEN-LAST:event_JmenuCorteitemActionPerformed

    private void JMenuArqueoitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuArqueoitemActionPerformed
        String reportPath = "src/Reportes/Arqueo.jasper"; // RUTA DEL REPORTE

        // Solicitar nombre de usuario y contraseña
        JTextField usuarioField = new JTextField();
        JPasswordField contraseñaField = new JPasswordField();
        Object[] message = {
            "Nombre de usuario:", usuarioField,
            "Contraseña:", contraseñaField
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Arqueo de Caja", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nombreUsuario = usuarioField.getText();
            String contraseña = new String(contraseñaField.getPassword());
            String nombreCompletoAdmin = validarAdministradorenBD(nombreUsuario, contraseña);
            if (nombreCompletoAdmin != null) {
                // Autenticación exitosa, generar reporte
                generarReporte(nombreCompletoAdmin, reportPath);
            } else {
                JOptionPane.showMessageDialog(null, "Acceso denegado. No eres administrador o las credenciales son incorrectas.");
            }
        }
    }//GEN-LAST:event_JMenuArqueoitemActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        mostrarpedido(); // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        mostrarventa();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    public String validarAdministradorenBD(String nombreUsuario, String contraseña) {
        Conexion conex = new Conexion();
        String consulta = "SELECT Nombre, Rol FROM Usuario WHERE NombreUsuario = ? AND Contraseña = ?";
        try (PreparedStatement pst = conex.getConnection().prepareStatement(consulta)) {
            pst.setString(1, nombreUsuario);
            pst.setString(2, contraseña);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String rol = rs.getString("Rol");
                if ("Administrador".equals(rol)) {
                    return rs.getString("Nombre");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al validar usuario: " + e.toString());
        }
        return null; // Retorna null si no es administrador o si hay un error
    }

    private void cambiarSesion() {
        JTextField nombreUsuarioField = new JTextField();
        JPasswordField contraseñaField = new JPasswordField();
        Object[] message = {
            "Nombre de usuario:", nombreUsuarioField,
            "Contraseña:", contraseñaField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Cambiar sesión", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String nombreUsuario = nombreUsuarioField.getText();
            String contraseña = new String(contraseñaField.getPassword());

            if (validarUsuario(nombreUsuario, contraseña)) {
                JOptionPane.showMessageDialog(null, "Cambio de sesión exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
            }

        } else if (option == JOptionPane.CANCEL_OPTION || option == JOptionPane.CLOSED_OPTION) {
            // Si el usuario presiona Cancelar o cierra el diálogo, simplemente terminamos el método
            return;
        }

        // Imprimir información de la sesión solo si se cambia exitosamente
        System.out.println(Usuariosesion.getInstance().getNombre());
        System.out.println(Usuariosesion.getInstance().getRol());
    }

    public boolean validarUsuario(String nombreUsuario, String contraseña) {
        Conexion conex = new Conexion();
        String consulta = "SELECT Nombreusuario, Rol, Nombre,idUsuario FROM Usuario WHERE Nombreusuario = ? AND Contraseña = ?";
        try (
                PreparedStatement pst = conex.getConnection().prepareStatement(consulta)) {
            pst.setString(1, nombreUsuario);
            pst.setString(2, contraseña);

            var rs = pst.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("Nombreusuario");
                String rol = rs.getString("Rol");
                String nombreal = rs.getString("Nombre");
                int idsuario = rs.getInt("idUsuario");
                Usuariosesion.getInstance().setUsuario(nombre, rol, nombreal, idsuario); // Guardar información del usuario en la sesión
                // Actualizar la interfaz según el rol
                ajustarInterfazSegunRol(rol);
                Ventas.getInstance().ajustarInterfazSegunRol(rol); // Usar la instancia única
                Ventas.getInstance().ajustarnombre(nombreal);
                // Revalidate y repaint para asegurar que la interfaz se actualice
                revalidate();
                repaint();

                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al validar usuario: " + e.toString());
        }
        return false;
    }

    public void ajustarInterfazSegunRol(String rol) {
        if (clientesPanel != null) {
            clientesPanel.ajustarInterfazSegunRol(rol);
            ajusterol(rol);
        }

        if (ventaspanel != null) {
            ventaspanel.ajustarInterfazSegunRol(rol);
            ajusterol(rol);
        }
    }

    public void ajusterol(String rol) {
        if ("Estandar".equals(rol)) {

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

    private void ajustarComponentes() {
        // Obtener el tamaño actual del JFrame
        int width = getWidth();
        int height = getHeight();

        // Ajustar los tamaños y posiciones de los paneles según el tamaño del JFrame
        // Queremos que los componentes se ajusten proporcionalmente.
        // Ajustar el panel superior PanelPadre
        int panelPadreHeight = (int) (height * 0.1); // Por ejemplo, 10% de la altura total
        PanelPadre.setBounds(0, 0, width, panelPadreHeight);

        // Ajustar el panel inferior Menuabajo
        int menuAbajoHeight = (int) (height * 0.2); // Por ejemplo, 20% de la altura total
        Menuabajo.setBounds(0, height - menuAbajoHeight, width, menuAbajoHeight);

        // Ajustar el panel del medio Panelacambiar
        int panelACambiarHeight = height - panelPadreHeight - menuAbajoHeight; // Lo que queda en el medio
        Panelacambiar.setBounds(0, panelPadreHeight, width, panelACambiarHeight);

        // Llama a revalidate y repaint para actualizar la interfaz
        revalidate();
        repaint();
    }

    public void pantallacompleta() {
        dispose();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        pantallaCompleta = true;
        ajustarComponentes(); // Ajusta componentes cuando se cambia a pantalla completa
    }

    public void alternarPantallaCompleta() {
        if (!pantallaCompleta) {
            pantallacompleta();
        } else {
            dispose();
            setUndecorated(false);
            setExtendedState(JFrame.NORMAL);
            setSize(950, 700); // Tamaño original
            setLocationRelativeTo(null);
            setVisible(true);
            pantallaCompleta = false;
            ajustarComponentes(); // Ajusta componentes cuando se cambia de pantalla completa a tamaño normal
            setSize(950, 700); // Tamaño original
        }

    }

    private void generarReporte(String nombreadmin, String reporthpath) {
        try {
            // Ruta del archivo .jasper

            System.out.println(reporthpath);

            // Parámetros del reporte
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("AdminenTurno", nombreadmin); // Administrador
            parameters.put("CajeroenTurno", Usuariosesion.getInstance().getNombrereal()); // Cajero

            // Conexión a la base de datos
            Conexion conexion = new Conexion();
            if (conexion.verificarConexion()) {
                // Llenar el reporte con los datos
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporthpath, parameters, conexion.getConnection());

                // Mostrar el reporte en el visor
                JasperViewer viewer = new JasperViewer(jasperPrint, false); // false evita cerrar la aplicación al cerrar el visor
                viewer.setTitle("Vista Previa del Reporte");
                viewer.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Error de conexión a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al visualizar el reporte: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void registrarFondoInicial() {
        // Solicitar al usuario el fondo inicial de la caja
        String fondoInicialStr;
        double fondoInicial = 0;
        boolean entradaValida = false;

        // Validar que solo se ingrese un número decimal válido
        while (!entradaValida) {
            fondoInicialStr = JOptionPane.showInputDialog(null, "Ingrese el fondo inicial de la caja:",
                    "Registro de Fondo Inicial", JOptionPane.INFORMATION_MESSAGE);
            if (fondoInicialStr == null) {
                // El usuario canceló
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;
            }
            try {
                fondoInicial = Double.parseDouble(fondoInicialStr);
                if (fondoInicial < 0) {
                    throw new NumberFormatException("El fondo inicial no puede ser negativo.");
                }
                entradaValida = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido con hasta dos decimales.",
                        "Entrada inválida", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Obtener la fecha y hora actuales
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        String fechaInicio = fechaHoraActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String fechaActual = fechaHoraActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Verificar si ya existe un registro para el día actual
        String queryVerificar = "SELECT COUNT(*) FROM caja WHERE DATE(FechaInicio) = ?";
        try (java.sql.Connection con = new Conexion().getConnection(); PreparedStatement pstVerificar = con.prepareStatement(queryVerificar)) {
            pstVerificar.setString(1, fechaActual);
            try (ResultSet rs = pstVerificar.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "Ya existe un registro de fondo inicial para hoy.",
                            "Registro duplicado", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar el fondo inicial: " + e.getMessage(),
                    "Error de base de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Registrar el fondo inicial en la base de datos
        String queryInsertar = "INSERT INTO caja (FechaInicio, FondoInicial, idUsuario, TotalCaja) VALUES (?, ?, ?,?)";
        try (java.sql.Connection con = new Conexion().getConnection(); PreparedStatement pstInsertar = con.prepareStatement(queryInsertar)) {
            pstInsertar.setString(1, fechaInicio);
            pstInsertar.setDouble(2, fondoInicial);
            // Asume que el ID del usuario autenticado se guarda en una variable estática (ejemplo: UsuarioActual.id)
            pstInsertar.setInt(3, Usuariosesion.getInstance().getIdUsuario());
            pstInsertar.setDouble(4, fondoInicial);

            int resultado = pstInsertar.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Fondo inicial registrado correctamente.\n"
                        + "Fecha y hora: " + fechaInicio + "\nFondo inicial: $" + fondoInicial);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar el fondo inicial.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el fondo inicial: " + e.getMessage(),
                    "Error de base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void registrarretiro() {
        // Obtener el id de la caja activa
        int idCaja = obtenerIdCajaActual();

        // Si no se encontró una caja activa, mostrar error y salir
        if (idCaja == -1) {
            JOptionPane.showMessageDialog(null, "No se encontró una caja activa para hoy.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Solicitar al administrador que ingrese el monto del retiro
        String montoStr;
        double monto = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            montoStr = JOptionPane.showInputDialog(null, "Ingrese el monto del retiro:",
                    "Registrar Retiro", JOptionPane.INFORMATION_MESSAGE);
            if (montoStr == null) {
                // Operación cancelada
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;
            }

            try {
                monto = Double.parseDouble(montoStr);
                if (monto <= 0) {
                    throw new NumberFormatException("El monto debe ser mayor que cero.");
                }
                entradaValida = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido con hasta dos decimales.",
                        "Entrada inválida", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Solicitar el motivo del retiro
        String motivo = JOptionPane.showInputDialog(null, "Ingrese el motivo del retiro:",
                "Motivo del Retiro", JOptionPane.INFORMATION_MESSAGE);
        if (motivo == null || motivo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe proporcionar un motivo para el retiro.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Registrar el retiro en la base de datos
        Conexion conex = new Conexion();
        String queryInsertRetiro = "INSERT INTO retiros (idCaja, Monto, FechaHora, Motivo) VALUES (?, ?, NOW(), ?)";
        String queryActualizarCaja = "UPDATE caja SET TotalRetiros = TotalRetiros + ?, TotalCaja = TotalCaja - ? WHERE idCaja = ?";

        try (java.sql.Connection con = conex.getConnection(); PreparedStatement pstInsertRetiro = con.prepareStatement(queryInsertRetiro); PreparedStatement pstActualizarCaja = con.prepareStatement(queryActualizarCaja)) {

            // Registrar en la tabla retiros
            pstInsertRetiro.setInt(1, idCaja); // Usar el idCaja obtenido
            pstInsertRetiro.setDouble(2, monto);
            pstInsertRetiro.setString(3, motivo);
            int resultadoRetiro = pstInsertRetiro.executeUpdate();

            if (resultadoRetiro > 0) {
                // Actualizar el total de retiros y el total de la caja
                pstActualizarCaja.setDouble(1, monto);
                pstActualizarCaja.setDouble(2, monto);
                pstActualizarCaja.setInt(3, idCaja);
                int resultadoActualizacion = pstActualizarCaja.executeUpdate();

                if (resultadoActualizacion > 0) {
                    JOptionPane.showMessageDialog(null, "Retiro registrado correctamente.\n"
                            + "Monto: $" + monto + "\nMotivo: " + motivo,
                            "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el total de la caja.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar el retiro.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar el retiro: " + e.getMessage(),
                    "Error de base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int obtenerIdCajaActual() {
        String query = "SELECT idCaja FROM caja WHERE DATE(FechaInicio) = CURDATE() AND FechaFin IS NULL"; // Solo la caja de hoy con FechaFin nulo

        try (java.sql.Connection con = new Conexion().getConnection(); PreparedStatement pst = con.prepareStatement(query); ResultSet rs = pst.executeQuery()) {

            // Si encontramos una caja activa, retornamos su id
            if (rs.next()) {
                return rs.getInt("idCaja");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // Si no se encuentra ninguna caja activa, retornar -1
    }

    public void actualizarCorteDeCaja() {
        String queryActualizar = "UPDATE caja SET CorteFinal = TotalCaja, FechaFin = NOW() WHERE DATE(FechaInicio) = CURDATE()";

        try (java.sql.Connection con = new Conexion().getConnection(); PreparedStatement pstActualizar = con.prepareStatement(queryActualizar)) {

            // Ejecutar la actualización en la base de datos
            int filasActualizadas = pstActualizar.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Corte de caja actualizado correctamente.");
            } else {
                System.err.println("No se encontró un registro de caja para el día actual.");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar el corte de caja: " + e.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCerrarsesion;
    private javax.swing.JButton BtnClientes;
    private javax.swing.JButton BtnEstadísticas;
    private javax.swing.JButton BtnProductos;
    private javax.swing.JButton BtnVenta;
    private javax.swing.JButton Btnusuarios;
    private javax.swing.JButton Contraer;
    private javax.swing.JMenuItem JMenuArqueoitem;
    private javax.swing.JMenuItem JmenuCorteitem;
    private javax.swing.JTextField Jtxtbusquedaproductos;
    private javax.swing.JPanel Menuabajo;
    private javax.swing.JPanel PanelPadre;
    private javax.swing.JPanel Panelacambiar;
    private javax.swing.JButton btnvtasdia;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
