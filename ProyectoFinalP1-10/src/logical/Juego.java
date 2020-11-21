package logical;

//import java.util.ArrayList;
import java.util.Date;

public class Juego {
	private Date calendario;
	
	//Falta creacion clase Equipo
	
	/*private ArrayList<Equipo> misEquipos;
	private Equipo ganador = null;           
	private Equipo perdedor = null;*/   
	
	public Juego(Date calendario) {
		super();
		this.calendario = calendario;
		//this.misEquipos = new ArrayList <Equipo>();
	}
	
	public void setGanadorPerdedor() {
		
	}


	public Date getCalendario() {
		return calendario;
	}

	public void setCalendario(Date calendario) {
		this.calendario = calendario;
	}

}
