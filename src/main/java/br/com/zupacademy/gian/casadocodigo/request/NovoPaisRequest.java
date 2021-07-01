package br.com.zupacademy.gian.casadocodigo.request;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.gian.casadocodigo.model.Pais;
import br.com.zupacademy.gian.casadocodigo.validator.UniqueValue;

public class NovoPaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "País já cadastrado")
	private String nome;
	
	@Deprecated
	public NovoPaisRequest() {
	}
	
	public NovoPaisRequest(String nome) {
		this.nome = nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}

	public String getNome() {
		return nome;
	}
}
