package logical;

import java.io.Serializable;

public class Bateador extends Jugador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cantTurnos;
	private int cantCarreras;
	private int cantHits;
	private int cantSencillos;
	private int cantDobles ;
	private int cantTriples;
	private int cantJonrones ;
	private int basesRobadas;
	private int cantPonches ;
	private int cantCarrerasImpulsadas;
	private int cantBoletos;
	private int cantBasesRobadas;
	private int cantAtrapadosRobando;
	private int golpeadoPorPitcher;
	private int flySacrifio;
	
	
	public Bateador(String cedula, String nombre, int edad, int numero, boolean estado) {
		super(cedula, nombre, edad, numero, estado);
		this.cantCarreras = 0;
		this.cantHits = 0;
		this.cantSencillos=0;
		this.cantDobles = 0;
		this.cantTriples = 0;
		this.cantJonrones = 0;
		this.basesRobadas = 0;
		this.cantPonches = 0;
		this.cantTurnos=0;
		this.cantCarrerasImpulsadas = 0;
		this.cantBoletos = 0;
		this.cantBasesRobadas = 0;
		this.cantAtrapadosRobando = 0;
		this.golpeadoPorPitcher= 0;
		this.flySacrifio=0;
		
	}
	
	

	public int getCantTurnos() {
		return cantTurnos;
	}



	public void setCantTurnos(int cantTurnos) {
		this.cantTurnos = cantTurnos;
	}



	public int getCantCarreras() {
		return cantCarreras;
	}

	public void setCantCarreras(int cantCarreras) {
		this.cantCarreras = cantCarreras;
	}

	public int getCantHits() {
		return cantHits;
	}
	
	

	public int getGolpeadoPorPitcher() {
		return golpeadoPorPitcher;
	}


	public void setGolpeadoPorPitcher(int golpeadoPorPitcher) {
		this.golpeadoPorPitcher = golpeadoPorPitcher;
	}



	public int getFlySacrifio() {
		return flySacrifio;
	}



	public void setFlySacrifio(int flySacrifio) {
		this.flySacrifio = flySacrifio;
	}



	public void setCantHits(int cantHits) {
		this.cantHits = cantHits;
	}
	

	public int getCantSencillos() {
		return cantSencillos;
	}



	public void setCantSencillos(int cantSencillos) {
		this.cantSencillos = cantSencillos;
	}



	public int getCantDobles() {
		return cantDobles;
	}

	public void setCantDobles(int cantDobles) {
		this.cantDobles = cantDobles;
	}

	public int getCantTriples() {
		return cantTriples;
	}

	public void setCantTriples(int cantTriples) {
		this.cantTriples = cantTriples;
	}

	public int getCantJonrones() {
		return cantJonrones;
	}

	public void setCantJonrones(int cantJonrones) {
		this.cantJonrones = cantJonrones;
	}

	public int getBasesRobadas() {
		return basesRobadas;
	}

	public void setBasesRobadas(int basesRobadas) {
		this.basesRobadas = basesRobadas;
	}

	public int getCantPonches() {
		return cantPonches;
	}

	public void setCantPonches(int cantPonches) {
		this.cantPonches = cantPonches;
	}

	public int getCantCarrerasImpulsadas() {
		return cantCarrerasImpulsadas;
	}

	public void setCantCarrerasImpulsadas(int cantCarrerasImpulsadas) {
		this.cantCarrerasImpulsadas = cantCarrerasImpulsadas;
	}

	public int getCantBoletos() {
		return cantBoletos;
	}

	public void setCantBoletos(int cantBoletos) {
		this.cantBoletos = cantBoletos;
	}

	public int getCantBasesRobadas() {
		return cantBasesRobadas;
	}

	public void setCantBasesRobadas(int cantBasesRobadas) {
		this.cantBasesRobadas = cantBasesRobadas;
	}

	public int getCantAtrapadosRobando() {
		return cantAtrapadosRobando;
	}

	public void setCantAtrapadosRobando(int cantAtrapadosRobando) {
		this.cantAtrapadosRobando = cantAtrapadosRobando;
	}

	public float PRO() {
		float returned = 0;
		if(cantHits == 0) {
			returned = 0;
		}else {
			returned = cantHits/cantTurnos;

		}
		return returned;
	}
	
	public float OBP() {
		
		float OBP = 0;
		
		try {
			OBP = (cantHits + cantBoletos + golpeadoPorPitcher)/(cantTurnos +cantBoletos + golpeadoPorPitcher + flySacrifio);
		} catch (ArithmeticException e){
			
		}
		
		return OBP;
		
		}
	public float SLG() {
		
		float slg = 0;
		
		try {
			slg = ((cantSencillos)+(cantDobles*2)+(cantTriples*3)+(cantJonrones*4) / cantTurnos);
		}catch(ArithmeticException e) {
			
		}
		
		return slg;
	}
	public float OPS() {
		return OBP()+SLG();
	}

}
