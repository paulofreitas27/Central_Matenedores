package util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TamanhoFixo extends PlainDocument {

    private final int tamMax;

    public TamanhoFixo(int tamMax) {
        this.tamMax = tamMax;
    }

    @Override
    public void insertString(int i, String string, AttributeSet as) throws BadLocationException {

        if (tamMax <= 0) {
            super.insertString(i, string, as);
        } else if (getLength() < tamMax) {

            int tam = getLength() + string.length();

            if (tam <= tamMax) {
                super.insertString(i, string, as);
            } else {
                String novaStr = string.substring(0, (tamMax - getLength()));
                super.insertString(i, novaStr.toUpperCase(), as);
            }
        }
    }

}
