package me.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.project.model.entities.Medico;
import me.project.model.entities.Paciente;
import me.project.repository.IMedicoDAO;
import me.project.repository.IPacienteDAO;

@Service
public class PacienteService implements IPacienteService{
	
	@Autowired
	private IPacienteDAO dao;
	@Autowired
	private IMedicoDAO mdao;

	@Override
	@Transactional(readOnly = true)
	public List<Paciente> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Paciente> findById(Long id) {
		return dao.findById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Paciente> findByUsuario(String usuario){
		Optional<Paciente> opt = Optional.empty();
		List<Paciente> l = dao.findByUsuario(usuario);
		if (!l.isEmpty())
			opt = Optional.of(l.get(0));
		return opt;
	}

	@Override
	@Transactional
	public Boolean save(Paciente paciente) {
		if (dao.findByUsuario(paciente.getUsuario()).isEmpty()) {
			dao.save(paciente);
			return true;
		}
		return false;	
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Medico> findMedicos(Long id) {
		/*//PROVISIONAL
		List<Medico> medicos = mdao.findAll().stream()
				.filter(m -> m.getId().equals(id))
				.collect(Collectors.toList());
		return medicos; */
		return dao.findMedicos(id);
	}
	
	@Transactional
	public boolean addMedico(Long pacienteId, Long medicoId) {
		Optional<Medico> med = mdao.findById(medicoId);
		Optional<Paciente> pac = dao.findById(pacienteId);
		if (med.isPresent() && pac.isPresent()) {
			Paciente paciente = pac.get();
			Medico medico = med.get();
			paciente.addMedico(medico);
			dao.save(paciente);
			return true;
		}
		return false;
	}
	
	@Override
	public Optional<Paciente> login (String usuario, String clave){
		Optional<Paciente> opt = Optional.empty();
		List<Paciente> l = dao.findByUsuario(usuario);
		if (l.isEmpty() || !l.get(0).getClave().equals(clave))
			return opt;
		return opt = Optional.of(l.get(0));
	}

}
