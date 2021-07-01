package br.com.zupacademy.gian.casadocodigo.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gian.casadocodigo.model.ListaLivroIdTituloProjecao;
import br.com.zupacademy.gian.casadocodigo.model.Livro;
import br.com.zupacademy.gian.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.gian.casadocodigo.request.NovoLivroRequest;
import br.com.zupacademy.gian.casadocodigo.response.DetalhesLivroResponse;
import br.com.zupacademy.gian.casadocodigo.response.ListaLivrosIdTituloResponse;
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
		
		Livro livro = request.toModel(manager);
		
		livroRepository.save(livro);
		
		return ResponseEntity.ok(new NovoLivroResponse(livro));
	}
	
	@GetMapping
	public List<ListaLivrosIdTituloResponse> listarLivrosIdTitulo() {
		List<ListaLivroIdTituloProjecao> listaLivrosProjecao = livroRepository.findLivrosIdAndTitulo();		
		
		return ListaLivrosIdTituloResponse.converter(listaLivrosProjecao);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesLivroResponse> detalharLivro(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		
		if (livro.isPresent()) {
			return ResponseEntity.ok(new DetalhesLivroResponse(livro.get()));
		}
			
		return ResponseEntity.notFound().build();
	}
}
