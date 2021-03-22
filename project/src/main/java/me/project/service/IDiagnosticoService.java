package me.project.service;

import java.util.List;
import java.util.Optional;

import me.project.model.entities.Diagnostico;

public interface IDiagnosticoService {
	
	public List<Diagnostico> findAll();
	
	public Optional<Diagnostico> findById(Long id);
	
	public List<Diagnostico> findByCita(Long citaId);
	
	public Diagnostico save(Diagnostico diagnostico);

	public void deleteById(Long id); 
}
