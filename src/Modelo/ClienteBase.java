package Modelo;
import java.util.List;

public abstract class ClienteBase {
    protected ClienteImplementacion implementacion;

    public ClienteBase(ClienteImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    public abstract List<Clientesclass> obtenerClientes();
    public abstract List<Clientesclass> obtenerClientesPorNumero(String numero);
    public abstract List<Clientesclass> obtenerClientesidnombre();
}