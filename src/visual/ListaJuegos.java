package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logical.Equipo;
import logical.Juego;
import logical.Jugador;
import logical.SerieNacional;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

public class ListaJuegos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel modelo;
	private Object[] filas;
	private JButton startBtn;
	private JButton eliminarBtn;
	private JButton cancelBtn;
	private Equipo local = null;
	private Equipo visit = null;
	private Juego aux = null;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public ListaJuegos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				modelo.setRowCount(0);
				llenarTabla();
			}
		});
		setTitle("Listar Juegos");
		setBounds(100, 100, 645, 526);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						int seleccion = table.getSelectedRow();

						if(seleccion != -1) {
							local = SerieNacional.getInstance().buscarEquipo((String)modelo.getValueAt(seleccion, 1));
							visit = SerieNacional.getInstance().buscarEquipo((String)modelo.getValueAt(seleccion, 2));
							aux = SerieNacional.getInstance().buscarJuego((String)modelo.getValueAt(seleccion, 0));
							if(!aux.isTerminado())
								startBtn.setEnabled(true);
							
							eliminarBtn.setEnabled(true);
						}
						
						
						
					}
				});
				modelo = new DefaultTableModel();
				String[] header1 = {"Código","Casa", "Visitante", "Estadio","Fecha","Estado"};
				modelo.setColumnIdentifiers(header1);
				table.setModel(modelo);
				
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				 startBtn = new JButton("Empezar Juego");
				 startBtn.setIcon(new ImageIcon(ListaJuegos.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlay.png")));
				 startBtn.setBackground(SystemColor.activeCaption);
				 startBtn.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		startBtn.setEnabled(false);
				 		
				 			if(aux.getLocal().getMisJugadores().size()>=9 && aux.getVisitante().getMisJugadores().size()>=9) {
					 			SimulacionJuego j = new SimulacionJuego(aux, local, visit);
						 		j.setVisible(true);
					 		}
					 			
					 		else
					 			JOptionPane.showMessageDialog(null, "Estos equipos no tienen los suficientes jugadores para empezar un juego", "ERROR", JOptionPane.ERROR_MESSAGE);
					 		
				 		
				 		
				 		
				 	}
				 });
				 startBtn.setEnabled(false);
				 buttonPane.add(startBtn);
			}
			{
				eliminarBtn = new JButton("Eliminar");
				eliminarBtn.setIcon(new ImageIcon("61848.png"));
				eliminarBtn.setBackground(SystemColor.controlHighlight);
				eliminarBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int rowIndex = table.getSelectedRow();
						int e1 = JOptionPane.showConfirmDialog(null, "Los datos de este juego se eliminaran por completo, no podrá recuperar esta información", "Eliminando Jugador", JOptionPane.WARNING_MESSAGE);

						if(e1 == 0) {
							SerieNacional.getInstance().getMisJuegos().remove(rowIndex);
							modelo.setRowCount(0);
							llenarTabla();
							deshabilitarBotones();
						}
					}


				});
				eliminarBtn.setEnabled(false);
				buttonPane.add(eliminarBtn);
			}
			{
				 cancelBtn = new JButton("Cerrar");
				 cancelBtn.setIcon(new ImageIcon("61155.png"));
				 cancelBtn.setBackground(SystemColor.controlHighlight);
				cancelBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelBtn.setActionCommand("Cancel");
				buttonPane.add(cancelBtn);
			}
		}
	}
	private void llenarTabla() {
		if(SerieNacional.getInstance().getMisJuegos().isEmpty() == false) {
		filas = new Object[modelo.getColumnCount()];
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date;
		for (Juego jue : SerieNacional.getInstance().getMisJuegos()) {
			date = simpleDateFormat.format(jue.getFecha());
					filas[0] = jue.getCodigo();
					filas[1]=jue.getLocal().getNombre();
					filas[2]=jue.getVisitante().getNombre();
					filas[3]=jue.getEstadio();
					filas[4]=date;
					String estado = null;
					if(jue.isTerminado() == false && jue.isEstado() == true) {
						estado = "Pendiente";
					}if(jue.isTerminado()==true && jue.isEstado() == true) {
						estado = "Terminado";
					}
					filas[5]=estado;
					modelo.addRow(filas);
			}
		}
		}
	public void deshabilitarBotones() {
		eliminarBtn.setEnabled(false);
		startBtn.setEnabled(false);
		
	}

	}



