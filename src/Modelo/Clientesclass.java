package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Clientesclass {
    
    int id;
    String Correo;
    String Celular;
    String Rfc;
    String Nombre;
    String Apellidos;

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getRfc() {
        return Rfc;
    }

    public void setRfc(String Rfc) {
        this.Rfc = Rfc;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public List<Clientesclass> obtenerClientes() {
        List<Clientesclass> clientes = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT Nombre, Apellidos, Celular, RFC, Correo FROM Cliente";

        try (Connection con = conex.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Clientesclass cliente = new Clientesclass();

                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellidos(rs.getString("Apellidos"));
                cliente.setCelular(rs.getString("Celular"));
                cliente.setRfc(rs.getString("RFC"));
                cliente.setCorreo(rs.getString("Correo"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener clientes: " + e.toString());
        }

        return clientes;
    }

    public List<Clientesclass> obtenerClientesPorNumero(String numero) {
        List<Clientesclass> clientes = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT Nombre, Apellidos, Celular, RFC, Correo FROM Cliente WHERE Celular LIKE ?";
        try (Connection con = conex.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            // Configurar el parámetro de la consulta con el número de celular proporcionado
            pst.setString(1, "%" + numero + "%");

            // Ejecutar la consulta
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Clientesclass cliente = new Clientesclass();
                    cliente.setNombre(rs.getString("Nombre"));
                    cliente.setApellidos(rs.getString("Apellidos"));
                    cliente.setCelular(rs.getString("Celular"));
                    cliente.setRfc(rs.getString("RFC"));
                    cliente.setCorreo(rs.getString("Correo"));
                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener clientes por número: " + e.toString());
        }
        return clientes;
    }

    public List<Clientesclass> obtenerClientesidnombre() {
        List<Clientesclass> clientes = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT idCliente, Nombre FROM Cliente";

        try (Connection con = conex.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Clientesclass cliente = new Clientesclass();

                cliente.setId(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("Nombre"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener clientes: " + e.toString());
        }

        return clientes;
    }

    public void actualizarClienteBD(Clientesclass cliente) {
        Conexion conex = new Conexion();
        String consulta = "UPDATE Cliente SET Nombre=?, Apellidos=?, RFC=?, Correo=? WHERE Celular=?";

        try (PreparedStatement pst = conex.getConnection().prepareCall(consulta)) {
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellidos());
            pst.setString(3, cliente.getRfc());
            pst.setString(4, cliente.getCorreo());
            pst.setString(5, cliente.getCelular());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Modificado Con Exito !!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar cliente: " + e.toString());
        }
    }

    public void eliminarClienteBD(String celular) {
        Conexion conex = new Conexion();
        String consulta = "DELETE FROM Cliente WHERE Celular = ?";
        try (PreparedStatement pst = conex.getConnection().prepareCall(consulta)) {
            pst.setString(1, celular);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Eliminado Con Exito !!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e.toString());
        }
    }

    public void agregarClienteBD(Clientesclass cliente) {
        Conexion conex = new Conexion();
        String consulta = "INSERT INTO Cliente (Nombre, Apellidos, Celular, RFC,Correo) VALUES (?, ?, ?, ?,?)";
        try (
                PreparedStatement pst = conex.getConnection().prepareCall(consulta)) {
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellidos());
            pst.setString(3, cliente.getCelular());
            pst.setString(4, cliente.getRfc());
            pst.setString(5, cliente.getCorreo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente Agregado Con Exito !!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar cliente: " + e.toString());
        }
    }

    // Método para crear un Memento (guardar el estado)
    public ClienteMemento createMemento() {
        return new ClienteMemento(id, Correo, Celular, Rfc, Nombre, Apellidos);
    }

    // Método para restaurar el estado desde un Memento
    public void restoreFromMemento(ClienteMemento memento) {
        this.id = memento.getId();
        this.Correo = memento.getCorreo();
        this.Celular = memento.getCelular();
        this.Rfc = memento.getRfc();
        this.Nombre = memento.getNombre();
        this.Apellidos = memento.getApellidos();
    }

    /**
     * Obtiene un cliente específico de la base de datos usando su número de
     * celular.
     *
     * @param celular El número de celular del cliente a buscar.
     * @return Una instancia de Clientesclass si se encuentra, o null si no.
     */
    public Clientesclass obtenerClientePorCelularBD(String celular) {
        Conexion conex = new Conexion();
        // Selecciona todas las columnas necesarias para reconstruir el objeto
        String sql = "SELECT idCliente, Nombre, Apellidos, Celular, RFC, Correo FROM Cliente WHERE Celular = ?";
        Clientesclass cliente = null;

        try (Connection con = conex.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, celular);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    cliente = new Clientesclass();
                    // Asegúrate de obtener el ID también si lo usas en el Memento
                    cliente.setId(rs.getInt("idCliente"));
                    cliente.setNombre(rs.getString("Nombre"));
                    cliente.setApellidos(rs.getString("Apellidos"));
                    cliente.setCelular(rs.getString("Celular"));
                    cliente.setRfc(rs.getString("RFC"));
                    cliente.setCorreo(rs.getString("Correo"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener cliente por celular: " + e.toString());
        }
        return cliente;
    }
}
