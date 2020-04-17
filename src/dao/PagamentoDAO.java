package dao;

import entidades.Pagamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.FabricaConexao;

public class PagamentoDAO {

    public void salvar(Pagamento pag) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "INSERT INTO pagamento (data_pagamento, valor, forma_pagamento_codigo, boleto_codigo, caixa_codigo) "
                + "VALUES(now(), ?, ?, ?, ?)";

        st = con.getConexao().prepareStatement(sql);

        st.setDouble(1, pag.getValor());
        st.setInt(2, pag.getFormaPagamento().getCodigo());
        st.setInt(3, pag.getBoleto().getCodigo());
        st.setInt(4, pag.getCaixa().getCodigo());

        st.execute();

        st.close();

    }

    public List<Pagamento> listarTodosCaixa(Integer codigo) throws SQLException {

        FabricaConexao con;

        PreparedStatement st;

        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "SELECT * FROM pagamento where caixa_codigo = ?";

        st = con.getConexao().prepareStatement(sql);

        List<Pagamento> lista = new ArrayList<>();

        st.setInt(1, codigo);

        rs = st.executeQuery();

        while (rs.next()) {
            lista.add(popular(rs));
        }

        rs.close();
        st.close();

        return lista;
    }

    private Pagamento popular(ResultSet rs) throws SQLException {

        Pagamento pag = new Pagamento();

        pag.setCodigo(rs.getInt("codigo"));
        pag.setDataPagamento(rs.getDate("data_pagamento"));
        pag.setValor(rs.getDouble("valor"));
        pag.setFormaPagamento(new FormaPagamentoDAO().BuscarCodigo(rs.getInt("forma_pagamento_codigo")));

        return pag;
    }

    public double somarValores(Integer codigoFP, Integer codigoCX) throws SQLException {

        FabricaConexao con;

        PreparedStatement st;

        ResultSet rs;

        double valor = 0;

        con = FabricaConexao.getInstancia();

        String sql = "SELECT SUM(valor) as soma FROM pagamento where caixa_codigo = ? and forma_pagamento_codigo = ?";

        st = con.getConexao().prepareStatement(sql);

        st.setInt(1, codigoCX);
        st.setInt(2, codigoFP);

        rs = st.executeQuery();

        if (rs.next()) {
            valor = rs.getDouble("soma");
        }

        rs.close();
        st.close();

        return valor;
    }

    public List<Pagamento> listarTodosBoleto(Integer codigo) throws SQLException {

        FabricaConexao con;

        PreparedStatement st;

        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "SELECT * FROM pagamento where boleto_codigo = ?";

        st = con.getConexao().prepareStatement(sql);

        List<Pagamento> lista = new ArrayList<>();

        st.setInt(1, codigo);

        rs = st.executeQuery();

        while (rs.next()) {
            lista.add(popular(rs));
        }

        rs.close();
        st.close();

        return lista;
    }

    public void delete(Integer codigo) throws SQLException {
        FabricaConexao con;
        PreparedStatement st;

        con = FabricaConexao.getInstancia();

        String sql = "delete from pagamento where codigo = ?";

        st = con.getConexao().prepareStatement(sql);

        st.setInt(1, codigo);

        st.execute();

        st.close();
    }

}
