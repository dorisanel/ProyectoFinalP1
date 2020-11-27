package logical;

import java.util.ArrayList;

public abstract class Jugador {
	
	protected String cedula;
	protected String nombre;
	protected int edad;
	protected int numero;
	protected boolean estado;
	protected int cantJuegos;
	protected ArrayList<Lesion> misLesiones;
	
	public Jugador(String cedula, String nombre, int edad, int numero, boolean estado) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.edad = edad;
		this.numero = numero;
		this.estado = estado;
		this.cantJuegos = 0;
		this.misLesiones = new ArrayList<Lesion>();
	}
	
	public abstract float PRO();

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getCantJuegos() {
		return cantJuegos;
	}

	public void setCantJuegos(int cantJuegos) {
		this.cantJuegos = cantJuegos;
	}

	public ArrayList<Lesion> getMisLesiones() {
		return misLesiones;
	}

	public void setMisLesiones(ArrayList<Lesion> misLesiones) {
		this.misLesiones = misLesiones;
	}

}
