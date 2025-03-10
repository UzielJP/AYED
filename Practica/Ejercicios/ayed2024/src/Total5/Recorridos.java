package Total5;

import java.util.ArrayList;
import java.util.List;

public class Recorridos<T> {

	Graph<T> grafo = new AdjListEdge<T>();
	
	
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
		
		visitados[origen.getPosition()-1] = true;
		for(Edge<T> e : grafo.getEdges(origen))
		{
			if(!visitados[e.getTarget().getPosition()])
			{
				this.dfs(e.getTarget(), visitados, lista, grafo);
			}
		}
	}
	
}
