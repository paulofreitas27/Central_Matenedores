
package dao;

import entidades.FormaPagamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.FabricaConexao;

public class FormaPagamentoDAO {

    public List<FormaPagamento> listarTodos() throws SQLException {

        FabricaConexao con;

        PreparedStatement st;

        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "SELECT * FROM Forma_Pagamento order by nome asc";

        st = con.getConexao().prepareStatement(sql);

        List<FormaPagamento> listaFPag = new ArrayList<>();

        rs = st.executeQuery();

        while (rs.next()) {
            listaFPag.add(popular(rs));
        }

        rs.close();
        st.close();

        return listaFPag;
    }

    public FormaPagamento BuscarCodigo(Integer codigo) throws SQLException {

        FabricaConexao con;

        PreparedStatement st;

        ResultSet rs;

        con = FabricaConexao.getInstancia();

        String sql = "SELECT * FROM Forma_Pagamento where codigo = ?";

        st = con.getConexao().prepareStatement(sql);

        FormaPagamento fPag = null;

        st.setInt(1, codigo);

        rs = st.executeQuery();

        if (rs.next()) {
            fPag = popular(rs);
        }

        rs.close();
        st.close();

        return fPag;
    }

    private FormaPagamento popular(ResultSet rs) throws SQLException {

        FormaPagamento fPag = new FormaPagamento();

        fPag.setCodigo(rs.getInt("codigo"));
        fPag.setNome(rs.getString("nome"));

        return fPag;
    }

}
