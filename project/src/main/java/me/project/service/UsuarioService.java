package me.project.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.project.model.entities.Usuario;
import me.project.repository.IUsuarioDAO;

@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	IUsuarioDAO dao;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional
	public Boolean save(Usuario usuario) {
		if (dao.findById(usuario.getId()).isPresent()) {
			return false;
		}
		dao.save(usuario);
		return true;
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		dao.deleteById(id);
	}
	
	

}
