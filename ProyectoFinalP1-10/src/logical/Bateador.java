package logical;

public class Bateador extends Jugador {

	private int cantCarreras = 0;
	private int cantHits = 0;
	private int cantDobles = 0;
	private int cantTriples = 0;
	private int cantJonrones = 0;
	private int basesRobadas = 0;
	private int cantPonches = 0;
	private int cantCarrerasImpulsadas=0;
	private int cantBoletos=0;
	private int cantBasesRobadas=0;
	private int cantAtrapadosRobando=0;
	
	
	public Bateador(String cedula, String nombre, int edad, int numero, boolean estado, int cantCarreras, int cantHits,
			int cantDobles, int cantTriples, int cantJonrones, int basesRobadas, int cantPonches,
			int cantCarrerasImpulsadas, int cantBoletos, int cantBasesRobadas, int cantAtrapadosRobando) {
		super(cedula, nombre, edad, numero, estado);
		this.cantCarreras = cantCarreras;
		this.cantHits = cantHits;
		this.cantDobles = cantDobles;
		this.cantTriples = cantTriples;
		this.cantJonrones = cantJonrones;
		this.basesRobadas = basesRobadas;
		this.cantPonches = cantPonches;
		this.cantCarrerasImpulsadas = cantCarrerasImpulsadas;
		this.cantBoletos = cantBoletos;
		this.cantBasesRobadas = cantBasesRobadas;
		this.cantAtrapadosRobando = cantAtrapadosRobando;
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

	public void setCantHits(int cantHits) {
		this.cantHits = cantHits;
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
		// TODO Auto-generated method stub
		return 0;
	}
	
	public float OBP() {
		return 0;
		}
	public float SLG() {
		return 0;
		
	}
	public float OPS() {
		return 0;
	}

}
