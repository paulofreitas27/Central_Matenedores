
package dao;

import entidades.Projeto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.FabricaConexao;

public class ProjetoDAO {

    public void salvar(Projeto proj) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "INSERT INTO projeto (nome, descricao, data_criacao, ativo) "
                + "VALUES(?, ?, now(), ?)";

        st = con.getConexao().prepareStatement(sql);

        st.setString(1, proj.getNome());
        st.setString(2, proj.getDescricao());
        st.setBoolean(3, proj.isAtivo());

        st.execute();

        st.close();

    }

    public void alterar(Projeto proj) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "UPDATE projeto SET nome = ?, descricao = ?, ativo = ? where codigo = ?";

        st = con.getConexao().prepareStatement(sql);

        st.setString(1, proj.getNome());
        st.setString(2, proj.getDescricao());
        st.setBoolean(3, proj.isAtivo());
        st.setInt(4, proj.getCodigo());

        st.execute();

        st.close();

    }

    public void remover(Projeto proj) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "UPDATE projeto SET ativo = ? where codigo = ?";

        st = con.getConexao().prepareStatement(sql);

        st.setBoolean(1, proj.isAtivo());
        st.setInt(2, proj.getCodigo());

        st.execute();

        st.close();

    }

    public List<Projeto> listarTodosNomes(String nome) throws SQLException {

        FabricaConexao con;

        PreparedStatement st;
        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "SELECT * FROM projeto where nome like ? order by nome asc";

        st = con.getConexao().prepareStatement(sql);

        List<Projeto> lista = new ArrayList<>();

        st.setString(1, "%" + nome + "%");

        rs = st.executeQuery();

        while (rs.next()) {
            lista.add(popular(rs));
        }

        rs.close();
        st.close();

        return lista;
    }

    public Projeto listarCodigo(Integer codigo) throws SQLException {

        FabricaConexao con;

        PreparedStatement st;
        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "SELECT * FROM projeto where codigo = ?";

        st = con.getConexao().prepareStatement(sql);

        Projeto proj = null;

        st.setInt(1, codigo);

        rs = st.executeQuery();

        if (rs.next()) {
            proj = popular(rs);
        }

        rs.close();
        st.close();

        return proj;
    }

    private Projeto popular(ResultSet rs) throws SQLException {

        Projeto proj = new Projeto();

        proj.setCodigo(rs.getInt("codigo"));
        proj.setNome(rs.getString("nome"));
        proj.setDescricao(rs.getString("descricao"));
        proj.setDataCriacao(rs.getDate("data_criacao"));
        proj.setAtivo(rs.getBoolean("ativo"));

        return proj;
    }

}
