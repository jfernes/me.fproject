package me.project.rest.converter;

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

public interface IConverter {
	public Usuario UDTOtoU(UsuarioDTO usuarioDTO);
	
	public UsuarioDTO UtoUDTO(Usuario usuario);
	
	public Paciente PDTOtoP(PacienteDTO pacienteDTO);
	
	public PacienteDTO PtoPDTO(Paciente paciente);
	
	public Medico MDTOtoM(MedicoDTO medicoDTO);
	
	public MedicoDTO MtoMDTO(Medico medico);
	
	public Cita CDTOtoC(CitaDTO citaDTO, Medico medico, Paciente paciente);
	
	public CitaDTO CtoCDTO(Cita cita);
	
	public Diagnostico DDTOtoD (DiagnosticoDTO diagnosticoDTO);
	
	public DiagnosticoDTO DtoDDTO(Diagnostico diagnostico);
}
