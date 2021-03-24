package me.project.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CitaDTO implements Serializable{

	private static final long serialVersionUID = -8698871845358111918L;
	
	private Long id;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDate fechaHora;
	private String motivoCita;
	private Long Diagnostico;
	private Long Paciente;
	private Long Medico;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDate fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getMotivoCita() {
		return motivoCita;
	}
	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}
	public Long getDiagnostico() {
		return Diagnostico;
	}
	public void setDiagnostico(Long diagnostico) {
		Diagnostico = diagnostico;
	}
	public Long getPaciente() {
		return Paciente;
	}
	public void setPaciente(Long paciente) {
		Paciente = paciente;
	}
	public Long getMedico() {
		return Medico;
	}
	public void setMedico(Long medico) {
		Medico = medico;
	}
	
	
	

}
