package me.project.model.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Paciente extends Usuario{
	private static final long serialVersionUID = -2408669723210022854L;
	@Column(name = "nss")
	private String nss;
	@Column(name = "num_tarjeta")
	private String numTarjeta;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "direccion")
	private String direccion;
	@ManyToMany(mappedBy = "pacientes", fetch = FetchType.EAGER)
	private List<Medico> medicos;
	
	public Paciente() {
		super();
		medicos = new ArrayList<Medico>();
	}

	public Paciente(String nombre, String apellidos, String usuario, String clave,
			String nss, String numTarjeta, String telefono, String direccion) {
		super(nombre, apellidos, usuario, clave);
		this.nss = nss;
		this.direccion = direccion;
		this.numTarjeta = numTarjeta;
		this.telefono = telefono;
		medicos = new ArrayList<Medico>();
	}
	
	public void addMedico(Medico medico) {
		if (!medicos.contains(medico))
			medicos.add(medico);
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

	public List<Medico> getMedicos() {
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
