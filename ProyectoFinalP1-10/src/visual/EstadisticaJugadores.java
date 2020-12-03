package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logical.Bateador;
import logical.Jugador;
import logical.Pitcher;
import logical.SerieNacional;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.ScrollPaneConstants;

public class EstadisticaJugadores extends JDialog {

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
	public EstadisticaJugadores() {
		
		setTitle("Estad\u00EDstica de Jugadores");
		setBounds(100, 100, 982, 540);
		
		String[] columnPit = {"Jugador","Equipo", "JG", "JP", "PCL", "J", "A", "JC", "SHO", "JS", "OS", "IL", "H", "C", "CL", "HR",
				"GP", "BB", "P", "WHIP", "PRO"};
		
		String[] columnBat = {"Jugador","Equipo", "J", "TB", "C", "H","2B","3B","HR","CI","BB","P","BR","AR","PRO","OBP","SLG","OPS"};
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			
			
			cbxTipo = new JComboBox();
			cbxTipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(cbxTipo.getSelectedItem().toString() == "Pitcher")
					{
						
						modelo.setColumnIdentifiers(columnPit);
					}
					
					else if(cbxTipo.getSelectedItem().toString() == "Bateador") {
						
						modelo.setColumnIdentifiers(columnBat);
					}
									
					cargarTabla(cbxTipo.getSelectedItem().toString());
				}
			});
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Bateador", "Pitcher"}));
			cbxTipo.setBounds(76, 11, 107, 20);
			contentPanel.add(cbxTipo);
		}
		
		JLabel lblNewLabel = new JLabel("Posici\u00F3n:");
		lblNewLabel.setBounds(10, 14, 56, 14);
		contentPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 39, 946, 413);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(columnBat);			
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBackground(SystemColor.controlHighlight);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		cargarTabla("Bateador");
		
	}
	
	private void cargarTabla(String tipo) {
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];


		if(tipo == "Bateador") {

			for(Jugador jugador : SerieNacional.getInstance().getMisJugadores()) {
				
				//"Jugador","Equipo", "J", "TB", "C", "H","2B","3B","HR","CI","BB","P","BR","AR","PRO","OBP","SLG","OPS"
				if(jugador instanceof Bateador) {
					fila[0] = jugador.getNombre(); 
					fila[1] = SerieNacional.getInstance().equipoJugador(jugador);
					fila[2] = jugador.getCantJuegos();
					fila[3] = ((Bateador) jugador).getCantTurnos();
					fila[4] = ((Bateador) jugador).getCantCarreras();
					fila[5] = ((Bateador) jugador).getCantHits();
					fila[6] = ((Bateador) jugador).getCantDobles();
					fila[7] = ((Bateador) jugador).getCantTriples();
					fila[8] = ((Bateador) jugador).getCantJonrones();
					fila[9] = ((Bateador) jugador).getCantCarrerasImpulsadas();
					fila[10] = ((Bateador) jugador).getCantBoletos();
					fila[11] = ((Bateador) jugador).getCantPonches();
					fila[12] = ((Bateador) jugador).getCantBasesRobadas();
					fila[13] = ((Bateador) jugador).getCantAtrapadosRobando();
					fila[14] = jugador.PRO();
					fila[15] = ((Bateador) jugador).OBP();
					fila [16] = ((Bateador) jugador).SLG();
					fila[17] = ((Bateador) jugador).OPS();
					
					modelo.addRow(fila);
				}

				
				
			}
		}

		else if(tipo == "Pitcher") {

			for(Jugador jugador : SerieNacional.getInstance().getMisJugadores()) {

				if(jugador instanceof Pitcher) {
					
					//"Jugador","Equipo", "JG", "JP", "PCL", "J", "A", "JC", "SHO", "JS", "OS", "IL", "H", "C", "CL", "HR",
					//"GP", "BB", "P", "WHIP", "PRO"
					
					fila[0] = jugador.getNombre(); 
					fila[1] = SerieNacional.getInstance().equipoJugador(jugador);
					fila[2] = ((Pitcher) jugador).getJuegosGanados();
					fila[3] = ((Pitcher) jugador).getJuegosPerdidos();
					fila[4] = ((Pitcher) jugador).PCL();
					fila[5] = ((Pitcher) jugador).getJuegosLanzados();
					fila[6] = ((Pitcher) jugador).getAperturas();
					fila[7] = ((Pitcher) jugador).getJuegosCompletos();
					fila[8] = ((Pitcher) jugador).getJuegosBlanqueados();
					fila[9] = ((Pitcher) jugador).getSalvados();
					fila[10] = ((Pitcher) jugador).getOportSalvado();
					fila[11] = ((Pitcher) jugador).getInningsPitched();
					fila[12] = ((Pitcher) jugador).getCantHits();
					fila[13] = ((Pitcher) jugador).getCantCarreras();
					fila[14] = ((Pitcher) jugador).getCarrerasLimpias();
					fila[15] = ((Pitcher) jugador).getCantJonrones();
					fila [16] = ((Pitcher) jugador).getBateadoresGolpeados();
					fila[17] = ((Pitcher) jugador).getBoletos();
					fila[18] = ((Pitcher) jugador).getCantPonches();
					fila[19] = ((Pitcher) jugador).WHIP();
					fila[20] = jugador.PRO();	
					
					modelo.addRow(fila);
					
				}
				
				
				
			}

		}

		

	}
}
