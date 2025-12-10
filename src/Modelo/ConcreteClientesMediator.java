/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.Clientes;
import Vista.RegistroClientes;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Stack;

/**
 *
 * @author Alan
 */
public class ConcreteClientesMediator implements ClientesMediator {

    private Clientes clientesPanel;
    private Clientesclass clientesClass;
    private Stack<ClienteMemento> historialMementos = new Stack<>();

    @Override
    public void registrarClientePanel(Clientes clientesPanel) {
        this.clientesPanel = clientesPanel;
    }

    @Override
    public void registrarClientesClass(Clientesclass clientesClass) {
        this.clientesClass = clientesClass;
    }

    @Override
    public void obtenerClientes() {
        if (clientesClass != null && clientesPanel != null) {
            List<Clientesclass> clientes = clientesClass.obtenerClientes();
        
            clientesPanel.actualizarTablaUI(clientes);
        }
    }

    @Override
    public void buscarClientesPorNumero(String numero) {
        if (clientesClass != null && clientesPanel != null) {
            List<Clientesclass> clientes = clientesClass.obtenerClientesPorNumero(numero);
            clientesPanel.actualizarTablaUI(clientes);
        }
    }

    @Override
    public void agregarNuevoCliente() {
        //if (clientesPanel != null) {
           // RegistroClientes registro = new RegistroClientes(this); // Pass the mediator
           // registro.setVisible(true);
        //}
    }

    // Method to handle saving a new client
    public void guardarNuevoCliente(Clientesclass cliente) {
        if (clientesClass != null) {
            clientesClass.agregarClienteBD(cliente); // Call the method in Clientesclass
            obtenerClientes(); // Refresh the table
        }
    }

    @Override
    public void modificarCliente(int selectedRow) {
        if (clientesPanel != null && selectedRow != -1 && clientesClass != null) { // Añadir chequeo de clientesClass
            DefaultTableModel modelo = clientesPanel.getModeloTabla();
            String celularOriginal = (String) modelo.getValueAt(selectedRow, 2); // Clave para buscar/identificar

            // 1. Obtener el estado ORIGINAL directamente de la BD usando el método en Clientesclass
            Clientesclass clienteOriginal = clientesClass.obtenerClientePorCelularBD(celularOriginal); // <--- CAMBIO AQUÍ

            if (clienteOriginal != null) {
                // 2. Crear y guardar el Memento del estado original
                ClienteMemento memento = clienteOriginal.createMemento();
                historialMementos.push(memento);
                System.out.println("Memento guardado para cliente: " + celularOriginal);
            } else {
                System.out.println("Advertencia: No se pudo obtener el estado original para guardar Memento (Celular: " + celularOriginal + ").");
                // Considera si quieres detener la modificación aquí o continuar sin 'undo'
                // JOptionPane.showMessageDialog(clientesPanel, "Error al obtener datos originales. No se puede modificar.");
                // return; // Opcional: Salir si no se puede guardar estado previo
            }

            // 3. Obtener los datos NUEVOS de la tabla (los que el usuario editó)
            String nombreNuevo = (String) modelo.getValueAt(selectedRow, 0);
            String apellidosNuevo = (String) modelo.getValueAt(selectedRow, 1);
            // El celular (PK) no debería cambiarse, usamos celularOriginal
            String rfcNuevo = (String) modelo.getValueAt(selectedRow, 3);
            String correoNuevo = (String) modelo.getValueAt(selectedRow, 4);

            Clientesclass clienteModificado = new Clientesclass(); // Objeto con los datos nuevos
            // Asegúrate de incluir el ID si lo obtuviste en clienteOriginal y es relevante
            if (clienteOriginal != null) {
                clienteModificado.setId(clienteOriginal.getId());
            }
            clienteModificado.setNombre(nombreNuevo);
            clienteModificado.setApellidos(apellidosNuevo);
            clienteModificado.setCelular(celularOriginal); // Usar el celular original como PK
            clienteModificado.setRfc(rfcNuevo);
            clienteModificado.setCorreo(correoNuevo);

            // 4. Ejecutar la actualización en la BD
            clientesClass.actualizarClienteBD(clienteModificado);
            obtenerClientes(); // Refrescar la tabla UI

        } else if (clientesPanel != null && selectedRow == -1) {
            JOptionPane.showMessageDialog(clientesPanel, "Seleccione una fila para modificar.");
        } else if (clientesClass == null) {
            System.err.println("Error: clientesClass no está registrado en el Mediator.");
            JOptionPane.showMessageDialog(clientesPanel, "Error interno al intentar modificar.");
        }
    }

    @Override
    public void eliminarCliente(int selectedRow) {
        if (clientesPanel != null && selectedRow != -1) {
            DefaultTableModel modelo = clientesPanel.getModeloTabla();
            String celular = (String) modelo.getValueAt(selectedRow, 2);

            if (clientesClass != null) {
                clientesClass.eliminarClienteBD(celular);
                obtenerClientes(); // Refrescar la tabla después de la eliminación
            }
        } else if (clientesPanel != null) {
            JOptionPane.showMessageDialog(clientesPanel, "Seleccione una fila para eliminar.");
        }
    }

    @Override
    public void actualizarTabla() {
        obtenerClientes();
    }

    @Override
    public void deshacerCambioCliente() {
        if (!historialMementos.isEmpty()) {
            ClienteMemento memento = historialMementos.pop();

            // Creamos una instancia temporal para aplicar el estado restaurado
            Clientesclass clienteRestaurado = new Clientesclass();
            clienteRestaurado.restoreFromMemento(memento);

            // Persistimos el estado restaurado en la BD
            if (clientesClass != null) {
                clientesClass.actualizarClienteBD(clienteRestaurado); // Sobreescribir con datos del memento
                obtenerClientes(); // Refrescar la tabla UI

                JOptionPane.showMessageDialog(clientesPanel, "Último cambio deshecho.");
                System.out.println("Cliente restaurado desde Memento: " + clienteRestaurado.getCelular());

            }
        } else {
            JOptionPane.showMessageDialog(clientesPanel, "No hay cambios para deshacer.");
        }
    }
}
