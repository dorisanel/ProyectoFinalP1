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
	private Equipo local;
	private Equipo visitante;
	private String estadio;
	private boolean estado;
	private boolean terminado;
	private int cantCarrerasV=0;
	private int cantCarrerasL=0;
	
	
	public Juego(String codigo, Date fecha, Equipo local, Equipo visitante, String estadio,
			int cantCarrerasV, int cantCarrerasL,boolean estado) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.local = local;
		this.visitante = visitante;
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
		
		
		int pitcherjuegosGanadosL=0;
		int pitcherjuegosPerdidosL=0;
		int pitcherjuegosGanadosV=0;
		int pitcherjuegosPerdidosV=0;
		
		
	 if(cantCarrerasL>cantCarrerasV) {
		 local.setCantJuegos(cantJuegosL+1);
		 local.setCantJuegosGanados(cantJuegosGanadosL+1);
		 visitante.setCantJuegos(cantJuegosV+1);
		 visitante.setCantJuegosPerdidos(cantJuegosPerdidosV+1);
		 
		 for(Jugador jugador : local.getMisJugadores()) {
			 
				if(jugador instanceof Pitcher) {
					((Pitcher)jugador).setJuegosGanados(pitcherjuegosGanadosL+1);
				} 
			 }
		 
		 for(Jugador jugador : visitante.getMisJugadores()) {
			 
				if(jugador instanceof Pitcher) {
					((Pitcher)jugador).setJuegosPerdidos(pitcherjuegosPerdidosV+1);
				} 
			 }
		 
	 }
	 
	 else if(cantCarrerasV>cantCarrerasL) {
		 visitante.setCantJuegos(cantJuegosV+1);
		 visitante.setCantJuegosGanados(cantJuegosGanadosV+1);
		 local.setCantJuegos(cantJuegosL+1);
		 local.setCantJuegosPerdidos(cantJuegosPerdidosL+1);
		
		 
		 for(Jugador jugador : visitante.getMisJugadores()) {
			 
				if(jugador instanceof Pitcher) {
					((Pitcher)jugador).setJuegosGanados(pitcherjuegosGanadosV+1);
				} 
			 }
		 
		 for(Jugador jugador : local.getMisJugadores()) {
			 
				if(jugador instanceof Pitcher) {
					((Pitcher)jugador).setJuegosPerdidos(pitcherjuegosPerdidosL+1);
				} 
			 }  
	 }
	 
		
	}
	
}


