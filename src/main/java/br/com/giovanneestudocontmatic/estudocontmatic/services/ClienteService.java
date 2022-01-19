package br.com.giovanneestudocontmatic.estudocontmatic.services;

import br.com.giovanneestudocontmatic.estudocontmatic.domain.Categoria;
import br.com.giovanneestudocontmatic.estudocontmatic.domain.Cliente;
import br.com.giovanneestudocontmatic.estudocontmatic.repositories.ClienteRepository;
import br.com.giovanneestudocontmatic.estudocontmatic.repositories.EnderecoRepository;
import br.com.giovanneestudocontmatic.estudocontmatic.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> find(){
        return clienteRepository.findAll();
    }

    public Cliente findOne(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException("Id: " + id +" not found!"));
    }
}
