package br.com.giovanneestudocontmatic.estudocontmatic.services;

import br.com.giovanneestudocontmatic.estudocontmatic.domain.Cidade;
import br.com.giovanneestudocontmatic.estudocontmatic.domain.Cliente;
import br.com.giovanneestudocontmatic.estudocontmatic.domain.Endereco;
import br.com.giovanneestudocontmatic.estudocontmatic.dto.ClienteDTO;
import br.com.giovanneestudocontmatic.estudocontmatic.dto.ClienteNewDTO;
import br.com.giovanneestudocontmatic.estudocontmatic.repositories.ClienteRepository;
import br.com.giovanneestudocontmatic.estudocontmatic.repositories.EnderecoRepository;
import br.com.giovanneestudocontmatic.estudocontmatic.services.exceptions.DataIntegrityException;
import br.com.giovanneestudocontmatic.estudocontmatic.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Cliente> find(){
        return clienteRepository.findAll();
    }

    public Cliente findOne(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException("Id: " + id +" not found!"));
    }

    @Transactional
    public Cliente create(Cliente cliente){
        cliente.setId(null);
        cliente = clienteRepository.save(cliente);
        enderecoRepository.saveAll(cliente.getEnderecos());
        return cliente;
    }

    public void update(Cliente cliente){
        Cliente newCliente = findOne(cliente.getId());
        updateData(newCliente, cliente);
        clienteRepository.save(newCliente);
    }

    public void delete(Integer id){
        findOne(id);
        try{
            clienteRepository.deleteById(id);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir clientes com produtos");
        }
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return clienteRepository.findAll(pageRequest);
    }


    public Cliente fromDTO(ClienteDTO clienteDTO){
        return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail(), clienteDTO.getCpfCnpj(), clienteDTO.getTipo());
    }

    public Cliente fromDTO(ClienteNewDTO clienteDTO){
        Cliente cliente = new Cliente(null, clienteDTO.getNome(), clienteDTO.getEmail(), clienteDTO.getCpfCnpj(), clienteDTO.getTipo());
        Cidade cidade = new Cidade(clienteDTO.getCidadeId(), null, null);
        Endereco endereco = new Endereco(null, clienteDTO.getLogradouro(), clienteDTO.getNumero(), clienteDTO.getComplemento(), clienteDTO.getBairro(), clienteDTO.getCep(), cliente, cidade);
        cliente.getEnderecos().add(endereco);
        cliente.getTelefone().add(clienteDTO.getTelefone1());
        if(clienteDTO.getTelefone2() != null ){
            cliente.getTelefone().add(clienteDTO.getTelefone2());
        }
        if(clienteDTO.getTelefone3() != null ){
            cliente.getTelefone().add(clienteDTO.getTelefone3());
        }
        return cliente;
    }

    private void updateData(Cliente newCliente, Cliente cliente) {
        newCliente.setNome(cliente.getNome());
        newCliente.setEmail(cliente.getEmail());
    }
}
