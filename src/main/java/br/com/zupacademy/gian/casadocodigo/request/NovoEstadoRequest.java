package br.com.zupacademy.gian.casadocodigo.request;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gian.casadocodigo.model.Estado;
import br.com.zupacademy.gian.casadocodigo.model.Pais;
import br.com.zupacademy.gian.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.gian.casadocodigo.validator.ExistsId;

public class NovoEstadoRequest {
	
	@NotBlank
	private String nome;
	
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "idPais", message = "País não encontrado")
	private Long idPais;
	
	@Deprecated
	public NovoEstadoRequest() {
	}

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Estado toModel(PaisRepository paisRepository) {
		Optional<Pais> pais = paisRepository.findById(idPais);
		
		return new Estado(this.nome, pais.get());		
	}
}
