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
import java.util.Date;
import java.util.List;
public class Pedidoclass {
    
    int numpedido, idusuario , idcliente, cantidad, numdepaginas;
    
    String  Nombredeusuario, Nombrecliennte, Apellidoscliente, cometarios,Celularcliente;

   

   
    String Servicio, Tipodecopia, Tamaño, Escala, Status;
    Date fechaEmision, Fechaentrega;
    Date Horaemision,Horaentrega;
    String pastafrente,pastatrasera,arillo; 
    
    double total, Anticipo, Resto;

    public int getNumpedido() {
        return numpedido;
    }
    public String getNombrecliennte() {
        return Nombrecliennte;
    }

    public void setNombrecliennte(String Nombrecliennte) {
        this.Nombrecliennte = Nombrecliennte;
    }
    public void setNumpedido(int numpedido) {
        this.numpedido = numpedido;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
    
     public String getCelularcliente() {
        return Celularcliente;
    }

    public void setCelularcliente(String Celularcliente) {
        this.Celularcliente = Celularcliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNumdepaginas() {
        return numdepaginas;
    }

    public void setNumdepaginas(int numdepaginas) {
        this.numdepaginas = numdepaginas;
    }

    public String getNombredeusuario() {
        return Nombredeusuario;
    }

    public void setNombredeusuario(String Nombredeusuario) {
        this.Nombredeusuario = Nombredeusuario;
    }

    public String getApellidoscliente() {
        return Apellidoscliente;
    }

    public void setApellidoscliente(String Apellidoscliente) {
        this.Apellidoscliente = Apellidoscliente;
    }

    public String getCometarios() {
        return cometarios;
    }

    public void setCometarios(String cometarios) {
        this.cometarios = cometarios;
    }

    public String getServicio() {
        return Servicio;
    }

    public void setServicio(String Servicio) {
        this.Servicio = Servicio;
    }

    public String getTipodecopia() {
        return Tipodecopia;
    }

    public void setTipodecopia(String Tipodecopia) {
        this.Tipodecopia = Tipodecopia;
    }

    public String getTamaño() {
        return Tamaño;
    }

    public void setTamaño(String Tamaño) {
        this.Tamaño = Tamaño;
    }

    public String getEscala() {
        return Escala;
    }

    public void setEscala(String Escala) {
        this.Escala = Escala;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaentrega() {
        return Fechaentrega;
    }

    public void setFechaentrega(Date Fechaentrega) {
        this.Fechaentrega = Fechaentrega;
    }

    public Date getHoraemision() {
        return Horaemision;
    }

    public void setHoraemision(Date Horaemision) {
        this.Horaemision = Horaemision;
    }

    public Date getHoraentrega() {
        return Horaentrega;
    }

    public void setHoraentrega(Date Horaentrega) {
        this.Horaentrega = Horaentrega;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAnticipo() {
        return Anticipo;
    }

    public void setAnticipo(double Anticipo) {
        this.Anticipo = Anticipo;
    }

    public double getResto() {
        return Resto;
    }

    public void setResto(double Resto) {
        this.Resto = Resto;
    }
    
    public String getPastafrente() {
        return pastafrente;
    }

    public void setPastafrente(String pastafrente) {
        this.pastafrente = pastafrente;
    }

    public String getPastatrasera() {
        return pastatrasera;
    }

    public void setPastatrasera(String pastatrasera) {
        this.pastatrasera = pastatrasera;
    }

    public String getArillo() {
        return arillo;
    }

    public void setArillo(String arillo) {
        this.arillo = arillo;
    }
    

      
public List<Pedidoclass> obtenerPastas() {
        List<Pedidoclass> pastas = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT Nombre_producto FROM productos WHERE Categoria LIKE 'Pasta'";

        try (Connection con = conex.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Pedidoclass pasta = new Pedidoclass();
                pasta.setPastafrente(rs.getString("Nombre_producto")); // Asignar el nombre al atributo pastafrente
                pastas.add(pasta); // Agregar el objeto a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pastas;
    }


public List<Pedidoclass> obtenerarilloList() {
        List<Pedidoclass> arillos = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT Nombre_producto FROM productos WHERE Categoria LIKE 'Arillo'";

        try (Connection con = conex.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Pedidoclass Arillo = new Pedidoclass();
                Arillo.setArillo(rs.getString("Nombre_producto")); // Asignar el nombre al atributo pastafrente
                arillos.add(Arillo); // Agregar el objeto a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arillos;
    }
    
public List<Pedidoclass> obtenerpedidos() {
    List<Pedidoclass> pedidos = new ArrayList<>();
    Conexion conex = new Conexion();

    // Consulta SQL para obtener pedidos con estado 'Pendiente'
    String sql = "SELECT `NumPedido`, `Nombre_Usuario`, `idUsuario`, `idCliente`, `Nombre_Cliente`, " +
                 "`Apellidos_Cliente`, `CelularCliente`, `Servicio`, `TipoDeCopia`, `Tamaño`, `Escala`, " +
                 "`FechaEmision`, `HoraEmision`, `FechaEntrega`, `HoraEntrega`, `NumeroDePag`, `Frente`, " +
                 "`Atras`, `Arillo`, `Comentarios`, `Total`, `Anticipo`, `Resto`, `Status`, `Cantidad`, " +
                 "`CantidadCarta`, `CantidadOficio` FROM `pedido` WHERE `Status` = 'Pendiente'";

    try (Connection con = conex.getConnection();
         PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        // Iterar por cada fila en el ResultSet
        while (rs.next()) {
            Pedidoclass pedido = new Pedidoclass();

            // Asignar valores de la base de datos al objeto `Pedidoclass`
            pedido.setNumpedido(rs.getInt("NumPedido"));
            pedido.setNombredeusuario(rs.getString("Nombre_Usuario"));
            pedido.setIdusuario(rs.getInt("idUsuario"));
            pedido.setIdcliente(rs.getInt("idCliente"));
            pedido.setNombrecliennte(rs.getString("Nombre_Cliente"));
            pedido.setApellidoscliente(rs.getString("Apellidos_Cliente"));
            pedido.setCelularcliente(rs.getString("CelularCliente"));
            pedido.setServicio(rs.getString("Servicio"));
            pedido.setTipodecopia(rs.getString("TipoDeCopia"));
            pedido.setTamaño(rs.getString("Tamaño"));
            pedido.setEscala(rs.getString("Escala"));
            pedido.setFechaEmision(rs.getDate("FechaEmision"));
            pedido.setHoraemision(rs.getTime("HoraEmision"));
            pedido.setFechaentrega(rs.getDate("FechaEntrega"));
            pedido.setHoraentrega(rs.getTime("HoraEntrega"));
            pedido.setNumdepaginas(rs.getInt("NumeroDePag"));
            pedido.setPastafrente(rs.getString("Frente"));
            pedido.setPastatrasera(rs.getString("Atras"));
            pedido.setArillo(rs.getString("Arillo"));
            pedido.setCometarios(rs.getString("Comentarios"));
            pedido.setTotal(rs.getDouble("Total"));
            pedido.setAnticipo(rs.getDouble("Anticipo"));
            pedido.setResto(rs.getDouble("Resto"));
            pedido.setStatus(rs.getString("Status"));
            pedido.setCantidad(rs.getInt("Cantidad"));

            // Asignar valores específicos de carta y oficio
            pedido.setCantidad(rs.getInt("CantidadCarta"));
            pedido.setCantidad(rs.getInt("CantidadOficio"));

            // Agregar el pedido a la lista
            pedidos.add(pedido);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return pedidos;
}



}
