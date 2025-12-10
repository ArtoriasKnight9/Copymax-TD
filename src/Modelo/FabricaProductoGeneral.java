package Modelo;
    
public class FabricaProductoGeneral {

    public static Producto crearProducto(int id, String nombre, double precio, int cantidad, String categoria) {
        FabricaProductos fabrica;

        switch (categoria.toLowerCase()) {
            case "papeleria":
                fabrica = new FabricaUtilEscolar();
                break;
            case "copia/impresion":
                fabrica = new FabricaImpresion();
                break;
            case "engargolado":
                fabrica = new FabricaEngargolado();
                break;
            case "pasta":
                fabrica = new FabricaPasta();
                break;
            case "arillo":
                fabrica = new FabricaArillo();
                break;
            default:
            
                fabrica = new FabricaDefault();
                break;
        }

        return fabrica.crearProducto(id, nombre, precio, cantidad);
    }
}