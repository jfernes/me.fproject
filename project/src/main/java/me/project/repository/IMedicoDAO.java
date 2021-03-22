package me.project.repository;

import me.project.model.entities.Medico;
import me.project.model.entities.Paciente;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface IMedicoDAO extends JpaRepository<Medico, Long>{
	
	@Query(value = 
			"SELECT U.id, nombre, apellidos, U.usuario, clave, num_colegiado FROM USUARIO U, (SELECT * FROM  MEDICO, (SELECT medico FROM MEDICO_PACIENTE\r\n"
			+ "                                    WHERE paciente=%?1%)\r\n"
			+ "                        WHERE id = medico) M\r\n"
			+ "WHERE U.id = M.id;",
		nativeQuery = true)
	public List<Paciente> findPacientes(Long id);
}
