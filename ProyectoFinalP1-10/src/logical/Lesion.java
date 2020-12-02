package logical;

import java.io.Serializable;
import java.util.Date;

public class Lesion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String diagnostico;
	private String tipo;
	private Date fechaLesion;
	private int diasLesionado;
	
	public Lesion(String diagnostico, String tipo, Date fechaLesion, int diasLesionado) {
		super();
		this.diagnostico = diagnostico;
		this.tipo = tipo;
		this.fechaLesion = fechaLesion;
		this.diasLesionado = diasLesionado;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFechaLesion() {
		return fechaLesion;
	}

	public void setFechaLesion(Date fechaLesion) {
		this.fechaLesion = fechaLesion;
	}

	public int getDiasLesionado() {
		return diasLesionado;
	}

	public void setDiasLesionado(int diasLesionado) {
		this.diasLesionado = diasLesionado;
	}
	
	

}
