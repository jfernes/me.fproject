package me.project.service;

import me.project.model.entities.Medico;
import java.util.List;
import java.util.Optional;
import me.project.model.entities.Paciente;

public interface IMedicoService {
	public List<Medico> findAll();
	
	public Optional<Medico> findById(Long id);

	public Boolean save(Medico medico);
	
	public void deleteById(Long id);
	
	public List<Paciente> findPacientes(Long id);
	
	public Boolean addPaciente(Long medicoId, Long pacienteId);

	Optional<Medico> findByUsuario(String usuario);

	Optional<Medico> login(String Usuario, String clave);
}
