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
	private String visitante;           
	private String local; 
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
		this.misEquipos = misEquipos;
		this.visitante = visitante;
		this.local = local;
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


	public void setGanadorPerdedor() {
		// TODO Auto-generated method stub
		
	}
	
	/*public void setGanadorPerdedor() {
		
		if(cantCarrerasL>cantCarrerasV)
		
		else if(cantCarrerasV>cantCarrerasL)
			aux=visitante;
		
	}*/

}
