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

import me.project.dto.MedicoDTO;
import me.project.model.entities.Medico;
import me.project.service.IMedicoService;
import oracle.jdbc.proxy.annotation.Post;
import me.project.rest.converter.Converter;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private IMedicoService service;
	@Autowired
	private Converter converter;

	@GetMapping
	public ResponseEntity<List<MedicoDTO>> read(){
		List<MedicoDTO> out = new ArrayList<MedicoDTO>();
		service.findAll().stream()
			.forEach(m -> out.add(converter.MtoMDTO(m)));
		return ResponseEntity.ok(out);
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody MedicoDTO medicoDTO) {
		Medico medico = converter.MDTOtoM(medicoDTO);
		if (service.save(medico)) 
			return ResponseEntity.ok("Medico creado correctamente");
		return ResponseEntity.status(412).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicoDTO> findById(@PathVariable Long id){
		Optional<Medico> opt = service.findById(id);
		if (opt.isPresent()) {
			return ResponseEntity.ok(converter.MtoMDTO(opt.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/u/{usuario}")
	public ResponseEntity<MedicoDTO> findByUsuario(@PathVariable String usuario){
		Optional<Medico> opt = service.findByUsuario(usuario);
		if (opt.isPresent()) {
			return ResponseEntity.ok(converter.MtoMDTO(opt.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.ok("Medico eliminado correctamente");
	}
	
	@PutMapping
	public ResponseEntity<String> addPaciente(@RequestBody ObjectNode obj){
		Long medicoId = obj.get("medicoId").asLong();
		Long pacienteId = obj.get("pacienteId").asLong();
		if (service.addPaciente(medicoId, pacienteId)) {
			return ResponseEntity.ok("Paciente insertado correctamente");
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<Medico> login(@RequestBody ObjectNode obj){
		String usuario = obj.get("usuario").asText();
		String clave = obj.get("clave").asText();
		Optional<Medico> opt = service.login(usuario, clave);
		if (opt.isPresent())
			return ResponseEntity.ok(opt.get());
		return ResponseEntity.notFound().build();

	}
}
