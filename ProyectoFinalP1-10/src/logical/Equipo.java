package logical;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Equipo {

	public Equipo(String nombre, String manager) {
		super();
		this.nombre = nombre;
		this.manager = manager;
		this.misJugadores = new ArrayList<Jugador>();
		this.estadisticasTemporadas = new ArrayList<Estadistica>();
		this.cantJuegosGanados = 0;
		this.cantJuegosPerdidos = 0;
		this.cantJuegos = 0;
		this.turnos = 0;
	}

	private String nombre;
	private String manager;
	private ArrayList<Jugador> misJugadores;
	private ArrayList<Estadistica> estadisticasTemporadas;
	private Estadistica estadisticaTotal;
	private int cantJuegosGanados = 0;
	private int cantJuegosPerdidos = 0;
	private int cantJuegos = 0;
	private int turnos = 0;


	public boolean agregarNuevaEstadistica(String nombreTemporada, Estadistica data){ 
		boolean hecho = false;
		Estadistica estadisticaNew = null;
		estadisticaNew = data;
		estadisticasTemporadas.add(estadisticaNew);
		if (estadisticasTemporadas.contains(estadisticaNew)==true) {
			hecho = true;
		}
		return hecho;
	}
	public boolean actualizarEstadisticasTotales(){ 
		boolean hecho = false;
		int j = estadisticaTotal.getJ();
		int AB= estadisticaTotal.getAB() ;
		int R= estadisticaTotal.getR() ;
		int H_bateo= estadisticaTotal.getH_bateo() ;
		int doubleB= estadisticaTotal.getDoubleB() ;
		int tripleB= estadisticaTotal.getTripleB() ;
		int HR= estadisticaTotal.getHR() ;
		int RBI= estadisticaTotal.getRBI() ;
		int TB= estadisticaTotal.getTB() ;
		int BB_bateo= estadisticaTotal.getBB_bateo() ;
		int SO_bateo= estadisticaTotal.getSO_bateo() ;
		int SB= estadisticaTotal.getSB() ;
		float SLG= estadisticaTotal.getSLG() ;
		float IP= estadisticaTotal.getIP() ;
		int G= estadisticaTotal.getG() ;
		int P= estadisticaTotal.getP() ;
		int SV= estadisticaTotal.getSV() ;
		int CG= estadisticaTotal.getCG() ;
		int SHO= estadisticaTotal.getSHO() ;
		int QS= estadisticaTotal.getQS() ;
		int H_pitcheo= estadisticaTotal.getH_pitcheo() ;
		int ER= estadisticaTotal.getER() ;
		int BB_pitcheo= estadisticaTotal.getBB_pitcheo() ;
		int SO_pitcheo= estadisticaTotal.getSO_pitcheo() ;
		for (Estadistica estadistica : estadisticasTemporadas) {
			estadisticaTotal.setJ(estadistica.getJ()+j);
			estadisticaTotal.setAB(estadistica.getAB()+AB);
			estadisticaTotal.setR(estadistica.getR()+R);
			estadisticaTotal.setH_bateo(estadistica.getH_bateo()+H_bateo);
			estadisticaTotal.setDoubleB(estadistica.getDoubleB()+doubleB);
			estadisticaTotal.setTripleB(estadistica.getTripleB()+tripleB);
			estadisticaTotal.setHR(estadistica.getHR()+HR);
			estadisticaTotal.setRBI(estadistica.getRBI()+RBI);
			estadisticaTotal.setTB(estadistica.getTB()+TB);
			estadisticaTotal.setBB_bateo(estadistica.getBB_bateo()+BB_bateo);
			estadisticaTotal.setSO_bateo(estadistica.getSO_bateo()+SO_bateo);
			estadisticaTotal.setSB(estadistica.getSB()+SB);
			estadisticaTotal.setSLG(estadistica.getSLG()+SLG);
			estadisticaTotal.setIP(estadistica.getIP()+IP);
			estadisticaTotal.setG(estadistica.getG()+G);
			estadisticaTotal.setP(estadistica.getP()+P);
			estadisticaTotal.setSV(estadistica.getSV()+SV);
			estadisticaTotal.setCG(estadistica.getCG()+CG);
			estadisticaTotal.setSHO(estadistica.getSHO()+SHO);
			estadisticaTotal.setQS(estadistica.getQS()+QS);
			estadisticaTotal.setH_pitcheo(estadistica.getH_pitcheo()+H_pitcheo);
			estadisticaTotal.setER(estadistica.getER()+ER);
			estadisticaTotal.setBB_pitcheo(estadistica.getBB_pitcheo()+BB_pitcheo);
			estadisticaTotal.setSO_pitcheo(estadistica.getSO_pitcheo()+SO_pitcheo);
			estadisticaTotal.setAVG();
			estadisticaTotal.setOPS();
			estadisticaTotal.setOBP();
			estadisticaTotal.setERA();
		}
		return hecho;

	}




}
