package me.project.service;

import java.util.List;
import java.util.Optional;

import me.project.model.entities.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Optional<Usuario> findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void deleteById(Long id);

}
