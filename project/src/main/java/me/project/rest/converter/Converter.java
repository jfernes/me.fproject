package me.project.rest.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import me.project.dto.CitaDTO;
import me.project.dto.DiagnosticoDTO;
import me.project.dto.MedicoDTO;
import me.project.dto.PacienteDTO;
import me.project.dto.UsuarioDTO;
import me.project.model.entities.Cita;
import me.project.model.entities.Diagnostico;
import me.project.model.entities.Medico;
import me.project.model.entities.Paciente;
import me.project.model.entities.Usuario;

@Component
public class Converter {
	
	private static Converter converter;
	
	private ModelMapper mapper;
	
	private Converter() {
		mapper = new ModelMapper();
	}
	
	public static Converter getConverter() {
		if (converter == null)
			converter = new Converter();
		return converter;
	}
	
	public Usuario UDTOtoU(UsuarioDTO usuarioDTO) {
		Usuario usuario = mapper.map(usuarioDTO, Usuario.class);
		return usuario;
	}
	
	public UsuarioDTO UtoUDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = mapper.map(usuario, UsuarioDTO.class);
		return usuarioDTO; 
	}
	
	public Paciente PDTOtoP(PacienteDTO pacienteDTO) {
		return mapper.map(pacienteDTO, Paciente.class);
	}
	
	public PacienteDTO PtoPDTO(Paciente paciente) {
		//no mapeo los medicos para hacerlo yo a mano
		PacienteDTO dto = mapper.typeMap(Paciente.class, PacienteDTO.class)
				.addMappings(mappr -> mappr.skip(PacienteDTO::setMedicos))
				.map(paciente);
		// mapeo los medicos
		dto.setMedicos(paciente.getMedicos().stream()
				.map(m -> m.getId())
				.collect(Collectors.toList()));
		return dto;		
	}
	
	public Medico MDTOtoM(MedicoDTO medicoDTO) {
		return mapper.map(medicoDTO, Medico.class);
	}
	
	public MedicoDTO MtoMDTO(Medico medico) {
		
		MedicoDTO dto = mapper.typeMap(Medico.class, MedicoDTO.class)
				.addMappings(mappr -> mappr.skip(MedicoDTO::setPacientes))
				.map(medico);
		//mapeo los pacientes
		dto.setPacientes(medico.getPacientes().stream()
				.map(p -> p.getId())
				.collect(Collectors.toList()));
		return dto;
	}
	
	public Cita CDTOtoC(CitaDTO citaDTO, Medico medico, Paciente paciente) {
		Cita cita = mapper.typeMap(CitaDTO.class, Cita.class)
				.addMappings(mappr -> mappr.skip(Cita::setFechaHora))
				.addMappings(mappr -> mappr.skip(Cita::setMedico))
				.addMappings(mappr -> mappr.skip(Cita::setPaciente))
				.map(citaDTO);
		try {
			cita.setFechaHora(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(citaDTO.getFechaHora()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cita.setMedico(medico);
		cita.setPaciente(paciente);
		return cita;
	}
	
	public CitaDTO CtoCDTO(Cita cita) {
		CitaDTO dto = mapper.typeMap(Cita.class, CitaDTO.class)
				.addMappings(mappr -> mappr.skip(CitaDTO::setMedico))
				.addMappings(mappr -> mappr.skip(CitaDTO::setPaciente))
				.addMappings(mappr -> mappr.skip(CitaDTO::setDiagnostico))
				.addMappings(mappr -> mappr.skip(CitaDTO::setFechaHora))
				.map(cita);
		//dto.setDiagnostico(cita.getDiagnostico().getId());
		dto.setMedico(cita.getMedico().getId());
		dto.setPaciente(cita.getPaciente().getId());
		dto.setFechaHora(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cita.getFechaHora()));
		return dto;
	}
	
	public Diagnostico DDTOtoD (DiagnosticoDTO diagnosticoDTO) {
		return mapper.map(diagnosticoDTO, Diagnostico.class);
	}
	
	public DiagnosticoDTO DtoDDTO(Diagnostico diagnostico) {
		return mapper.map(diagnostico, DiagnosticoDTO.class);
	}
	
	
	
	

}
