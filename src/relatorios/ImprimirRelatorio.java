package relatorios;

import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;
import util.FabricaConexao;

public class ImprimirRelatorio {

    private static void imprimirRelatorio(boolean imprimirDireto, HashMap filtro, String relatorio) throws JRException {

        String arquivo = System.getProperty("user.dir") + relatorio;

        JasperPrint print = JasperFillManager.fillReport(arquivo, filtro, FabricaConexao.getInstancia().getConexao());

        if (imprimirDireto) {
            JasperPrintManager.printReport(print, true);
        } else {
            JasperViewer view = new JasperViewer(print, false);
            if (print.getPages().size() > 0) {
                view.setVisible(true);
            }
        }

    }

    public static void gerarReciboPagamento(Integer codigo) throws JRException {

        String arquivo = "/relatorios/recibo/reciboPagamento.jasper";

        HashMap filtro = new HashMap();

        filtro.put("boleto_codigo", codigo);

        imprimirRelatorio(true, filtro, arquivo);

    }

    public static void fechamentoCaixa(Integer codigo_caixa) throws JRException {

        String arquivo = "/relatorios/fechamentoCaixa/fechamentoCaixa.jasper";

        HashMap filtro = new HashMap();

        filtro.put("caixa_codigo", codigo_caixa);

        imprimirRelatorio(false, filtro, arquivo);

    }

}
