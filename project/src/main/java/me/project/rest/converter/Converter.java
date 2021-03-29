package me.project.rest.converter;

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
	
	public Cita CDTOtoC(CitaDTO citaDTO) {
		return mapper.map(citaDTO, Cita.class);
	}
	
	public CitaDTO CtoCDTO(Cita cita) {
		return mapper.map(cita, CitaDTO.class);
	}
	
	public Diagnostico DDTOtoD (DiagnosticoDTO diagnosticoDTO) {
		return mapper.map(diagnosticoDTO, Diagnostico.class);
	}
	
	public DiagnosticoDTO DtoDDTO(Diagnostico diagnostico) {
		return mapper.map(diagnostico, DiagnosticoDTO.class);
	}
	
	
	
	

}
