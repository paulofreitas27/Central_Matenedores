package util;

import javax.swing.JOptionPane;

public class Mensagens {

    public static void erro(String texto) {
        JOptionPane.showMessageDialog(null, texto, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void sucesso() {
        JOptionPane.showMessageDialog(null, "Operação realizada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void atenção(String texto) {
        JOptionPane.showMessageDialog(null, texto, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public static int perguntar(String texto) {
        return JOptionPane.showConfirmDialog(null, texto, "Atenção", JOptionPane.YES_NO_OPTION);
    }

    public static void main(String[] args) {
        System.out.println(Mensagens.perguntar("fechar"));
    }

}
