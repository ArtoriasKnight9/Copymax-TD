package Modelo;

public class FiltroLongitud implements Filtro {
    private Filtro siguiente;

    @Override
    public void setSiguiente(Filtro siguiente) {
        this.siguiente = siguiente;
    }
    @Override
    public boolean validar(String texto) {
        if (texto.length() > 30) {
            System.out.println("Error: Texto demasiado largo.");
            return false;
        }
        return siguiente == null || siguiente.validar(texto);
    }
}