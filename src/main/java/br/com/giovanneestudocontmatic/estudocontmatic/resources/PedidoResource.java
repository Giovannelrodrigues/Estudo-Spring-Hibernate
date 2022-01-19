package br.com.giovanneestudocontmatic.estudocontmatic.resources;

import br.com.giovanneestudocontmatic.estudocontmatic.domain.Pedido;
import br.com.giovanneestudocontmatic.estudocontmatic.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<?> index(){
        List<Pedido> pedidos = pedidoService.find();
        return ResponseEntity.ok().body(pedidos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> show(@PathVariable Integer id) {
        Pedido pedido = pedidoService.findOne(id);
        return ResponseEntity.ok().body(pedido);
    }


}
