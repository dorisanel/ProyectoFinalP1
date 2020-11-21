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

}
