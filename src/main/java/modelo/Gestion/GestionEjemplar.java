package modelo.Gestion;

import modelo.DTO.Ejemplar;
import modelo.DTO.Libro;
import modelo.memoria.MemoriaGN;

import java.util.*;

public class GestionEjemplar {

    MemoriaGN<Ejemplar,String> memoriaEjemplar;
    Map<String, Integer> stockEjemplares;

    public GestionEjemplar() {
        this.memoriaEjemplar = new MemoriaGN<>(Ejemplar.class);
        this.stockEjemplares = new HashMap<>();
        calcularStock();

    }
    private Map<String, Integer> calculaStockInicialXEjemplar(ArrayList<Ejemplar> ejemplars ) {
        Map<String, Integer> stockInicialXEjemplar = new HashMap<>();
        for(Ejemplar ejemplar : ejemplars){
            stockInicialXEjemplar.put(ejemplar.getIsbn().getIsbn(), stockInicialXEjemplar.getOrDefault(ejemplar.getIsbn().getIsbn(), 0) + 1);
        }
        return stockInicialXEjemplar;
    }

    private Map<String, int[]> calcularEstado(ArrayList<Ejemplar> ejemplars){
        Map<String, int[]> estado = new HashMap<>();
        for(Ejemplar ejemplar : ejemplars){
            if (!estado.containsKey(ejemplar.getIsbn().getIsbn())) {
                estado.putIfAbsent(ejemplar.getIsbn().getIsbn(), new int[3]);
            }
            if (ejemplar.getEstado().equals("Disponible")) {
                estado.get(ejemplar.getIsbn().getIsbn())[0]++;
            } else if (ejemplar.getEstado().equals("Prestado")) {
                estado.get(ejemplar.getIsbn().getIsbn())[1]++;
            } else if (ejemplar.getEstado().equals("Dañado")) {
                estado.get(ejemplar.getIsbn().getIsbn())[2]++;
            }

        }
        return estado;
    }

    public void calcularStock(){
        ArrayList<Ejemplar> ejemplars = new ArrayList<>(memoriaEjemplar.findAll());
        Map<String, int[]> estado = calcularEstado(ejemplars);
        Integer StockIniciar = 0;
        Integer CalculoEstado = 0;
        Map<String, Integer> stockInicialXEjemplar = calculaStockInicialXEjemplar(ejemplars);
        for(Ejemplar ejemplar : ejemplars){
            if (!stockEjemplares.containsKey(ejemplar.getIsbn().getIsbn())) {
                StockIniciar = stockInicialXEjemplar.get(ejemplar.getIsbn().getIsbn());
                CalculoEstado = (estado.get(ejemplar.getIsbn().getIsbn())[0] + estado.get(ejemplar.getIsbn().getIsbn())[1] + estado.get(ejemplar.getIsbn().getIsbn())[2]);
                stockEjemplares.put(ejemplar.getIsbn().getIsbn(), StockIniciar - CalculoEstado);

            }
        }

    }

    public void pintaStock(){
        for (Map.Entry<String, Integer> entry : stockEjemplares.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public MemoriaGN<Ejemplar, String> getMemoriaEjemplar() {
        return memoriaEjemplar;
    }

    public void setMemoriaEjemplar(MemoriaGN<Ejemplar, String> memoriaEjemplar) {
        this.memoriaEjemplar = memoriaEjemplar;
    }

    public Map<String, Integer> getStockEjemplares() {
        return stockEjemplares;
    }

    public void setStockEjemplares(Map<String, Integer> stockEjemplares) {
        this.stockEjemplares = stockEjemplares;
    }

    public static void main(String[] args) {
        GestionEjemplar gestion = new GestionEjemplar();
        gestion.pintaStock();

    }

}
