package me.project.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.project.model.entities.Medico;
import me.project.service.IMedicoService;

@RestController
@RequestMapping("medicos")
public class MedicoController {
	
	@Autowired
	IMedicoService service;

	@GetMapping
	public List<Medico> read(){
		return service.findAll();
	}
	
	@PostMapping
	public Medico create(Medico medico) {
		return service.save(medico);
	}
	
}
