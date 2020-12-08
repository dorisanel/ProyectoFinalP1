package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import logical.Jugador;
import logical.SerieNacional;
import logical.Lesion;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class GraficaLesiones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	public static DefaultTableModel modelo;
	public static Object[] fila;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public GraficaLesiones() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("muuSawtA_preview_rev_2.png"));
		setResizable(false);
		setTitle("Listado de Lesiones");
		setBounds(100, 100, 853, 582);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlHighlight);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			
			 // Fuente de Datos
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        
	        int cantT = 0;
	        int cantF = 0;
	        int cantCon = 0;
	        int cantH = 0;
	        int cantCod = 0;
	        int cantR = 0;
	        
	        /*"Tendon","Fractura","Contusion","Hombros","Codos","Rodillas"*/
	        
	        for(Jugador jugador : SerieNacional.getInstance().getMisJugadores()) {
	        	for(Lesion lesion : jugador.getMisLesiones()) {
	        		if(lesion.getTipo().equalsIgnoreCase("Tendon"))
	        			cantT++;
	        			
	        		if(lesion.getTipo().equalsIgnoreCase("Fractura"))
	        			cantF++;
	        		
	        		if(lesion.getTipo().equalsIgnoreCase("Contusion"))
	        			cantCon++;
	        		
	        		if(lesion.getTipo().equalsIgnoreCase("Hombros"))
	        			cantH++;
	        		
	        		if(lesion.getTipo().equalsIgnoreCase("Codos"))
	        			cantCod++;
	        		
	        		if(lesion.getTipo().equalsIgnoreCase("Rodillas"))
	        			cantR++;
	        	}
	        	
	        }
	        
	        dataset.setValue(cantT, "Tendon", "");
	        dataset.setValue(cantF, "Fractura", "");
	        dataset.setValue(cantCon, "Contusion", "");
	        dataset.setValue(cantH, "Hombros", "");
	        dataset.setValue(cantCod, "Codos", "");
	        dataset.setValue(cantR, "Rodillas", "");
	        
	        
	        JFreeChart chart = ChartFactory.createBarChart
	        ("Tipos de Lesiones","Tipo", "Cantidad", 
	        dataset, PlotOrientation.VERTICAL, true,true, false);
	        chart.setBackgroundPaint(Color.lightGray);
	        chart.getTitle().setPaint(Color.black); 
	        CategoryPlot p = chart.getCategoryPlot(); 
	        p.setRangeGridlinePaint(Color.gray);
	        panel.setLayout(null);
	        ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setBounds(0, 0, 827, 328);
	        chartPanel.setBackground(SystemColor.control);
	        chartPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	        panel.add(chartPanel);
	        
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(0, 353, 827, 141);
	        panel.add(scrollPane);
	        
	        modelo = new DefaultTableModel();
			String[] columns = {"Jugador","Tipo","Fecha", "Tiempo", "Diagnóstico"};
			modelo.setColumnIdentifiers(columns);
			table = new JTable();
			table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			table.setModel(modelo);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(table);
			
			JSeparator separator = new JSeparator();
			separator.setBackground(new Color(0, 51, 102));
			separator.setBounds(0, 339, 827, 10);
			panel.add(separator);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.setIcon(new ImageIcon("61155.png"));
				cancelButton.setBackground(SystemColor.controlHighlight);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarTabla();
	}
	
	private void cargarTabla() {

		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date;
		for(Jugador jugador: SerieNacional.getInstance().getMisJugadores()) {
			
			fila[0] = jugador.getNombre();
			
			for(logical.Lesion lesion : jugador.getMisLesiones()) {
				date = simpleDateFormat.format(lesion.getFechaLesion());
				fila[1] = lesion.getTipo();
				fila[2] = date;
				fila[3] = lesion.getDiasLesionado();
				fila[4] = lesion.getDiagnostico();
				modelo.addRow(fila);
			}			

		}
		
	}
}
