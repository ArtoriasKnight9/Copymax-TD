package Modelo;

import Conexion.Conexion;
import javax.swing.JOptionPane;

   
public class Usuariosesion {
    private static Usuariosesion instance;
    private String nombre;
    private String nombrereal;
    private int idUsuario;

   
    
    private String rol;

    private Usuariosesion(String nombre, String rol, String nombreeal,int idusuario) {
        this.nombre = nombre;
        this.rol = rol;
        this.nombrereal=nombreeal;
        this.idUsuario=idusuario;
    }

    public static Usuariosesion getInstance(String nombre, String rol, String nombreal, int idusuario) {
    if (instance == null) {
        instance = new Usuariosesion(nombre, rol, nombreal, idusuario);
    } else {
        instance.setUsuario(nombre, rol, nombreal, idusuario);
    }
    return instance;
}
    public static Usuariosesion getInstance() {
        return instance;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public void cerrarSesion() {
        instance = null;
    }
     public String getNombrereal() {
        return nombrereal;
    } 
     
     public int getIdUsuario() {
        return idUsuario;
    }
   
    
     public void setUsuario(String nombre, String rol, String nombreal, int idusuario) {
    this.nombre = nombre;
    this.rol = rol;
    this.nombrereal = nombreal;
    this.idUsuario = idusuario;
}
    
}
