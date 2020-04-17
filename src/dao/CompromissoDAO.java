package dao;

import entidades.Compromisso;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.FabricaConexao;

public class CompromissoDAO {

    private final ProjetoDAO projDao;

    public CompromissoDAO() {
        this.projDao = new ProjetoDAO();
    }

    public void salvar(Compromisso comp) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;
        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "INSERT INTO compromisso (data_geracao, dia_vencimento, "
                + "valor_parcela, total_num_parcela, usuario_cpf, projeto_codigo, "
                + "membro_codigo, quitado ) VALUES(now(), ?, ?, ?, ?, ?, ?, false)";

        st = con.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        st.setDate(1, new Date(comp.getDiaVencimento().getTime()));
        st.setDouble(2, comp.getValor_parcela());
        st.setInt(3, comp.getTotalNumParcela());
        st.setString(4, comp.getUsuario().getCpf());
        st.setInt(5, comp.getProjeto().getCodigo());
        st.setInt(6, comp.getMembro().getCodigo());

        st.execute();

        rs = st.getGeneratedKeys();

        if (rs.next()) {
            comp.setCodigo(rs.getInt(1));
        }

        st.close();

    }

    public void alterar(Compromisso comp) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "update compromisso set dia_vencimento = ?, valor_parcela = ?, usuario_cpf = ? where codigo = ? ";

        st = con.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        st.setDate(1, new Date(comp.getDiaVencimento().getTime()));
        st.setDouble(2, comp.getValor_parcela());
        st.setString(3, comp.getUsuario().getCpf());
        st.setInt(4, comp.getCodigo());

        st.execute();

        st.close();

    }

    public void comfirmarPagamento(Compromisso compSelecionado) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "UPDATE compromisso SET quitado = true where codigo = ?";

        st = con.getConexao().prepareStatement(sql);

        st.setInt(1, compSelecionado.getCodigo());

        st.execute();

        st.close();
    }

    public List<Compromisso> listarTodosCPF(String cpf) throws SQLException {

        FabricaConexao con;

        PreparedStatement st;

        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "SELECT * FROM compromisso where usuario_cpf = ? order by data_geracao desc";

        st = con.getConexao().prepareStatement(sql);

        List<Compromisso> lista = new ArrayList<>();

        st.setString(1, cpf);

        rs = st.executeQuery();

        while (rs.next()) {
            lista.add(popular(rs));
        }

        rs.close();
        st.close();

        return lista;
    }

    public List<Compromisso> listarTodosMembro(Integer codigo) throws SQLException {

        FabricaConexao con;

        PreparedStatement st;

        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "SELECT * FROM compromisso where membro_codigo = ? order by data_geracao desc";

        st = con.getConexao().prepareStatement(sql);

        List<Compromisso> lista = new ArrayList<>();

        st.setInt(1, codigo);

        rs = st.executeQuery();

        while (rs.next()) {
            lista.add(popular(rs));
        }

        rs.close();
        st.close();

        return lista;
    }

    private Compromisso popular(ResultSet rs) throws SQLException {

        Compromisso comp = new Compromisso();

        comp.setCodigo(rs.getInt("codigo"));
        comp.setDataGeracao(rs.getDate("data_geracao"));
        comp.setDiaVencimento(rs.getDate("dia_vencimento"));
        comp.setValor_parcela(rs.getDouble("valor_parcela"));
        comp.setTotalNumParcela(rs.getInt("total_num_parcela"));
        comp.setProjeto(projDao.listarCodigo(rs.getInt("projeto_codigo")));
        comp.setQuitado(rs.getBoolean("quitado"));

        return comp;
    }

    public void delete(Compromisso comp) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "delete from compromisso where codigo = ?";

        st = con.getConexao().prepareStatement(sql);

        st.setInt(1, comp.getCodigo());

        st.execute();

        st.close();
    }

}
