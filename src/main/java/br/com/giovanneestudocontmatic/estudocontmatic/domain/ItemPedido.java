package br.com.giovanneestudocontmatic.estudocontmatic.domain;

import javax.persistence.*;

@Entity
@IdClass(ItemPedidoPK.class)
public class ItemPedido {
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @Id
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    @Id
    private Produto produto;
    private double desconto;
    private int quantidade;
    private double preco;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto ,double desconto, int quantidade, double preco) {
        this.produto = produto;
        this.pedido= pedido ;
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemPedido that = (ItemPedido) o;

        if (getPedido() != null ? !getPedido().equals(that.getPedido()) : that.getPedido() != null) return false;
        return getProduto() != null ? getProduto().equals(that.getProduto()) : that.getProduto() == null;
    }

    @Override
    public int hashCode() {
        int result = getPedido() != null ? getPedido().hashCode() : 0;
        result = 31 * result + (getProduto() != null ? getProduto().hashCode() : 0);
        return result;
    }
}
