package Modelo;

import java.util.HashMap;
import java.util.Map;

public class ProductosFactory {
    private static final Map<String, Productosprecios> pool = new HashMap<>();

    public static Productosprecios getProducto(String nombre, double precio, String icono) {
        String key = nombre + "|" + precio + "|" + icono;
        if (!pool.containsKey(key)) {
            pool.put(key, new Productosprecios(nombre, precio, icono));
        }
        return pool.get(key);
    }
}
