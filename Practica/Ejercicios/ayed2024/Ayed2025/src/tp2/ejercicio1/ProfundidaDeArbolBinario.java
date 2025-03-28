package tp2.ejercicio1;

import tp3.ejercicio1.Queue;

public class ProfundidaDeArbolBinario {
	
	BinaryTree<Integer> arbol;
	
	public ProfundidaDeArbolBinario(BinaryTree<Integer> arbol)
	{
		this.arbol=arbol;
	}
	
	public int sumaElementosProfundidad(int p){

		int cantNodos = 0;
		
		if(!arbol.isEmpty())
		{
			Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
			BinaryTree<Integer> aux;
			int contNivel=0;
			
			
			cola.enqueue(arbol);
			cola.enqueue(null);
			
			while(!cola.isEmpty() && contNivel<=p)
			{
				aux= cola.dequeue();
				
				if(aux!=null)
				{
					if(contNivel == p)
					{
						cantNodos++;
					}
					
					if(aux.hasLeftChild())
					{
						cola.enqueue(aux.getLeftChild());
					}
					if(aux.hasRightChild())
					{
						cola.enqueue(aux.getRightChild());
					}
				}
				else
				{
					contNivel++;
					if(!cola.isEmpty())
					{
						cola.enqueue(null);
					}
					
				}
			}
		}
		
		return cantNodos;
   }
}
