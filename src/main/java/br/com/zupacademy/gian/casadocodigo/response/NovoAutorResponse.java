package br.com.zupacademy.gian.casadocodigo.response;

import java.time.LocalDateTime;

import br.com.zupacademy.gian.casadocodigo.model.Autor;

public class NovoAutorResponse {

	private Long id;
	private String nome;
	private String descricao;
	private LocalDateTime dataCriacao;

	public NovoAutorResponse(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
		this.dataCriacao = autor.getDataCriacao();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
}
