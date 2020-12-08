package logical;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Equipo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Equipo(String id, String nombre, String manager, ImageIcon img) {
		super();
		this.setID(id);
		this.setNombre(nombre);
		this.setManager(manager);
		this.misJugadores = new ArrayList<Jugador>();
		this.estadisticasTemporadas = new ArrayList<Estadistica>();
		this.setCantJuegosGanados(0);
		this.setCantJuegosPerdidos(0);
		this.setCantJuegos(0);
		this.setTurnos(0);
		this.image = img;
	}
	private String ID;
	private String nombre;
	private String manager;
	private ArrayList<Jugador> misJugadores;
	private ArrayList<Estadistica> estadisticasTemporadas;
	private Estadistica estadisticaTotal;
	private int cantJuegosGanados;
	private int cantJuegosPerdidos;
	private int cantJuegos;
	private int turnos;
	private ImageIcon image;


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
	public void actualizarEstadisticasTotales(){ 
		if(estadisticaTotal == null) {
			estadisticaTotal = new Estadistica("0", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		}
		
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
		int HB = estadisticaTotal.getHB();
		int SVO = estadisticaTotal.getSVO();
		for (Jugador jug : misJugadores) {
			if(jug instanceof Bateador) {
			estadisticaTotal.setJ(jug.getCantJuegos()+j);
			estadisticaTotal.setR(((Bateador) jug).getCantCarreras()+R);
			estadisticaTotal.setAB(((Bateador) jug).getCantTurnos()+AB);
			estadisticaTotal.setH_bateo(((Bateador) jug).getCantHits()+H_bateo);
			estadisticaTotal.setDoubleB(((Bateador) jug).getCantDobles()+doubleB);
			estadisticaTotal.setTripleB(((Bateador) jug).getCantTriples()+tripleB);
			estadisticaTotal.setHR(((Bateador) jug).getCantJonrones()+HR);
			estadisticaTotal.setRBI(((Bateador) jug).getCantCarrerasImpulsadas()+RBI);
			estadisticaTotal.setBB_bateo(((Bateador) jug).getCantBoletos()+BB_bateo);
			estadisticaTotal.setSO_bateo(((Bateador) jug).getCantPonches()+SO_bateo);
			estadisticaTotal.setSB(((Bateador) jug).getBasesRobadas()+SB);
			
		}else{
			if(jug instanceof Pitcher) {
			estadisticaTotal.setG(jug.getCantJuegos()+G);
			estadisticaTotal.setP(((Pitcher) jug).getJuegosPerdidos()+P);
			estadisticaTotal.setCG(((Pitcher) jug).getJuegosCompletos()+CG);
			estadisticaTotal.setSHO(((Pitcher) jug).getJuegosBlanqueados()+SHO);
			estadisticaTotal.setSV(((Pitcher) jug).getSalvados()+SV);
			estadisticaTotal.setSVO(((Pitcher) jug).getOportSalvado()+SVO);
			estadisticaTotal.setH_pitcheo(((Pitcher) jug).getCantHits()+H_pitcheo);
			estadisticaTotal.setR(((Pitcher) jug).getCantCarreras()+R);
			estadisticaTotal.setER(((Pitcher) jug).getCarrerasLimpias()+ER);
			estadisticaTotal.setHB(((Pitcher) jug).getBateadoresGolpeados()+HB);
			}
			
			
		}
		}
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public void insertarJugador(Jugador aux) {
		misJugadores.add(aux);
	}
	public ArrayList<Jugador> getMisJugadores() {
		return misJugadores;
	}
	public void setMisJugadores(ArrayList<Jugador> misJugadores) {
		this.misJugadores = misJugadores;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getCantJuegosGanados() {
		return cantJuegosGanados;
	}
	public void setCantJuegosGanados(int cantJuegosGanados) {
		this.cantJuegosGanados = cantJuegosGanados;
	}
	public int getCantJuegosPerdidos() {
		return cantJuegosPerdidos;
	}
	public void setCantJuegosPerdidos(int cantJuegosPerdidos) {
		this.cantJuegosPerdidos = cantJuegosPerdidos;
	}
	public int getCantJuegos() {
		return cantJuegos;
	}
	public void setCantJuegos(int cantJuegos) {
		this.cantJuegos = cantJuegos;
	}
	public int getTurnos() {
		return turnos;
	}
	public void setTurnos(int turnos) {
		this.turnos = turnos;
	}
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	public ArrayList<Estadistica> getEstadisticasTemporadas() {
		return estadisticasTemporadas;
	}
	public void setEstadisticasTemporadas(ArrayList<Estadistica> estadisticasTemporadas) {
		this.estadisticasTemporadas = estadisticasTemporadas;
	}
	public Estadistica getEstadisticaTotal() {
		return estadisticaTotal;
	}
	public void setEstadisticaTotal(Estadistica estadisticaTotal) {
		this.estadisticaTotal = estadisticaTotal;
	}




}