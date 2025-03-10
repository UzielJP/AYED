package tp2.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class ContadorArbol {

	BinaryTree<Integer> arbol;
	
	public List<Integer> numerosParesInOrden()
	{
		List<Integer> lista = new ArrayList<Integer>();
		this.numerosParesInOrden(this.arbol,lista);
		return lista;
	}
	
	public void numerosParesInOrden(BinaryTree<Integer> arbol, List<Integer> lista)
	{
		if(!arbol.isEmpty())
		{
			if(arbol.hasLeftChild())
			{
				this.numerosParesInOrden(arbol.getLeftChild(),lista);
			}
			
			if(arbol.getData()%2==0)
			{
				lista.add(arbol.getData());
			}
			
			if(arbol.hasRightChild())
			{
				this.numerosParesInOrden(arbol.getRightChild(),lista);
			}
		}
	}
	
	public List<Integer> numerosParesPostOrden()
	{
		List<Integer> lista = new ArrayList<Integer>();
		this.numerosParesPostOrden(this.arbol,lista);
		return lista;
	}
	
	public void numerosParesPostOrden(BinaryTree<Integer> arbol, List<Integer> lista)
	{
		if(!arbol.isEmpty())
		{
			if(arbol.hasLeftChild())
			{
				this.numerosParesPostOrden(arbol.getLeftChild(),lista);
			}
			
			if(arbol.hasRightChild())
			{
				this.numerosParesPostOrden(arbol.getRightChild(),lista);
			}
			
			if(arbol.getData()%2==0)
			{
				lista.add(arbol.getData());
			}
		}
	}
	
	/*
	public BinaryTree<Integer> numerosParesInOrden()
	{
		BinaryTree<Integer> par= new BinaryTree<Integer>();
		if(!this.arbol.isEmpty())
		{
			if(this.arbol.getData()%2==0)
			{
				par = arbol;
			}
			if(!this.arbol.getLeftChild().isEmpty())
			{
				if(this.arbol.getLeftChild().getData()%2 == 0)
				{
					par.addLeftChild(this.arbol.getLeftChild());
				}
			}
			if(!this.arbol.getRightChild().isEmpty())
			{
				if(this.arbol.getRightChild().getData()%2 ==0)
				{
					par.addRightChild(this.arbol.getRightChild());
				}
			}
		}
		return par;
	}
	*/
	
}
