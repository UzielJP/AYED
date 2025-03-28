package tp3.ejercicio1;

public class ParcialArboles11 {

	public boolean resolver(GeneralTree<Integer> arbol)
	{
		boolean ok = true;
		if(!arbol.isEmpty())
		{
			Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
			GeneralTree<Integer> aux;
			int hijosPorNivel = 1;
			int nivel = 0;
			int hijos = 0;
			
			
			cola.enqueue(arbol);
			cola.enqueue(null);
			
			System.out.println("Entramos al primer if");
			while(!cola.isEmpty() && ok==true)
			{
				aux = cola.dequeue();
				
				if(aux!=null)
				{
					hijos++;
					if(aux.hasChildren())
					{
						for (GeneralTree<Integer> i : aux.getChildren())
						{
							cola.enqueue(i);
						}
					}
					System.out.println("La cantidad de hijos en el nivel: "+nivel+". Es de: "+hijos);
					System.out.println("La cantidad de hijos en el nivel: "+nivel+". Que debe tener es de : "+hijosPorNivel);
				}
				else
				{
					System.out.println("Subida de nivel");
					if(hijosPorNivel!=hijos)
					{
						ok = false;	
					}
					if(!cola.isEmpty())
					{
						cola.enqueue(null);
					}
					hijosPorNivel++;
					nivel++;
					hijos = 0;
				}
			}
		}
		else
		{
			ok = false;
		}
		
		return ok;
	}
	
}
