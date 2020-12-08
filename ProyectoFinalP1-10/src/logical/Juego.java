package logical;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;




public class Juego implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private Date fecha;
	private ArrayList<Equipo> misEquipos;
	private Equipo local = null;
	private Equipo visitante= null;
	private String estadio;
	private boolean estado;
	private boolean terminado;
	private int cantCarrerasV=0;
	private int cantCarrerasL=0;
	
	
	public Juego(String codigo, Date fecha, ArrayList<Equipo> misEquipos, String visitante, String local, String estadio,
			int cantCarrerasV, int cantCarrerasL,boolean estado) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.misEquipos = new ArrayList<Equipo>(); 
		this.estadio = estadio;
		this.cantCarrerasV = cantCarrerasV;
		this.cantCarrerasL = cantCarrerasL;
		this.terminado = false;
		this.estado=estado;
	}


	public String getEstadio() {
		return estadio;
	}


	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	
	public int getCantCarrerasV() {
		return cantCarrerasV;
	}


	public void setCantCarrerasV(int cantCarrerasV) {
		this.cantCarrerasV = cantCarrerasV;
	}


	public int getCantCarrerasL() {
		return cantCarrerasL;
	}


	public void setCantCarrerasL(int cantCarrerasL) {
		this.cantCarrerasL = cantCarrerasL;
	}


	public ArrayList<Equipo> getMisEquipos() {
		return misEquipos;
	}

	public void setMisEquipos(ArrayList<Equipo> misEquipos) {
		this.misEquipos = misEquipos;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public boolean isTerminado() {
		return terminado;
	}


	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public Equipo getLocal() {
		return local;
	}


	public void setLocal(Equipo local) {
		this.local = local;
	}


	public Equipo getVisitante() {
		return visitante;
	}


	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}
	
	public void setGanadorPerdedor() {
		
		int cantJuegosL= local.getCantJuegos();
		int cantJuegosGanadosL= local.getCantJuegosGanados();
		int cantJuegosPerdidosL = local.getCantJuegosPerdidos();
		int cantJuegosV= visitante.getCantJuegos();
		int cantJuegosGanadosV= visitante.getCantJuegosGanados();
		int cantJuegosPerdidosV = visitante.getCantJuegosPerdidos();
		
		
		int cantjuegosGanadosL=0;
		int cantjuegosPerdidosL=0;
		int cantjuegosLanzadosL=0;
		int cantjuegosGanadosV=0;
		int cantjuegosPerdidosV=0;
		int cantjuegosLanzadosV=0;
		
	 if(cantCarrerasL>cantCarrerasV) {
		 cantJuegosL++;
		 cantJuegosGanadosL++;
		 cantJuegosV++;
		 cantJuegosPerdidosV++;
		 
		 for(Jugador jugador : local.getMisJugadores()) {
			 
				if(jugador instanceof Pitcher) {
					cantjuegosGanadosL += ((Pitcher)jugador).getJuegosGanados();
					cantjuegosLanzadosL +=((Pitcher)jugador).getJuegosLanzados();
				} 
			 }
		 
		 for(Jugador jugador : visitante.getMisJugadores()) {
			 
				if(jugador instanceof Pitcher) {
					cantJuegosPerdidosV += ((Pitcher)jugador).getJuegosPerdidos();
					cantjuegosLanzadosV +=((Pitcher)jugador).getJuegosLanzados();
				} 
			 }
		 
	 }
	 
	 else if(cantCarrerasV>cantCarrerasL) {
		 cantJuegosV++;
		 cantJuegosGanadosV++;
		 cantJuegosL++;
		 cantJuegosPerdidosL++;
		 
		 for(Jugador jugador : visitante.getMisJugadores()) {
			 
				if(jugador instanceof Pitcher) {
					cantjuegosGanadosV += ((Pitcher)jugador).getJuegosGanados();
					cantjuegosLanzadosV +=((Pitcher)jugador).getJuegosLanzados();
				} 
			 }
		 
		 for(Jugador jugador : local.getMisJugadores()) {
			 
				if(jugador instanceof Pitcher) {
					cantJuegosPerdidosL += ((Pitcher)jugador).getJuegosPerdidos();
					cantjuegosLanzadosL +=((Pitcher)jugador).getJuegosLanzados();
				} 
			 }  
	 }
	 
		
	}
	
}


