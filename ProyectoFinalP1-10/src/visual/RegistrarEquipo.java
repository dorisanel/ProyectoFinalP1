package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.Equipo;
import logical.SerieNacional;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.Checkbox;
import javax.swing.JPasswordField;

public class RegistrarEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCod;
	private JTextField textNombre;
	private JTextField textManager;
	private JButton okButton;

	/**
	 * Create the dialog.
	 * @param object 
	 * @param modo 
	 * @param titulo 
	 */
	public RegistrarEquipo(String titulo, int modo, Equipo equipo) {
		setTitle(titulo);
		setBounds(100, 100, 414, 188);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setBounds(10, 12, 57, 14);
		contentPanel.add(lblNewLabel);
		
		textCod = new JTextField();
		textCod.setBounds(66, 8, 185, 23);
		contentPanel.add(textCod);
		textCod.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 46, 57, 14);
		contentPanel.add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setBounds(66, 42, 185, 23);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textManager = new JTextField();
		textManager.setBounds(66, 76, 185, 23);
		contentPanel.add(textManager);
		textManager.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Manager:");
		lblNewLabel_2.setBounds(10, 80, 57, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Logo:");
		lblNewLabel_3.setBounds(261, 12, 46, 14);
		contentPanel.add(lblNewLabel_3);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{

				okButton = new JButton(" ");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean logrado = false;
						
						if(modo == 0) {
							Equipo aux = null;
							

							//String cod = textCod.getText();
							String nombre = textNombre.getText();
							String manager = textManager.getText();

							aux = new Equipo(nombre, manager);

							if(!(nombre.isEmpty()) || !(manager.isEmpty()))
								logrado = true;

							if(logrado) {
								SerieNacional.getInstance().insertarEquipo(aux);
								JOptionPane.showMessageDialog(null, "Registro satisfactorio", "Información", JOptionPane.INFORMATION_MESSAGE);
								clean();
							}
							
							else
								JOptionPane.showMessageDialog(null, "Complete todas las casillas, por favor", "Error", JOptionPane.ERROR_MESSAGE);

						}


						else {

							//String cod = textCod.getText();
							String nombre = textNombre.getText();
							String manager = textManager.getText();
							
							if(!(nombre.isEmpty()) && !(manager.isEmpty())) {
								equipo.setManager(manager);
								equipo.setNombre(nombre);
								logrado = true;
							}

							if(logrado) {
								JOptionPane.showMessageDialog(null, "Modificación satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}
							
							else
								JOptionPane.showMessageDialog(null, "Complete todas las casillas, por favor", "Error", JOptionPane.ERROR_MESSAGE);
							
						}
					}
				});
				
				if(modo == 0)
					okButton.setText("Registrar");
				
				else
					okButton.setText("Modificar");
					
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

	protected void clean() {
		textCod.setText("");
		textNombre.setText("");
		textManager.setText("");
	}
}
