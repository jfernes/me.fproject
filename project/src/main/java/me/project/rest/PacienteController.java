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
import me.project.dto.MessageDTO;
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
	public ResponseEntity<MessageDTO> read(){
		List<PacienteDTO> out = new ArrayList<PacienteDTO>();
		service.findAll().stream()
			.forEach(p -> out.add(converter.PtoPDTO(p)));
		return ResponseEntity.ok(new MessageDTO(200, out));
	}
	
	@PostMapping
	public ResponseEntity<MessageDTO> create(@RequestBody PacienteDTO pacienteDTO) {
		if (service.save(converter.PDTOtoP(pacienteDTO)))
			return ResponseEntity.ok(new MessageDTO(200, "Paciente creado correctamente"));
		return ResponseEntity.ok(new MessageDTO(412, null));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MessageDTO> findById(@PathVariable Long id){
		Optional<Paciente> opt = service.findById(id);
		if (opt.isPresent()) {
			return ResponseEntity.ok(new MessageDTO(200, converter.PtoPDTO(opt.get())));
		}
		return ResponseEntity.ok(new MessageDTO(404, null));
	}
	
	@GetMapping("/u/{usuario}")
	public ResponseEntity<MessageDTO> findByUsuario(@PathVariable String usuario){
		Optional<Paciente> opt = service.findByUsuario(usuario);
		if (opt.isPresent()) {
			return ResponseEntity.ok(new MessageDTO(200, converter.PtoPDTO(opt.get())));
		}
		return ResponseEntity.ok(new MessageDTO(404, null));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageDTO> deleteById(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.ok(new MessageDTO(200, "Paciente eliminado correctamente"));
	}
	
	@PutMapping
	public ResponseEntity<MessageDTO> addPaciente(@RequestBody ObjectNode obj){
		Long medicoId = obj.get("medicoId").asLong();
		Long pacienteId = obj.get("pacienteId").asLong();
		if (service.addMedico(pacienteId, medicoId)) {
			return ResponseEntity.ok(new MessageDTO(200, "Paciente insertado correctamente"));
		}
		return ResponseEntity.ok(new MessageDTO(404, null));
	}
	
	@PostMapping("/login")
	public ResponseEntity<MessageDTO> login(@RequestBody ObjectNode obj){
		String usuario = obj.get("usuario").asText();
		String clave = obj.get("clave").asText();
		Optional<Paciente> opt = service.login(usuario, clave);
		if (opt.isPresent())
			return ResponseEntity.ok(new MessageDTO(200, converter.PtoPDTO(opt.get())));
		return ResponseEntity.ok(new MessageDTO(404, null));
	}
	
}
