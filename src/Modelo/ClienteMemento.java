/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alan
 */
public class ClienteMemento {

    private final int id;
    private final String Correo;
    private final String Celular;
    private final String Rfc;
    private final String Nombre;
    private final String Apellidos;

    // Constructor (nota el modificador 'package-private' o 'default', para que solo sea accesible desde el mismo paquete)
    ClienteMemento(int id, String correo, String celular, String rfc, String nombre, String apellidos) {
        this.id = id;
        this.Correo = correo;
        this.Celular = celular;
        this.Rfc = rfc;
        this.Nombre = nombre;
        this.Apellidos = apellidos;
    }

    // Getters (solo getters, no setters, para que el Memento sea inmutable)
    public int getId() {
        return id;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getCelular() {
        return Celular;
    }

    public String getRfc() {
        return Rfc;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }
}
