package me.project.model.entities;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
public class Medico extends Usuario{
	private static final long serialVersionUID = 2772355728921694683L;
	@Column(name = "num_colegiado")
	private String numColegiado; 
	@Transient
	private ArrayList<Paciente> pacientes;
	
	public Medico(String nombre, String apellidos, String usuario, String clave, String numColegiado) {
		super(nombre, apellidos, usuario, clave);
		this.numColegiado = numColegiado;
		pacientes = new ArrayList<Paciente>();
	}

	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	

}
