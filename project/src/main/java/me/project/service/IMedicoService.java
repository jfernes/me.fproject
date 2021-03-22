package me.project.service;

import me.project.model.entities.Medico;
import java.util.List;
import java.util.Optional;
import me.project.model.entities.Paciente;

public interface IMedicoService {
	public List<Medico> findAll();
	
	public Optional<Medico> findById(Long id);

	public Medico save(Medico medico);
	
	public void deleteById(Long id);
	
	public List<Paciente> findPacientes(Long id);
}
