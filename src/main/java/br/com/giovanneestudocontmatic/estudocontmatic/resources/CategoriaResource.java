package br.com.giovanneestudocontmatic.estudocontmatic.resources;

import br.com.giovanneestudocontmatic.estudocontmatic.domain.Categoria;
import br.com.giovanneestudocontmatic.estudocontmatic.dto.CategoriaDTO;
import br.com.giovanneestudocontmatic.estudocontmatic.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> index(){
        List<Categoria> categorias = categoriaService.find();
        List<CategoriaDTO> categoriaDTOS = categorias.stream().map(CategoriaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(categoriaDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> show(@PathVariable Integer id) {
        Categoria categoria = categoriaService.findOne(id);
        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping
    public ResponseEntity<Void> store(@RequestBody Categoria categoria){
        categoria = categoriaService.create(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoria.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Categoria categoria, @PathVariable Integer id){
        categoria.setId(id);
        categoriaService.update(categoria);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
