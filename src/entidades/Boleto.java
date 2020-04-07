package entidades;

import java.util.Date;
import java.util.List;


public class Boleto {

    private Integer codigo;
    private int numeroParcela;
    private Date dataVencimento;
    private double valor;
    private boolean quitado;
    private List<Pagamento> listaPagamento;
    private Compromisso compromisso;

    public Boleto() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(int numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isQuitado() {
        return quitado;
    }

    public void setQuitado(boolean quitado) {
        this.quitado = quitado;
    }

    public List<Pagamento> getListaPagamento() {
        return listaPagamento;
    }

    public void setListaPagamento(List<Pagamento> listaPagamento) {
        this.listaPagamento = listaPagamento;
    }

    public Compromisso getCompromisso() {
        return compromisso;
    }

    public void setCompromisso(Compromisso compromisso) {
        this.compromisso = compromisso;
    }

}
