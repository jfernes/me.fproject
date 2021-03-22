package me.project.service;

import java.util.List;
import java.util.Optional;

import me.project.model.entities.Paciente;
import me.project.model.entities.Medico;

public interface IPacienteService {
	
	public List<Paciente> findAll();
	
	public Optional<Paciente> findById(Long id);
	
	public Paciente save(Paciente paciente);
	
	public void deleteById(Long id);
	
	public List<Medico> findMedicos(Long id);
}
