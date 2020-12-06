package logical;

import java.io.Serializable;

public class Estadistica implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Estadistica(String nombreTemporada, int j, int aB, int r, int h_bateo, int doubleB, int tripleB, int hR,
			int rBI, int tB, int bB_bateo, int sO_bateo, int sB, float iP, int g, int p, int sV, int cG, int sHO,
			int qS, int h_pitcheo, int eR, int bB_pitcheo, int sO_pitcheo) {
		super();
		NombreTemporada = nombreTemporada;
		this.j = j;
		AB = aB;
		R = r;
		H_bateo = h_bateo;
		this.doubleB = doubleB;
		this.tripleB = tripleB;
		HR = hR;
		RBI = rBI;
		TB = tB;
		BB_bateo = bB_bateo;
		SO_bateo = sO_bateo;
		SB = sB;
		IP = iP;
		G = g;
		P = p;
		SV = sV;
		CG = cG;
		SHO = sHO;
		QS = qS;
		H_pitcheo = h_pitcheo;
		ER = eR;
		BB_pitcheo = bB_pitcheo;
		SO_pitcheo = sO_pitcheo;
		AVG = 0;
		OBP = 0;
		OPS = 0;
		ERA = 0;
	}
	private  String  NombreTemporada;
	private int j;
	private  int AB;
	private  int R;
	private  int H_bateo;
	private  int doubleB;
	private  int tripleB;
	private  int HR;
	private  int RBI;
	private  int TB;
	private  int BB_bateo;
	private  int SO_bateo;
	private  int SB;
	private  float AVG;
	private  float OBP;
	private  float SLG;
	private  float OPS;
	private float ERA;
	private float IP;
	private  int G;
	private  int P;
	private  int SV;
	private  int CG;
	private  int SHO;
	private  int QS;
	private  int H_pitcheo;
	private  int ER;
	private  int BB_pitcheo;
	private  int SO_pitcheo;
	
	
	public String getNombreTemporada() {
		return NombreTemporada;
	}
	public void setNombreTemporada(String nombreTemporada) {
		NombreTemporada = nombreTemporada;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	public int getAB() {
		return AB;
	}
	public void setAB(int aB) {
		AB = aB;
	}
	public int getR() {
		return R;
	}
	public void setR(int r) {
		R = r;
	}
	public int getH_bateo() {
		return H_bateo;
	}
	public void setH_bateo(int h_bateo) {
		H_bateo = h_bateo;
	}
	public int getDoubleB() {
		return doubleB;
	}
	public void setDoubleB(int doubleB) {
		this.doubleB = doubleB;
	}
	public int getTripleB() {
		return tripleB;
	}
	public void setTripleB(int tripleB) {
		this.tripleB = tripleB;
	}
	public int getHR() {
		return HR;
	}
	public void setHR(int hR) {
		HR = hR;
	}
	public int getRBI() {
		return RBI;
	}
	public void setRBI(int rBI) {
		RBI = rBI;
	}
	public int getTB() {
		return TB;
	}
	public void setTB(int tB) {
		TB = tB;
	}
	public int getBB_bateo() {
		return BB_bateo;
	}
	public void setBB_bateo(int bB_bateo) {
		BB_bateo = bB_bateo;
	}
	public int getSO_bateo() {
		return SO_bateo;
	}
	public void setSO_bateo(int sO_bateo) {
		SO_bateo = sO_bateo;
	}
	public int getSB() {
		return SB;
	}
	public void setSB(int sB) {
		SB = sB;
	}
	public float getAVG_Bateo() {
		
		if(H_bateo == 0 || AB == 0) {
			AVG = 0;
		}else {
			AVG = H_bateo/AB;
		}
		return AVG;
	}
	public float getAVG_Pitcheo() {
		
		if(H_pitcheo == 0 || AB == 0) {
			AVG = 0;
		}else {
			AVG =H_pitcheo/AB;
		}
		return AVG;
	}

	public float getSLG() {
		return SLG;
	}
	public void setSLG(float sLG) {
		SLG = sLG;
	}
	public float getERA() {
		setERA();
		return ERA;
	}
	public void setERA() {
		ERA = (ER/IP)*9;
	}
	public float getIP() {
		return IP;
	}
	public void setIP(float iP) {
		IP = iP;
	}
	public int getG() {
		return G;
	}
	public void setG(int g) {
		G = g;
	}
	public int getP() {
		return P;
	}
	public void setP(int p) {
		P = p;
	}
	public int getSV() {
		return SV;
	}
	public void setSV(int sV) {
		SV = sV;
	}
	public int getCG() {
		return CG;
	}
	public void setCG(int cG) {
		CG = cG;
	}
	public int getSHO() {
		return SHO;
	}
	public void setSHO(int sHO) {
		SHO = sHO;
	}
	public int getQS() {
		return QS;
	}
	public void setQS(int qS) {
		QS = qS;
	}
	public int getH_pitcheo() {
		return H_pitcheo;
	}
	public void setH_pitcheo(int h_pitcheo) {
		H_pitcheo = h_pitcheo;
	}
	public int getER() {
		return ER;
	}
	public void setER(int eR) {
		ER = eR;
	}
	public int getBB_pitcheo() {
		return BB_pitcheo;
	}
	public void setBB_pitcheo(int bB_pitcheo) {
		BB_pitcheo = bB_pitcheo;
	}
	public int getSO_pitcheo() {
		return SO_pitcheo;
	}
	public void setSO_pitcheo(int sO_pitcheo) {
		SO_pitcheo = sO_pitcheo;
	}
	public float getOBP() {
		return OBP;
	}
	public void setOBP() {
		OBP = (H_bateo+BB_bateo)/(AB+BB_bateo);
	}
	public float getOPS() {
		return OPS;
	}
	public void setOPS() {
		OPS = OBP+SLG;
	}
	
	
	
}
