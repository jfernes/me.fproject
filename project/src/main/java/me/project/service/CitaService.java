package me.project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.project.model.entities.Cita;
import me.project.repository.ICitaDAO;

@Service
public class CitaService implements ICitaService{
	
	@Autowired
	private ICitaDAO dao;

	@Override
	@Transactional(readOnly = true)
	public List<Cita> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cita> findById(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional
	public Cita save(Cita cita) {
		return dao.save(cita);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cita> findByDate(LocalDate date) {
		List<Cita> out = dao.findAll().stream()
				.filter(c -> c.isToday(date))
				.collect(Collectors.toList());
		return out;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cita> findByMedico(Long medicoId) {
		List<Cita> out = dao.findAll().stream()
				.filter(c -> c.isMedico(medicoId))
				.collect(Collectors.toList());
		return out;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cita> findByPaciente(Long pacienteId) {
		List<Cita> out = dao.findAll().stream()
				.filter(c -> c.isPaciente(pacienteId))
				.collect(Collectors.toList());
		return out;
	}

}
