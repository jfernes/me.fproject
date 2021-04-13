package me.project.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.project.dto.UsuarioDTO;
import me.project.model.entities.Usuario;
import me.project.rest.converter.Converter;
import me.project.service.IUsuarioService;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	private Converter converter = Converter.getConverter(); 
	
	
	
	@PostMapping
	public ResponseEntity<String> create (@RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuario = converter.UDTOtoU(usuarioDTO);
		if (service.save(usuario)) {
			return ResponseEntity.ok("Usuario creado correctamente");
		}
		return ResponseEntity.ok("Usuario ya existe");
			
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>>  read(){
		List<UsuarioDTO> out = new ArrayList<UsuarioDTO>();
		service.findAll().stream()
			.forEach(u -> out.add(converter.UtoUDTO(u)));
		return ResponseEntity.ok(out);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id){
		Optional<Usuario> opt = service.findById(id);
		if (opt.isPresent()) {
			return ResponseEntity.ok(converter.UtoUDTO(opt.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.ok("Usuario eliminado correctamente");
	}
	
	
	
	

}
