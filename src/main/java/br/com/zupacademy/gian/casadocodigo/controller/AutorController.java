package br.com.zupacademy.gian.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gian.casadocodigo.config.ProibeEmailDuplicadoAutorValidator;
import br.com.zupacademy.gian.casadocodigo.model.Autor;
import br.com.zupacademy.gian.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.gian.casadocodigo.request.NovoAutorRequest;
import br.com.zupacademy.gian.casadocodigo.response.NovoAutorResponse;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<NovoAutorResponse> cadastrar(@RequestBody @Valid NovoAutorRequest request) {		
		Autor autor = request.toModel();		
		autorRepository.save(autor);
		
		return ResponseEntity.ok(new NovoAutorResponse(autor));
	}
}
