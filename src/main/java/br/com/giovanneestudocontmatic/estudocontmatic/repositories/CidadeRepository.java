package br.com.giovanneestudocontmatic.estudocontmatic.repositories;

import br.com.giovanneestudocontmatic.estudocontmatic.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
