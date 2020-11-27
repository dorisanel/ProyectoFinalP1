package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import logical.Equipo;
import logical.Jugador;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegLesion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txDiagnostico;
	private JComboBox comboBox;
	private JSpinner spDias;
	private JSpinner spFecha;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public RegLesion(Jugador jug) {
		setTitle("Registrar lesi\u00F3n para "+jug.getNombre());
		setType(Type.POPUP);
		setBounds(100, 100, 664, 444);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Categor\u00EDa:");
			lblNewLabel.setBounds(31, 21, 120, 26);
			panel.add(lblNewLabel);
			
			comboBox = new JComboBox();
			String[] categorias = {"<Seleccione>","Brazo","Mu�eca","Otro"};
			comboBox.setModel(new DefaultComboBoxModel(categorias));
			comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
			comboBox.setBounds(187, 23, 207, 26);
			panel.add(comboBox);
			
			JLabel lblNewLabel_1 = new JLabel("Fecha:");
			lblNewLabel_1.setBounds(31, 68, 92, 26);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("D\u00EDas lesionado:");
			lblNewLabel_2.setBounds(31, 116, 148, 23);
			panel.add(lblNewLabel_2);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(null);
			panel_1.setBounds(21, 161, 586, 157);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			txDiagnostico = new JTextField();
			txDiagnostico.setBounds(10, 31, 565, 124);
			panel_1.add(txDiagnostico);
			txDiagnostico.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Diagn\u00F3stico:");
			lblNewLabel_3.setBounds(10, 0, 141, 26);
			panel_1.add(lblNewLabel_3);
			
			spFecha = new JSpinner();
			spFecha.setModel(new SpinnerDateModel(new Date(1606449600000L), null, null, Calendar.DAY_OF_WEEK_IN_MONTH));
			spFecha.setBounds(187, 68, 207, 26);
			panel.add(spFecha);
			
			spDias = new JSpinner();
			spDias.setBounds(190, 114, 204, 26);
			panel.add(spDias);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String categoria = comboBox.getSelectedItem().toString();
							Date fecha = (Date) spFecha.getValue();
							int dias = Integer.valueOf(spDias.getValue().toString());
							String diagnostico = txDiagnostico.getText();
							logical.Lesion lesion = new logical.Lesion(diagnostico, categoria, fecha, dias);
							jug.getMisLesiones().add(lesion);
							JOptionPane.showMessageDialog(null, "Registro satisfactorio", "Info:", JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "No se pudo realizar el registro", "Error:", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
}
