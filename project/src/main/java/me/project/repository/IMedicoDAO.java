package me.project.repository;

import me.project.model.entities.Medico;
import me.project.model.entities.Paciente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicoDAO extends JpaRepository<Medico, Long>{

	@Query(value = "SELECT * FROM PACIENTE p\r\n"
			+ "WHERE p.id IN (SELECT paciente FROM MEDICO_PACIENTE \r\n"
			+ "    WHERE medico = ?1)",
			nativeQuery = true)
	public List<Paciente> findPacientes(Long id);
	
	public List<Medico> findByUsuario(String Usuario);
}
