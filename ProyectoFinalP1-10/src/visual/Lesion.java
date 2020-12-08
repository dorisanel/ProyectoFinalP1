package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logical.Equipo;
import logical.Jugador;
import logical.SerieNacional;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Lesion extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTable table;
	private Object[] filas;
	private DefaultTableModel modelo;
	private Object comboBox;
	private JButton eliminarBtn;

	private JButton modificarBtn;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public Lesion(Jugador jug) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("muuSawtA_preview_rev_2.png"));
		setTitle("Lesiones de "+jug.getNombre());
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				modelo.setRowCount(0);
				llenarTabla(jug);
			}
		});
		setBounds(100, 100, 675, 519);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						if(table.isColumnSelected(0)&&table.getSelectedRow() != -1) {
							eliminarBtn.setEnabled(true);
							modificarBtn.setEnabled(true);
						}
							}
				
				});
				
				modelo = new DefaultTableModel();
				String[] header1 = {"Tipo de lesión", "Fecha", "Tiempo","Diagnóstico"};
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
				eliminarBtn = new JButton("Eliminar");
				eliminarBtn.setIcon(new ImageIcon("C:\\Users\\aneli\\git\\ProyectoFinalP1\\61848.png"));
				eliminarBtn.setBackground(SystemColor.activeCaption);
				eliminarBtn.setEnabled(false);
				eliminarBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int selected = 0;
							selected = table.getSelectedRow();
							logical.Lesion l1 = jug.getMisLesiones().get(selected);
							jug.getMisLesiones().remove(l1);
							modelo.setRowCount(0);
							llenarTabla(jug);
							eliminarBtn.setEnabled(false);
							modificarBtn.setEnabled(false);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "No se pudo realizar la modificación", "Error:", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				{
					modificarBtn = new JButton("Modificar");
					modificarBtn.setIcon(new ImageIcon("C:\\Users\\aneli\\git\\ProyectoFinalP1\\modi.png"));
					modificarBtn.setBackground(SystemColor.activeCaption);
					modificarBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								int rowIndex = table.getSelectedRow();
								
								String tipo = table.getModel().getValueAt(rowIndex, 0).toString();
								String Duracion = table.getModel().getValueAt(rowIndex, 2).toString();
								String Diagnostico = table.getModel().getValueAt(rowIndex, 3).toString();
								jug.getMisLesiones().get(rowIndex).setDiagnostico(Diagnostico);
								jug.getMisLesiones().get(rowIndex).setTipo(tipo);
								jug.getMisLesiones().get(rowIndex).setDiasLesionado(Integer.valueOf(Duracion));
								modelo.setRowCount(0);
								llenarTabla(jug);
								modificarBtn.setEnabled(false);
								JOptionPane.showMessageDialog(null, "Modificación satisfactoria", "Info:", JOptionPane.INFORMATION_MESSAGE);
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "No se pudo realizar la modificación", "Error:", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					});
					modificarBtn.setEnabled(false);
					buttonPane.add(modificarBtn);
				}
				eliminarBtn.setActionCommand("OK");
				buttonPane.add(eliminarBtn);
				getRootPane().setDefaultButton(eliminarBtn);
			}
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.setIcon(new ImageIcon("C:\\Users\\aneli\\git\\ProyectoFinalP1\\61155.png"));
				cancelButton.setBackground(SystemColor.activeCaption);
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
	private void llenarTabla(Jugador jug1) {
		filas = new Object[modelo.getColumnCount()];
		for (logical.Lesion ju : jug1.getMisLesiones()) {
					filas[0]=ju.getTipo();
					filas[1]=ju.getFechaLesion();
					filas[2]=ju.getDiasLesionado();
					filas[3]=ju.getDiagnostico();
					modelo.addRow(filas);
			}
		}


}
