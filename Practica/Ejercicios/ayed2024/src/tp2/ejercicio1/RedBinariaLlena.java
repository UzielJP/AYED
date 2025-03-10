package tp2.ejercicio1;

import tp3.ejercicio1.Queue;

public class RedBinariaLlena
{

	BinaryTree<Integer> arbol;
	
	public RedBinariaLlena(BinaryTree<Integer> arbol)
	{
		this.arbol=arbol;
	}
	
	public int entreNiveles(){
		int contador = 0;
		if(!this.arbol.isEmpty())
		{
			Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
			BinaryTree<Integer> aux;
			
			cola.enqueue(this.arbol);
			cola.enqueue(null);
			
			while(!cola.isEmpty())
			{
				aux= cola.dequeue();
				
				if(aux!=null)
				{
					contador+=aux.getData();
					
					if(aux.hasLeftChild()&&aux.hasRightChild())
					{
						if(aux.getLeftChild().getData()>aux.getRightChild().getData())
						{
							cola.enqueue(aux.getLeftChild());
						}
						else
						{
							cola.enqueue(aux.getRightChild());
						}
					}
					else
					{
						if(aux.hasLeftChild())
						{
							cola.enqueue(aux.getLeftChild());
						}
						if(aux.hasRightChild())
						{
							cola.enqueue(aux.getRightChild());
						}
					}
				}
				else
				{
					if(!cola.isEmpty())
					{
						cola.enqueue(null);
					}
					
				}
			}
		}
		return contador;
	}
	
	//Opcion b:
	/*
	 	public int retardoEnvio() {
		if (this.abb.esVacio())
			return 0;
		return this.retardoEnvio(this.abb);
	}

	private int retardoEnvio(ArbolBinario<Integer> ab) {
		if (ab.esHoja()) {
			return ab.getDato();
		}
		if (ab.esVacio())
			return 0;
		else {
			int cant=0;
			int izq=0;
			int dcho=0;
			if (ab.tieneHijoDerecho())
				dcho= this.retardoEnvio(ab.getHijoDerecho());
			if (ab.tieneHijoIzquierdo())
				izq=this.retardoEnvio(ab.getHijoIzquierdo());
			
			int max= Math.max(izq,dcho);
			return ab.getDato()+ max;	
		}
	*/
}
