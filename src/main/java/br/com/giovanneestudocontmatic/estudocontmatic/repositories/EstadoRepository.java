package br.com.giovanneestudocontmatic.estudocontmatic.repositories;

import br.com.giovanneestudocontmatic.estudocontmatic.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
