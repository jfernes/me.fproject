package me.project.model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Cita implements Serializable{
	private static final long serialVersionUID = -6565864941172902199L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "fecha_hora")
	private LocalDate fechaHora;
	@Column(name = "motivo_cita")
	private String motivoCita;
	@OneToOne
	@JoinColumn(name = "diagnostico")
	private Diagnostico diagnostico;
	@OneToOne
	@JoinColumn(name = "medico")
	private Medico medico;
	@OneToOne
	@JoinColumn(name = "paciente")
	private Paciente paciente;
	
	public Cita() {}
	
	public Cita(LocalDate fechaHora, String motivoCita, Medico medico, Paciente paciente) {
		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
		this.medico = medico;
		this.paciente = paciente;
	}
	
	public boolean isToday(LocalDate date) {
		return (fechaHora.getDayOfYear() == date.getDayOfYear()) 
				&& (fechaHora.getYear() == date.getYear());
	}
	
	public boolean isMedico(Long id) {
		return medico.getId().equals(id);
	}
	
	public boolean isPaciente(Long id) {
		return paciente.getId().equals(id);
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

	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
