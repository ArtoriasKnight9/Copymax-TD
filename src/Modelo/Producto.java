package Modelo;
public interface Producto {
    void setId(int id);
    void setNombre(String nombre);
    void setPrecio(double precio);
    void setCantidad(int cantidad);
    void setCategoria(String categoria);

    int getId();
    String getNombre();
    double getPrecio();
    int getCantidad();
    String getCategoria();
}