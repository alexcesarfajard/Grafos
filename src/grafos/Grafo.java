/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

/**
 *
 * @author Usuario
 */
public class Grafo {
    
    private Nodo[] nodos;
    private int[][] matrizAdyacencia;
    
    public Grafo(int cantidadNodos){
        nodos = new Nodo[cantidadNodos];
        //Espacio para generar una matriz de adyacencia
        
        matrizAdyacencia = new int[cantidadNodos][cantidadNodos];
        
        //Agregando valores a los nodos
        for(int i = 0;  i < cantidadNodos; i++){
            nodos[i] = new Nodo(i);
        }
    }
    
    public void agregarArista(int nodoOrigen, int nodoDestino){
        //Lo vamos a generar alimentando la matriz 
        matrizAdyacencia[nodoOrigen][nodoDestino] = 1;
        matrizAdyacencia[nodoDestino][nodoOrigen] = 1;
        
        
    }
    
    public void imprimirMatrizAdyacencia(){
        for (int i = 0; i < matrizAdyacencia.length ; i++) {
            for (int j = 0; j < matrizAdyacencia.length ; j++) {
                System.out.print(matrizAdyacencia[i][j]);
            }
            System.out.println();
        }
    }
    
}
