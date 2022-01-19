package br.com.giovanneestudocontmatic.estudocontmatic.repositories;

import br.com.giovanneestudocontmatic.estudocontmatic.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
