package br.com.zupacademy.gian.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gian.casadocodigo.model.Pais;
import br.com.zupacademy.gian.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.gian.casadocodigo.request.NovoPaisRequest;
import br.com.zupacademy.gian.casadocodigo.response.NovoPaisResponse;

@RestController
@RequestMapping("/paises")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<NovoPaisResponse> cadastrar(@RequestBody @Valid NovoPaisRequest request) {
		
		Pais pais = request.toModel();		
		paisRepository.save(pais);
		
		return ResponseEntity.ok(new NovoPaisResponse(pais));
	}
}
