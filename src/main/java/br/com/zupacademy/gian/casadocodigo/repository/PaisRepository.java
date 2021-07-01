package br.com.zupacademy.gian.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.zupacademy.gian.casadocodigo.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

}
