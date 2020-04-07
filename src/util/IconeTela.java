package util;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class IconeTela {

    public static Image buscarIcone(JFrame tela) {
        URL url = tela.getClass().getResource("../imagens/8527logoPrincipal.ico");
        return Toolkit.getDefaultToolkit().getImage(url);
    }

    public static Image buscarImagenPrincipal(JDesktopPane tela) {
        URL url = tela.getClass().getResource("../imagens/logo.jpeg");
        return Toolkit.getDefaultToolkit().getImage(url);
    }

}
