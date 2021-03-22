package me.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.project.model.entities.Medico;
import me.project.model.entities.Paciente;
import me.project.repository.IPacienteDAO;

@Service
public class PacienteService implements IPacienteService{
	
	@Autowired
	IPacienteDAO dao;

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
	@Transactional
	public Paciente save(Paciente paciente) {
		return dao.save(paciente);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Medico> findMedicos(Long id) {
		return dao.findMedicos(id);
	}

}
