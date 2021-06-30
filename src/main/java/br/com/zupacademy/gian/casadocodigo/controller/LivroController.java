package br.com.zupacademy.gian.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gian.casadocodigo.model.Livro;
import br.com.zupacademy.gian.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.gian.casadocodigo.request.NovoLivroRequest;
import br.com.zupacademy.gian.casadocodigo.response.NovoLivroResponse;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<NovoLivroResponse> cadastrar(@RequestBody @Valid NovoLivroRequest request) {	
		
		System.out.println(request.getTitulo());
		
		Livro livro = request.toModel(manager);
		
		livroRepository.save(livro);
		
		return ResponseEntity.ok(new NovoLivroResponse(livro));
	}

}
