package logical;

import java.util.ArrayList;

public class SerieNacional {
	private ArrayList<Equipo> misEquipos;
	private ArrayList<Juego> misJuegos;
	private ArrayList<Jugador> misJugadores;
	
	
	
	public SerieNacional() {
		super();
		this.misJuegos = new ArrayList <Juego>();
		this.misJugadores = new ArrayList <Jugador>();
		this.misEquipos = new ArrayList <Equipo>();
	}
	
	public ArrayList<Juego> getMisJuegos() {
		return misJuegos;
	}

	public void setMisJuegos(ArrayList<Juego> misJuegos) {
		this.misJuegos = misJuegos;
	}
	public ArrayList<Jugador> getMisJugadores() {
		return misJugadores;
	}
	public void setMisJugadores(ArrayList<Jugador> misJugadores) {
		this.misJugadores = misJugadores;
	}

	public ArrayList<Equipo> getMisEquipos() {
		return misEquipos;
	}

	public void setMisEquipos(ArrayList<Equipo> misEquipos) {
		this.misEquipos = misEquipos;
	}

}
