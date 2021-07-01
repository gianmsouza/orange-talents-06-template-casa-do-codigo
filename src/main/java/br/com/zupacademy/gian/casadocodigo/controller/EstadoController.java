package br.com.zupacademy.gian.casadocodigo.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gian.casadocodigo.model.Estado;
import br.com.zupacademy.gian.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gian.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.gian.casadocodigo.request.NovoEstadoRequest;
import br.com.zupacademy.gian.casadocodigo.response.NovoEstadoResponse;
import br.com.zupacademy.gian.casadocodigo.validator.ErroDeFormularioDto;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoEstadoRequest request) throws MethodArgumentNotValidException {
		
		Estado estado = request.toModel(paisRepository);
		
		Optional<Estado> estadoDuplicado = estadoRepository.findByNomeAndPaisId(estado.getNome(), request.getIdPais());
		
		if (estadoDuplicado.isPresent()) {			
			return ResponseEntity.badRequest().body(new ErroDeFormularioDto("nome", "Nome já existe"));
		}		
		
		estadoRepository.save(estado);
		
		return ResponseEntity.ok(new NovoEstadoResponse(estado));		
	}
}
