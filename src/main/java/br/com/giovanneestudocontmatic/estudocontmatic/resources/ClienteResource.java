package br.com.giovanneestudocontmatic.estudocontmatic.resources;

import br.com.giovanneestudocontmatic.estudocontmatic.domain.Categoria;
import br.com.giovanneestudocontmatic.estudocontmatic.domain.Cliente;
import br.com.giovanneestudocontmatic.estudocontmatic.services.CategoriaService;
import br.com.giovanneestudocontmatic.estudocontmatic.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<?> index(){
        List<Cliente> clientes = clienteService.find();
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> show(@PathVariable Integer id) {
        Cliente cliente = clienteService.findOne(id);
        return ResponseEntity.ok().body(cliente);
    }


}
