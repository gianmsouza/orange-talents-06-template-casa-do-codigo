package br.com.zupacademy.gian.casadocodigo.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.gian.casadocodigo.model.Autor;
import br.com.zupacademy.gian.casadocodigo.model.Categoria;
import br.com.zupacademy.gian.casadocodigo.model.Livro;
import br.com.zupacademy.gian.casadocodigo.validator.ExistsId;
import br.com.zupacademy.gian.casadocodigo.validator.UniqueValue;

public class NovoLivroRequest {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Título já cadastrado")
	private String titulo;

	@NotBlank
	private String resumo;

	private String sumario;

	@NotNull
	@Min(value = 20)
	private BigDecimal preco;
	
	@NotNull
	@Min(value = 100)
	private Integer numeroPaginas;

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "Isbn já cadastrado")
	private String isbn;
	
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;

	@NotNull
	@ExistsId(domainClass = Categoria.class, fieldName = "idCategoria", message = "Categoria não encontrada")
	private Long idCategoria;

	@NotNull
	@ExistsId(domainClass = Autor.class, fieldName = "idAutor", message = "Autor não encontrado")
	private Long idAutor;

	public Livro toModel(EntityManager manager) {
		Autor autor = manager.find(Autor.class, idAutor);
		Categoria categoria = manager.find(Categoria.class, idCategoria);
		
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
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

	public Long getIdAutor() {
		return idAutor;
	}
	
	public Long getIdCategoria() {
		return idCategoria;
	}
}
