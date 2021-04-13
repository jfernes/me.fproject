package me.project.model.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Medico extends Usuario{
	private static final long serialVersionUID = 2772355728921694683L;
	@Column(name = "num_colegiado")
	private String numColegiado; 
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "medico_paciente",
		joinColumns = @JoinColumn(name = "medico"),
		inverseJoinColumns = @JoinColumn(name = "paciente"))
	private List<Paciente> pacientes;
	
	public Medico() {
		super();
		pacientes = new ArrayList<Paciente>();
	}
	
	public Medico(String nombre, String apellidos, String usuario, String clave, String numColegiado) {
		super(nombre, apellidos, usuario, clave);
		this.numColegiado = numColegiado;
		pacientes = new ArrayList<Paciente>();
	}
	
	public void addPaciente(Paciente paciente) {
		if (!pacientes.contains(paciente)) {
			pacientes.add(paciente);
		}
	}

	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	@Override
	public String toString() {
		return "Medico [numColegiado=" + numColegiado + ", pacientes=" + pacientes + "]";
	}
	
	
	
	

}
