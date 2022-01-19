package br.com.giovanneestudocontmatic.estudocontmatic.domain.enums;

public enum EstadoPagamento {
    PENDENTE(1, "Pendente"), QUITADO(2, "Quitado"), CANCELADO(3, "Cancelado");

    private Integer codigo;

    private String descricao;

    private EstadoPagamento(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao =descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao(){
        return descricao;
    }


    public static EstadoPagamento toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }
        for(EstadoPagamento x: EstadoPagamento.values()){
            if(x.getCodigo().equals(codigo)){
                return x;
            }
        }
        throw new IllegalArgumentException("Codigo do Estado de Pagamento não encontrado!");
    }



}
