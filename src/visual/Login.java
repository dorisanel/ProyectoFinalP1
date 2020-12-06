package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.SerieNacional;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUser;
	private JLabel lblNewLabel_1;
	private JButton btnEntrar;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setTitle("Login");
		setBounds(100, 100, 455, 231);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(10, 44, 65, 14);
		contentPanel.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setBounds(85, 41, 185, 23);
		contentPanel.add(txtUser);
		txtUser.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(10, 96, 79, 14);
		contentPanel.add(lblNewLabel_1);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(String.valueOf(txtPass.getPassword()).matches("Admin") && txtUser.getText().matches("Admin")){
					Principal aux = new Principal();
					aux.setVisible(true);
					dispose();
				}
			
				
				
				else {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
					txtUser.setText("");
					txtPass.setText("");
				}
				
				
			}
		});
		btnEntrar.setBounds(340, 158, 89, 23);
		contentPanel.add(btnEntrar);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(85, 93, 185, 23);
		contentPanel.add(txtPass);
	}
}
