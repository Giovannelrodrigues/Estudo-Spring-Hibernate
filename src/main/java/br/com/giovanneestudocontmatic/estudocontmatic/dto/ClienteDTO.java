package br.com.giovanneestudocontmatic.estudocontmatic.dto;

import br.com.giovanneestudocontmatic.estudocontmatic.domain.Cliente;
import br.com.giovanneestudocontmatic.estudocontmatic.domain.enums.TipoCliente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "O nome do cliente não pode ser vazio")
    @Length(min = 3, max = 100, message = "O nome do cliente deve conter entre 3 e 100 caracteres")
    private String nome;

    @NotEmpty(message = "O email do cliente não pode ser vazio")
    @Length(min = 3, max = 100, message = "O nome do cliente deve conter entre 3 e 100 caracteres")
    @Email
    private String email;

    private String cpfCnpj;

    private Integer tipo;


    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.cpfCnpj = cliente.getCpfCnpj();
        this.tipo = cliente.getTipo() == null? null: cliente.getTipo().getCodigo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoCliente getTipo() {
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCodigo();
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
}
