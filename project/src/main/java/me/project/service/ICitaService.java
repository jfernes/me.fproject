package me.project.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import me.project.model.entities.Cita;
import me.project.model.entities.Diagnostico;

public interface ICitaService {
	public List<Cita> findAll();
	
	public Optional<Cita> findById(Long id);
	
	public List<Cita> findByDate(Date date);
	
	public List<Cita> findByMedico(Long medicoId);
	
	public List<Cita> findByPaciente(Long pacienteId);
	
	public boolean save(Cita cita);
	
	public boolean addDiagnostico(Long citaId, Diagnostico diagnostico);
	
	public void deleteById(Long id);
	
}
