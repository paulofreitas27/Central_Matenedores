package dao;

import entidades.Membro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.FabricaConexao;

public class MembroDAO {

    public void salvar(Membro mem) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "INSERT INTO membro (nome, fone) VALUES(?, ?)";

        st = con.getConexao().prepareStatement(sql);

        st.setString(1, mem.getNome());
        st.setString(2, mem.getFone());

        st.execute();

        st.close();

    }

    public void alterar(Membro mem) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "UPDATE Membro SET nome = ?, fone = ? where codigo = ?";

        st = con.getConexao().prepareStatement(sql);

        st.setString(1, mem.getNome());
        st.setString(2, mem.getFone());
        st.setInt(3, mem.getCodigo());

        st.execute();

        st.close();

    }

    public List<Membro> listarTodosNomes(String nome) throws SQLException {

        FabricaConexao con;

        PreparedStatement st;

        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "SELECT * FROM Membro where nome like ? order by nome asc limit 50";

        st = con.getConexao().prepareStatement(sql);

        List<Membro> lista = new ArrayList<>();

        st.setString(1, "%" + nome + "%");

        rs = st.executeQuery();

        while (rs.next()) {
            lista.add(popular(rs));
        }

        rs.close();
        st.close();

        return lista;
    }

    public List<Membro> listarTodosNomesFone(String nome, String fone) throws SQLException {

        FabricaConexao con;

        PreparedStatement st;

        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "SELECT * FROM Membro where nome like ? and fone like ? order by nome asc limit 50";

        st = con.getConexao().prepareStatement(sql);

        List<Membro> lista = new ArrayList<>();

        st.setString(1, "%" + nome + "%");
        st.setString(2, "%" + fone + "%");

        rs = st.executeQuery();

        while (rs.next()) {
            lista.add(popular(rs));
        }

        rs.close();
        st.close();

        return lista;
    }

    private Membro popular(ResultSet rs) throws SQLException {

        Membro mem = new Membro();

        mem.setCodigo(rs.getInt("codigo"));
        mem.setNome(rs.getString("nome"));
        mem.setFone(rs.getString("fone"));

        return mem;
    }

}
