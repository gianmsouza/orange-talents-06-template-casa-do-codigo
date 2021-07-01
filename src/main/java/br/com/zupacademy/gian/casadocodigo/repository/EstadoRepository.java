package br.com.zupacademy.gian.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.gian.casadocodigo.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	Optional<Estado> findByNomeAndPaisId(String nomeEstado, Long idPais);

}
