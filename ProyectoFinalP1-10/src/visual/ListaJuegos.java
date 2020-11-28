package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
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

public class ListaJuegos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel modelo;
	private Object[] filas;
	private JButton startBtn;
	private JButton eliminarBtn;
	private JButton cancelBtn;

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
					
						startBtn.setEnabled(true);
						eliminarBtn.setEnabled(true);
					}
				});
				modelo = new DefaultTableModel();
				String[] header1 = {"Casa", "Visitante", "Estadio","Fecha","Estado"};
				modelo.setColumnIdentifiers(header1);
				table.setModel(modelo);
				
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				 startBtn = new JButton("Empezar Juego");
				 startBtn.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		startBtn.setEnabled(false);
				 	}
				 });
				startBtn.setEnabled(false);
				buttonPane.add(startBtn);
			}
			{
				 eliminarBtn = new JButton("Eliminar");
				 eliminarBtn.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		int rowIndex = table.getSelectedRow();
						
						SerieNacional.getInstance().getMisJuegos().remove(rowIndex);
				 		modelo.setRowCount(0);
				 		llenarTabla();
				 		deshabilitarBotones();
				 	}

				
				 });
				eliminarBtn.setEnabled(false);
				buttonPane.add(eliminarBtn);
			}
			{
				 cancelBtn = new JButton("Cerrar");
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
		String estado = null;
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date;
		for (Juego jue : SerieNacional.getInstance().getMisJuegos()) {
			date = simpleDateFormat.format(jue.getFecha());
					filas[0]=jue.getLocal();
					filas[1]=jue.getVisitante();
					filas[2]=jue.getEstadio();
					filas[3]=date;
					if(jue.isEstado() == true) {
						estado = "Pendiente";
					}else if(jue.isEstado() == false){
						estado = "Cancelado";
					}else if(jue.isEstado() == true && jue.isTerminado()==true) {
						estado = "Terminado";
					}
					filas[4]=estado;
					modelo.addRow(filas);
			}
		}
		}
	public void deshabilitarBotones() {
		eliminarBtn.setEnabled(false);
		startBtn.setEnabled(false);
		
	}

	}



