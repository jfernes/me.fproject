package me.project.dto;

import java.io.Serializable;

public class DiagnosticoDTO implements Serializable{

	private static final long serialVersionUID = -4413902703630430644L;
		
	private Long id;
	private String valoracionEspecialista;
	private String enfermedad;
	private Long cita;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValoracionEspecialista() {
		return valoracionEspecialista;
	}
	public void setValoracionEspecialista(String valoracionEspecialista) {
		this.valoracionEspecialista = valoracionEspecialista;
	}
	public String getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	public Long getCita() {
		return cita;
	}
	public void setCita(Long cita) {
		this.cita = cita;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
