package me.project.dto;

import java.io.Serializable;
import java.util.List;

public class MedicoDTO implements Serializable{
	
	private static final long serialVersionUID = -4327391224292363507L;
	
	private Long id;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String clave;
	private String numColegiado;
	
	private List<Long> pacientes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNumColegiado() {
		return numColegiado;
	}
	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}
	public List<Long> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Long> pacientes) {
		this.pacientes = pacientes;
	}
	
	

}
