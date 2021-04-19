package me.project.service;

import java.util.List;
import java.util.Optional;

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
	@Transactional
	public boolean save(Diagnostico diagnostico) {
		if (dao.findById(diagnostico.getId()).isPresent())
			return false;
		dao.save(diagnostico);
		return true;
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		dao.deleteById(id);
		
	}

}
