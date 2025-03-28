package tp2.ejercicio1;

	public class MainParcial8 {
	    public static void main(String[] args) {
	        // Crear el primer árbol binario con 5 nodos
	        BinaryTree<Integer> tree1 = new BinaryTree<>(1);
	        tree1.addLeftChild(new BinaryTree<>(2));
	        tree1.addRightChild(new BinaryTree<>(3));
	        tree1.getLeftChild().addLeftChild(new BinaryTree<>(4));
	        tree1.getLeftChild().addRightChild(new BinaryTree<>(5));

	        System.out.println("Árbol 1 (5 nodos):");
	        tree1.recorridoInOrden();
	        System.out.println();

	        // Crear el segundo árbol binario con 10 nodos
	        BinaryTree<Integer> tree2 = new BinaryTree<>(1);
	        tree2.addLeftChild(new BinaryTree<>(2));
	        tree2.addRightChild(new BinaryTree<>(3));
	        tree2.getLeftChild().addLeftChild(new BinaryTree<>(4));
	        tree2.getLeftChild().addRightChild(new BinaryTree<>(5));

	        // Extender el árbol 2 con nodos adicionales
	        tree2.getRightChild().addLeftChild(new BinaryTree<>(6));
	        tree2.getRightChild().addRightChild(new BinaryTree<>(7));
	        tree2.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(8));
	        tree2.getLeftChild().getLeftChild().addRightChild(new BinaryTree<>(9));
	        tree2.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(10));

	        System.out.println("Árbol 2 (10 nodos):");
	        tree2.recorridoInOrden();
	        
	        ParcialArboles8 b = new ParcialArboles8();
	        System.out.println("El arbol 1 es prefijo del arbol 2 : "+b.esPrefijo(tree1, tree2));
	    }
	}
