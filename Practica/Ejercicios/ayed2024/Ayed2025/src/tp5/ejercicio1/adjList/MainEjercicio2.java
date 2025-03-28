package tp5.ejercicio1.adjList;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class MainEjercicio2 {
	public static void main(String[] args) {

		// EJERCICIO 3:
		
		// Crear una instancia del grafo usando la implementación AdjListGraph
        Graph<String> grafoCiudades = new AdjListGraph<>();
        
        // Agregar vértices (ciudades)
        Vertex<String> buenosAires = grafoCiudades.createVertex("Buenos Aires");
        Vertex<String> cordoba = grafoCiudades.createVertex("Córdoba");
        Vertex<String> rosario = grafoCiudades.createVertex("Rosario");
        Vertex<String> mendoza = grafoCiudades.createVertex("Mendoza");
        Vertex<String> salta = grafoCiudades.createVertex("Salta");
        
        // Conectar las ciudades con aristas
        grafoCiudades.connect(buenosAires, rosario, 3);
        grafoCiudades.connect(rosario, cordoba, 2);
        grafoCiudades.connect(cordoba, mendoza, 4);
        grafoCiudades.connect(buenosAires, salta, 6);
        grafoCiudades.connect(salta, mendoza, 5);
        
        // Crear una instancia de Mapa usando el grafo
        Mapa mapa = new Mapa(grafoCiudades);
        
        List<String> excepto = new ArrayList<>();
        excepto.add("Rosario");
        excepto.add("Salta");
        
        // Probar el método devolverCamino
        String origen = "Buenos Aires";
        String destino = "Mendoza";
        List<String> camino = mapa.devolverCamino(origen, destino);
        List<String> caminoExcepto = mapa.devolverCaminoExceptuando(origen, destino, excepto);
        List<String> caminoMasCorto = mapa.caminoMasCorto(origen, destino);
        List<String> sinCargarCombustible = mapa.caminoSinCargarCombustible(origen, destino, 100);
        List<String> caminoConMenorCargaDeCombustible = mapa.caminoConMenorCargaDeCombustible(origen, destino, 10);
        
        
        // Imprimir el resultado
        if (camino != null && !camino.isEmpty()) {
            System.out.println("Camino encontrado de " + origen + " a " + destino + ": " + camino);
        } else {
            System.out.println("No se encontró un camino de " + origen + " a " + destino);
        }
		
        
        if (caminoExcepto != null && !caminoExcepto.isEmpty()) {
            System.out.println("Camino encontrado de " + origen + " a " + destino + ": " + caminoExcepto);
        } else {
            System.out.println("No se encontró un camino de " + origen + " a " + destino);
        }
		
        
        if (caminoMasCorto != null && !caminoMasCorto.isEmpty()) {
            System.out.println("Camino encontrado de " + origen + " a " + destino + ": " + caminoMasCorto);
        } else {
            System.out.println("No se encontró un camino de " + origen + " a " + destino);
        }
        
        
        if (sinCargarCombustible != null && !sinCargarCombustible.isEmpty()) {
            System.out.println("Camino encontrado de " + origen + " a " + destino + ": " + sinCargarCombustible);
        } else {
            System.out.println("No se encontró un camino de " + origen + " a " + destino);
        }
        
        if (caminoConMenorCargaDeCombustible != null && !caminoConMenorCargaDeCombustible.isEmpty()) {
            System.out.println("Camino encontrado de " + origen + " a " + destino + ": " + caminoConMenorCargaDeCombustible);
        } else {
            System.out.println("No se encontró un camino de " + origen + " a " + destino);
        }
        
        // EJERCICIO 4:
        
        Graph<String> grafoCiudades2 = new AdjListGraph<>();
        
        // Agregar vértices (ciudades)
        Vertex<String> buenosAires2 = grafoCiudades2.createVertex("Buenos Aires");
        Vertex<String> cordoba2 = grafoCiudades2.createVertex("Córdoba");
        Vertex<String> rosario2 = grafoCiudades2.createVertex("Rosario");
        Vertex<String> mendoza2 = grafoCiudades2.createVertex("Mendoza");
        Vertex<String> salta2 = grafoCiudades2.createVertex("Salta");
        
        // Conectar las ciudades con aristas
        grafoCiudades2.connect(buenosAires2, rosario2, 30);
        grafoCiudades2.connect(rosario2, cordoba2, 20);
        grafoCiudades2.connect(cordoba2, mendoza2, 40);
        grafoCiudades2.connect(buenosAires2, salta2, 80);
        grafoCiudades2.connect(mendoza2, salta2, 60);
        grafoCiudades2.connect(salta2, mendoza2, 50);
        
        List<String> excepto2 = new ArrayList<>();
        excepto2.add("Rosario");
        
        VisitaOslo oslo = new VisitaOslo();
        
        List<String> camino2 = oslo.paseoEnBici(grafoCiudades2,destino,150,excepto2);
        
        if (camino2 != null && !camino2.isEmpty()) {
            System.out.println("Oslo: Camino encontrado de " + origen + " a " + destino + ": " + camino2);
        } else {
            System.out.println("Oslo: No se encontró un camino de " + origen + " a " + destino);
        }
		/*
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
        
        List<Integer> bfsResult = recorridos.bfs(grafo);

        // Imprimir el resultado del DFS
        System.out.println("Recorrido DFS:");
        for (Integer dato : dfsResult) {
            System.out.println(dato + " ");
        }
        
        System.out.println("Recorrido BFS:");
        for (Integer dato : bfsResult) {
            System.out.println(dato + " ");
        */
		
        }
        
}

