package me.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.project.model.entities.Usuario;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{

}
