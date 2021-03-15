package me.project.model.entities;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Paciente extends Usuario{
	private static final long serialVersionUID = -2408669723210022854L;
	@Column(name = "nss")
	private String nss;
	@Column(name = "numTarjeta")
	private String numTarjeta;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "direccion")
	private String direccion;
	private ArrayList<Medico> medicos;

	public Paciente(String nombre, String apellidos, String usuario, String clave,
			String nss, String numTarjeta, String telefono, String direccion) {
		super(nombre, apellidos, usuario, clave);
		this.nss = nss;
		this.direccion = direccion;
		this.numTarjeta = numTarjeta;
		this.telefono = telefono;
		medicos = new ArrayList<Medico>();
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(ArrayList<Medico> medicos) {
		this.medicos = medicos;
	}

	@Override
	public String toString() {
		return "Paciente [nss=" + nss + ", numTarjeta=" + numTarjeta + ", telefono=" + telefono + ", direccion="
				+ direccion + ", medicos=" + medicos + "]";
	}
	
	
	

}
