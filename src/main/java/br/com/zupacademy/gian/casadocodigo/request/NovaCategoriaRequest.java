package br.com.zupacademy.gian.casadocodigo.request;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.gian.casadocodigo.model.Categoria;
import br.com.zupacademy.gian.casadocodigo.validator.UniqueValue;

public class NovaCategoriaRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Categoria já cadastrada")
	private String nome;
	
	@Deprecated
	public NovaCategoriaRequest() {		
	}
	
	public NovaCategoriaRequest(String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}

	public String getNome() {
		return nome;
	}
}
