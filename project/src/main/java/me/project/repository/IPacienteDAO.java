package me.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import me.project.model.entities.Medico;
import me.project.model.entities.Paciente;

@Repository
public interface IPacienteDAO extends JpaRepository<Paciente, Long>{
	
	@Query(value = "SELECT * FROM PACIENTE p\r\n"
			+ "WHERE p.id IN (SELECT paciente FROM MEDICO_PACIENTE \r\n"
			+ "    WHERE medico = ?1)",
			nativeQuery = true)
	public List<Medico> findMedicos(Long id);
	
	public List<Paciente> findByUsuario(String Usuario);

}
