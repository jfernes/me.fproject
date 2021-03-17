package me.project.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.project.model.entities.Cita;
import me.project.repository.ICitaDAO;

@RestController
@RequestMapping("/citas")
public class CitaController {
	@Autowired
	private ICitaDAO dao;
	
	@GetMapping
	public void create (Cita cita) {
		dao.save(cita);
	}
	
	@PostMapping
	public List<Cita> read(){
		return dao.findAll();
	}
	
	@PutMapping
	public void update (Cita cita) {
		dao.save(cita);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(Long id) {
		dao.deleteById(id);
	}

}
