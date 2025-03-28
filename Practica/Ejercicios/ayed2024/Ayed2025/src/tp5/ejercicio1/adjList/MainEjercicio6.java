package tp5.ejercicio1.adjList;

import java.util.List;

import tp5.ejercicio1.Graph;

public class MainEjercicio6 {
	
	public static void main(String[] args) {
        // Crear grafo del bosque
        Graph<String> bosque = new AdjListGraph<>();

        // Crear los vértices del bosque
        var casaCaperucita = bosque.createVertex("Casa Caperucita");
        var claro1 = bosque.createVertex("Claro 1");
        var claro2 = bosque.createVertex("Claro 2");
        var claro3 = bosque.createVertex("Claro 3");
        var claro4 = bosque.createVertex("Claro 4");
        var claro5 = bosque.createVertex("Claro 5");
        var casaAbuelita = bosque.createVertex("Casa Abuelita");

        // Conectar los vértices según el grafo proporcionado
        bosque.connect(casaCaperucita, claro1, 3);
        bosque.connect(casaCaperucita, claro2, 4);
        bosque.connect(casaCaperucita, claro3, 4);
        bosque.connect(claro1, claro5, 3);
        bosque.connect(claro2, claro1, 4);
        bosque.connect(claro2, claro4, 10);
        bosque.connect(claro3, claro5, 15);
        bosque.connect(claro4, claro5, 11);
        bosque.connect(claro5, casaAbuelita, 4);
        bosque.connect(claro4, casaAbuelita, 9);

        // Crear instancia de Bosque
        Bosque bosqueInstancia = new Bosque(bosque);

        // Obtener los recorridos más seguros
        List<List<String>> recorridos = bosqueInstancia.recorridosMasSeguro();

        // Imprimir los resultados
        System.out.println("Recorridos más seguros:");
        for (List<String> recorrido : recorridos) {
            System.out.println(recorrido);
        }
        
    }
}
