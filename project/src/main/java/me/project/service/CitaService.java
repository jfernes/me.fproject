package me.project.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.project.model.entities.Cita;
import me.project.model.entities.Diagnostico;
import me.project.repository.ICitaDAO;
import me.project.repository.IDiagnosticoDAO;

@Service
public class CitaService implements ICitaService{
	
	@Autowired
	private ICitaDAO dao;
	@Autowired
	private IDiagnosticoDAO dDao;

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
	public boolean save(Cita cita) {
		if (dao.findById(cita.getId()).isPresent())
			return false;
		dao.save(cita);
		return true;
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cita> findByDate(Date date) {
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

	@Override
	@Transactional
	public boolean addDiagnostico(Long citaId, Diagnostico diagnostico) {
		Optional<Cita> opt = dao.findById(citaId);
		if (!opt.isPresent() || opt.get().getDiagnostico() != null)
			return false;
		Cita cita = opt.get();
		Diagnostico d = dDao.save(diagnostico);
		cita.setDiagnostico(d);
		dao.save(cita);
		return true;
	}
	
	

}
