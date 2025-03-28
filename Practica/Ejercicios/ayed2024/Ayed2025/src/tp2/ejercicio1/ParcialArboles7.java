package tp2.ejercicio1;

public class ParcialArboles7 {

	BinaryTree<Integer> arbol;
	
	public ParcialArboles7(BinaryTree<Integer> arbol)
	{
		this.arbol=arbol;
	}
	
	public  boolean isLeftTree(int n)
	{
		boolean b = false;
		return this.isLeftTree(arbol, n,b);
	}
	
	private boolean isLeftTree(BinaryTree<Integer> ab, int n,boolean b)
	{
		if(ab.getData()==n)
		{
			System.out.println("Encontramos el valor");
			int iz=0;
			int der=0;
			if(ab.hasLeftChild())
			{
				System.out.println("Tiene hijo izquierdo");
				iz+= ab.getLeftChild().retornarValor();
			}
			else
			{
				iz=-1;
			}
			if(ab.hasRightChild())
			{
				System.out.println("Tiene hijo derecho");
				der+= ab.getRightChild().retornarValor();
			}
			else
			{
				der=-1;
			}
			System.out.println("Valor actual de iz: "+iz);
			System.out.println("Valor actual de der: "+der);
			b=(iz>der);
			System.out.println("Valor actual de valor: "+b);
			return b;
		}
		else
		{
			if(ab.hasLeftChild())
			{
				System.out.println("Buscando numero: "+n+". Por la izquierda.");
				b = this.isLeftTree(ab.getLeftChild(), n,b);
			}
			System.out.println("Valor actual de valor: "+b);
			if(ab.hasRightChild())
			{
				System.out.println("Buscando numero: "+n+". Por la derecha.");
				this.isLeftTree(ab.getRightChild(), n,b);
			}
		}
		return b;
	}
}
