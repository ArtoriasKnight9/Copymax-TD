/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Admin
 */

import java.util.ArrayList;
import java.util.List;

public class StockNotifier {
    private static StockNotifier instance;
    private List<StockObserver> observadores;

    private StockNotifier() {
        observadores = new ArrayList<>();
    }

    public static StockNotifier getInstance() {
        if (instance == null) {
            instance = new StockNotifier();
        }
        return instance;
    }

    public void agregarObservador(StockObserver observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(StockObserver observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        for (StockObserver obs : observadores) {
            obs.actualizarStock();
        }
    }
}

