package me.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.project.model.entities.Medico;
import me.project.model.entities.Paciente;
import me.project.repository.IMedicoDAO;

@Service
public class MedicoService implements IMedicoService{
	
	@Autowired
	IMedicoDAO dao;

	@Override
	@Transactional(readOnly = true)
	public List<Medico> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Medico> findById(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional
	public Medico save(Medico medico) {
		return dao.save(medico);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional(readOnly = true)
	public List<Paciente> findPacientes(Long id) {
		return dao.findPacientes(id);
	}

}
