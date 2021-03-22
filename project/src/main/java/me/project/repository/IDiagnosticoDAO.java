package me.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.project.model.entities.Diagnostico;

@Repository
public interface IDiagnosticoDAO extends JpaRepository<Diagnostico, Long>{
	
}
