
package entidades;

import java.util.List;

public class Membro {

    private Integer codigo;
    private String nome;
    private String fone;
    private List<Compromisso> listaCompromisso;

    public Membro() {
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

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public List<Compromisso> getListaCompromisso() {
        return listaCompromisso;
    }

    public void setListaCompromisso(List<Compromisso> listaCompromisso) {
        this.listaCompromisso = listaCompromisso;
    }

}
