package br.com.giovanneestudocontmatic.estudocontmatic.services;

import br.com.giovanneestudocontmatic.estudocontmatic.domain.Categoria;
import br.com.giovanneestudocontmatic.estudocontmatic.dto.CategoriaDTO;
import br.com.giovanneestudocontmatic.estudocontmatic.repositories.CategoriaRepository;
import br.com.giovanneestudocontmatic.estudocontmatic.services.exceptions.DataIntegrityException;
import br.com.giovanneestudocontmatic.estudocontmatic.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> find(){
        return categoriaRepository.findAll();
    }

    public Categoria findOne(Integer id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException("Id: " + id +" not found!"));
    }

    public Categoria create(Categoria categoria){
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    public void update(Categoria categoria){
        findOne(categoria.getId());
        categoriaRepository.save(categoria);
    }

    public void delete(Integer id){
        findOne(id);
        try{
            categoriaRepository.deleteById(id);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir categorias com produtos");
        }
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return categoriaRepository.findAll(pageRequest);
    }


    public Categoria fromDTO(CategoriaDTO categoriaDTO){
        return  new Categoria(categoriaDTO.getId(), categoriaDTO.getNome());
    }


}
