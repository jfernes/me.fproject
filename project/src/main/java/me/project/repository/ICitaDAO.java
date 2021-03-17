package me.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.project.model.entities.Cita;

@Repository
public interface ICitaDAO extends JpaRepository<Cita, Long>{

}
