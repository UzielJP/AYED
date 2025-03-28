package tp3.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class RecorridosAG {
	
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n)
	{
		List<Integer> l = new ArrayList<Integer>();
		return this.numerosImparesMayoresQuePreOrden(a,n,l);
	}
	
	private List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n, List<Integer> l)
	{
		if(a.getData()%2==1 && a.getData()>n)
		{
			System.out.println(a.getData());
			l.add(a.getData());
		}
		
		if(!a.isLeaf())
		{
			for (GeneralTree <Integer> h : a.getChildren())
			{
				l = this.numerosImparesMayoresQuePreOrden(h,n,l);
			}
		}
		
		return l;
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n)
	{
		List<Integer> l = new ArrayList<Integer>();
		return this.numerosImparesMayoresQuePostOrden(a,n,l);
	}
	
	private List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n, List<Integer> l)
	{
		
		if(!a.isLeaf())
		{
			for (GeneralTree <Integer> h : a.getChildren())
			{
				l = this.numerosImparesMayoresQuePostOrden(h,n,l);
			}
		}
		
		if(a.getData()%2==1 && a.getData()>n)
		{
			l.add(a.getData());
		}
		
		return l;
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n)
	{
		List<Integer> l = new ArrayList<Integer>();
		
		if(!a.isLeaf())
		{
			List<GeneralTree<Integer>> children = a.getChildren();
			 int mid = children.size() / 2;
			 
			 for (int i = 0; i < mid; i++) 
			 {
			        l = this.numerosImparesMayoresQueInOrden(children.get(i), n);
			 }
			 
			 if(a.getData()%2==1 && a.getData()>n)
			 {
					l.add(a.getData());
			 }
			 
			 for (int i = mid; i < children.size(); i++) 
			 {
				 l = this.numerosImparesMayoresQueInOrden(children.get(i), n);
			 }
		}
		else
		{
			if(!a.isLeaf())
			{
				for (GeneralTree <Integer> h : a.getChildren())
				{
					l = this.numerosImparesMayoresQueInOrden(h,n);
				}
			}
		}
		
		return l;
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n)
	{
		List<Integer> l = new ArrayList<Integer>();
		
		if(!a.isEmpty())
		{
			Queue<GeneralTree <Integer>> cola = new Queue<GeneralTree <Integer>>();
			GeneralTree <Integer> aux;
			int contNivel=0;
			
			boolean ok = false;
			
			cola.enqueue(a);
			cola.enqueue(null);
			
			while(!cola.isEmpty() && ok==false)
			{
				aux= cola.dequeue();
				
				if(aux!=null)
				{
					if(aux.getData()%2==1 && aux.getData()>n)
					{
						l.add(aux.getData());
					}
					
					if(aux.hasChildren())
					{
						for (GeneralTree <Integer> h : aux.getChildren())
						{
							cola.enqueue(h);
						}
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
		
		return l;
   }
}
