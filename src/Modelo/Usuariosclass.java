/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



public class Usuariosclass {

    
    int id;
    String Nombre,NombreUsuario,Apellidos,Celular,Contraseña,Rol;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    

  
    // Método para obtener usuarios de la base de datos
    public List<Usuariosclass> obtenerUsuarios() {
        List<Usuariosclass> usuarios = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT idUsuario, Nombreusuario, Nombre, Apellidos, Celular, Rol FROM Usuario";

        try (Connection con = conex.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                Usuariosclass usuario = new Usuariosclass();
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("Nombreusuario"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setCelular(rs.getString("Celular"));
                usuario.setRol(rs.getString("Rol"));
                
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener usuarios: " + e.toString());
        }

        return usuarios;
    }
    
     public List<Usuariosclass> obtenerUsuariosAdministradores() {
        List<Usuariosclass> usuarios = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT Nombreusuario, Rol FROM Usuario";

        try (Connection con = conex.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                Usuariosclass usuario = new Usuariosclass();
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("Nombreusuario"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setCelular(rs.getString("Celular"));
                usuario.setRol(rs.getString("Rol"));
                
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener usuarios: " + e.toString());
        }

        return usuarios;
    }

    
     public List<Usuariosclass> obtenerUsuariosPorNumero(String numero) {
        List<Usuariosclass> usuarios = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT Nombre, Apellidos, Nombreusuario, Celular,Rol FROM Cliente WHERE Celular LIKE ?";
        try (Connection con = conex.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            // Configurar el parámetro de la consulta con el número de celular proporcionado
            pst.setString(1, "%" + numero + "%");
            
            // Ejecutar la consulta
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Usuariosclass usuario = new Usuariosclass();
                    usuario.setNombre(rs.getString("Nombre"));
                    usuario.setApellidos(rs.getString("Apellidos"));
                    usuario.setNombreUsuario(rs.getString("Nombreusuario"));
                    usuario.setCelular(rs.getString("Celular"));
                    usuario.setRol(rs.getString("Rol"));
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener clientes por número: " + e.toString());
        }
        return usuarios;
    }
    
     
     
}
