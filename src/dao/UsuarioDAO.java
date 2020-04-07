package dao;

import entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.FabricaConexao;

public class UsuarioDAO {

    public void salvar(Usuario usu) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "INSERT INTO usuario (cpf, nome, senha, adm, ativo ) VALUES(?, ?, ?, ?, ?)";

        st = con.getConexao().prepareStatement(sql);

        st.setString(1, usu.getCpf());
        st.setString(2, usu.getNome());
        st.setString(3, usu.getSenha());
        st.setBoolean(4, usu.isAdm());
        st.setBoolean(5, usu.isAtivo());

        st.execute();

        st.close();

    }

    public void alterar(Usuario usu) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "UPDATE usuario SET nome = ?, senha = ?, adm = ?, ativo = ? where cpf = ?";

        st = con.getConexao().prepareStatement(sql);

        st.setString(1, usu.getNome());
        st.setString(2, usu.getSenha());
        st.setBoolean(3, usu.isAdm());
        st.setBoolean(4, usu.isAtivo());
        st.setString(5, usu.getCpf());

        st.execute();

        st.close();

    }

    public void remover(Usuario usu) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "UPDATE usuario SET ativo = ? where cpf = ?";

        st = con.getConexao().prepareStatement(sql);

        st.setBoolean(1, usu.isAtivo());
        st.setString(2, usu.getCpf());

        st.execute();

        st.close();

    }

    public List<Usuario> listarTodosNomes(String nome) throws SQLException {

        FabricaConexao con;

        PreparedStatement st;
        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "SELECT * FROM usuario where nome like ? order by nome asc";

        st = con.getConexao().prepareStatement(sql);

        List<Usuario> lista = new ArrayList<>();

        st.setString(1, "%" + nome + "%");

        rs = st.executeQuery();

        while (rs.next()) {
            lista.add(popular(rs));
        }

        rs.close();
        st.close();

        return lista;
    }

    public Usuario listarCPF(String cpf) throws SQLException {

        FabricaConexao con;

        PreparedStatement st;
        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "SELECT * FROM usuario where cpf = ?";

        st = con.getConexao().prepareStatement(sql);

        st.setString(1, cpf);

        rs = st.executeQuery();

        Usuario usu = null;

        if (rs.next()) {
            usu = popular(rs);
        }

        rs.close();
        st.close();

        return usu;
    }

    private Usuario popular(ResultSet rs) throws SQLException {

        Usuario usu = new Usuario();

        usu.setCpf(rs.getString("cpf"));
        usu.setNome(rs.getString("nome"));
        usu.setSenha(rs.getString("senha"));
        usu.setAdm(rs.getBoolean("adm"));
        usu.setAtivo(rs.getBoolean("ativo"));

        return usu;
    }

}
