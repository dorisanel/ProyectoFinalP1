package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.Bateador;
import logical.Equipo;
import logical.Estadistica;
import logical.Pitcher;
import logical.SerieNacional;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.Checkbox;
import javax.swing.JPasswordField;
import javax.swing.JFileChooser;
import java.awt.Label;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistrarEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCod;
	private JTextField textNombre;
	private JTextField textManager;
	private JButton okButton;
	private JTextField txLogo;
	private Component areaTexto;
	private String path;
	private JButton buscarBtn;
	private JButton establecerBtn;
	private JPanel paneImagen;
	private ImageIcon m1;
	private JLabel imagen;
	

	/**
	 * Create the dialog.
	 * @param object 
	 * @param modo 
	 * @param titulo 
	 */
	public RegistrarEquipo(String titulo, int modo, Equipo equipo) {
		
		setTitle(titulo);
		setBounds(100, 100, 663, 374);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
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
		textNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!(Character.isAlphabetic(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == ' '))
				{
					e.consume();
					JOptionPane.showMessageDialog(null, "¡Escriba únicamente letras!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textNombre.setBounds(66, 42, 185, 23);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textManager = new JTextField();
		textManager.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!(Character.isAlphabetic(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == ' '))
				{
					e.consume();
					JOptionPane.showMessageDialog(null, "¡Escriba únicamente letras!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textManager.setBounds(66, 76, 185, 23);
		contentPanel.add(textManager);
		textManager.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Manager:");
		lblNewLabel_2.setBounds(10, 80, 57, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Logo:");
		lblNewLabel_3.setBounds(256, 10, 57, 19);
		contentPanel.add(lblNewLabel_3);
		
		txLogo = new JTextField();
		txLogo.setEditable(false);
		txLogo.setBounds(129, 246, 236, 23);
		contentPanel.add(txLogo);
		txLogo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ruta del logo:");
		lblNewLabel_4.setBounds(10, 246, 118, 23);
		contentPanel.add(lblNewLabel_4);
		
		 establecerBtn = new JButton("Seleccionar imagen");
		establecerBtn.setEnabled(false);
		establecerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//establecer imagen
				
				m1 = new ImageIcon(txLogo.getText());
				paneImagen.add(imagen);
				try {
				imagen.setIcon(m1);
				}catch(Exception ew) {
					JOptionPane.showMessageDialog(null, "Especifique una ruta valida", "Error", JOptionPane.ERROR_MESSAGE);
				}
				buscarBtn.setVisible(false);
			}
		});
		establecerBtn.setBounds(497, 246, 131, 23);
		contentPanel.add(establecerBtn);
		
		buscarBtn = new JButton("Buscar");
		buscarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int seleccion = fileChooser.showOpenDialog(areaTexto);
				path = fileChooser.getSelectedFile().getPath();
				txLogo.setText(path);
				establecerBtn.setEnabled(true);
			}
		});
		buscarBtn.setBounds(369, 246, 126, 23);
		contentPanel.add(buscarBtn);
		
		JLabel lblNewLabel_5 = new JLabel("*Resolucion maxima: 200x300");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(411, 224, 148, 23);
		contentPanel.add(lblNewLabel_5);
		
		paneImagen = new JPanel();
		paneImagen.setLayout(null);
		paneImagen.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paneImagen.setBackground(Color.WHITE);
		paneImagen.setBounds(307, 12, 321, 215);
		contentPanel.add(paneImagen);
		
		imagen = new JLabel("");
		imagen.setBounds(0, 0, 321, 215);
		paneImagen.add(imagen);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.menu);
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
							String id = textCod.getText();
							ImageIcon img = null;
							
							if(txLogo.toString().isEmpty() == false ) {
								try {
									img = new ImageIcon(resize(txLogo.getText(), 300, 200));
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch(Exception e1) {
									
								}
							}
							Equipo ver = SerieNacional.getInstance().buscarEquipo(nombre);

							aux = new Equipo(id,nombre, manager, img);

							if(!(nombre.isEmpty()) && !(manager.isEmpty()) && !(id.isEmpty()))
								logrado = true;
							
							if(ver != null) {
								logrado = false;
								JOptionPane.showMessageDialog(null, "¡Ya existe un equipo con este código!", "Error", JOptionPane.ERROR_MESSAGE);
							}

							if(logrado) {
								SerieNacional.getInstance().insertarEquipo(aux);
								JOptionPane.showMessageDialog(null, "Registro satisfactorio", "Información", JOptionPane.INFORMATION_MESSAGE);
								paneImagen.remove(imagen);
								
								clean();
							}
							
							else if(!logrado && ver == null)
								JOptionPane.showMessageDialog(null, "Complete todas las casillas, por favor", "Error", JOptionPane.ERROR_MESSAGE);

						}


						else {

							String id = textCod.getText();
							String nombre = textNombre.getText();
							String manager = textManager.getText();
							Equipo ver = SerieNacional.getInstance().buscarEquipo(nombre);
							
							
							if(!(nombre.isEmpty()) && !(manager.isEmpty()) && !(id.isEmpty()) && (ver == equipo || ver==null)) {
								equipo.setManager(manager);
								equipo.setNombre(nombre);
								equipo.setID(id);
								logrado = true;
							}
							
							if(ver != equipo && ver != null) {
								logrado = false;
								JOptionPane.showMessageDialog(null, "¡Ya existe un equipo con este código!", "Error", JOptionPane.ERROR_MESSAGE);
							}

							if(logrado) {
								JOptionPane.showMessageDialog(null, "Modificación satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}
							
							else if(!logrado  && (ver == equipo || ver==null))
								JOptionPane.showMessageDialog(null, "Complete todas las casillas, por favor", "Error", JOptionPane.ERROR_MESSAGE);
							
						}
					}
				});
				
				if(modo == 0)
					okButton.setText("Registrar");
				
				else
					okButton.setText("Modificar");
					
				okButton.setActionCommand("OK");
				okButton.setIcon(new ImageIcon("modi.png"));
				okButton.setBackground(SystemColor.controlHighlight);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setIcon(new ImageIcon("61848.png"));
				cancelButton.setBackground(SystemColor.controlHighlight);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
			if(modo == 1 && equipo != null) {

				textCod.setText(equipo.getID());
				textNombre.setText(equipo.getNombre());
				textManager.setText(equipo.getManager());
				try {
					imagen.setIcon(equipo.getImage());
				}catch(Exception ew) {

				}
			}
		}
	}
	
	
	protected void clean() {
		textCod.setText("");
		textNombre.setText("");
		textManager.setText("");
		txLogo.setText("");
		buscarBtn.setVisible(true);
		establecerBtn.setEnabled(false);
		
	}
	public BufferedImage resize(String inputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {
	
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = null;
        BufferedImage outputImage = null;
        try {
        	 inputImage = ImageIO.read(inputFile);
        	// creates output image
             outputImage = new BufferedImage(scaledWidth,
                     scaledHeight, inputImage.getType());
      
             // scales the input image to the output image
             Graphics2D g2d = outputImage.createGraphics();
             g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
             g2d.dispose();
        } catch(Exception e0) {
        	
        }
      
        return outputImage;
    }
 
	
}
