package Modelo;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.JOptionPane;

public class FiltroCelular extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        string = string.replaceAll("\\s+", "");
       
        StringBuilder nuevoTexto = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        nuevoTexto.insert(offset, string);
        
        if (validarParcial(nuevoTexto.toString())) {
            super.insertString(fb, offset, string, attr);
        } else {
            mostrarError(nuevoTexto.toString());
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        text = text.replaceAll("\\s+", "");
       
        StringBuilder nuevoTexto = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        nuevoTexto.replace(offset, offset + length, text);
        
        if (validarParcial(nuevoTexto.toString())) {
            super.replace(fb, offset, length, text, attrs);
        } else {
            mostrarError(nuevoTexto.toString());
        }
    }

    private void mostrarError(String texto) {
        if (texto.length() > 10) {
            JOptionPane.showMessageDialog(null, "El número de celular debe tener exactamente 10 dígitos.", "Error en Número de Celular", JOptionPane.ERROR_MESSAGE);
        } else if (texto.length() == 1 && !texto.matches("[3-9]")) {
            JOptionPane.showMessageDialog(null, "El número de celular debe comenzar con un dígito entre 3 y 9.", "Error en Número de Celular", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validarParcial(String texto) {
        if (!texto.matches("[0-9]*")) {
            return false;
        }
        if (texto.length() > 10) {
            return false;
        }
        if (texto.length() > 0 && !texto.substring(0, 1).matches("[3-9]")) {
            return false;
        }

        return true;
    }
}
