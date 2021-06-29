package br.com.zupacademy.gian.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gian.casadocodigo.model.Categoria;
import br.com.zupacademy.gian.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.gian.casadocodigo.request.NovaCategoriaRequest;
import br.com.zupacademy.gian.casadocodigo.response.NovaCategoriaResponse;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<NovaCategoriaResponse> cadastrar(@RequestBody @Valid NovaCategoriaRequest request) {	
		
		Categoria categoria = request.toModel();
		categoriaRepository.save(categoria);
		
		return ResponseEntity.ok(new NovaCategoriaResponse(categoria));
	}
}
