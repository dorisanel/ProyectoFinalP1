package logical;

import java.util.ArrayList;


public class Juego {
	private String fecha;
	private ArrayList<Equipo> misEquipos;
	private String visitante;           
	private String local; 
	private String estadio;
	private int cantCarrerasV=0;
	private int cantCarrerasL=0;
	
	
	public Juego(String fecha, String estadio,String visitante,String local,int cantCarrerasV,int cantCarrerasL) {
		super();
		this.estadio=estadio;
		this.local=local;
		this.visitante=visitante;
		this.cantCarrerasL=cantCarrerasV;
		this.cantCarrerasV=cantCarrerasV;
		this.misEquipos = new ArrayList <Equipo>();
	}
	
	
	public String getEstadio() {
		return estadio;
	}


	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
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
	
	// en proceso
	/*public void setGanadorPerdedor() {
		
		String aux;
		
		if(cantCarrerasL>cantCarrerasV)
			aux=local;
		
		else if(cantCarrerasV>cantCarrerasL)
			aux=visitante;
		
		}*/

}
