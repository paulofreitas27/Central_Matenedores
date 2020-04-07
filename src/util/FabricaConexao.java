package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class FabricaConexao {

    private static FabricaConexao instancia = null;
    private static Connection con;
    private static final Properties confBanco = new Properties();

    private FabricaConexao() {
        abrirConexao();
    }

    private void abrirConexao() {

        try {

            String arquivo = System.getProperty("user.dir") + "/conf_banco_dado/Configuracao.properties";

            confBanco.load(new FileInputStream(arquivo));

            Class.forName(confBanco.getProperty("driver"));

            String url = confBanco.getProperty("url") + confBanco.getProperty("banco");

            con = DriverManager.getConnection(url, confBanco.getProperty("usuario"), confBanco.getProperty("senha"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel estabelecer uma conexão com o Banco de Dados." + ex.getMessage());
            System.exit(0);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo de Configuração do Banco de Dados não encontrado!");
            System.exit(0);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver de Conexão não encontrado." + ex.getMessage());
            System.exit(0);
        }

    }

    public static FabricaConexao getInstancia() {
        if (instancia == null) {
            instancia = new FabricaConexao();
        }
        return instancia;
    }

    public Connection getConexao() {
        return con;
    }

}
