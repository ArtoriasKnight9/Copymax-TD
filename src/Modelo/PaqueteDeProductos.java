package Modelo;

import java.util.ArrayList;
import java.util.List;

public class PaqueteDeProductos implements ComponenteProducto {
    private String nombre;
    private List<ComponenteProducto> productos = new ArrayList<>();

    public PaqueteDeProductos(String nombre) {
        this.nombre = nombre;
    }

    public void agregarProducto(ComponenteProducto producto) {
        productos.add(producto);
    }

    @Override
    public double getPrecio() {
        double total = 0;
        for (ComponenteProducto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    @Override
    public String getDescripcion() {
        StringBuilder descripcion = new StringBuilder(nombre + ":\n");
        for (ComponenteProducto producto : productos) {
            descripcion.append(" - ").append(producto.getDescripcion()).append("\n");
        }
        descripcion.append("Total: $").append(getPrecio());
        return descripcion.toString();
    }
}
