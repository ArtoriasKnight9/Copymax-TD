package Modelo;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.JOptionPane;
import java.util.Set;
import java.util.HashSet;

public class FiltroCorreo extends DocumentFilter {
    private static final Set<String> DOMINIOS_VALIDOS = new HashSet<>();

    static {
        DOMINIOS_VALIDOS.add("gmail.com");
        DOMINIOS_VALIDOS.add("yahoo.com");
        DOMINIOS_VALIDOS.add("hotmail.com");
        DOMINIOS_VALIDOS.add("outlook.com");
        DOMINIOS_VALIDOS.add("tec.mx");
        DOMINIOS_VALIDOS.add("live.com");
        DOMINIOS_VALIDOS.add("icloud.com");
        DOMINIOS_VALIDOS.add("protonmail.com");
        DOMINIOS_VALIDOS.add("edu.mx");
        DOMINIOS_VALIDOS.add("correo.com");
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
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
        StringBuilder nuevoTexto = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        nuevoTexto.replace(offset, offset + length, text);
        
        if (validarParcial(nuevoTexto.toString())) {
            super.replace(fb, offset, length, text, attrs);
        } else {
            mostrarError();
        }
    }

    private void mostrarError() {
        JOptionPane.showMessageDialog(null, "El correo electrónico debe tener un dominio válido:\n" + String.join(", ", DOMINIOS_VALIDOS), "Error en Correo Electrónico", JOptionPane.ERROR_MESSAGE);
    }

    private boolean validarParcial(String texto) {
        if (!texto.contains("@")) {
            return texto.matches("[A-Za-z0-9._%+-]*");
        }
        String[] partes = texto.split("@", 2);
        if (partes.length == 2) {
            String dominio = partes[1];
            for (String valido : DOMINIOS_VALIDOS) {
                if (valido.startsWith(dominio)) {
                    return true;
                }
            }
        }
        return DOMINIOS_VALIDOS.contains(partes[1]);
    }
}
