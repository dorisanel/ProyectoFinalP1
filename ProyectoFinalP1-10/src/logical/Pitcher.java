package logical;

public class Pitcher extends Jugador {
	
	private int juegosLanzados;
	private int aperturas;
	private int juegosCompletos;
	private int juegosBlanqueados;
	private int salvados;
	private int oportSalvado;
	private int cantStrikeOut;
	private int bolas;
	private int boletos;
	private int cantPonches;
	private int cantCarreras;
	private int carrerasLimpias;
	private int cantHits;
	private int cantJonrones;
	private int bateadoresGolpeados;	

	public Pitcher(String cedula, String nombre, int edad, int numero, boolean estado) {
		super(cedula, nombre, edad, numero, estado);
		this.juegosLanzados = 0;
		this.aperturas = 0;
		this.juegosCompletos = 0;
		this.juegosBlanqueados = 0;
		this.salvados = 0;
		this.oportSalvado = 0;
		this.cantStrikeOut = 0;
		this.bolas = 0;
		this.boletos = 0;
		this.cantPonches = 0;
		this.cantCarreras = 0;
		this.carrerasLimpias = 0;
		this.cantHits = 0;
		this.cantJonrones = 0;
		this.bateadoresGolpeados = 0;
	}
	
	

	public int getJuegosLanzados() {
		return juegosLanzados;
	}



	public void setJuegosLanzados(int juegosLanzados) {
		this.juegosLanzados = juegosLanzados;
	}



	public int getAperturas() {
		return aperturas;
	}



	public void setAperturas(int aperturas) {
		this.aperturas = aperturas;
	}



	public int getJuegosCompletos() {
		return juegosCompletos;
	}



	public void setJuegosCompletos(int juegosCompletos) {
		this.juegosCompletos = juegosCompletos;
	}



	public int getJuegosBlanqueados() {
		return juegosBlanqueados;
	}



	public void setJuegosBlanqueados(int juegosBlanqueados) {
		this.juegosBlanqueados = juegosBlanqueados;
	}



	public int getSalvados() {
		return salvados;
	}



	public void setSalvados(int salvados) {
		this.salvados = salvados;
	}



	public int getOportSalvado() {
		return oportSalvado;
	}



	public void setOportSalvado(int oportSalvado) {
		this.oportSalvado = oportSalvado;
	}



	public int getCantStrikeOut() {
		return cantStrikeOut;
	}



	public void setCantStrikeOut(int cantStrikeOut) {
		this.cantStrikeOut = cantStrikeOut;
	}



	public int getBolas() {
		return bolas;
	}



	public void setBolas(int bolas) {
		this.bolas = bolas;
	}



	public int getBoletos() {
		return boletos;
	}



	public void setBoletos(int boletos) {
		this.boletos = boletos;
	}



	public int getCantPonches() {
		return cantPonches;
	}



	public void setCantPonches(int cantPonches) {
		this.cantPonches = cantPonches;
	}



	public int getCantCarreras() {
		return cantCarreras;
	}



	public void setCantCarreras(int cantCarreras) {
		this.cantCarreras = cantCarreras;
	}



	public int getCarrerasLimpias() {
		return carrerasLimpias;
	}



	public void setCarrerasLimpias(int carrerasLimpias) {
		this.carrerasLimpias = carrerasLimpias;
	}



	public int getCantHits() {
		return cantHits;
	}



	public void setCantHits(int cantHits) {
		this.cantHits = cantHits;
	}



	public int getCantJonrones() {
		return cantJonrones;
	}



	public void setCantJonrones(int cantJonrones) {
		this.cantJonrones = cantJonrones;
	}



	public int getBateadoresGolpeados() {
		return bateadoresGolpeados;
	}



	public void setBateadoresGolpeados(int bateadoresGolpeados) {
		this.bateadoresGolpeados = bateadoresGolpeados;
	}



	@Override
	public float PRO() {
		// TODO Auto-generated method stub
		return 0;
	}

}
