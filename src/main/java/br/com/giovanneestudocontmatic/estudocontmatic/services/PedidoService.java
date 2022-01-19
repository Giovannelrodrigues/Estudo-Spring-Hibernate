package br.com.giovanneestudocontmatic.estudocontmatic.services;

import br.com.giovanneestudocontmatic.estudocontmatic.domain.Categoria;
import br.com.giovanneestudocontmatic.estudocontmatic.domain.Pedido;
import br.com.giovanneestudocontmatic.estudocontmatic.repositories.CategoriaRepository;
import br.com.giovanneestudocontmatic.estudocontmatic.repositories.PedidoRepository;
import br.com.giovanneestudocontmatic.estudocontmatic.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> find(){
        return pedidoRepository.findAll();
    }

    public Pedido findOne(Integer id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElseThrow(() -> new ObjectNotFoundException("Id: " + id +" not found!"));
    }

}
