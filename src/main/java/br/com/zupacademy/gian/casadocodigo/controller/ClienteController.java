package br.com.zupacademy.gian.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gian.casadocodigo.model.Cliente;
import br.com.zupacademy.gian.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.gian.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gian.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.gian.casadocodigo.request.NovoClienteRequest;
import br.com.zupacademy.gian.casadocodigo.response.NovoClienteResponse;
import br.com.zupacademy.gian.casadocodigo.validator.ErroDeFormularioDto;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoClienteRequest request) {
		
		Cliente cliente = request.toModel(paisRepository, estadoRepository);
		
		if (request.isPrecisaEstado()) {
			return ResponseEntity.badRequest().body(
					new ErroDeFormularioDto("idEstado", "Para este país é ncessário informar o estado"));
		}
		
		if (!request.isEstadoPertenceAoPais()) {
			return ResponseEntity.badRequest().body(
					new ErroDeFormularioDto("idEstado", "Estado não pertence ao país"));
		}
		
		clienteRepository.save(cliente);
		
		return ResponseEntity.ok(new NovoClienteResponse(cliente));
	}
}
