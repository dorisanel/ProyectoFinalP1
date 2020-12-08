package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import logical.Bateador;
import logical.Jugador;
import logical.Pitcher;
import logical.SerieNacional;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Top10 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	public static DefaultTableModel modelo;
	public static Object[] fila;
	private JComboBox cbxTipo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Top10() {
		setTitle("Top 10 de Jugadores");
		setResizable(false);
		setBounds(100, 100, 583, 412);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Posici\u00F3n:");
			lblNewLabel.setBounds(10, 14, 66, 14);
			contentPanel.add(lblNewLabel);
		}
		
		cbxTipo = new JComboBox();
		cbxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarTabla(cbxTipo.getSelectedItem().toString());
			}
		});
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Bateadores", "Pitchers"}));
		cbxTipo.setBounds(81, 11, 94, 20);
		contentPanel.add(cbxTipo);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 39, 547, 290);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel();
		String[] columns = {"Nombre","Dorsal", "Edad", "Juegos", "Promedio"};
		modelo.setColumnIdentifiers(columns);
		table = new JTable();
		table.setModel(modelo);
		
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.setIcon(new ImageIcon("61155.png"));
				cancelButton.setBackground(SystemColor.controlHighlight);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		cargarTabla(cbxTipo.getSelectedItem().toString());
	}
	
	private void cargarTabla(String tipo) {
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];


		if(tipo == "Bateadores") {

			for(Jugador jugador : SerieNacional.getInstance().mvpDiezBateador()) {

				fila[0] = jugador.getNombre(); 
				fila[1] = jugador.getNumero();
				fila[2] = jugador.getEdad();
				fila[3] = jugador.getCantJuegos();
				fila[4] = jugador.PRO();

			}
		}

		else if(tipo == "Pitchers") {

			for(Jugador jugador : SerieNacional.getInstance().mvpDiezPitcher()) {


				fila[0] = jugador.getNombre(); 
				fila[1] = jugador.getNumero();
				fila[2] = jugador.getEdad();
				fila[3] = jugador.getCantJuegos();
				fila[4] = ((Pitcher) jugador).PCL();

			}

		}

		modelo.addRow(fila);

	}

}
