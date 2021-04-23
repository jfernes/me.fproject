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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.project.service.IDiagnosticoService;
import me.project.dto.DiagnosticoDTO;
import me.project.model.entities.Diagnostico;
import me.project.rest.converter.Converter;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/diagnosticos")
public class DiagnosticoController {
	
	@Autowired
	private IDiagnosticoService service;
	@Autowired
	private Converter converter;
	
	@GetMapping
	public ResponseEntity<List<DiagnosticoDTO>> read(){
		List<DiagnosticoDTO> out = new ArrayList<DiagnosticoDTO>();
		service.findAll().stream()
			.forEach(d -> out.add(converter.DtoDDTO(d)));
		return ResponseEntity.ok(out);
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody DiagnosticoDTO diagnosticoDTO) {
		Diagnostico diagnostico = converter.DDTOtoD(diagnosticoDTO);
		if (service.save(diagnostico)) {
			return ResponseEntity.ok("Diagnostico creado correctamente");
		}
		return ResponseEntity.status(412).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DiagnosticoDTO> findById(@PathVariable Long id){
		Optional<Diagnostico> opt = service.findById(id);
		if (opt.isPresent()) {
			return ResponseEntity.ok(converter.DtoDDTO(opt.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.ok("Diagnostico eliminado correctamente");
	}
	

}
