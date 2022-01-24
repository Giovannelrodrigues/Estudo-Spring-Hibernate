package br.com.giovanneestudocontmatic.estudocontmatic.resources;

import br.com.giovanneestudocontmatic.estudocontmatic.domain.Categoria;
import br.com.giovanneestudocontmatic.estudocontmatic.domain.Cliente;
import br.com.giovanneestudocontmatic.estudocontmatic.dto.ClienteDTO;
import br.com.giovanneestudocontmatic.estudocontmatic.dto.ClienteNewDTO;
import br.com.giovanneestudocontmatic.estudocontmatic.services.CategoriaService;
import br.com.giovanneestudocontmatic.estudocontmatic.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Void> store(@Valid @RequestBody ClienteNewDTO clienteDTO) {
        Cliente cliente = clienteService.fromDTO(clienteDTO);
        cliente = clienteService.create(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cliente.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable Integer id) {
        Cliente cliente = clienteService.fromDTO(clienteDTO);
        cliente.setId(id);
        clienteService.update(cliente);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
