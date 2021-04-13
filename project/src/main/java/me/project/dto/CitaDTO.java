package me.project.dto;

import java.io.Serializable;

public class CitaDTO implements Serializable{

	private static final long serialVersionUID = -8698871845358111918L;
	
	private Long id;
	private String fechaHora; //formato "yyyy-MM-dd HH:mm:ss"
	private String motivoCita;
	private Long diagnostico;
	private Long paciente;
	private Long medico;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getMotivoCita() {
		return motivoCita;
	}
	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}
	public Long getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(Long diagnostico) {
		this.diagnostico = diagnostico;
	}
	public Long getPaciente() {
		return paciente;
	}
	public void setPaciente(Long paciente) {
		this.paciente = paciente;
	}
	public Long getMedico() {
		return medico;
	}
	public void setMedico(Long medico) {
		this.medico = medico;
	}
	
	
	

}
