package Modelo;

public class FiltroSoloLetras implements Filtro {
    private Filtro siguiente;

    @Override
    public void setSiguiente(Filtro siguiente) {
        this.siguiente = siguiente;
    }
    @Override
    public boolean validar(String texto) {
        if (!texto.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
            System.out.println("Error: Solo letras y espacios permitidos.");
            return false;
        }
        return siguiente == null || siguiente.validar(texto);
    }
}