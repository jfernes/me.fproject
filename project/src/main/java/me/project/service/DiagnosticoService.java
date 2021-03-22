package me.project.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.project.model.entities.Diagnostico;
import me.project.repository.IDiagnosticoDAO;

@Service
public class DiagnosticoService implements IDiagnosticoService{
	
	@Autowired
	IDiagnosticoDAO dao;

	@Override
	@Transactional(readOnly = true)
	public List<Diagnostico> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Diagnostico> findById(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Diagnostico> findByCita(Long citaId) {
		List<Diagnostico> out = dao.findAll().stream()
				.filter(d -> d.getCita().getId().equals(citaId))
				.collect(Collectors.toList());
		return out;
	}

	@Override
	@Transactional
	public Diagnostico save(Diagnostico diagnostico) {
		return dao.save(diagnostico);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		dao.deleteById(id);
		
	}

}
