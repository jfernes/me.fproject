package me.project.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
public class Cita implements Serializable{
	private static final long serialVersionUID = -6565864941172902199L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "fecha_hora")
	private Date fechaHora;
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
	
	public Cita(Date fechaHora, String motivoCita, Medico medico, Paciente paciente) {
		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
		this.medico = medico;
		this.paciente = paciente;
	}
	
	@SuppressWarnings("deprecation")
	public boolean isToday(Date date) {
		return (fechaHora.getDay() == date.getDay()) 
				&& (fechaHora.getYear() == date.getYear())
				&& (fechaHora.getMonth() == date.getMonth());
	}
	
	public boolean isMedico(Long id) {
		return medico.getId().equals(id);
	}
	
	public boolean isPaciente(Long id) {
		return paciente.getId().equals(id);
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
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

	@Override
	public String toString() {
		return "Cita [id=" + id + ", fechaHora=" + fechaHora + ", motivoCita=" + motivoCita + ", diagnostico="
				+ null + ", medico=" + medico + ", paciente=" + paciente + "]";
	}
	
	
}
