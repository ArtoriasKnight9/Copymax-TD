package Adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

/**
 * Clase que adapta los objetos para convertirlos a formato JSON.
 *
 * @param <T> Tipo de objeto que se convertirá a JSON.
 */
public class JsonAdapter<T> {

    private final Gson gson;

    // Constructor que inicializa el Gson con formato bonito
    public JsonAdapter() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Convierte un objeto de tipo T a formato JSON.
     * 
     * @param objeto El objeto de tipo T que se convertirá.
     * @return El objeto convertido a formato JSON.
     */
    public String convertirAFormato(T objeto) {
        return gson.toJson(objeto);
    }

    /**
     * Convierte una lista de objetos de tipo T a formato JSON.
     * 
     * @param lista La lista de objetos de tipo T que se convertirá.
     * @return La lista convertida a formato JSON.
     */
    public String convertirAFormato(List<T> lista) {
        return gson.toJson(lista);
    }
}


