package br.com.zupacademy.gian.casadocodigo.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.gian.casadocodigo.model.Autor;

public class NovoAutorRequest {

	@NotNull
	@NotEmpty
	@NotBlank
	private String nome;

	@NotNull
	@NotEmpty
	@Email
	@NotBlank
	private String email;

	@NotNull
	@NotEmpty
	@Size(max = 400)
	@NotBlank
	private String descricao;

	public NovoAutorRequest(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}
	
	public String getEmail() {
		return email;
	}
}
