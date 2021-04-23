package me.project.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import me.project.service.IPacienteService;
import me.project.dto.PacienteDTO;
import me.project.model.entities.Paciente;
import me.project.rest.converter.Converter;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private IPacienteService service;
	@Autowired
	private Converter converter;
	
	@GetMapping
	public ResponseEntity<List<PacienteDTO>> read(){
		List<PacienteDTO> out = new ArrayList<PacienteDTO>();
		service.findAll().stream()
			.forEach(p -> out.add(converter.PtoPDTO(p)));
		return ResponseEntity.ok(out);
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody PacienteDTO pacienteDTO) {
		if (service.save(converter.PDTOtoP(pacienteDTO)))
			return ResponseEntity.ok("Paciente creado correctamente");
		return ResponseEntity.status(412).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PacienteDTO> findById(@PathVariable Long id){
		Optional<Paciente> opt = service.findById(id);
		if (opt.isPresent()) {
			return ResponseEntity.ok(converter.PtoPDTO(opt.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/u/{usuario}")
	public ResponseEntity<PacienteDTO> findById(@PathVariable String usuario){
		Optional<Paciente> opt = service.findByUsuario(usuario);
		if (opt.isPresent()) {
			return ResponseEntity.ok(converter.PtoPDTO(opt.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.ok("Paciente eliminado correctamente");
	}
	
	@PutMapping
	public ResponseEntity<String> addPaciente(@RequestBody ObjectNode obj){
		Long medicoId = obj.get("medicoId").asLong();
		Long pacienteId = obj.get("pacienteId").asLong();
		if (service.addMedico(pacienteId, medicoId)) {
			return ResponseEntity.ok("Paciente insertado correctamente");
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<Paciente> login(@RequestBody ObjectNode obj){
		String usuario = obj.get("usuario").asText();
		String clave = obj.get("clave").asText();
		Optional<Paciente> opt = service.login(usuario, clave);
		if (opt.isPresent())
			return ResponseEntity.ok(opt.get());
		return ResponseEntity.notFound().build();
	}
	
}
