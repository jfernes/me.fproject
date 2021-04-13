package me.project.service;

import java.util.List;
import java.util.Optional;

import me.project.model.entities.Diagnostico;

public interface IDiagnosticoService {
	
	public List<Diagnostico> findAll();
	
	public Optional<Diagnostico> findById(Long id);
	
	public boolean save(Diagnostico diagnostico);

	public void deleteById(Long id); 
}
