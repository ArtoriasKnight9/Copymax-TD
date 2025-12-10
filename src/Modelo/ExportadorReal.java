package Modelo;

import Adapter.JsonAdapter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExportadorReal implements Exportador {

    @Override
    public String exportarProductos() {
        try {
            // Crear instancia del Adapter y del servicio
            JsonAdapter<Producto> adapter = new JsonAdapter<>();
            FabricaProducto fabrica = new FabricaProductoDesdeResultSet(); // clase nueva sin afectar las demás
            ServicioProductos servicio = ServicioProductos.getInstancia();
            List<Producto> productosOriginales = servicio.obtenerProductosDesdeFabrica(fabrica);
 
            
            List<Producto> productosClonados = new ArrayList<>();
            for (Producto producto : productosOriginales) {
                if (producto instanceof ClonableProducto) {
                    productosClonados.add(((ClonableProducto) producto).clonar());
                }
            }

            // Convertir a JSON
            String json = adapter.convertirAFormato(productosClonados);

            // Guardar archivo JSON
            String ruta = System.getProperty("user.home") + "/Downloads/productos_clonados.json";
            try (FileWriter writer = new FileWriter(ruta)) {
                writer.write(json);
            }

            return "Productos exportados correctamente.";
        } catch (IOException e) {
            return "Error al exportar productos: " + e.getMessage();
        }
    }

    @Override
    public String exportarClientes() {
        try {
            String rutaEscritorio = System.getProperty("user.home") + "/Desktop/clientes_exportados.csv";
            try (FileWriter writer = new FileWriter(rutaEscritorio)) {
                writer.write("ID,Nombre,Apellidos,Celular,RFC,Correo\n");
                List<Clientesclass> clientes = new Clientesclass().obtenerClientes();
                for (Clientesclass c : clientes) {
                    writer.write(c.getId() + "," + c.getNombre() + "," + c.getApellidos() + "," +
                                 c.getCelular() + "," + c.getRfc() + "," + c.getCorreo() + "\n");
                }
            }
            return "Clientes exportados correctamente a tu Escritorio.";
        } catch (IOException e) {
            return "Error al exportar: " + e.getMessage();
        }
    }
}
