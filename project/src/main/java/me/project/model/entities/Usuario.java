package me.project.model.entities;
import java.io.Serializable;

import javax.persistence.*;

@MappedSuperclass
public abstract class Usuario implements Serializable{
	private static final long serialVersionUID = 7411614913520604498L;
	@Id
	private String usuario;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private String clave;
	

	public Usuario(String nombre, String apellidos, String usuario, String clave) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.clave = clave;
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
	
	

}
