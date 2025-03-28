package tp5.ejercicio1.adjList;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Recorridos<T> {
	
	public List<T> dfs(Graph<T> grafo)
	{
		boolean[] visitados = new boolean[grafo.getVertices().size()];
		List<T> lista = new ArrayList<T>();
		dfs(grafo.getVertex(0),visitados,lista,grafo);
		return lista;
	}
	
	private void dfs(Vertex<T> origen, boolean[] visitados, List<T> lista, Graph<T> grafo)
	{
		if(!visitados[origen.getPosition()])
		{
			lista.add(origen.getData());
		}
		
		visitados[origen.getPosition()] = true;
		for(Edge<T> e : grafo.getEdges(origen))
		{
			if(!visitados[e.getTarget().getPosition()])
			{
				this.dfs(e.getTarget(), visitados, lista, grafo);
			}
		}
	}
	
	public List<T> bfs(Graph<T> grafo)
	{
		List<T> lista = new ArrayList<T>();
		boolean[] visitados = new boolean[grafo.getVertices().size()];
		Queue<Vertex<T>> c = new Queue<Vertex<T>>();
		Vertex<T> aux;
		
		c.enqueue(grafo.getVertex(0));
		
		while(!c.isEmpty())
		{
			aux = c.dequeue();
			
			if(!visitados[aux.getPosition()])
			{
				lista.add(aux.getData());
			}
			visitados[aux.getPosition()] = true;
			
			for (Edge<T> e : grafo.getEdges(aux))
			{
				if(!visitados[e.getTarget().getPosition()])
				{
					c.enqueue(e.getTarget());
				}
			}
		}
		
		return lista;
	}
}
