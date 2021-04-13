package me.project.rest;

import java.util.ArrayList;
import java.util.Date;
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
import me.project.dto.DiagnosticoDTO;
import me.project.model.entities.Cita;
import me.project.model.entities.Diagnostico;
import me.project.model.entities.Medico;
import me.project.model.entities.Paciente;
import me.project.rest.converter.Converter;
import me.project.service.ICitaService;
import me.project.service.IDiagnosticoService;
import me.project.service.IMedicoService;
import me.project.service.IPacienteService;

@RestController
@RequestMapping("/citas")
public class CitaController {
	
	@Autowired
	private ICitaService service;
	@Autowired 
	private IMedicoService mService;
	@Autowired
	private IPacienteService pService;
	@Autowired
	private IDiagnosticoService dService;
	
	private Converter converter = Converter.getConverter();
	
	
	@PostMapping
	public ResponseEntity<String> create (@RequestBody CitaDTO citaDTO) {
		System.out.println("el medico: " + citaDTO.getMedico() + " el paciente: " + citaDTO.getPaciente());
		Optional<Paciente> paciente = pService.findById(citaDTO.getPaciente());
		Optional<Medico> medico = mService.findById(citaDTO.getMedico());
		if (!medico.isPresent() || !paciente.isPresent())
			return ResponseEntity.status(409).build();
		Cita cita = converter.CDTOtoC(citaDTO, medico.get(), paciente.get()); 
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
	public ResponseEntity<List<CitaDTO>> findByFecha(@RequestBody Date date){	
		List<CitaDTO> out = new ArrayList<CitaDTO>();
		service.findByDate(date).stream()
			.forEach(c -> out.add(converter.CtoCDTO(c)));
		return ResponseEntity.ok(out);
	}
	
	@GetMapping("/diagnostico/{citaId}")
	public ResponseEntity<DiagnosticoDTO> getDiagnosticoByCita(@PathVariable Long citaId){	
		Optional<Cita> opt = service.findById(citaId);
		if (opt.isPresent() && opt.get().getDiagnostico() != null)
			return ResponseEntity.ok(converter.DtoDDTO(opt.get().getDiagnostico()));
		return ResponseEntity.status(409).build();
	}
	
	@PostMapping("/diagnostico/{citaId}")
	public ResponseEntity<String> addDiagnostico(@PathVariable Long citaId, @RequestBody DiagnosticoDTO diagnosticoDTO){
		if (service.addDiagnostico(citaId, converter.DDTOtoD(diagnosticoDTO)))
			return ResponseEntity.ok("Diágnostico guardado correctamente");
		return ResponseEntity.status(409).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.ok("Medico eliminado correctamente");
	}
	
	
}
