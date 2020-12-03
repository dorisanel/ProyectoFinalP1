package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.javafx.embed.swing.Disposer;

import javafx.scene.control.ComboBox;
import logical.Equipo;
import logical.Jugador;
import logical.Pitcher;
import logical.SerieNacional;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoJugador extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel modelo;
	private JTable table;
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	private Object[] filas;
	private JButton lesionesBtn;
	private JButton regLesionBtn;
	private JButton eliminarBtn;
	private JButton modificarBtn;
	private Jugador aux = null;
	private String[] text;
	private JPanel panel_1;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public ListadoJugador() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				generarLista();
				lesionesBtn.setEnabled(false);
				regLesionBtn.setEnabled(false);
				modelo.setRowCount(0);
				llenarTabla();
			}
		});

		setTitle("Listado de jugadores");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 742, 473);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{92, 0, 0};
			gbl_panel.rowHeights = new int[] {29, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				panel_1 = new JPanel();
				panel_1.setLayout(null);
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.gridwidth = 2;
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 0;
				gbc_panel_1.gridy = 0;
				panel.add(panel_1, gbc_panel_1);
				{
					JLabel lblNewLabel = new JLabel("Equipo:");
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
					lblNewLabel.setBounds(0, 0, 92, 26);
					panel_1.add(lblNewLabel);
				}

			}
		}
		{
			scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						int seleccion = table.getSelectedRow();

						if(seleccion != -1) {

							aux = SerieNacional.getInstance().buscarJugador((String)modelo.getValueAt(seleccion, 0));
							lesionesBtn.setEnabled(true);
							regLesionBtn.setEnabled(true);
							eliminarBtn.setEnabled(true);
							modificarBtn.setEnabled(true);

						}
					}
				});
				modelo = new DefaultTableModel();
				String[] header1 = {"ID", "Nombre", "Número","Equipo","Posición","Estado"};
				modelo.setColumnIdentifiers(header1);
				table.setModel(modelo);
				scrollPane.setViewportView(table);
			}



			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				regLesionBtn = new JButton("Registrar lesi\u00F3n");
				regLesionBtn.setEnabled(false);
				regLesionBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						RegLesion RegLesion = new RegLesion(aux);
						
						RegLesion.setVisible(true);
						regLesionBtn.setEnabled(false);
						modificarBtn.setEnabled(false);
						eliminarBtn.setEnabled(false);
					}
				});
				regLesionBtn.setEnabled(false);
				buttonPane.add(regLesionBtn);
			}
			{
				lesionesBtn = new JButton("Ver lesiones");
				lesionesBtn.setEnabled(false);
				lesionesBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Jugador jug = aux;
						Lesion l1 = new Lesion(jug);
						l1.setVisible(true);
						lesionesBtn.setEnabled(false);
					}

				});
				buttonPane.add(lesionesBtn);
			}
			{
				modificarBtn = new JButton("Modificar");
				modificarBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if(aux != null) {
							RegistrarJugador eq = new RegistrarJugador("Modificar Jugador", 1, aux);
							eq.setVisible(true);
							eq.setLocationRelativeTo(null);
							eq.setResizable(false);
						}

					}
				});
				modificarBtn.setEnabled(false);
				buttonPane.add(modificarBtn);
			}
			{
				eliminarBtn = new JButton("Eliminar");
				eliminarBtn.setEnabled(false);
				eliminarBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int selected = 0;
						int selEquipo;
						selected = table.getSelectedRow();
						selEquipo = comboBox.getSelectedIndex();
						SerieNacional.getInstance().getMisEquipos().get(selEquipo).getMisJugadores().remove(selected);
						eliminarBtn.setVisible(false);
						llenarTabla();
						modelo.setRowCount(0);
					}
				});
				eliminarBtn.setActionCommand("OK");
				buttonPane.add(eliminarBtn);
				getRootPane().setDefaultButton(eliminarBtn);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void llenarTabla() {
		if(SerieNacional.getInstance().getMisEquipos().isEmpty() == false) {
			filas = new Object[modelo.getColumnCount()];
			String tipoAFiltrar = comboBox.getSelectedItem().toString();
			for (Equipo equipo : SerieNacional.getInstance().getMisEquipos()) {
				for (Jugador jue : equipo.getMisJugadores()) {
					if(tipoAFiltrar == equipo.getNombre()) {
						filas[0]=jue.getCedula();
						filas[1]=jue.getNombre();
						filas[2]=jue.getNumero();
						filas[3]=equipo.getNombre();
						filas[4]=detPosicion(jue);
						filas[5]=estado(jue.isEstado());
						modelo.addRow(filas);
					}

					if(tipoAFiltrar == "<Todos>"){

						filas[0]=jue.getCedula();
						filas[1]=jue.getNombre();
						filas[2]=jue.getNumero();
						filas[3]=equipo.getNombre();
						filas[4]=detPosicion(jue);
						filas[5]=estado(jue.isEstado());
						modelo.addRow(filas);
					}
				}
			}
		}


	}


	public String estado(boolean isEstado) {
		String estado;
		if(isEstado == true) {
			estado = "Disponible";
		}else {
			estado = "No disponible";
		}
		return estado;
	}
	public String detPosicion(Jugador juga) {
		String salida;
		if(juga instanceof Pitcher) {
			salida = "Lanzador";
		}else {
			salida = "pitcher";
		}
		return salida;
	}


	public Equipo buscarEquipo(String string) {
		Equipo equipoEncontrado = null;
		for(Equipo jug : SerieNacional.getInstance().getMisEquipos()) {
			if(jug.getNombre().compareToIgnoreCase(string) == 0) {
				equipoEncontrado = jug;
			}
		}
		return equipoEncontrado;
	}
	public void generarLista() {
		int cant = 0;
		cant = SerieNacional.getInstance().getMisEquipos().size();
		text = new String[cant+1];
		text[0] = "<Todos>";
		int i = 1;
		for (Equipo ser : SerieNacional.getInstance().getMisEquipos()) {
			text[i] = ser.getNombre();
			i++;
		}
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.setRowCount(0);
				llenarTabla();

			}
		});

		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(60, 2, 248, 23);
		panel_1.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(text));

	}

}
