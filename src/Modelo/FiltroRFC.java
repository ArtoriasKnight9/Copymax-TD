package Modelo;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.JOptionPane;

public class FiltroRFC extends DocumentFilter {
    private Filtro siguiente;

    public void setSiguiente(Filtro siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        string = string.toUpperCase();
        StringBuilder nuevoTexto = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        nuevoTexto.insert(offset, string);
        
        if (validarParcial(nuevoTexto.toString())) {
            super.insertString(fb, offset, string, attr);
        } else {
            mostrarError();
        }
    }
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        text = text.toUpperCase();
        StringBuilder nuevoTexto = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        nuevoTexto.replace(offset, offset + length, text);
        
        if (validarParcial(nuevoTexto.toString())) {
            super.replace(fb, offset, length, text, attrs);
        } else {
            mostrarError();
        }
    }

    private void mostrarError() {
        JOptionPane.showMessageDialog(null, "El RFC debe tener exactamente 13 caracteres:\n- 4 letras al principio\n- 6 números (fecha)\n- 3 alfanuméricos al final", "Error en RFC", JOptionPane.ERROR_MESSAGE);
    }

    private boolean validarParcial(String texto) {
        if (texto.length() > 13) {
            return false;
        }
        if (texto.length() <= 4) {
            return texto.matches("[A-Za-z]*");
        }
        if (texto.length() > 4 && texto.length() <= 10) {
            String fecha = texto.substring(4);
            return fecha.matches("[0-9]*");
        }
        if (texto.length() > 10) {
            String ultimos = texto.substring(10);
            return ultimos.matches("[A-Za-z0-9]*");
        }
        return true;
    }
}