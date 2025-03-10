package tp2.ejercicio1;

public class ParcialArboles9 {

	public BinaryTree<Nodo> sumAndDif(BinaryTree<Integer> arbol)
	{
		int e = 0;
		return this.sumAndDif(arbol,e);
	}
	
	private BinaryTree<Nodo> sumAndDif(BinaryTree<Integer> arbol,int e)
	{
		BinaryTree<Nodo> ab = new BinaryTree<Nodo>();
		Nodo n = new Nodo(arbol.getData()+e,arbol.getData()-e);
		ab.setData(n);
		
		if(!arbol.isLeaf())
		{
			e = ab.getData().getSuma();
			if(arbol.hasLeftChild())
			{
				ab.addLeftChild(this.sumAndDif(arbol.getLeftChild(), e));
			}
			
			if(arbol.hasRightChild())
			{
				ab.addRightChild(this.sumAndDif(arbol.getRightChild(), e));
			}
		}
		
		return ab;
	}
}
