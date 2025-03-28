package Total5;

import java.util.List;

public class MainEjercicio2 {
	public static void main(String[] args) {
        // Crear un grafo de enteros
        Graph<Integer> grafo = new AdjListGraph<Integer>();
        
        // Agregar vértices al grafo
        Vertex<Integer> v1 = grafo.createVertex(1);
        Vertex<Integer> v2 = grafo.createVertex(2);
        Vertex<Integer> v3 = grafo.createVertex(3);
        Vertex<Integer> v4 = grafo.createVertex(4);
        Vertex<Integer> v5 = grafo.createVertex(5);

        // Conectar los vértices
        grafo.connect(v1, v2);
        grafo.connect(v1, v3);
        grafo.connect(v2, v4);
        grafo.connect(v3, v5);
        grafo.connect(v4, v5);

        // Instanciar la clase Recorridos y ejecutar DFS
        Recorridos<Integer> recorridos = new Recorridos<>();
        List<Integer> dfsResult = recorridos.dfs(grafo);

        // Imprimir el resultado del DFS
        System.out.println("Recorrido DFS:");
        for (Integer dato : dfsResult) {
            System.out.print(dato + " ");
        }
    }
}
