package br.com.zupacademy.gian.casadocodigo.response;

import br.com.zupacademy.gian.casadocodigo.model.Estado;

public class NovoEstadoResponse {

	private Long id;
	private String nome;
	private String nomePais;

	public NovoEstadoResponse(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.nomePais = estado.getPais().getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getNomePais() {
		return nomePais;
	}
}
