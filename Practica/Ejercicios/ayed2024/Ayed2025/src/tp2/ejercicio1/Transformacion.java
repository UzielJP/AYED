package tp2.ejercicio1;

public class Transformacion {

    private BinaryTree<Integer> arbol;

    // Constructor que recibe el árbol binario
    public Transformacion(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    /**
     * Transforma el árbol binario reemplazando el valor de cada nodo
     * con la suma de los valores de los nodos de sus subárboles izquierdo y derecho.
     * @return El árbol binario transformado.
     */
    public BinaryTree<Integer> suma() {
        transformar(arbol);
        return arbol;
    }
    
    public void recorridoInOrden()
    {
    	this.arbol.recorridoInOrden();
    }
    /**
     * Método recursivo que realiza la transformación del árbol.
     * @param nodo El nodo actual del árbol.
     * @return La suma de los valores de los nodos en el subárbol cuya raíz es el nodo dado.
     */
    private int transformar(BinaryTree<Integer> nodo) {
        if (nodo == null || nodo.isEmpty()) {
            return 0; // Subárbol vacío tiene valor 0
        }

        // Si el nodo es una hoja, guardar su valor y establecerlo en 0
        if (nodo.isLeaf()) {
            int valorOriginal = nodo.getData();
            nodo.setData(0);
            return valorOriginal;
        }

        // Calcular la suma de los subárboles izquierdo y derecho
        int sumaIzquierda = transformar(nodo.getLeftChild());
        int sumaDerecha = transformar(nodo.getRightChild());

        // Actualizar el valor del nodo con la suma de los valores de sus subárboles
        nodo.setData(sumaIzquierda + sumaDerecha);

        // Retornar la suma total incluyendo el valor original del nodo
        return nodo.getData();
    }
    
}
	/*
		public BinaryTree<Integer> suma(BinaryTree<Integer> ar)
		{
			BinaryTree<Integer> ab = new BinaryTree<Integer>();
			ab=ar;
			if(!ar.isEmpty())
			{
				if(this.
			}
			return ab;
		}
		
		public int Transformar(BinaryTree<Integer> ab)
		{
			int valor=0;
			if(ab.isLeaf())
			{
				return valor;
			}
			else
			{
				if(ab.hasLeftChild())
				{
					valor+=ab.getLeftChild().getData();
				}
				if(ab.hasRightChild())
				{
					valor+=ab.getRightChild().getData();
				}
			}
			return valor;
		}
		*/

