package tp5.ejercicio1.adjList;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class QuedateEnCasa {

	public List<Persona> bfs(Graph<Persona> grafo, Persona empleado, int gradoSeparacion)
	{
		List<Persona> lista = new ArrayList<>();
		boolean[] visitados = new boolean[grafo.getVertices().size()];
		Queue<Vertex<Persona>> c = new Queue<Vertex<Persona>>();
		Vertex<Persona> aux;
		int distancia=1;
		
		for (Vertex<Persona> i: grafo.getVertices())
		{
			if(i.getData() == empleado)
			{
				for (Edge<Persona> e : grafo.getEdges(i))
				{
					if(!visitados[e.getTarget().getPosition()]&&e.getTarget().getData().esJubilado())
					{
						c.enqueue(e.getTarget());
					}
				}
			}
		}
		
		while(!c.isEmpty() && distancia<=gradoSeparacion && lista.size()<=40)
		{
			aux = c.dequeue();
			
			if(aux!=null)
			{	
					//lista.add(aux.getData());
					
					if(!visitados[aux.getPosition()])
					{
						lista.add(aux.getData());
					}
					
					visitados[aux.getPosition()] = true;
					
					for (Edge<Persona> e : grafo.getEdges(aux))
					{
						if(!visitados[e.getTarget().getPosition()]&&e.getTarget().getData().esJubilado())
						{
							c.enqueue(e.getTarget());
						}
					}
				
			}
			else
			{
				distancia++;
				if(!c.isEmpty())
				{
					c.enqueue(null);
				}
			}
			
		}
		
		return lista;
	}
}
