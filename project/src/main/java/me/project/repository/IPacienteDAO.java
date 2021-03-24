package me.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.project.model.entities.Paciente;

@Repository
public interface IPacienteDAO extends JpaRepository<Paciente, Long>{

}
