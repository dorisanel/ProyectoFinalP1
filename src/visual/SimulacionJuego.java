package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logical.Bateador;
import logical.Equipo;
import logical.Juego;
import logical.Jugador;
import logical.Pitcher;
import logical.SerieNacional;

import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class SimulacionJuego extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableBatLocal;
	private JTable tablePitLocal;
	private JTable tableBatVisit;
	private JTable tablePitVisit;
	private JTable table_2;
	public static DefaultTableModel modeloBatLoc;
	public static DefaultTableModel modeloPitLoc;
	public static Object[] filaBatLoc;
	public static Object[] filaPitLoc;

	public static DefaultTableModel modeloBatVis;
	public static DefaultTableModel modeloPitVis;
	public static Object[] filaBatVis;
	public static Object[] filaPitVis;

	public static DefaultTableModel modelo;
	public static Object[] fila;
	private JButton btnTerminar;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public SimulacionJuego(Juego juego, Equipo local, Equipo visitante) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("muuSawtA_preview_rev_2.png"));
		setTitle("Simulaci\u00F3n de Juego");

		String[] columnPit = {"Pitcher", "J", "A", "JC", "SHO", "JS", "OS", "IL", "H", "C", "CL", "HR",
				"GP", "BB", "P"};

		String[] columnBat = {"Bateador", "TB", "C", "H","2B","3B","HR","CI","BB","P","BR","AR"};

		String[] column = {"Equipo", "Carreras"};

		modeloBatLoc = new DefaultTableModel();
		modeloPitLoc = new DefaultTableModel();
		modeloBatVis = new DefaultTableModel();
		modeloPitVis = new DefaultTableModel();
		modelo = new DefaultTableModel();

		setBounds(100, 100, 1101, 768);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JPanel panelLocal = new JPanel();


			panelLocal.setBorder(new TitledBorder(null, local.getNombre(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelLocal.setBounds(10, 11, 866, 316);
			contentPanel.add(panelLocal);
			panelLocal.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 21, 846, 130);
				panelLocal.add(scrollPane);
				{
					tableBatLocal = new JTable();
					modeloBatLoc.setColumnIdentifiers(columnBat);
					tableBatLocal.setModel(modeloBatLoc);
					scrollPane.setViewportView(tableBatLocal);
				}
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 162, 846, 139);
				panelLocal.add(scrollPane);
				{
					tablePitLocal = new JTable();
					modeloPitLoc.setColumnIdentifiers(columnPit);
					tablePitLocal.setModel(modeloPitLoc);
					scrollPane.setViewportView(tablePitLocal);
				}
			}
		}

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 347, 866, 10);
		contentPanel.add(separator);
		{
			JPanel panelVisit = new JPanel();
			modeloPitVis.setColumnIdentifiers(columnPit);
			modeloBatVis.setColumnIdentifiers(columnBat);
			panelVisit.setBorder(new TitledBorder(null, visitante.getNombre(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelVisit.setBounds(10, 368, 866, 309);
			contentPanel.add(panelVisit);
			panelVisit.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 21, 846, 150);
				panelVisit.add(scrollPane);
				{
					tableBatVisit = new JTable();
					tableBatVisit.setModel(modeloBatVis);
					scrollPane.setViewportView(tableBatVisit);
				}
			}

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 172, 846, 126);
			panelVisit.add(scrollPane);

			tablePitVisit = new JTable();
			tablePitVisit.setModel(modeloPitVis);
			scrollPane.setViewportView(tablePitVisit);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Puntuaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(875, 11, 194, 174);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));

			JScrollPane scrollPane = new JScrollPane();
			panel.add(scrollPane, BorderLayout.CENTER);

			table_2 = new JTable();
			modelo.setColumnIdentifiers(column);
			table_2.setModel(modelo);
			table_2.setRowSelectionAllowed(false);
			scrollPane.setViewportView(table_2);
		}
		{
			JLabel lblCasa = new JLabel("");
			try {
				Image imgIcon = local.getImage().getImage().getScaledInstance(177, 133, Image.SCALE_SMOOTH);
				ImageIcon img2 =(ImageIcon) new ImageIcon(imgIcon); 
				lblCasa.setIcon(img2);
			} catch(Exception e) {
				
			}
			
			lblCasa.setBounds(886, 196, 183, 183);
			contentPanel.add(lblCasa);
		}
		{
			JLabel lblVisitante = new JLabel("");
			try {
				Image imgIcon = visitante.getImage().getImage().getScaledInstance(177, 133, Image.SCALE_SMOOTH);
				ImageIcon img2 =(ImageIcon) new ImageIcon(imgIcon); 
				lblVisitante.setIcon(img2);
			} catch(Exception e) {
				
			}
			
			lblVisitante.setBounds(885, 484, 183, 183);
			contentPanel.add(lblVisitante);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Vs");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 29));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblNewLabel_2.setBounds(875, 417, 194, 26);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(21, 177, 848, -164);
			contentPanel.add(panel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSimular = new JButton("Simular");
				btnSimular.setBackground(SystemColor.controlHighlight);
				btnSimular.setIcon(new ImageIcon(SimulacionJuego.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
				btnSimular.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnTerminar.setEnabled(true);
						cargarTabla(local, visitante);
						
					}
				});
				{
					btnTerminar = new JButton("Terminar Juego");
					btnTerminar.setBackground(SystemColor.controlHighlight);
					btnTerminar.setEnabled(false);
					btnTerminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {

							int filaBL = 0;
							int filaPL = 0;
							int filaBV = 0;
							int filaPV = 0;

							for(Jugador jugador : local.getMisJugadores()) {

								jugador.setCantJuegos(jugador.getCantJuegos()+1);

								if(jugador instanceof Bateador) {

									//"Bateador", "TB", "C", "H","2B","3B","HR","CI","BB","P","BR","AR"
									//try {
										((Bateador) jugador).setCantTurnos(((Bateador) jugador).getCantTurnos()+Integer.valueOf(tableBatLocal.getValueAt(filaBL, 1).toString()));
										((Bateador) jugador).setCantCarreras(((Bateador) jugador).getCantCarreras()+Integer.valueOf(tableBatLocal.getValueAt(filaBL, 2).toString()));
										((Bateador) jugador).setCantHits(((Bateador) jugador).getCantHits()+Integer.valueOf(tableBatLocal.getValueAt(filaBL, 3).toString()));
										((Bateador) jugador).setCantDobles(((Bateador) jugador).getCantDobles()+Integer.valueOf(tableBatLocal.getValueAt(filaBL, 4).toString()));
										((Bateador) jugador).setCantTriples(((Bateador) jugador).getCantTriples()+Integer.valueOf(tableBatLocal.getValueAt(filaBL, 5).toString()));
										((Bateador) jugador).setCantJonrones(((Bateador) jugador).getCantJonrones()+Integer.valueOf(tableBatLocal.getValueAt(filaBL, 6).toString()));
										((Bateador) jugador).setCantCarrerasImpulsadas(((Bateador) jugador).getCantCarrerasImpulsadas()+Integer.valueOf(tableBatLocal.getValueAt(filaBL, 7).toString()));
										((Bateador) jugador).setCantBoletos(((Bateador) jugador).getCantBoletos()+Integer.valueOf(tableBatLocal.getValueAt(filaBL, 8).toString()));
										((Bateador) jugador).setCantPonches(((Bateador) jugador).getCantPonches()+Integer.valueOf(tableBatLocal.getValueAt(filaBL, 9).toString()));
										((Bateador) jugador).setCantBasesRobadas(((Bateador) jugador).getCantBasesRobadas()+Integer.valueOf(tableBatLocal.getValueAt(filaBL, 10).toString()));
										((Bateador) jugador).setCantAtrapadosRobando(((Bateador) jugador).getCantAtrapadosRobando()+Integer.valueOf(tableBatLocal.getValueAt(filaBL, 11).toString()));

										filaBL++;
									//} catch(Exception e) {
										
									//}
									
								}

								if(jugador instanceof Pitcher) {

									//"Pitcher", "J", "A", "JC", "SHO", "JS", "OS", "IL", "H", "C", "CL", "HR",
									//"GP", "BB", "P"
									//try {
										((Pitcher) jugador).setJuegosLanzados(((Pitcher) jugador).getJuegosLanzados()+Integer.valueOf(tablePitLocal.getValueAt(filaPL, 1).toString()));
										((Pitcher) jugador).setAperturas(((Pitcher) jugador).getAperturas()+Integer.valueOf(tablePitLocal.getValueAt(filaPL, 2).toString()));
										((Pitcher) jugador).setJuegosCompletos(((Pitcher) jugador).getJuegosCompletos()+Integer.valueOf(tablePitLocal.getValueAt(filaPL, 3).toString()));
										((Pitcher) jugador).setJuegosBlanqueados(((Pitcher) jugador).getJuegosBlanqueados()+Integer.valueOf(tablePitLocal.getValueAt(filaPL, 4).toString()));
										((Pitcher) jugador).setSalvados(((Pitcher) jugador).getSalvados()+Integer.valueOf(tablePitLocal.getValueAt(filaPL, 5).toString()));
										((Pitcher) jugador).setOportSalvado(((Pitcher) jugador).getOportSalvado()+Integer.valueOf(tablePitLocal.getValueAt(filaPL, 6).toString()));
										((Pitcher) jugador).setInningsPitched(((Pitcher) jugador).getInningsPitched()+Integer.valueOf(tablePitLocal.getValueAt(filaPL, 7).toString()));
										((Pitcher) jugador).setCantHits(((Pitcher) jugador).getCantHits()+Integer.valueOf(tablePitLocal.getValueAt(filaPL, 8).toString()));
										((Pitcher) jugador).setCantCarreras(((Pitcher) jugador).getCantCarreras()+Integer.valueOf(tablePitLocal.getValueAt(filaPL, 9).toString()));
										((Pitcher) jugador).setCarrerasLimpias(((Pitcher) jugador).getCarrerasLimpias()+Integer.valueOf(tablePitLocal.getValueAt(filaPL, 10).toString()));
										((Pitcher) jugador).setCantJonrones(((Pitcher) jugador).getCantJonrones()+Integer.valueOf(tablePitLocal.getValueAt(filaPL, 11).toString()));
										((Pitcher) jugador).setBateadoresGolpeados(((Pitcher) jugador).getBateadoresGolpeados()+Integer.valueOf(tablePitLocal.getValueAt(filaPL, 12).toString()));
										((Pitcher) jugador).setBoletos(((Pitcher) jugador).getBoletos()+Integer.valueOf(tablePitLocal.getValueAt(filaPL, 13).toString()));
										((Pitcher) jugador).setCantPonches(((Pitcher) jugador).getCantPonches()+Integer.valueOf(tablePitLocal.getValueAt(filaPL, 14).toString()));

										filaPL++;
									//} catch(Exception e) {
										
									//}
									
								}

							}

							for(Jugador jugador : visitante.getMisJugadores()) {

								jugador.setCantJuegos(jugador.getCantJuegos()+1);

								if(jugador instanceof Bateador) {

									//"Bateador", "TB", "C", "H","2B","3B","HR","CI","BB","P","BR","AR"
									//try {
										((Bateador) jugador).setCantTurnos(((Bateador) jugador).getCantTurnos()+Integer.valueOf(tableBatVisit.getValueAt(filaBV, 1).toString()));
										((Bateador) jugador).setCantCarreras(((Bateador) jugador).getCantCarreras()+Integer.valueOf(tableBatVisit.getValueAt(filaBV, 2).toString()));
										((Bateador) jugador).setCantHits(((Bateador) jugador).getCantHits()+Integer.valueOf(tableBatVisit.getValueAt(filaBV, 3).toString()));
										((Bateador) jugador).setCantDobles(((Bateador) jugador).getCantDobles()+Integer.valueOf(tableBatVisit.getValueAt(filaBV, 4).toString()));
										((Bateador) jugador).setCantTriples(((Bateador) jugador).getCantTriples()+Integer.valueOf(tableBatVisit.getValueAt(filaBV, 5).toString()));
										((Bateador) jugador).setCantJonrones(((Bateador) jugador).getCantJonrones()+Integer.valueOf(tableBatVisit.getValueAt(filaBV, 6).toString()));
										((Bateador) jugador).setCantCarrerasImpulsadas(((Bateador) jugador).getCantCarrerasImpulsadas()+Integer.valueOf(tableBatVisit.getValueAt(filaBV, 7).toString()));
										((Bateador) jugador).setCantBoletos(((Bateador) jugador).getCantBoletos()+Integer.valueOf(tableBatVisit.getValueAt(filaBV, 8).toString()));
										((Bateador) jugador).setCantPonches(((Bateador) jugador).getCantPonches()+Integer.valueOf(tableBatVisit.getValueAt(filaBV, 9).toString()));
										((Bateador) jugador).setCantBasesRobadas(((Bateador) jugador).getCantBasesRobadas()+Integer.valueOf(tableBatVisit.getValueAt(filaBV, 10).toString()));
										((Bateador) jugador).setCantAtrapadosRobando(((Bateador) jugador).getCantAtrapadosRobando()+Integer.valueOf(tableBatVisit.getValueAt(filaBV, 11).toString()));

										filaBV++;
									//} catch(Exception e) {
										
									//}
									
								}

								if(jugador instanceof Pitcher) {

									//"Pitcher", "J", "A", "JC", "SHO", "JS", "OS", "IL", "H", "C", "CL", "HR",
									//"GP", "BB", "P"
									//try {
										((Pitcher) jugador).setJuegosLanzados(((Pitcher) jugador).getJuegosLanzados()+Integer.valueOf(tablePitVisit.getValueAt(filaPV, 1).toString()));
										((Pitcher) jugador).setAperturas(((Pitcher) jugador).getAperturas()+Integer.valueOf(tablePitVisit.getValueAt(filaPV, 2).toString()));
										((Pitcher) jugador).setJuegosCompletos(((Pitcher) jugador).getJuegosCompletos()+Integer.valueOf(tablePitVisit.getValueAt(filaPV, 3).toString()));
										((Pitcher) jugador).setJuegosBlanqueados(((Pitcher) jugador).getJuegosBlanqueados()+Integer.valueOf(tablePitVisit.getValueAt(filaPV, 4).toString()));
										((Pitcher) jugador).setSalvados(((Pitcher) jugador).getSalvados()+Integer.valueOf(tablePitVisit.getValueAt(filaPV, 5).toString()));
										((Pitcher) jugador).setOportSalvado(((Pitcher) jugador).getOportSalvado()+Integer.valueOf(tablePitVisit.getValueAt(filaPV, 6).toString()));
										((Pitcher) jugador).setInningsPitched(((Pitcher) jugador).getInningsPitched()+Integer.valueOf(tablePitVisit.getValueAt(filaPV, 7).toString()));
										((Pitcher) jugador).setCantHits(((Pitcher) jugador).getCantHits()+Integer.valueOf(tablePitVisit.getValueAt(filaPV, 8).toString()));
										((Pitcher) jugador).setCantCarreras(((Pitcher) jugador).getCantCarreras()+Integer.valueOf(tablePitVisit.getValueAt(filaPV, 9).toString()));
										((Pitcher) jugador).setCarrerasLimpias(((Pitcher) jugador).getCarrerasLimpias()+Integer.valueOf(tablePitVisit.getValueAt(filaPV, 10).toString()));
										((Pitcher) jugador).setCantJonrones(((Pitcher) jugador).getCantJonrones()+Integer.valueOf(tablePitVisit.getValueAt(filaPV, 11).toString()));
										((Pitcher) jugador).setBateadoresGolpeados(((Pitcher) jugador).getBateadoresGolpeados()+Integer.valueOf(tablePitVisit.getValueAt(filaPV, 12).toString()));
										((Pitcher) jugador).setBoletos(((Pitcher) jugador).getBoletos()+Integer.valueOf(tablePitVisit.getValueAt(filaPV, 13).toString()));
										((Pitcher) jugador).setCantPonches(((Pitcher) jugador).getCantPonches()+Integer.valueOf(tablePitVisit.getValueAt(filaPV, 14).toString()));

										filaPV++;
									//}catch(Exception e) {
										
									//}
									
								}

							}
							if(juego != null) {
								juego.setCantCarrerasL(Integer.valueOf(table_2.getValueAt(0, 1).toString()));
								juego.setCantCarrerasV(Integer.valueOf(table_2.getValueAt(1, 1).toString()));
								
								juego.setGanadorPerdedor();
								juego.setTerminado(true);
								juego.setEstado(true);
								JOptionPane.showMessageDialog(null, "Local: "+juego.getCantCarrerasL()+" Carreras"+"\nVisitante: "+juego.getCantCarrerasV()+" Carreras", "Juego Terminado", JOptionPane.INFORMATION_MESSAGE);
								SerieNacional.getInstance().setUltimoJuego(juego);
								dispose();
							}
							

						}
					});
					buttonPane.add(btnTerminar);
				}
				btnSimular.setActionCommand("OK");
				buttonPane.add(btnSimular);
				getRootPane().setDefaultButton(btnSimular);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(SystemColor.controlHighlight);
				cancelButton.setIcon(new ImageIcon("61155.png"));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}

			cargarTablaLocal(local);
			cargarTablaVisit(visitante);
		}

	}



	private void cargarTablaLocal(Equipo e) {
		modeloBatLoc.setRowCount(0);
		filaBatLoc = new Object[modeloBatLoc.getColumnCount()];
		modeloPitLoc.setRowCount(0);
		filaPitLoc = new Object[modeloPitLoc.getColumnCount()];

		for(Jugador jugador : e.getMisJugadores()) {

			if(jugador instanceof Bateador) {
				filaBatLoc[0] = jugador.getNombre();
				filaBatLoc[1] = 0;
				filaBatLoc[2] = 0;
				filaBatLoc[3] = 0;
				filaBatLoc[4] = 0;
				filaBatLoc[5] = 0;
				filaBatLoc[6] = 0;
				filaBatLoc[7] = 0;
				filaBatLoc[8] = 0;
				filaBatLoc[9] = 0;
				filaBatLoc[10] = 0;
				filaBatLoc[11] = 0;
				modeloBatLoc.addRow(filaBatLoc);
				
			}

			if(jugador instanceof Pitcher) {
				filaPitLoc[0] = jugador.getNombre();
				
				filaPitLoc[1] = 0;
				filaPitLoc[2] = 0;
				filaPitLoc[3] = 0;
				filaPitLoc[4] = 0;
				filaPitLoc[5] = 0;
				filaPitLoc[6] = 0;
				filaPitLoc[7] = 0;
				filaPitLoc[8] = 0;
				filaPitLoc[9] = 0;
				filaPitLoc[10] = 0;
				filaPitLoc[11] = 0;
				filaPitLoc[12] = 0;
				filaPitLoc[13] = 0;
				filaPitLoc[14] = 0;
				modeloPitLoc.addRow(filaPitLoc);
			}

		}




	}

	private void cargarTablaVisit(Equipo e){

		modeloBatVis.setRowCount(0);
		filaBatVis = new Object[modeloBatVis.getColumnCount()];
		modeloPitVis.setRowCount(0);
		filaPitVis = new Object[modeloPitVis.getColumnCount()];

		for(Jugador jugador : e.getMisJugadores()) {

			if(jugador instanceof Bateador) {
				filaBatVis[0] = jugador.getNombre();
				filaBatVis[1] = 0;
				filaBatVis[2] = 0;
				filaBatVis[3] = 0;
				filaBatVis[4] = 0;
				filaBatVis[5] = 0;
				filaBatVis[6] = 0;
				filaBatVis[7] = 0;
				filaBatVis[8] = 0;
				filaBatVis[9] = 0;
				filaBatVis[10] = 0;
				filaBatVis[11] = 0;
				modeloBatVis.addRow(filaBatVis);
				
			}
			if(jugador instanceof Pitcher) {
				filaPitVis[0] = jugador.getNombre(); 
				filaPitVis[1] = 0;
				filaPitVis[2] = 0;
				filaPitVis[3] = 0;
				filaPitVis[4] = 0;
				filaPitVis[5] = 0;
				filaPitVis[6] = 0;
				filaPitVis[7] = 0;
				filaPitVis[8] = 0;
				filaPitVis[9] = 0;
				filaPitVis[10] = 0;
				filaPitVis[11] = 0;
				filaPitVis[12] = 0;
				filaPitVis[13] = 0;
				filaPitVis[14] = 0;
				modeloPitVis.addRow(filaPitVis);
				
			}

		}

	}


	private void cargarTabla(Equipo l, Equipo v){

		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];
		int totalCarreras = 0;
		fila[0] = l.getNombre();
		for(int i=0; i<l.getMisJugadores().size();i++) {
			try {
				totalCarreras += Integer.valueOf((String) tableBatLocal.getValueAt(i, 2));
			}catch(Exception e) {
				
			}
			
		}

		fila[1] = totalCarreras;
		modelo.addRow(fila);
		
		totalCarreras = 0;
		fila[0] = v.getNombre();
		for(int i=0; i<v.getMisJugadores().size();i++) {
			try {
				totalCarreras += Integer.valueOf((String) tableBatVisit.getValueAt(i, 2));
			}catch(Exception e) {
				
			}
			
		}

		fila[1] = totalCarreras;
		modelo.addRow(fila);


	}
	
}

