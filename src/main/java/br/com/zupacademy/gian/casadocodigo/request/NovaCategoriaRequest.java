package br.com.zupacademy.gian.casadocodigo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gian.casadocodigo.model.Categoria;

public class NovaCategoriaRequest {

	@NotNull
	@NotEmpty
	@NotBlank
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
