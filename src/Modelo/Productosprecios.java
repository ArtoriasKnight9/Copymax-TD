/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Artorias<maxstell5549@hotmail.com>
 */
public class Productosprecios {
    
    private String nombre,direccionicon;
    private double precio;

    public Productosprecios(String nombre, double precio, String icono) {
        this.nombre = nombre;
        this.precio = precio;
        this.direccionicon= icono;
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
