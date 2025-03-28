package tp3.ejercicio1;

public class AnalizarArbol {

	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> ab)
	{
		double max=0;
		
		if(!ab.isEmpty())
		{
			Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
			GeneralTree<AreaEmpresa> aux;
			double promedioHijo = 0;
			int e = 0;
			int contNivel = 0;
			
			cola.enqueue(ab);
			cola.enqueue(null);

			
			while(!cola.isEmpty())
			{
				
				aux= cola.dequeue();
				
				if(aux!=null)
				{
					promedioHijo+=aux.getData().getTardanza();
					e++;
					
					if(aux.hasChildren())
					{
						for (GeneralTree<AreaEmpresa> h : aux.getChildren())
						{
							cola.enqueue(h);
						}
					}
				}
				else
				{
					contNivel++;
					promedioHijo = promedioHijo/e;
					System.out.println("La cantidad de hijos es de: "+e);
					System.out.println("El promedio por hijo es de: "+promedioHijo);
					if(promedioHijo>max)
					{
						max=promedioHijo;
					}
					e = 0;
					promedioHijo = 0;
					if(!cola.isEmpty())
					{
						cola.enqueue(null);
					}
					
				}
			}
		}
		
		return max;
	}
}
