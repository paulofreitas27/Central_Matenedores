
package entidades;

import java.util.List;

public class FormaPagamento {

    private Integer codigo;
    private String nome;
    private List<Pagamento> listaPagamentos;

    public FormaPagamento() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pagamento> getListaPagamentos() {
        return listaPagamentos;
    }

    public void setListaPagamentos(List<Pagamento> listaPagamentos) {
        this.listaPagamentos = listaPagamentos;
    }

    @Override
    public String toString() {
        return getNome();
    }

}
