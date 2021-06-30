package br.com.zupacademy.gian.casadocodigo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.zupacademy.gian.casadocodigo.model.Livro;
import br.com.zupacademy.gian.casadocodigo.model.ListaLivroIdTituloProjecao;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
	
	@Query(value = "select l.id, l.titulo from livro l", nativeQuery = true)
	List<ListaLivroIdTituloProjecao> findLivrosIdAndTitulo();
}
