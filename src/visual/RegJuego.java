package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import logical.Equipo;
import logical.Juego;
import logical.SerieNacional;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

public class RegJuego extends JDialog {

	private final JPanel estadioCbx = new JPanel();
	private JComboBox casaCbx;
	private JComboBox VisitanteCbx;
	private JComboBox cbEstadio;
	private JSpinner spFecha;
	private JButton regBtn;
	private JLabel labelCasa;
	private JLabel labelVisitante;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public RegJuego(String titulo, int modo, Juego juego) {

		setTitle(titulo);
		setBounds(100, 100, 720, 487);
		getContentPane().setLayout(new BorderLayout());
		estadioCbx.setBackground(SystemColor.text);
		estadioCbx.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(estadioCbx, BorderLayout.CENTER);
		estadioCbx.setLayout(null);
		
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("Casa:");
		lblNewLabel.setBounds(20, 46, 92, 26);
		estadioCbx.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Estadio:");
		lblNewLabel_1.setBounds(20, 106, 92, 26);
		estadioCbx.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Visitante:");
		lblNewLabel_2.setBounds(359, 46, 92, 26);
		estadioCbx.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Fecha:");
		lblNewLabel_3.setBounds(363, 106, 102, 26);
		estadioCbx.add(lblNewLabel_3);

		casaCbx = new JComboBox();
		int size = SerieNacional.getInstance().getMisEquipos().size();
		String[] text = new String[size];

		int i = 0;
		for (Equipo ser : SerieNacional.getInstance().getMisEquipos()) {
			text[i] = ser.getNombre();
			i++;
		}
		casaCbx.setModel(new DefaultComboBoxModel(text));
		casaCbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelCasa.setIcon(buscarEquipo(casaCbx.getSelectedItem().toString()).getImage());
			}
		});
		casaCbx.setBounds(100, 46, 211, 26);
		estadioCbx.add(casaCbx);

		VisitanteCbx = new JComboBox();
		VisitanteCbx.setModel(new DefaultComboBoxModel(text));
		VisitanteCbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				labelVisitante.setIcon(buscarEquipo(VisitanteCbx.getSelectedItem().toString()).getImage());
				}catch(NullPointerException e1) {
				labelVisitante.removeAll();
				}
			}
		});
		VisitanteCbx.setBounds(451, 46, 233, 26);
		estadioCbx.add(VisitanteCbx);

		cbEstadio = new JComboBox();
		cbEstadio.setMaximumRowCount(15);
		cbEstadio.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione un estadio>", "Estadio Felix Sanchez", "Estadio La Barranquita", "Estadio Cibao", "Estadio Quisqueya", "Estadio Julian Javier", "Estadio Francisco Michelli", "Palacio de los Deportes", "Estadio Tetelo Vargas", "Estadio Ol\u00EDmpico", "Carlos Teo Cruz Coliseum", "Softball Stadium", "Volleyball Pavilion", "La Feria Oval"}));
		cbEstadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cbEstadio.setBounds(100, 106, 211, 26);
		estadioCbx.add(cbEstadio);

		spFecha = new JSpinner();
		spFecha.setModel(new SpinnerDateModel(new Date(1607400000000L), new Date(1607400000000L), null, Calendar.DAY_OF_YEAR));
		spFecha.setBounds(449, 103, 235, 26);
		estadioCbx.add(spFecha);

		labelCasa = new JLabel("");
		labelCasa.setBounds(20, 168, 300, 200);
		estadioCbx.add(labelCasa);

		labelVisitante = new JLabel("");
		labelVisitante.setBounds(379, 168, 300, 200);
		estadioCbx.add(labelVisitante);

		JLabel lblNewLabel_6 = new JLabel("Vs");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_6.setBounds(330, 229, 44, 26);
		estadioCbx.add(lblNewLabel_6);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				regBtn = new JButton("Registrar");
				regBtn.setBackground(SystemColor.controlHighlight);
				regBtn.setIcon(new ImageIcon("modi.png"));
				regBtn.setEnabled(false);
				if(SerieNacional.getInstance().getMisEquipos().size() >= 2) {
					regBtn.setEnabled(true);
				}
				regBtn.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						try{
							Date fecha = (Date) spFecha.getValue();
							//ArrayList<Equipo> misEquipos = new ArrayList<Equipo>();
							Equipo visitante = SerieNacional.getInstance().buscarEquipo(VisitanteCbx.getSelectedItem().toString());
							Equipo local = SerieNacional.getInstance().buscarEquipo(casaCbx.getSelectedItem().toString());
							String estadio  = cbEstadio.getModel().getSelectedItem().toString();
				
							if(local != visitante) {
								Juego jug1 = new Juego("J00"+SerieNacional.getInstance().getCodJuego(),fecha, local, visitante, estadio, 0, 0, true);
								SerieNacional.getInstance().setCodJuego(SerieNacional.getInstance().getCodJuego()+1);
								SerieNacional.getInstance().getMisJuegos().add(jug1);
								
								JOptionPane.showMessageDialog(null, "Registro satisfactorio", "Información", JOptionPane.INFORMATION_MESSAGE);
								limpiar();
							}else {
								JOptionPane.showMessageDialog(null, "No se puede realizar un juego con el mismo equipo de contrincante", "Error", JOptionPane.ERROR_MESSAGE);
								limpiar();
							}
						}
						catch(Exception e2) {
							JOptionPane.showMessageDialog(null, "Complete todos los campos requeridos", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}

					private void limpiar() {
						casaCbx.setSelectedIndex(0);
						VisitanteCbx.setSelectedIndex(0);
						cbEstadio.setSelectedIndex(0);
						spFecha.setValue(new Date(Calendar.DAY_OF_YEAR));
						dispose();
						RegJuego r1 = new RegJuego("Registrar juego", 0, null);
						r1.setVisible(true);
					}});
				regBtn.setActionCommand("OK");
				buttonPane.add(regBtn);
				getRootPane().setDefaultButton(regBtn);
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
