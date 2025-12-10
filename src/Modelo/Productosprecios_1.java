/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Artorias<maxstell5549@hotmail.com>
 */
public class Productosprecios_1 {
    
    private String nombre,direccionicon;
    private double precio;

    public Productosprecios_1(String nombre, double precio, String icono) {
        this.nombre = nombre;
        this.precio = precio;
        this.direccionicon= icono;
    }

    public Productosprecios_1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getDireccionicon() {
        return direccionicon;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
}
