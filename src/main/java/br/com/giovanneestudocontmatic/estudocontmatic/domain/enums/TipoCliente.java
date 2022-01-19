package br.com.giovanneestudocontmatic.estudocontmatic.domain.enums;

public enum TipoCliente {

    PESSOAFISICA(0, "Pessoa Física"),
    PESSOAJURIDICA(1, "Pessoa Jurídica");

    private int codigo;
    private String descricao;

    private TipoCliente(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static TipoCliente toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }
        for (TipoCliente x : TipoCliente.values()){
            if(codigo.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido"+ codigo);
    }


}
