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
		setTitle(titulo);
		setBounds(100, 100, 397, 221);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textCedula = new JTextField();
			textCedula.setBounds(66, 16, 305, 23);
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
			textNombre.setBounds(66, 50, 305, 23);
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
		lblNewLabel_3.setBounds(251, 88, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		spnDorsal = new JSpinner();
		spnDorsal.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnDorsal.setBounds(307, 84, 64, 23);
		contentPanel.add(spnDorsal);
		
		cbxEquipo = new JComboBox<String>();
		cbxEquipo.setBounds(66, 118, 113, 23);
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
		lblNewLabel_5.setBounds(203, 122, 59, 14);
		contentPanel.add(lblNewLabel_5);
		
		cbxPosicion = new JComboBox();
		cbxPosicion.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Bateador", "Pitcher"}));
		cbxPosicion.setBounds(258, 118, 113, 23);
		contentPanel.add(cbxPosicion);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton(" ");
				
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
						
						if(modo == 0) {
							Jugador aux = null;
							
									

							if(cbxPosicion.getSelectedItem().toString().equalsIgnoreCase("Bateador")) {
								
								aux = new Bateador(cedula, nombre, edad, dorsal, true);
								logrado = true;
							}
							
							else if(cbxPosicion.getSelectedItem().toString().equalsIgnoreCase("Pitcher")) {
								aux = new Pitcher(cedula, nombre, edad, dorsal, true);
								logrado = true;
							}
							Equipo equipoSelected = buscarEquipo(equipo);
							
							if(logrado) {
								SerieNacional.getInstance().getMisJugadores().add(aux);
								equipoSelected.getMisJugadores().add(aux);
								JOptionPane.showMessageDialog(null, "Registro satisfactorio", "Información", JOptionPane.INFORMATION_MESSAGE);
								clean();
							}
							
							else
								JOptionPane.showMessageDialog(null, "Complete todas las casillas, por favor", "Error", JOptionPane.ERROR_MESSAGE);

						}


						else {

														
							if(!(nombre.isEmpty()) || !(cedula.isEmpty())) {
								jugador.setCedula(cedula);
								jugador.setNombre(nombre);
								jugador.setEdad(edad);
								jugador.setNumero(dorsal);
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
	textCedula.setText("");
	textNombre.setText("");
	spnEdad.setValue(0);
	spnDorsal.setValue(0);
	cbxEquipo.setSelectedIndex(-1);
	cbxPosicion.setSelectedIndex(-1);
	}
	public Equipo buscarEquipo(String string) {
		Equipo equipoEncontrado = null;
		for(Equipo jug : SerieNacional.getInstance().getMisEquipos()) {
			if(jug.getNombre().compareToIgnoreCase(string) == 0) {
				equipoEncontrado = jug;
			}
		}
		return equipoEncontrado;
	}
}
