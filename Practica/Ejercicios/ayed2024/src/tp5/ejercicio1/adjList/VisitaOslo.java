package tp5.ejercicio1.adjList;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class VisitaOslo {

	public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos)
	{
		List<String> resultado = new ArrayList<>();
		List<String> camino = new ArrayList<>();
		int tiempoActual = 0;
		boolean[] visitados = new boolean[lugares.getVertices().size()];
		for (Vertex<String> i: lugares.getVertices())
		{
			if(i.getData()==destino)
			{
				return paseoEnBici(lugares.getVertex(0),visitados,lugares,destino,camino, resultado, lugaresRestringidos,maxTiempo,tiempoActual);
			}
		}
		return null;
	}
	
	private List<String> paseoEnBici(Vertex<String> origen, boolean[] visitados, Graph<String> lugares, String destino, List<String> camino, List<String> resultado, List<String> lugaresRestringidos,int maxTiempo, int tiempoActual)
	{
		camino.add(origen.getData());
		visitados[origen.getPosition()] = true;
		
		if(origen.getData()==destino)
		{
			if(tiempoActual<=maxTiempo)
			{
				resultado.removeAll(resultado);
				resultado.addAll(camino);
				return resultado;
			}
		}
		else
		{
	
			for(Edge<String> e : lugares.getEdges(origen))
			{
				
				boolean ok = true;
				
				for (String s : lugaresRestringidos)
				{
					if(e.getTarget().getData()==s)
					{
						ok = false;
					}
				}
				
				if(!visitados[e.getTarget().getPosition()]&&ok)
				{
					tiempoActual+=e.getWeight();
					resultado = this.paseoEnBici(e.getTarget(), visitados, lugares, destino, camino, resultado, lugaresRestringidos, maxTiempo, tiempoActual);
					tiempoActual-=e.getWeight();
					visitados[e.getTarget().getPosition()] = false;
					camino.remove(camino.size()-1);
				}
				
			}
			
		}	
		
		return resultado;
	}
	
}
