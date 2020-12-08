package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logical.Bateador;
import logical.Equipo;
import logical.Estadistica;
import logical.Juego;
import logical.Jugador;
import logical.Pitcher;
import logical.SerieNacional;
import sun.text.resources.FormatData;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JLayeredPane;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

public class ListaEstadistica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6617167782438887078L;
	private JPanel contentPane;
	private Object[] filas;
	private DefaultTableModel modelo;
	private DefaultTableModel modelo1;
	public static DefaultTableModel modelo2;
	private String selected;
	private JTable tablaBateo;
	private JTable tablaPitcheo;
	private Object[] filas1;
	private JScrollPane scrollPane_1;
	public static Object[] fila;
	private String[] columnPit = {"Jugador","Equipo", "JG", "JP", "PCL", "J", "A", "JC", "SHO", "JS", "OS", "IL", "H", "C", "CL", "HR",
			"GP", "BB", "P", "WHIP", "PRO"};
	
	private String[] columnBat = {"Jugador","Equipo", "J", "TB", "C", "H","2B","3B","HR","CI","BB","P","BR","AR","PRO","OBP","SLG","OPS"};
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ListaEstadistica() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("muuSawtA_preview_rev_2.png"));
		setTitle("Estadisticas");
		/*Estadistica e11 = new Estadistica("11",10,22,33,44,55,6,77,8,56,54,33,55,66,7,89,5,4,543,34,454,5,43,234);
		//SerieNacional.getInstance().getMisEquipos().get(0).setCantJuegos(1);
		SerieNacional.getInstance().getMisEquipos().get(0).agregarNuevaEstadistica("13", e11);*/
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				modelo.setRowCount(0);
				llenarTablaEquipo();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 832, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);

		modelo = new DefaultTableModel();

		String[] head1 = {"Equipo","Juegos", "Al bate","Carreras","Hits","Dobles","Triples","Cuadrangulares","Empujadas","Bases totales","Bases por bolas","Ponches","Bases robadas","Prom"};
		modelo.setColumnIdentifiers(head1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 153));
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("Estad\u00EDsticas de Equipos");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Heading", Font.PLAIN, 14));
		panel.add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				modelo.setRowCount(0);
				llenarTablaEquipo();
			}
		});
		tabbedPane.addTab("Bateo", null, scrollPane, null);
		tabbedPane.setEnabledAt(0, true);

		modelo = new DefaultTableModel();
		tablaBateo = new JTable();
		String[] header = {"Equipo","Jugadas","Carreras","Al bate","Hits","Dobles","Triples","Jonron","RBI","BB","SO","SB","Prom"};
		modelo.setColumnIdentifiers(header);
		tablaBateo.setModel(modelo);
		scrollPane.setViewportView(tablaBateo);


		scrollPane_1 = new JScrollPane();
		scrollPane_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				selected = "pitcheo";
				modelo1.setRowCount(0);
				llenarTablaEquipoPitcheo();
			}
		});
		tabbedPane.addTab("Pitcheo", null, scrollPane_1, null);
		tabbedPane.setEnabledAt(1, true);

		modelo1 = new DefaultTableModel();
		tablaPitcheo = new JTable();
		String[] header1 = {"Equipo","Ganados","Perdidos","ERA","CG","SHO","SV","SVO","IP","H","R","ER","HB","Prom"};
		modelo1.setColumnIdentifiers(header1);
		tablaPitcheo.setModel(modelo1);
		scrollPane_1.setViewportView(tablaPitcheo);
		llenarTablaEquipoPitcheo();
		
		modelo2 = new DefaultTableModel();		

	}



	private void llenarTablaEquipo() {
		filas = new Object[modelo.getColumnCount()];
		//filas1 = new Object[15];
		if(SerieNacional.getInstance().getMisJuegos().isEmpty() == false) {
			for (Equipo eq : SerieNacional.getInstance().getMisEquipos()) {
				try {
					filas[0]=eq.getNombre();
					filas[1]=eq.getCantJuegos();
					filas[2]=eq.getEstadisticaTotal().getR();
					filas[3]=eq.getEstadisticaTotal().getAB();
					filas[4]=eq.getEstadisticaTotal().getH_bateo();
					filas[5]=eq.getEstadisticaTotal().getDoubleB();
					filas[6]=eq.getEstadisticaTotal().getTripleB();
					filas[7]=eq.getEstadisticaTotal().getHR();
					filas[8]=eq.getEstadisticaTotal().getRBI();
					filas[9]=eq.getEstadisticaTotal().getBB_bateo();
					filas[10]=eq.getEstadisticaTotal().getSO_bateo();
					filas[11]=eq.getEstadisticaTotal().getSB();
					eq.getEstadisticaTotal().getAVG_Bateo();
					filas[12]=eq.getEstadisticaTotal().getAVG_Bateo();
					modelo.addRow(filas);
					tablaBateo.setModel(modelo);
				}catch(NullPointerException e1) {
					eq.actualizarEstadisticasTotales();
				}
			}


		}


	}

	private void llenarTablaEquipoPitcheo() {
		filas1 = new Object[15];
		if(!SerieNacional.getInstance().getMisJuegos().isEmpty()) {
			for (Equipo eq : SerieNacional.getInstance().getMisEquipos()) {
				eq.actualizarEstadisticasTotales();
				String era = String.format("%.3f",eq.getEstadisticaTotal().getERA());
				filas1[0]=eq.getNombre();
				filas1[1]=eq.getCantJuegosGanados();
				filas1[2]=eq.getCantJuegosPerdidos();
				filas1[3]=era;
				filas1[4]=eq.getEstadisticaTotal().getBB_pitcheo();
				filas1[5]=eq.getEstadisticaTotal().getCG();
				filas1[6]=eq.getEstadisticaTotal().getSHO();
				filas1[7]=eq.getEstadisticaTotal().getSV();
				filas1[8]=eq.getEstadisticaTotal().getIP();
				filas1[9]=eq.getEstadisticaTotal().getH_pitcheo();
				filas1[10]=eq.getEstadisticaTotal().getR();
				filas1[11]=eq.getEstadisticaTotal().getER();
				filas1[12]=eq.getEstadisticaTotal().getHR();
				filas1[13]=eq.getEstadisticaTotal().getBB_pitcheo();
				filas1[14]=eq.getEstadisticaTotal().getAVG_Pitcheo();
				modelo1.addRow(filas1);
				tablaPitcheo.setModel(modelo1);

			}




		}


	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
