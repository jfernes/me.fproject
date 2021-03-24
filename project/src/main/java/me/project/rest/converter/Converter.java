package me.project.rest.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	private ModelMapper mapper;
	
	public Converter() {
		mapper = new ModelMapper();
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
		return mapper.map(paciente, PacienteDTO.class);
	}
	
	public Medico MDTOtoM(MedicoDTO medicoDTO) {
		return mapper.map(medicoDTO, Medico.class);
	}
	
	public MedicoDTO MtoMDTO(Medico medico) {
		return mapper.map(medico, MedicoDTO.class);
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
