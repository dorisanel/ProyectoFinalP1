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

public class ListarEquipos extends JDialog {
	private DefaultTableModel modelo;
	private Object[] filas;
	private JTable table;

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
				JButton eliminarBtn = new JButton("Eliminar");
				eliminarBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int selected = 0;
						int selEquipo;
						selected = table.getSelectedRow();
						SerieNacional.getInstance().getMisEquipos().remove(selected);
						modelo.setRowCount(0);
						eliminarBtn.setVisible(false);
						llenarTabla();
					}
				});
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
					filas[0]=equipo.getID();
					filas[1]=equipo.getNombre();
					filas[2]=equipo.getManager();
					filas[3]=equipo.getCantJuegos();
					filas[4]=equipo.getCantJuegosGanados();
					filas[5]=equipo.getCantJuegosPerdidos();
					modelo.addRow(filas);
			}
	}
	}
}
