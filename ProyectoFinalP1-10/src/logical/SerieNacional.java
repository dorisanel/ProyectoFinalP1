package logical;

import java.io.Serializable;
import java.util.ArrayList;



public class SerieNacional implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Equipo> misEquipos;
	private ArrayList<Juego> misJuegos;
	private ArrayList<Jugador> misJugadores;
	private static SerieNacional serieNacional = null;
	private int codJuego = 0;
	
	

	public SerieNacional() {
		super();
		this.misJuegos = new ArrayList <Juego>();
		this.misJugadores = new ArrayList <Jugador>();
		this.misEquipos = new ArrayList <Equipo>();
	}
	
	public static SerieNacional getInstance() {
		if(serieNacional == null)
			serieNacional = new SerieNacional();
		
		return serieNacional; 
	}
	
	public static SerieNacional getSerieNacional() {
		return serieNacional;
	}

	public static void setSerieNacional(SerieNacional serieNacional) {
		SerieNacional.serieNacional = serieNacional;
	}
	
	public void insertarEquipo(Equipo e) {
		misEquipos.add(e);
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

	public void insertarJugador(Jugador aux, String equipo) {
		Equipo e = buscarEquipo(equipo);
		
		if(e != null) {
			misJugadores.add(aux);
			e.insertarJugador(aux);
		}
				
	}

	public Equipo buscarEquipo(String nombre) {
		
		Equipo aux = null;
		
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i<misEquipos.size()) {
			if(misEquipos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				aux = misEquipos.get(i);
				encontrado = true;
			}	
			
			i++;
		}
		return aux;
	}
	
	public ArrayList<Jugador> mvpDiezBateador() {
		ArrayList<Jugador> mvp = new ArrayList<Jugador>();
		Jugador aux = null;

		for(int i=0; i<10; i++) {

			for(Jugador jugador: misJugadores) {

				if(jugador instanceof Bateador)
				{

					if(aux == null) {

						if(mvp.isEmpty())
							aux = jugador;

						else if(!mvp.contains(jugador))

							aux = jugador;

					}

					else if(jugador.PRO()>=aux.PRO() && !(mvp.contains(jugador)))
						aux = jugador;				
				}

				if(aux!= null)
					mvp.add(aux);

				aux = null;
			}

		}

		return mvp;
	}
	
	public ArrayList<Jugador> mvpDiezPitcher() {
		ArrayList<Jugador> mvp = new ArrayList<Jugador>();
		Jugador aux = null;

		for(int i=0; i<10; i++) {

			for(Jugador jugador: misJugadores) {

				if(jugador instanceof Pitcher)
				{

					if(aux == null) {

						if(mvp.isEmpty())
							aux = jugador;

						else if(!mvp.contains(jugador))

							aux = jugador;

					}

					else if(((Pitcher)jugador).PCL()>=((Pitcher)jugador).PCL() && !(mvp.contains(jugador)))
						aux = jugador;				
				}

				if(aux!= null)
					mvp.add(aux);

				aux = null;
			}

		}

		return mvp;
	}
	
	public String equipoJugador(Jugador j) {
		String aux = null;
		
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i<misJugadores.size()) {
			if(misEquipos.get(i).getMisJugadores().contains(j)) {
				aux = misEquipos.get(i).getNombre();
				encontrado = true;
			}	
			
			i++;
		}
		return aux;
		
	}

	public Jugador buscarJugador(String cedula) {
		Jugador aux = null;
		
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i<misJugadores.size()) {
			if(misJugadores.get(i).getCedula().equalsIgnoreCase(cedula)) {
				aux = misJugadores.get(i);
				encontrado = true;
			}	
			
			i++;
		}
		return aux;
	}

	public int getCodJuego() {
		return codJuego;
	}

	public void setCodJuego(int codJuego) {
		this.codJuego = codJuego;
	}

	public Juego buscarJuego(String codigo) {
		Juego aux = null;
		
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i<misJuegos.size()) {
			if(misJuegos.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				aux = misJuegos.get(i);
				encontrado = true;
			}	
			
			i++;
		}
		return aux;
	}
	
	

}
