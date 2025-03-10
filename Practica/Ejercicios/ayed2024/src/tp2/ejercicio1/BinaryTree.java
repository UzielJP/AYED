package tp2.ejercicio1;

import tp3.ejercicio1.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}
	
	public BinaryTree(T data) {
		this.data = data;
		this.leftChild=null;
		this.rightChild=null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public int contarHojas() 
	{
		int cant = 0;
		if(!this.isEmpty())
		{
			if(this.isLeaf())
			{
				System.out.println("esta es una hoja");
				cant++;
			}
			else
			{
				if(this.hasLeftChild())
				{
					System.out.println("esta no es una hoja giro a la izquierda");
					cant+=this.getLeftChild().contarHojas();
				}
				if(this.hasLeftChild())
				{
					System.out.println("esta no es una hoja giro a la derecha");
					cant+=this.getRightChild().contarHojas();
				}
			}
		}
		return cant;
	}
	
	/*
	public BinaryTree<T> noespejo()
	{
		BinaryTree<T> espejo = new BinaryTree<T>();
		if(!this.isEmpty())
		{
			espejo.setData(this.data);;
			espejo = this.espejo(espejo);
		}
		return espejo;
	}
    */
	
	public int retornarValor()
	{
		if(this.isLeaf())
		{
			return 0;
		}
		else
		{
			int iz = 0;
			if(this.hasLeftChild()&&this.hasRightChild())
			{
				iz+= this.getLeftChild().retornarValor();
				iz+=this.getRightChild().retornarValor();
				return iz;
			}
			else
			{
				if(this.hasLeftChild())
				{
					iz+=this.getLeftChild().retornarValor()+1;
				}
				if(this.hasRightChild())
				{
					iz+=this.getRightChild().retornarValor();
				}
				return iz;
			}
		}
	}
	
	
    public BinaryTree<T> espejo()
    {
    	BinaryTree<T> espejo = new BinaryTree<T>();
    	if(!this.isEmpty())
    	{
    		if(this.hasLeftChild())
    		{
    			espejo.addRightChild(this.leftChild);
    			espejo.getRightChild().espejo();
    		}
    		
    		if(this.hasRightChild())
    		{
    			espejo.addLeftChild(this.rightChild);
    			espejo.getLeftChild().espejo();
    		}
    		
    	}
    	return espejo;
    }
    
    public BinaryTree<T> getArbol()
    {
    	BinaryTree<T> espejo = new BinaryTree<T>();
    	if(!this.isEmpty())
    	{
    		if(this.hasLeftChild())
    		{
    			espejo.addLeftChild(this.leftChild);
    			espejo.getLeftChild().getArbol();
    		}
    		
    		if(this.hasRightChild())
    		{
    			espejo.addRightChild(this.rightChild);
    			espejo.getRightChild().getArbol();
    		}
    		
    	}
    	return espejo;
    }
    
    public void recorridoInOrden()
    {
    	if(!this.isEmpty())
    	{
    		System.out.println(this.data);
    		if(this.hasLeftChild())
    		{
    			this.getLeftChild().recorridoInOrden();
    		}
    		
    		if(this.hasRightChild())
    		{
    			this.getRightChild().recorridoInOrden();
    		}
    	}
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		
		if(!this.isEmpty())
		{
			Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
			BinaryTree<T> aux;
			int contNivel=0;
			
			cola.enqueue(this);
			cola.enqueue(null);
			
			while(!cola.isEmpty())
			{
				aux= cola.dequeue();
				
				if(aux!=null)
				{
					if(contNivel >= n && contNivel <= m)
					{
						System.out.print(aux.getData() + " ");
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
		
   }
		
}

