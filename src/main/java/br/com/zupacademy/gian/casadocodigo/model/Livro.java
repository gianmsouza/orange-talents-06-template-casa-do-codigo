package br.com.zupacademy.gian.casadocodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(unique = true)
	private String titulo;

	@NotNull
	@Size(max = 500)
	private String resumo;

	private String sumario;

	@NotNull
	@Min(value = 20)
	private BigDecimal preco;

	@NotNull
	@Min(value = 100)
	private Integer numeroPaginas;

	@NotNull
	private String isbn;

	private LocalDate dataPublicacao;

	@NotNull
	@ManyToOne
	private Categoria categoria;

	@NotNull
	@ManyToOne
	private Autor autor;
	
	@Deprecated
	public Livro() {		
	}

	public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas, String isbn,
			LocalDate dataPublicacao, Categoria categoria, Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}
}
