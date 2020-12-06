package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logical.Equipo;
import logical.Jugador;
import logical.SerieNacional;

import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class ListarEquipos extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7166303890710526947L;
	private DefaultTableModel modelo;
	private Object[] filas;
	private JTable table;
	private JButton eliminarBtn;
	private Equipo aux = null;
	private JButton btnModificar;
	

	/**
	 * Launch the application.
	 */
	 /**
	 * Create the dialog.
	 */
	public ListarEquipos() {
	 	setTitle("Listado de equipos");
	 	addWindowListener(new WindowAdapter() {
	 		@Override
	 		public void windowActivated(WindowEvent e) {
	 			modelo.setRowCount(0);
	 			llenarTabla();
	 		}
	 	});
		setBounds(100, 100, 667, 529);
		getContentPane().setLayout(new BorderLayout());
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				 eliminarBtn = new JButton("Eliminar");
				eliminarBtn.setEnabled(false);
				eliminarBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						int e1 = JOptionPane.showConfirmDialog(null, "Los datos de este equipo se eliminaran por completo, no podrá recuperar esta información", "Eliminando Jugador", JOptionPane.WARNING_MESSAGE);
						
						if(e1 == 0) {
						int selected = 0;
					
						selected = table.getSelectedRow();
						SerieNacional.getInstance().getMisEquipos().remove(selected);
						modelo.setRowCount(0);
						eliminarBtn.setEnabled(false);
						llenarTabla();
						}
					}
				});
				{
					btnModificar = new JButton("Modificar");
					btnModificar.setEnabled(false);
					btnModificar.setBackground(SystemColor.controlHighlight);
					btnModificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(aux != null) {
								
								RegistrarEquipo eq = new RegistrarEquipo("Modificar Equipo", 1, aux);
								eq.setVisible(true);
								eq.setLocationRelativeTo(null);
								eq.setResizable(false);
								btnModificar.setEnabled(false);
								eliminarBtn.setEnabled(false);
							}
						}
					});
					buttonPane.add(btnModificar);
				}
				eliminarBtn.setActionCommand("OK");
				buttonPane.add(eliminarBtn);
				getRootPane().setDefaultButton(eliminarBtn);
			}
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane);
				{
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							
							int seleccion = table.getSelectedRow();

							if(seleccion != -1) {
								aux = SerieNacional.getInstance().buscarEquipo((String)modelo.getValueAt(seleccion, 1));
								btnModificar.setEnabled(true);
								eliminarBtn.setEnabled(true);
							}
						}
					});
					
					modelo = new DefaultTableModel();
					String[] header1 = {"Código", "Nombre", "Manager","Juegos","Ganados","Perdidos"};
					modelo.setColumnIdentifiers(header1);
					table.setModel(modelo);
					scrollPane.setViewportView(table);
				}
			}
		}
	}
	private void llenarTabla() {
		if(SerieNacional.getInstance().getMisEquipos().isEmpty() == false) {
		filas = new Object[modelo.getColumnCount()];
		for (Equipo equipo : SerieNacional.getInstance().getMisEquipos()) {
			try {
				if(equipo.getImage().getImage() != null) {
					Image imgIcon = equipo.getImage().getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
					ImageIcon img2 =(ImageIcon) new ImageIcon(imgIcon); 
				}
			}catch(NullPointerException e33) {
				
			}
					table.setRowHeight(50);
					filas[0]=equipo.getID();
					filas[1]=equipo.getNombre();
					filas[2]=equipo.getManager();
					filas[3]=equipo.getCantJuegos();
					filas[4]=equipo.getCantJuegosGanados();
					filas[5]=equipo.getCantJuegosPerdidos();
					
					modelo.addRow(filas);
				
			}
	}else {
		JOptionPane.showMessageDialog(null, "No hay datos que mostrar", "Error", JOptionPane.ERROR_MESSAGE);
		dispose();
	}
	}
}

