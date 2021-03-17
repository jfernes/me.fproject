package me.project.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.project.model.entities.Usuario;
import me.project.repository.IUsuarioDAO;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioDAO dao;
	
	@PostMapping
	public void create (@RequestBody Usuario usuario) {
		dao.save(usuario);
	}
	
	@GetMapping
	public List<Usuario> read (){
		return dao.findAll();
	}

}
