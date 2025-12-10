/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;

/**
 *
 * @author Artorias<maxstell5549@hotmail.com>
 */
public class Letraseditor extends DefaultCellEditor {
     private boolean shouldReplaceContent = true;

    public Letraseditor() {
        super(new JTextField());
        JTextField textField = (JTextField) getComponent();
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new FiltroLetras());

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                shouldReplaceContent = true;
                textField.selectAll();
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (shouldReplaceContent) {
                    textField.setText("");
                    shouldReplaceContent = false;
                }
            }
        });
    }
}
