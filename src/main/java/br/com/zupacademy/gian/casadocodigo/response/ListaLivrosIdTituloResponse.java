package br.com.zupacademy.gian.casadocodigo.response;

import java.util.ArrayList;
import java.util.List;
import br.com.zupacademy.gian.casadocodigo.model.ListaLivroIdTituloProjecao;

public class ListaLivrosIdTituloResponse {
	
	private Long id;
	private String titulo;	

	public ListaLivrosIdTituloResponse(Long id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}

	public static List<ListaLivrosIdTituloResponse> converter(List<ListaLivroIdTituloProjecao> listaLivrosProjecao) {
	
		List<ListaLivrosIdTituloResponse> lista = new ArrayList<>();
		
		for (ListaLivroIdTituloProjecao projecao : listaLivrosProjecao) {
			ListaLivrosIdTituloResponse livro = new ListaLivrosIdTituloResponse(projecao.getId(), projecao.getTitulo());
			lista.add(livro);
		}	 
		
		return lista;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
}
	
