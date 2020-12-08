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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUser;
	private JLabel lblNewLabel_1;
	private JButton btnEntrar;
	private JPasswordField txtPass;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				FileInputStream serieN;
				FileOutputStream serieN2;
				ObjectInputStream serieRead;
				ObjectOutputStream serieWrite;
				try {
					serieN = new FileInputStream("SerieNacional.dat");
					serieRead = new ObjectInputStream(serieN); 
					SerieNacional temp = (SerieNacional)serieRead.readObject();
					SerieNacional.setSerieNacional(temp);
					serieN.close();
					serieRead.close();
				} catch (FileNotFoundException e) {
					try {
						serieN2 = new FileOutputStream("SerieNacional.dat");
						serieWrite = new ObjectOutputStream(serieN2);
						serieWrite.writeObject(SerieNacional.getInstance());
					} catch (FileNotFoundException e1) {

					} catch (IOException e1) {

					}
				} catch (IOException e) {

				} catch (ClassNotFoundException e) {
					
				}
				
				try {
					Login dialog = new Login();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("muuSawtA_preview_rev_2.png"));
		setTitle("Login");
		setBounds(100, 100, 547, 337);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.textHighlightText);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(10, 131, 65, 14);
		contentPanel.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setBounds(85, 127, 185, 23);
		contentPanel.add(txtUser);
		txtUser.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(10, 172, 79, 14);
		contentPanel.add(lblNewLabel_1);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(SystemColor.activeCaption);
		btnEntrar.setIcon(new ImageIcon(Login.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlay.png")));
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
		btnEntrar.setBounds(92, 219, 89, 23);
		contentPanel.add(btnEntrar);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(85, 168, 185, 23);
		contentPanel.add(txtPass);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 153));
		panel.setBounds(280, 0, 252, 305);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("unnamed.png"));
		panel.add(lblNewLabel_2, BorderLayout.CENTER);
		
		lblNewLabel_3 = new JLabel("\u00A1Bienvenido!\r\n");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Sitka Small", Font.PLAIN, 21));
		lblNewLabel_3.setBounds(67, 11, 136, 41);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Sistema de la Serie Nacional de B\u00E9isbol");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 63, 260, 14);
		contentPanel.add(lblNewLabel_4);
	}
}
