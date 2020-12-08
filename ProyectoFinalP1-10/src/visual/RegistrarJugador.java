package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Bateador;
import logical.Equipo;
import logical.Jugador;
import logical.Pitcher;
import logical.SerieNacional;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;

public class RegistrarJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JTextField textCedula;
	private JTextField textNombre;
	private JSpinner spnEdad;
	private JSpinner spnDorsal;
	private JComboBox<String> cbxEquipo;
	private JComboBox<String> cbxPosicion;
	private ArrayList<String> model = new ArrayList<String>();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @param n1 
	 */
	public RegistrarJugador(String titulo, int modo, Jugador jugador) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("muuSawtA_preview_rev_2.png"));
		setTitle(titulo);
		setBounds(100, 100, 497, 234);
		getContentPane().setLayout(new BorderLayout());
		
		
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textCedula = new JTextField();
			textCedula.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					
					if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE))
					{
						e.consume();
						JOptionPane.showMessageDialog(null, "¡Escriba únicamente números!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			
			textCedula.setBounds(66, 16, 391, 23);
			contentPanel.add(textCedula);
			textCedula.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("C\u00E9dula:");
			lblNewLabel.setBounds(10, 20, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
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
			textNombre.setBounds(66, 50, 391, 23);
			contentPanel.add(textNombre);
			textNombre.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(10, 54, 59, 14);
			contentPanel.add(lblNewLabel_1);
		}
		
		spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(new Integer(18), new Integer(16), null, new Integer(1)));
		spnEdad.setBounds(65, 84, 64, 23);
		contentPanel.add(spnEdad);
		
		JLabel lblNewLabel_2 = new JLabel("Edad:");
		lblNewLabel_2.setBounds(20, 88, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dorsal:");
		lblNewLabel_3.setBounds(325, 88, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		spnDorsal = new JSpinner();
		spnDorsal.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnDorsal.setBounds(393, 84, 64, 23);
		contentPanel.add(spnDorsal);
		
		cbxEquipo = new JComboBox<String>();
		cbxEquipo.setBounds(66, 118, 178, 23);
		contentPanel.add(cbxEquipo);
		
		for(Equipo equipo : SerieNacional.getInstance().getMisEquipos()) {
			model.add(equipo.getNombre());
		}
		
		int l = model.size();
		String[]modelo = new String[l+1];
		modelo[0] = "<Seleccione>";
		int i = 1;
		for(String m: model) {
			modelo[i] = m;
			i++;
		}
		cbxEquipo.setModel(new DefaultComboBoxModel<String>(modelo));
		
		JLabel lblNewLabel_4 = new JLabel("Equipo:");
		lblNewLabel_4.setBounds(10, 122, 46, 14);
		contentPanel.add(lblNewLabel_4);
			
		
		JLabel lblNewLabel_5 = new JLabel("Posici\u00F3n:");
		lblNewLabel_5.setBounds(261, 122, 59, 14);
		contentPanel.add(lblNewLabel_5);
		
		
		
		cbxPosicion = new JComboBox();
		cbxPosicion.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Bateador", "Pitcher"}));
		cbxPosicion.setBounds(317, 118, 140, 23);
		
		
		if(modo == 1 && jugador != null) {
			
			cbxEquipo.setSelectedItem(SerieNacional.getInstance().equipoJugador(jugador));
			cbxEquipo.setEnabled(false);
			textCedula.setText(jugador.getCedula());
			textNombre.setText(jugador.getNombre());
			spnEdad.setValue(jugador.getEdad());
			spnDorsal.setValue(jugador.getNumero());
			if(jugador instanceof Bateador)
				cbxPosicion.setSelectedIndex(1);

			else if(jugador instanceof Pitcher)
				cbxPosicion.setSelectedIndex(2);

			cbxPosicion.setEnabled(false);
		}
		
		contentPanel.add(cbxPosicion);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton(" ");
				okButton.setIcon(new ImageIcon("modi.png"));
				okButton.setBackground(SystemColor.controlHighlight);
				
				if(modo == 0)
					okButton.setText("Registrar");
				
				else
					okButton.setText("Modificar");
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						boolean logrado = false;
						String equipo = cbxEquipo.getSelectedItem().toString();
						String nombre = textNombre.getText();
						String cedula = textCedula.getText();				
						int edad = new Integer(spnEdad.getValue().toString());
						int dorsal = new Integer(spnDorsal.getValue().toString());
						Equipo equipoSelected = SerieNacional.getInstance().buscarEquipo(equipo);
						Jugador ver = SerieNacional.getInstance().buscarJugador(cedula);
						Jugador verDorsal = buscarDorsal(dorsal, equipoSelected);
						
						if(modo == 0) {
							Jugador aux = null;
							
									
							if(equipoSelected != null) {
								
								if(cbxPosicion.getSelectedItem().toString().equalsIgnoreCase("Bateador")) {
									
									aux = new Bateador(cedula, nombre, edad, dorsal, true);
									logrado = true;
								}
								
								else if(cbxPosicion.getSelectedItem().toString().equalsIgnoreCase("Pitcher")) {
									aux = new Pitcher(cedula, nombre, edad, dorsal, true);
									logrado = true;
								}
								
								if(ver != null) {
									logrado = false;
									JOptionPane.showMessageDialog(null, "¡Ya existe un jugador con esta cédula!", "Error", JOptionPane.ERROR_MESSAGE);
								}
								
								if(verDorsal != null) {
									logrado = false;
									JOptionPane.showMessageDialog(null, "¡Ya existe un jugador con este dorsal!", "Error", JOptionPane.ERROR_MESSAGE);
								}
								
								
							}
							
							if(logrado) {
								SerieNacional.getInstance().getMisJugadores().add(aux);
								equipoSelected.getMisJugadores().add(aux);
								JOptionPane.showMessageDialog(null, "Registro satisfactorio", "Información", JOptionPane.INFORMATION_MESSAGE);
								clean();
							}
							
							else if(!logrado && ver == null && verDorsal == null)
								JOptionPane.showMessageDialog(null, "Complete todas las casillas, por favor", "Error", JOptionPane.ERROR_MESSAGE);
							
						}


						else {

							
							if(!(nombre.isEmpty()) || !(cedula.isEmpty()) && ver == null) {
								jugador.setCedula(cedula);
								jugador.setNombre(nombre);
								jugador.setEdad(edad);
								jugador.setNumero(dorsal);
								logrado = true;
							}
							
							if(ver != null) {
								logrado = false;
								JOptionPane.showMessageDialog(null, "¡Ya existe un jugador con esta cédula!", "Error", JOptionPane.ERROR_MESSAGE);
							}
							
							if(verDorsal != null) {
								logrado = false;
								JOptionPane.showMessageDialog(null, "¡Ya existe un jugador con este dorsal!", "Error", JOptionPane.ERROR_MESSAGE);
							}

							if(logrado) {
								JOptionPane.showMessageDialog(null, "Modificación satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}
							
							else if(!logrado && ver == null && verDorsal == null)
								JOptionPane.showMessageDialog(null, "Complete todas las casillas, por favor", "Error", JOptionPane.ERROR_MESSAGE);
							
						}
						
					}
				});
				okButton.setActionCommand("OK");
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
		}
	}

	protected void clean() {
	textCedula.setText("");
	textNombre.setText("");
	spnEdad.setValue(18);
	spnDorsal.setValue(1);
	cbxEquipo.setSelectedIndex(-1);
	cbxPosicion.setSelectedIndex(-1);
	}
	
	private Jugador buscarDorsal(int numero, Equipo equipo) {
			Jugador aux = null;
			
			boolean encontrado = false;
			int i = 0;
			
			while(!encontrado && i<equipo.getMisJugadores().size()) {
				if(equipo.getMisJugadores().get(i).getNumero() == numero) {
					aux = equipo.getMisJugadores().get(i);
					encontrado = true;
				}	
				
				i++;
			}
			return aux;
		
	}
	
}
