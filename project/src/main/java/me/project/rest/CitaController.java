package me.project.rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.project.dto.CitaDTO;
import me.project.model.entities.Cita;
import me.project.rest.converter.Converter;
import me.project.service.ICitaService;

@RestController
@RequestMapping("/citas")
public class CitaController {
	
	@Autowired
	private ICitaService service;
	private Converter converter = Converter.getConverter();
	
	
	@PostMapping
	public ResponseEntity<String> create (@RequestBody CitaDTO citaDTO) {
		Cita cita = converter.CDTOtoC(citaDTO);
		if (service.save(cita)) {
			return ResponseEntity.ok("Cita creada correctamente");
		}
		return ResponseEntity.status(409).build();
	} 
	
	@GetMapping
	public ResponseEntity<List<CitaDTO>> read(){
		List<CitaDTO> out = new ArrayList<CitaDTO>();
		service.findAll().stream()
			.forEach(c -> out.add(converter.CtoCDTO(c)));
		return ResponseEntity.ok(out);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CitaDTO> findById (Long id){
		Optional<Cita> opt = service.findById(id);
		if (opt.isPresent()) {
			return ResponseEntity.ok(converter.CtoCDTO(opt.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/medico/{id}")
	public ResponseEntity<List<CitaDTO>> findByMedico(@PathVariable Long id){	
		List<CitaDTO> out = new ArrayList<CitaDTO>();
		service.findByMedico(id).stream()
			.forEach(c -> out.add(converter.CtoCDTO(c)));
		return ResponseEntity.ok(out);
	}
	
	@GetMapping("/paciente/{id}")
	public ResponseEntity<List<CitaDTO>> findByPaciente(@PathVariable Long id){	
		List<CitaDTO> out = new ArrayList<CitaDTO>();
		service.findByPaciente(id).stream()
			.forEach(c -> out.add(converter.CtoCDTO(c)));
		return ResponseEntity.ok(out);
	}
	
	@GetMapping("/date")
	public ResponseEntity<List<CitaDTO>> findByMedico(@RequestBody LocalDate date){	
		List<CitaDTO> out = new ArrayList<CitaDTO>();
		service.findByDate(date).stream()
			.forEach(c -> out.add(converter.CtoCDTO(c)));
		return ResponseEntity.ok(out);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.ok("Medico eliminado correctamente");
	}
	
	
}
