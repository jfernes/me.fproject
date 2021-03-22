package me.project.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.project.service.IPacienteService;
import me.project.model.entities.Paciente;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	IPacienteService service;
	
	@GetMapping
	public List<Paciente> read(){
		return service.findAll();
	}
	
	@PostMapping
	public Paciente create(@RequestBody Paciente paciente) {
		return service.save(paciente);
	}
	
}
