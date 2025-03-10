package tp5.ejercicio1.adjList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Mapa {

	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> mapaCiudades)
	{
		this.mapaCiudades=mapaCiudades;
	}
	
	public List<String> caminoConMenorCargaDeCombustible (String origen, String destino,int tanqueAuto)
	{
		Minimo minimo = new Minimo(Integer.MAX_VALUE);
		int valorOriginal = tanqueAuto;
		int cantActual = 0;
		List<String> resultado = new ArrayList<>();
		List<String> camino = new ArrayList<>();
		boolean[] visitados = new boolean[this.mapaCiudades.getVertices().size()];
		for (Vertex<String> i: this.mapaCiudades.getVertices())
		{
			if(i.getData()==origen)
			{
				return caminoConMenorCargaDeCombustible(i, visitados, this.mapaCiudades, destino,camino,resultado,tanqueAuto,minimo,valorOriginal,cantActual);
			}
		}
		return null;
	}
	
	private List<String> caminoConMenorCargaDeCombustible(Vertex<String> origen, boolean[] visitados, Graph<String> grafo, String destino, List<String> camino, List<String> resultado,int tanqueAuto,Minimo minimo,int valorOriginal,int cantActual)
	{
		camino.add(origen.getData());
		visitados[origen.getPosition()] = true;
		
		System.out.println("La cantidad actual es de: "+cantActual);
		System.out.println("La tanqueAuto actual es de: "+tanqueAuto);
		System.out.println("¿tanqueAuto actual es mayor a 0?: "+(tanqueAuto<=0));
		System.out.println("La provincia actual es: "+origen.getData());
		
		if(tanqueAuto<=0)
		{
			
			tanqueAuto=valorOriginal;
			cantActual++;
			
		}
		
		System.out.println("La cantidad nueva es de: "+cantActual);
		
		if(origen.getData()==destino)
		{
			if(minimo.getMinimo()>cantActual)
			{
				minimo.setMinimo(cantActual);
				resultado.removeAll(resultado);
				resultado.addAll(camino);
			}
		}
		else
		{
			for(Edge<String> e : grafo.getEdges(origen))
			{	
				if(!visitados[e.getTarget().getPosition()])
				{
					
					tanqueAuto-=e.getWeight();
					resultado = this.caminoConMenorCargaDeCombustible(e.getTarget(), visitados, grafo, destino,camino,resultado,tanqueAuto,minimo,valorOriginal,cantActual);
					visitados[e.getTarget().getPosition()] = false;
					camino.remove(camino.size()-1);
					tanqueAuto+=e.getWeight();
					
				}
				
			}
			
		}	
		
		return resultado;
	}
	
	public List<String> caminoSinCargarCombustible (String origen, String destino,int tanqueAuto)
	{
		List<String> resultado = new ArrayList<>();
		List<String> camino = new ArrayList<>();
		boolean[] visitados = new boolean[this.mapaCiudades.getVertices().size()];
		for (Vertex<String> i: this.mapaCiudades.getVertices())
		{
			if(i.getData()==origen)
			{
				return caminoSinCargarCombustible(i, visitados, this.mapaCiudades, destino,camino,resultado,tanqueAuto);
			}
		}
		return null;
	}
	
	private List<String> caminoSinCargarCombustible(Vertex<String> origen, boolean[] visitados, Graph<String> grafo, String destino, List<String> camino, List<String> resultado,int tanqueAuto)
	{
		camino.add(origen.getData());
		visitados[origen.getPosition()] = true;
		
		if(origen.getData()==destino)
		{
			if(tanqueAuto>0)
			{
				resultado.removeAll(resultado);
				resultado.addAll(camino);
				return resultado;
			}
		}
		else
		{
			for(Edge<String> e : grafo.getEdges(origen))
			{	
				if(!visitados[e.getTarget().getPosition()])
				{
					tanqueAuto-=e.getWeight();
					resultado = this.caminoSinCargarCombustible(e.getTarget(), visitados, grafo, destino,camino,resultado,tanqueAuto);
					visitados[e.getTarget().getPosition()] = false;
					camino.remove(camino.size()-1);
					tanqueAuto+=e.getWeight();
				}
				
			}
			
		}	
		
		return resultado;
	}
	
	public List<String> caminoMasCorto (String origen, String destino)
	{
		String s = "hola";
		List<String> resultado = new ArrayList<>(Collections.nCopies(1000,s));
		List<String> camino = new ArrayList<>();
		boolean[] visitados = new boolean[this.mapaCiudades.getVertices().size()];
		for (Vertex<String> i: this.mapaCiudades.getVertices())
		{
			if(i.getData()==origen)
			{
				return caminoMasCorto(i, visitados, this.mapaCiudades, destino,camino,resultado);
			}
		}
		return null;
	}
	
	private List<String> caminoMasCorto(Vertex<String> origen, boolean[] visitados, Graph<String> grafo, String destino, List<String> camino, List<String> resultado)
	{
		camino.add(origen.getData());
		visitados[origen.getPosition()] = true;
		
		if(origen.getData()==destino)
		{
			if(camino.size()<resultado.size())
			{
				resultado.removeAll(resultado);
				resultado.addAll(camino);
			}
		}
		else
		{
	
			for(Edge<String> e : grafo.getEdges(origen))
			{	
				if(!visitados[e.getTarget().getPosition()])
				{
					resultado = this.caminoMasCorto(e.getTarget(), visitados, grafo, destino,camino,resultado);
					visitados[e.getTarget().getPosition()] = false;
					camino.remove(camino.size()-1);
				}
				
			}
			
		}	
		
		return resultado;
	}
	
	public List<String> devolverCaminoExceptuando (String origen, String destino, List<String> ciudades)
	{
		List<String> resultado = new ArrayList<>();
		List<String> camino = new ArrayList<>();
		boolean[] visitados = new boolean[this.mapaCiudades.getVertices().size()];
		for (Vertex<String> i: this.mapaCiudades.getVertices())
		{
			if(i.getData()==origen)
			{
				return devolverCaminoExceptuando(i, visitados, this.mapaCiudades, destino,camino,resultado,ciudades);
			}
		}
		return null;
	}
	
	private List<String> devolverCaminoExceptuando(Vertex<String> origen, boolean[] visitados, Graph<String> grafo, String destino, List<String> camino, List<String> resultado, List<String> ciudades)
	{
		camino.add(origen.getData());
		visitados[origen.getPosition()] = true;
		
		if(origen.getData()==destino)
		{
			
			resultado.removeAll(resultado);
			resultado.addAll(camino);
			return resultado;
			
		}
		else
		{
	
			for(Edge<String> e : grafo.getEdges(origen))
			{
				
				boolean ok = true;
				
				for (String s : ciudades)
				{
					if(e.getTarget().getData()==s)
					{
						ok = false;
					}
				}
				
				if(!visitados[e.getTarget().getPosition()]&&ok)
				{
					resultado = this.devolverCaminoExceptuando(e.getTarget(), visitados, grafo, destino,camino,resultado,ciudades);
					camino.remove(camino.size()-1);
				}
				
			}
			
		}	
		
		return resultado;
	}
	
	public List<String> devolverCamino(String origen, String destino)
	{
		List<String> resultado = new ArrayList<>();
		List<String> camino = new ArrayList<>();
		boolean[] visitados = new boolean[this.mapaCiudades.getVertices().size()];
		
		for (Vertex<String> i: this.mapaCiudades.getVertices())
		{
			if(i.getData()==origen)
			{
				return devolverCamino(i, visitados, this.mapaCiudades, destino,camino,resultado);
			}
		}
		
		return null;
	}
	
	private List<String> devolverCamino(Vertex<String> origen, boolean[] visitados, Graph<String> grafo, String destino, List<String> camino, List<String> resultado)
	{
		
		camino.add(origen.getData());
		visitados[origen.getPosition()] = true;
		
		if(origen.getData()==destino)
		{
			
			resultado.removeAll(resultado);
			resultado.addAll(camino);
			return resultado;
			
		}
		else
		{
	
			for(Edge<String> e : grafo.getEdges(origen))
			{
				if(!visitados[e.getTarget().getPosition()])
				{
					resultado = this.devolverCamino(e.getTarget(), visitados, grafo, destino,camino,resultado);
					camino.remove(camino.size()-1);
				}
			}
			
		}	
		
		return resultado;
	}
	
}
