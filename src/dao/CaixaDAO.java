package dao;

import entidades.Caixa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import util.FabricaConexao;

public class CaixaDAO {

    public void abrir(String CPF) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "INSERT INTO Caixa (data_hora_abertura, aberto, usuario_cpf) VALUES(now(), true, ?)";

        st = con.getConexao().prepareStatement(sql);

        st.setString(1, CPF);

        st.execute();

        st.close();

    }

    public void fechar(Caixa cai) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "UPDATE Caixa SET data_hora_fechamento = now(), aberto = 0 where codigo = ?";

        st = con.getConexao().prepareStatement(sql);

        st.setInt(1, cai.getCodigo());

        st.execute();

        st.close();

    }

    public List<Caixa> listarPorUsuario(String CPF) throws SQLException {

        FabricaConexao con;

        PreparedStatement st;

        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "SELECT * FROM Caixa where usuario_cpf = ? order by data_hora_abertura";

        st = con.getConexao().prepareStatement(sql);

        List<Caixa> lista = new ArrayList<>();

        st.setString(1, CPF);

        rs = st.executeQuery();

        while (rs.next()) {
            lista.add(popular(rs));
        }

        rs.close();
        st.close();

        return lista;
    }

    public List<Caixa> listarPorPeriodo(String cpf, Date dataInicial, Date dataFinal) throws SQLException {

        FabricaConexao con;

        PreparedStatement st;

        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "select * from Caixa where usuario_cpf = ? and date(data_hora_abertura) between ? and ? ";

        st = con.getConexao().prepareStatement(sql);

        List<Caixa> lista = new ArrayList<>();

        st.setString(1, cpf);
        st.setDate(2, new java.sql.Date(dataInicial.getTime()));
        st.setDate(3, new java.sql.Date(dataFinal.getTime()));

        rs = st.executeQuery();

        while (rs.next()) {
            lista.add(popular(rs));
        }

        rs.close();
        st.close();

        return lista;
    }

    public Caixa buscarCaixaAberto(String CPF) throws SQLException {

        FabricaConexao con;

        PreparedStatement st;

        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "SELECT * FROM Caixa where usuario_cpf = ? and aberto = 1";

        st = con.getConexao().prepareStatement(sql);

        Caixa cai = null;

        st.setString(1, CPF);

        rs = st.executeQuery();

        if (rs.next()) {
            cai = popular(rs);
        }

        rs.close();
        st.close();

        return cai;
    }

    private Caixa popular(ResultSet rs) throws SQLException {

        Caixa cai = new Caixa();

        cai.setCodigo(rs.getInt("codigo"));
        cai.setDataHoraAbertura(rs.getTimestamp("data_hora_abertura"));
        cai.setDataHoraFechamento(rs.getTimestamp("data_hora_fechamento"));
        cai.setAberto(rs.getBoolean("aberto"));

        return cai;
    }

}
