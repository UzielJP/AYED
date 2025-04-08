package tp5.ejercicio1.adjList;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Bosque {

	private Graph<String> grafo;
	
	public Bosque(Graph grafo)
	{
		this.grafo=grafo;
	}
	
	/**
	 * Retrieves the safest paths in the graph starting from the vertex labeled "Casa Caperucita".
	 * The method utilizes depth-first search to identify paths that meet safety criteria, based
	 * on an additional private implementation. The result contains a collection of these paths.
	 *
	 * @return A list of the safest paths, where each path is represented as a list of strings.
	 *         Returns null if the starting vertex "Casa Caperucita" is not found in the graph.
	 */
	public List <List<String>> recorridosMasSeguro ()
	{
		List <List<String>> resultado = new ArrayList<>();
		List<String> camino = new ArrayList<>();
		boolean[] visitados = new boolean[this.grafo.getVertices().size()];
		for (Vertex<String> i: this.grafo.getVertices())
		{
			if(i.getData()=="Casa Caperucita")
			{
				return recorridosMasSeguro(i, visitados,camino,resultado);
			}
		}
		return null;
	}
	
	/**
	 * Finds the safest paths from a given starting vertex to a specific destination in the graph, avoiding
	 * edges with weights greater than or equal to 5. It performs a depth-first search to explore all
	 * possible paths while tracking visited vertices and constructing valid paths.
	 *
	 * @param origen The starting vertex for calculating the paths.
	 * @param visitados An array indicating the visited state of each vertex in the graph.
	 * @param camino A list representing the current path being constructed.
	 * @param resultado A list of lists containing all valid and safe paths found.
	 * @return A list of safe paths, where each path is represented as a list of strings.
	 */
	private List<List<String>> recorridosMasSeguro(Vertex<String> origen, boolean[] visitados, List<String> camino, List <List<String>> resultado)
	{
		camino.add(origen.getData());
		visitados[origen.getPosition()] = true;
		
		if(origen.getData()=="Casa Abuelita")
		{
			resultado.add(new ArrayList<>(camino));
		}
		else
		{
	
			for(Edge<String> e : this.grafo.getEdges(origen))
			{
				
				boolean ok = true;
			
				if(e.getWeight()>=5)
				{
					ok = false;
				}
				
				if(!visitados[e.getTarget().getPosition()]&&ok)
				{
					resultado = this.recorridosMasSeguro(e.getTarget(), visitados,camino,resultado);
					visitados[e.getTarget().getPosition()] = false;
					camino.remove(camino.size()-1);
				}
				
			}
			
		}	
		
		return resultado;
	}
	
	
}
