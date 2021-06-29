package br.com.zupacademy.gian.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.gian.casadocodigo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Optional<Categoria> findByNome(String nome);
}
