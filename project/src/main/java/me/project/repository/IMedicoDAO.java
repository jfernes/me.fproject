package me.project.repository;

import me.project.model.entities.Medico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicoDAO extends JpaRepository<Medico, Long>{

}
