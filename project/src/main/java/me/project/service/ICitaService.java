package me.project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import me.project.model.entities.Cita;

public interface ICitaService {
	public List<Cita> findAll();
	
	public Optional<Cita> findById(Long id);
	
	public List<Cita> findByDate(LocalDate date);
	
	public List<Cita> findByMedico(Long medicoId);
	
	public List<Cita> findByPaciente(Long pacienteId);
	
	public Cita save(Cita cita);
	
	public void deleteById(Long id);
	
}
