package me.project.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.project.model.entities.Cita;
import me.project.repository.ICitaDAO;
import me.project.service.ICitaService;

@RestController
@RequestMapping("/citas")
public class CitaController {
	
	@Autowired
	ICitaService service;
	
	@PostMapping
	public Cita create (@RequestBody Cita cita) {
		return service.save(cita);
	}
	
	@GetMapping
	public List<Cita> read(){
		return service.findAll();
	}
}
