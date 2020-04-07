
package entidades;

import java.util.Date;
import java.util.List;

public class Caixa {

    private Integer codigo;
    private Date dataHoraAbertura;
    private Date dataHoraFechamento;
    private boolean aberto;
    private Usuario usuarioCpf;
    private List<Pagamento> pagamentoList;

    public Caixa() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(Date dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public Date getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(Date dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Usuario getUsuarioCpf() {
        return usuarioCpf;
    }

    public void setUsuarioCpf(Usuario usuarioCpf) {
        this.usuarioCpf = usuarioCpf;
    }

    public List<Pagamento> getPagamentoList() {
        return pagamentoList;
    }

    public void setPagamentoList(List<Pagamento> pagamentoList) {
        this.pagamentoList = pagamentoList;
    }

}
