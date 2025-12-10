package Vista;

import Modelo.DashboardManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox; // IMPORTANTE
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class PanelDashboard extends JPanel {

    private DashboardManager manager;
    private JPanel panelGraficos;
    private JLabel lblEstadoFiltro;
    private JComboBox<String> comboMeses; // Nuevo componente

    public PanelDashboard() {
        manager = new DashboardManager();
        configurarDiseñoInteractivo();
    }

    private void configurarDiseñoInteractivo() {
        this.setLayout(new BorderLayout(10, 10));
        this.setBackground(Color.WHITE);

        // --- 1. BARRA SUPERIOR ---
        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.setBackground(new Color(0, 51, 102));
        panelTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Título KPI
        double ticketPromedio = manager.obtenerTicketPromedio();
        JLabel lblTitulo = new JLabel("Ticket Promedio Histórico: $" + String.format("%.2f", ticketPromedio));
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        panelTop.add(lblTitulo, BorderLayout.WEST);

        // Panel derecho con Filtros
        JPanel panelDerecho = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelDerecho.setOpaque(false);

        lblEstadoFiltro = new JLabel("Viendo: Mes Actual (30 días)  ");
        lblEstadoFiltro.setForeground(Color.CYAN);
        lblEstadoFiltro.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panelDerecho.add(lblEstadoFiltro);

        // Botones de Días (esMes = false)
        panelDerecho.add(crearBotonFiltro("Hoy", 1));
        panelDerecho.add(crearBotonFiltro("Semana", 7));
        panelDerecho.add(crearBotonFiltro("Mes (30d)", 30));

        // Separador visual
        JLabel lblSep = new JLabel(" | ");
        lblSep.setForeground(Color.WHITE);
        panelDerecho.add(lblSep);

        // ComboBox de Meses (esMes = true)
        String[] meses = {"- Histórico Mes -", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
                          "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        comboMeses = new JComboBox<>(meses);
        comboMeses.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        comboMeses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mesSeleccionado = comboMeses.getSelectedIndex(); // 1=Enero, 10=Octubre
                if (mesSeleccionado > 0) {
                    lblEstadoFiltro.setText("Viendo: " + meses[mesSeleccionado] + "  ");
                    // AQUÍ ESTÁ LA CLAVE: true indica que filtramos por MES
                    actualizarGraficos(mesSeleccionado, true); 
                }
            }
        });
        panelDerecho.add(comboMeses);

        panelTop.add(panelDerecho, BorderLayout.EAST);
        this.add(panelTop, BorderLayout.NORTH);

        // --- 2. ZONA CENTRAL ---
        panelGraficos = new JPanel(new GridLayout(2, 2, 15, 15));
        panelGraficos.setBackground(Color.WHITE);
        panelGraficos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Carga inicial (30 días, false para esMes)
        actualizarGraficos(30, false);
        
        this.add(panelGraficos, BorderLayout.CENTER);

        // --- 3. BARRA LATERAL (STOCK) ---
        JPanel panelAlerta = new JPanel(new BorderLayout());
        panelAlerta.setPreferredSize(new Dimension(280, 0));
        panelAlerta.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 0, 0), 2), 
                "⚠️ ALERTA: STOCK BAJO", 
                0, 0, new Font("Segoe UI", Font.BOLD, 14), new Color(200, 0, 0)));
        
        JTable tablaStock = new JTable(manager.obtenerStockBajo());
        tablaStock.setRowHeight(30);
        tablaStock.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tablaStock.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tablaStock.getTableHeader().setBackground(new Color(255, 200, 200));
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tablaStock.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        panelAlerta.add(new JScrollPane(tablaStock), BorderLayout.CENTER);
        this.add(panelAlerta, BorderLayout.EAST);
    }

    private JButton crearBotonFiltro(String texto, int valor) {
        JButton btn = new JButton(texto);
        btn.setFocusPainted(false);
        btn.setBackground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblEstadoFiltro.setText("Viendo: " + texto + "  ");
                comboMeses.setSelectedIndex(0); // Reiniciar el combo
                // Al pulsar botón, esMes = false
                actualizarGraficos(valor, false);
            }
        });
        return btn;
    }

    // MÉTODO CENTRAL CORREGIDO (Acepta los 2 parámetros)
    private void actualizarGraficos(int filtro, boolean esMes) {
        panelGraficos.removeAll();
        
        panelGraficos.add(crearChartTopProductos(filtro, esMes));
        panelGraficos.add(crearChartCategorias(filtro, esMes));
        panelGraficos.add(crearChartTendencia(filtro, esMes));
        panelGraficos.add(crearChartHorasPico(filtro, esMes));
        
        panelGraficos.revalidate();
        panelGraficos.repaint();
    }

    // --- GRÁFICOS (Ahora pasan los 2 parámetros al Manager) ---

    private ChartPanel crearChartTopProductos(int filtro, boolean esMes) {
        DefaultCategoryDataset datos = manager.obtenerTopProductos(filtro, esMes);
        JFreeChart chart = ChartFactory.createBarChart("Top 5 Más Vendidos", "", "Unidades", datos, PlotOrientation.VERTICAL, false, true, false);
        
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
        
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(0, 153, 153)); 
        
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultItemLabelFont(new Font("SansSerif", Font.BOLD, 12));
        
        return new ChartPanel(chart);
    }

    private ChartPanel crearChartCategorias(int filtro, boolean esMes) {
        DefaultPieDataset datos = manager.obtenerVentasPorCategoria(filtro, esMes);
        JFreeChart chart = ChartFactory.createPieChart("Ingresos por Categoría", datos, true, true, false);
        
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
            "{0}: {1} ({2})", NumberFormat.getNumberInstance(), new DecimalFormat("0.0%")
        ));
        plot.setLabelBackgroundPaint(new Color(255, 255, 255, 200)); 
        
        return new ChartPanel(chart);
    }

    private ChartPanel crearChartTendencia(int filtro, boolean esMes) {
        DefaultCategoryDataset datos = manager.obtenerTendenciaVentas(filtro, esMes);
        JFreeChart chart = ChartFactory.createLineChart("Tendencia de Ventas ($)", "", "Dinero", datos, PlotOrientation.VERTICAL, false, true, false);
        
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
        
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(0, 102, 204)); 
        renderer.setSeriesStroke(0, new java.awt.BasicStroke(3.0f));
        
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);
        
        return new ChartPanel(chart);
    }

    private ChartPanel crearChartHorasPico(int filtro, boolean esMes) {
        DefaultCategoryDataset datos = manager.obtenerVentasPorHora(filtro, esMes);
        JFreeChart chart = ChartFactory.createBarChart("Horas Pico (Tráfico)", "Hora", "Ventas", datos, PlotOrientation.VERTICAL, false, true, false);
        
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
        
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(255, 128, 0)); 
        
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);
        
        return new ChartPanel(chart);
    }
}