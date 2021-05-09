package me.project.rest;

import java.util.ArrayList;
import java.util.Date;
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

import me.project.dto.CitaDTO;
import me.project.dto.DiagnosticoDTO;
import me.project.dto.MessageDTO;
import me.project.model.entities.Cita;
import me.project.model.entities.Medico;
import me.project.model.entities.Paciente;
import me.project.rest.converter.Converter;
import me.project.service.ICitaService;
import me.project.service.IMedicoService;
import me.project.service.IPacienteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/citas")
public class CitaController {
	
	@Autowired
	private ICitaService service;
	@Autowired 
	private IMedicoService mService;
	@Autowired
	private IPacienteService pService;
	@Autowired
	private Converter converter;
	
	
	@PostMapping
	public ResponseEntity<MessageDTO> create (@RequestBody CitaDTO citaDTO) {
		Optional<Paciente> paciente = pService.findById(citaDTO.getPaciente());
		Optional<Medico> medico = mService.findById(citaDTO.getMedico());
		if (!medico.isPresent() || !paciente.isPresent())
			return ResponseEntity.ok(new MessageDTO(404, null));
		Cita cita = converter.CDTOtoC(citaDTO, medico.get(), paciente.get()); 
		if (service.save(cita)) {
			return ResponseEntity.ok(new MessageDTO(200, "Diágnostico guardado correctamente"));
		}
		return ResponseEntity.ok(new MessageDTO(404, null));
	} 
	
	@GetMapping
	public ResponseEntity<MessageDTO> read(){
		List<CitaDTO> out = new ArrayList<CitaDTO>();
		service.findAll().stream()
			.forEach(c -> out.add(converter.CtoCDTO(c)));
		return ResponseEntity.ok(new MessageDTO(200, out));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MessageDTO> findById (Long id){
		Optional<Cita> opt = service.findById(id);
		if (opt.isPresent()) {
			return ResponseEntity.ok(new MessageDTO(200, converter.CtoCDTO(opt.get())));
		}
		return ResponseEntity.ok(new MessageDTO(404, null));
	}
	
	@GetMapping("/medico/{id}")
	public ResponseEntity<MessageDTO> findByMedico(@PathVariable Long id){	
		List<CitaDTO> out = new ArrayList<CitaDTO>();
		service.findByMedico(id).stream()
			.forEach(c -> out.add(converter.CtoCDTO(c)));
		return ResponseEntity.ok(new MessageDTO(200, out));
	}
	
	@GetMapping("/paciente/{id}")
	public ResponseEntity<MessageDTO> findByPaciente(@PathVariable Long id){	
		List<CitaDTO> out = new ArrayList<CitaDTO>();
		service.findByPaciente(id).stream()
			.forEach(c -> out.add(converter.CtoCDTO(c)));
		return ResponseEntity.ok(new MessageDTO(200, out));
	}
	
	@GetMapping("/date")
	public ResponseEntity<MessageDTO> findByFecha(@RequestBody Date date){	
		List<CitaDTO> out = new ArrayList<CitaDTO>();
		service.findByDate(date).stream()
			.forEach(c -> out.add(converter.CtoCDTO(c)));
		return ResponseEntity.ok(new MessageDTO(200, out));
	}
	
	@GetMapping("/diagnostico/{citaId}")
	public ResponseEntity<MessageDTO> getDiagnosticoByCita(@PathVariable Long citaId){	
		Optional<Cita> opt = service.findById(citaId);
		if (opt.isPresent() && opt.get().getDiagnostico() != null)
			return ResponseEntity.ok(new MessageDTO(200, converter.DtoDDTO(opt.get().getDiagnostico())));
		return ResponseEntity.ok(new MessageDTO(404, null));
	}
	
	@PostMapping("/diagnostico/{citaId}")
	public ResponseEntity<MessageDTO> addDiagnostico(@PathVariable Long citaId, @RequestBody DiagnosticoDTO diagnosticoDTO){
		if (service.addDiagnostico(citaId, converter.DDTOtoD(diagnosticoDTO)))
			return ResponseEntity.ok(new MessageDTO(200, "Diágnostico guardado correctamente"));
		return ResponseEntity.ok(new MessageDTO(412, null));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageDTO> deleteById(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.ok(new MessageDTO(200, "Diágnostico eliminado correctamente"));
	}
	
	
}
