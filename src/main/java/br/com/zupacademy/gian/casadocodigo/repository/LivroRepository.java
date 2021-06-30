package br.com.zupacademy.gian.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.gian.casadocodigo.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
