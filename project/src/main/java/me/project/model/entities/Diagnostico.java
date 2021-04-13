package me.project.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Diagnostico implements Serializable{
	private static final long serialVersionUID = 6294765597706644298L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "valoracion_especialista")
	private String valoracionEspecialista;
	@Column(name = "enfermedad")
	private String enfermedad;

	public Diagnostico() {}
	
	public Diagnostico(String valoracionEspecialista, String enfermedad, Cita cita) {
		this.valoracionEspecialista = valoracionEspecialista;
		this.enfermedad = enfermedad;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Diagnostico [id=" + id + ", valoracionEspecialista=" + valoracionEspecialista + ", enfermedad="
				+ enfermedad + "]";
	}
	
	
	
	
}
