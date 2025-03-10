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
