package br.com.zupacademy.gian.casadocodigo.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.gian.casadocodigo.model.Autor;
import br.com.zupacademy.gian.casadocodigo.validator.UniqueValue;

public class NovoAutorRequest {
	
	@NotBlank
	private String nome;	
	
	@Email
	@NotBlank
	@UniqueValue(domainClass = Autor.class, fieldName = "email", message = "Email já cadastrado")
	private String email;	
	
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
