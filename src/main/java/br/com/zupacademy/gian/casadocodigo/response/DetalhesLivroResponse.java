package br.com.zupacademy.gian.casadocodigo.response;

import java.math.BigDecimal;
import br.com.zupacademy.gian.casadocodigo.model.Livro;

public class DetalhesLivroResponse {

	private String titulo;	
	private String resumo;
	private BigDecimal preco;
	private String sumario;
	private String nomeAutor;
	private String descricaoAutor;
	private Integer numeroPaginas;
	private String isbn;	

	public DetalhesLivroResponse(Livro livro) {		
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.nomeAutor = livro.getAutor().getNome();
		this.descricaoAutor = livro.getAutor().getDescricao();		
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getSumario() {
		return sumario;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getDescricaoAutor() {
		return descricaoAutor;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}	
}
