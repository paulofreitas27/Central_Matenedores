
package entidades;

import java.util.Date;
import java.util.List;

public class Compromisso {

    private Integer codigo;
    private Date dataGeracao;
    private Date diaVencimento;
    private double valor_parcela;
    private Integer totalNumParcela;
    private boolean quitado;
    private List<Boleto> listaBoletos;
    private Usuario usuario;
    private Projeto projeto;
    private Membro membro;

    public Compromisso() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public Date getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Date diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public double getValor_parcela() {
        return valor_parcela;
    }

    public void setValor_parcela(double valor_parcela) {
        this.valor_parcela = valor_parcela;
    }

    public Integer getTotalNumParcela() {
        return totalNumParcela;
    }

    public void setTotalNumParcela(Integer totalNumParcela) {
        this.totalNumParcela = totalNumParcela;
    }

    public List<Boleto> getListaBoletos() {
        return listaBoletos;
    }

    public void setListaBoletos(List<Boleto> listaBoletos) {
        this.listaBoletos = listaBoletos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public boolean isQuitado() {
        return quitado;
    }

    public void setQuitado(boolean quitado) {
        this.quitado = quitado;
    }

}
