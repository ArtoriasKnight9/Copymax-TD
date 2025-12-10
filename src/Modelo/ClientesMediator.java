/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import Vista.Clientes;
import java.util.List;

/**
 *
 * @author Alan
 */
public interface ClientesMediator {

    void registrarClientePanel(Clientes clientesPanel);

    void registrarClientesClass(Clientesclass clientesClass);

    void obtenerClientes();

    void buscarClientesPorNumero(String numero);

    void guardarNuevoCliente(Clientesclass cliente);

    void agregarNuevoCliente(); // Para el botón Nuevo

    void modificarCliente(int selectedRow); // Para el botón Modificar

    void eliminarCliente(int selectedRow); // Para el botón Eliminar

    void actualizarTabla(); // Para el botón Actualizar
    
    void deshacerCambioCliente();
}
