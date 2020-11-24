package logical;

import java.util.ArrayList;
import java.util.Date;


public class Juego {
	private Date fecha;
	private ArrayList<Equipo> misEquipos;
	private String visitante;           
	private String local; 
	private String estadio;
	private boolean estado;
	private int cantCarrerasV=0;
	private int cantCarrerasL=0;
	
	
	public Juego(Date fecha, ArrayList<Equipo> misEquipos, String visitante, String local, String estadio,
			int cantCarrerasV, int cantCarrerasL,boolean estado) {
		super();
		this.fecha = fecha;
		this.misEquipos = misEquipos;
		this.visitante = visitante;
		this.local = local;
		this.estadio = estadio;
		this.cantCarrerasV = cantCarrerasV;
		this.cantCarrerasL = cantCarrerasL;
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


	public String getVisitante() {
		return visitante;
	}


	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
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
	
	// en proceso
	/*public void setGanadorPerdedor() {
		
		String aux;
		
		if(cantCarrerasL>cantCarrerasV)
			aux=local;
		
		else if(cantCarrerasV>cantCarrerasL)
			aux=visitante;
		
		}*/

}
