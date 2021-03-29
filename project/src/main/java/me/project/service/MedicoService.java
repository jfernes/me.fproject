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
public class MedicoService implements IMedicoService{
	
	@Autowired
	IMedicoDAO dao;
	@Autowired
	IPacienteDAO pdao;

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
	public Boolean save(Medico medico) {
		if (dao.findById(medico.getId()).isPresent()) {
			return false;
		}
		dao.save(medico);
		return true;
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional(readOnly = true)
	public List<Paciente> findPacientes(Long id) {
		/*//PROVISIONAL
		List<Paciente> pacientes = pdao.findAll().stream()
			.filter(p -> p.getId().equals(id))
			.collect(Collectors.toList());
		return pacientes;
		*/
		return dao.findPacientes(id);
	}

	@Override
	public Boolean addPaciente(Long medicoId, Long pacienteId) {
		Optional<Paciente> pac = pdao.findById(pacienteId);
		Optional<Medico> med = dao.findById(medicoId);
		if (pac.isPresent() && med.isPresent()) {
			Paciente paciente = pac.get();
			Medico medico = med.get();
			medico.addPaciente(paciente);
			dao.save(medico);
			return true;
		}
		return false;
	}
	
	

}
