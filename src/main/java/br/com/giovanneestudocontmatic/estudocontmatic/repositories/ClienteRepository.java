package br.com.giovanneestudocontmatic.estudocontmatic.repositories;

import br.com.giovanneestudocontmatic.estudocontmatic.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
