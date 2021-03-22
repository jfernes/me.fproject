package me.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import me.project.model.entities.Medico;

import me.project.model.entities.Paciente;

@Repository
public interface IPacienteDAO extends JpaRepository<Paciente, Long>{
	
	@Query(value = 
			"SELECT U.id, nombre, apellidos, U.usuario, clave, nss, num_tarjeta, telefono, direccion FROM USUARIO U,(SELECT * FROM  PACIENTE, (SELECT paciente FROM MEDICO_PACIENTE\r\n"
			+ "                                    WHERE medico=%?1%)\r\n"
			+ "                        WHERE id = paciente) P\r\n"
			+ "WHERE U.id = P.id;",
			nativeQuery = true)
	public List<Medico> findMedicos(Long id);

}
