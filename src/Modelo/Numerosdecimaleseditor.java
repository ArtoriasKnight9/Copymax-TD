/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import javax.swing.*;
import javax.swing.text.*;

/**
 *
 * @author Artorias<maxstell5549@hotmail.com>
 */
public class Numerosdecimaleseditor extends DefaultCellEditor {
    public Numerosdecimaleseditor() {
        super(new JTextField());
        JTextField textField = (JTextField) getComponent();
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new FiltroNumerosDecimales());
    }
    
    
}
