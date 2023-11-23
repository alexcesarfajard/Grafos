package grafos;

public class Grafo {

    private Nodo[] nodos;
    private int[][] matrizAdyacencia;

    public Grafo(int cantidadNodos) {
        nodos = new Nodo[cantidadNodos];
        //Espacio para generar una matriz de adyacencia

        matrizAdyacencia = new int[cantidadNodos][cantidadNodos];

        //Agregando valores a los nodos
        for (int i = 0; i < cantidadNodos; i++) {
            nodos[i] = new Nodo(i);
        }
    }

    public void agregarArista(int nodoOrigen, int nodoDestino) {
        //Lo vamos a generar alimentando la matriz 
        matrizAdyacencia[nodoOrigen][nodoDestino] = 1;
        matrizAdyacencia[nodoDestino][nodoOrigen] = 1;
    }

    public void imprimirMatrizAdyacencia() {
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia.length; j++) {
                System.out.print(matrizAdyacencia[i][j]);
            }
            System.out.println();
        }
    }

    //Recorrido a profundidad
    public Nodo[] recorrerProfundidad(int nodoInicial) {
        Nodo[] nodosVisitados = new Nodo[nodos.length];
        boolean[] visitado = new boolean[nodos.length];

        recorridoProfundidadRecursivo(nodoInicial, visitado, nodosVisitados, 0);
        System.out.println("Nodos visitados a profundidad: ");
        for (int i = 0; i < nodosVisitados.length; i++) {
            System.out.println(nodosVisitados[i].getValor());
        }

        return nodosVisitados;
    }

    private int recorridoProfundidadRecursivo(int nodo, boolean[] visitados, Nodo[] nodosVisitados, int idx) {
        /*
        una vez que entramos al metodo, vamos a definir como true la posicion del nodo en la lista de visitados
        para marcarlo como un nodo por el que ya pasamos en algun momento, le asignamos un true
         */
        visitados[nodo] = true;

        //vamos a almacenar segun el recorrido de la arista (idx) el nodo del grafo original al cual estamos accediendo en el recorrido
        //le sumamos un 1 al recorrido de la arista (idx) para que nos de un valor de 1 en adelante 
        //y nos permite una mejor lectura de los nodos visitados
        nodosVisitados[idx++] = nodos[nodo];

        //vamos a recorrer todos los nodos del grafo, siempre y cuando no hayan sido visitados, 
        //y no se encuentren ya almacenados en la lista de nodos 
        for (int i = 0; i < nodos.length; i++) {
            if (matrizAdyacencia[nodo][i] == 1 && !visitados[i]) {
                // si el nodo que estamos evaluando tiene relacion con cualquier otro de los nodos del grafo 
                //y aun no se le ha visitado, entonces lo almacenamos (como un identificador de arista(idx) y seguimos el recorrido
                idx = recorridoProfundidadRecursivo(i, visitados, nodosVisitados, idx);
            }
        }
        return idx;
    }

    //busqueda por amplitud 
    public Nodo[] recorridoAmplitud(int nodoInicial) {

        Nodo[] nodosVisitados = new Nodo[nodos.length];
        boolean[] visitado = new boolean[nodos.length];
        int frente = 0;
        int finalcola = 0;
        int[] cola = new int[nodos.length];
        
        visitado[nodoInicial] = true;
        cola[finalcola++] = nodoInicial;

        while (frente != finalcola) {
            int nodoPorAtender = cola[frente++];
            nodosVisitados[frente - 1] = nodos[nodoPorAtender];

            for (int i = 0; i < nodos.length; i++) {
                if (matrizAdyacencia[nodoPorAtender][i] == 1 && !visitado[i]) {
                    visitado[i] = true;
                    cola[finalcola++] = i;
                }
            }

        }

        System.out.println("Nodos visitados a amplitud: ");
        for (int i = 0; i < nodosVisitados.length; i++) {
            System.out.println(nodosVisitados[i].getValor());
        }

        return nodosVisitados;
    }
}
