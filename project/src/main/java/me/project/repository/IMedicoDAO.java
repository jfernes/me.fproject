package me.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.project.model.entities.Medico;

@Repository
public interface IMedicoDAO extends JpaRepository<Medico, Long>{

}
