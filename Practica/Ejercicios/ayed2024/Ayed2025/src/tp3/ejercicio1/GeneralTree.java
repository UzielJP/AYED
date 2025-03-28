package tp3.ejercicio1;

import java.util.LinkedList;
import java.util.List;

import tp2.ejercicio1.BinaryTree;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
			
		if(this.isLeaf())
		{
			return 0;
		}
		else
		{
			int alturaMax=0;
			for(GeneralTree<T> i : this.getChildren())
			{
				int alturaHijo= i.altura();
				if(alturaHijo>alturaMax)
				{
					alturaMax=alturaHijo;
				}
			}
			return alturaMax+1;
		}
		
	}
	
	public int nivel(T dato){
			int contNivel=0;
			
			if(!this.isEmpty())
			{
				Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
				GeneralTree<T> aux;
				
				boolean ok = false;
				
				cola.enqueue(this);
				cola.enqueue(null);
				
				while(!cola.isEmpty() && ok==false)
				{
					aux= cola.dequeue();
					
					if(aux!=null)
					{
						if(this.getData()==dato)
						{
							ok=true;
						}
						
						if(aux.hasChildren())
						{
							for (GeneralTree<T> h : aux.getChildren())
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
			
			return contNivel;
	   }
	
	  

	public int ancho(){
		
		if(this.isLeaf())
		{
			return 0;
		}
		else
		{
			int anchoMax=this.getChildren().size();
			for(GeneralTree<T> i : this.getChildren())
			{
				int anchoHijo= i.ancho();
				if(i.getChildren().size()>anchoMax)
				{
					anchoMax=anchoHijo;
				}
			}
			return anchoMax;
		}
		
	}
	
	public boolean esAncestro(T a, T b)
	{
		boolean ok = false;
		GeneralTree<T> t = new GeneralTree<T>();
		GeneralTree<T> f = this.buscarNodo(t, a);
		System.out.println("hay nodo que le corresponde: "+a+". Y es: "+(f!=null)+". Valor: "+f.getData());
		return esAncestro(f,b,ok);
	}
	
	
	private boolean esAncestro(GeneralTree<T> ab, T b, boolean ok)
	{
		System.out.println("El numero actual es: "+ab.getData());
		if(ab.getData()==b)
		{
			ok = true;
			System.out.println("Lo encontramos");
		}
		else
		{
			if(!ab.isLeaf())
			{
				for (GeneralTree<T> i : this.getChildren())
				{
					ok = i.esAncestro(i, b,ok);
				}
				
			}
		}
		return ok;
	}
	
	
	private GeneralTree<T> buscarNodo(GeneralTree<T> t, T a)
	{
		if(this.getData()==a)
		{
			t=this;
			System.out.println(t.getData());
		}
		else
		{
			if(!this.isLeaf())
			{
				for (GeneralTree<T> i : this.getChildren())
				{
					t = i.buscarNodo(t,a);
				}
			}
		}
		return t;
	}
	
	public double minimoCaudal(double caudal)
	{
		if(this.isLeaf())
		{
			return caudal;
		}
		else
		{
			double valorMenor = caudal/this.getChildren().size();
			double aux = valorMenor;
			for(GeneralTree<T> i : this.getChildren())
			{
				double hijoTarzanda = i.minimoCaudal(aux);
				if(hijoTarzanda<valorMenor)
				{
					valorMenor=hijoTarzanda;
				}
			}
			return valorMenor;
		}
		 
	}
}