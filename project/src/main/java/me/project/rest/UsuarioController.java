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
import me.project.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	IUsuarioService service;
	
	@PostMapping
	public Usuario create (@RequestBody Usuario usuario) {
		return service.save(usuario);
	}
	
	@GetMapping
	public List<Usuario> read(){
		return service.findAll();
	}
	
	

}
