package grafos;

public class Grafos {

    public static void main(String[] args) {
        // TODO code application logic here 
        Grafo g = new Grafo(6);
        
        g.agregarArista(0, 1);
        g.agregarArista(1, 2);
        g.agregarArista(2, 3);
        g.agregarArista(3, 4);
        g.agregarArista(4, 5);
        g.agregarArista(1, 3);
        g.agregarArista(0, 4);
        
        g.imprimirMatrizAdyacencia();
        
        g.recorrerProfundidad(3);
        g.recorridoAmplitud(3);
    }
    
}
