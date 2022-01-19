package br.com.giovanneestudocontmatic.estudocontmatic.repositories;

import br.com.giovanneestudocontmatic.estudocontmatic.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
