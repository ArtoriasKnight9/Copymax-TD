package Modelo;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class FiltroLetras extends DocumentFilter {
    private Filtro filtro;
    public FiltroLetras(){
        FiltroSoloLetras filtroLetras = new FiltroSoloLetras();
        FiltroLongitud filtroLongitud = new FiltroLongitud();
        FiltroRFC rfc = new FiltroRFC();
        
        filtroLetras.setSiguiente(filtroLongitud);
        this.filtro = filtroLetras;
    }
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string != null && filtro.validar(string)) {
            super.insertString(fb, offset, string, attr);
        }
    }
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text != null && filtro.validar(text)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
    }
}
