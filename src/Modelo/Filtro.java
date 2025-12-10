package Modelo;

public interface Filtro {
    void setSiguiente(Filtro siguiente);
    boolean validar(String texto);
}