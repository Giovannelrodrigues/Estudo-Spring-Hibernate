package br.com.giovanneestudocontmatic.estudocontmatic.services;

import br.com.giovanneestudocontmatic.estudocontmatic.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

}
