package dao;

import entidades.Boleto;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.FabricaConexao;

public class BoletoDAO {

    public void salvar(Boleto bo) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "INSERT INTO Boleto (numero_parcela, data_vencimento, valor, compromisso_codigo, quitado) VALUES(?, ?, ?, ?, false)";

        st = con.getConexao().prepareStatement(sql);

        st.setInt(1, bo.getNumeroParcela());
        st.setDate(2, new Date(bo.getDataVencimento().getTime()));
        st.setDouble(3, bo.getValor());
        st.setInt(4, bo.getCompromisso().getCodigo());

        st.execute();

        st.close();

    }

    public void confirmarPagamento(Boleto boleto) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "UPDATE boleto SET quitado = true, valor = ? where codigo = ?";

        st = con.getConexao().prepareStatement(sql);

        st.setDouble(1, boleto.getValor());
        st.setInt(2, boleto.getCodigo());

        st.execute();

        st.close();
    }

    public List<Boleto> listarTodosCompromisso(Integer codigo) throws SQLException {

        FabricaConexao con;

        PreparedStatement st;

        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "SELECT * FROM boleto where compromisso_codigo = ? order by numero_parcela";

        st = con.getConexao().prepareStatement(sql);

        List<Boleto> lista = new ArrayList<>();

        st.setInt(1, codigo);

        rs = st.executeQuery();

        while (rs.next()) {
            lista.add(popular(rs));
        }

        rs.close();
        st.close();

        return lista;
    }

    private Boleto popular(ResultSet rs) throws SQLException {

        Boleto bo = new Boleto();

        bo.setCodigo(rs.getInt("codigo"));
        bo.setNumeroParcela(rs.getInt("numero_parcela"));
        bo.setDataVencimento(rs.getDate("data_vencimento"));
        bo.setValor(rs.getDouble("valor"));
        bo.setQuitado(rs.getBoolean("quitado"));

        return bo;
    }

}
