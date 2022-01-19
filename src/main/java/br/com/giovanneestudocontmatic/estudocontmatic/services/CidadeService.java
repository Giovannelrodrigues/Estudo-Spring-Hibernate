package br.com.giovanneestudocontmatic.estudocontmatic.services;

import br.com.giovanneestudocontmatic.estudocontmatic.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

}
