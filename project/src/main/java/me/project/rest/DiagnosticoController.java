package me.project.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.project.service.IDiagnosticoService;
import me.project.model.entities.Diagnostico;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {
	
	@Autowired
	IDiagnosticoService service;
	
	@GetMapping
	public List<Diagnostico> read(){
		return service.findAll();
	}
	
	@PostMapping
	public Diagnostico create(@RequestBody Diagnostico diagnostico) {
		return service.save(diagnostico);
	}
	

}
