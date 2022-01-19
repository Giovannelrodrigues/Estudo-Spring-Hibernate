package br.com.giovanneestudocontmatic.estudocontmatic.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
public class ItemPedidoPK implements Serializable {
    private Pedido pedido;
    private Produto produto;
}