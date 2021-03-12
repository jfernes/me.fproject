package me.project.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Diagnostico implements Serializable{
	private static final long serialVersionUID = 6294765597706644298L;
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String valoracionEspecialista;
	@Column
	private String enfermedad;
	//TODO revisar si se deja
	@OneToOne(mappedBy = "diagnostico")
	private Cita cita;
	
	public Diagnostico(String valoracionEspecialista, String enfermedad, Cita cita) {
		this.valoracionEspecialista = valoracionEspecialista;
		this.enfermedad = enfermedad;
		this.cita = cita;
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

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
	
}