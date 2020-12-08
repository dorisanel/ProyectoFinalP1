package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
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
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

public class ListarEquipos extends JDialog {
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
	 	setIconImage(Toolkit.getDefaultToolkit().getImage("muuSawtA_preview_rev_2.png"));
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
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				 eliminarBtn = new JButton("Eliminar");
				 eliminarBtn.setBackground(SystemColor.controlHighlight);
				 eliminarBtn.setIcon(new ImageIcon("61848.png"));
				eliminarBtn.setEnabled(false);
				eliminarBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						int e1 = JOptionPane.showConfirmDialog(null, "Los datos de este equipo se eliminaran por completo, no podr� recuperar esta informaci�n", "Eliminando Jugador", JOptionPane.WARNING_MESSAGE);
						
						if(e1 == 0) {
						int selected = 0;
						int selEquipo;
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
					btnModificar.setIcon(new ImageIcon("modi.png"));
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
								aux = SerieNacional.getInstance().buscarEquipo((String)modelo.getValueAt(seleccion, 0));
								btnModificar.setEnabled(true);
								eliminarBtn.setEnabled(true);
							}
						}
					});
					
					modelo = new DefaultTableModel();
					String[] header1 = {"C�digo", "Nombre", "Manager","Juegos","Ganados","Perdidos"};
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
