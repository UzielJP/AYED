package tp2.ejercicio1;

	public class MainParcial7_2 {
	    public static void main(String[] args) {
	        // Crear el árbol binario
	        BinaryTree<Integer> binaryTree = new BinaryTree<>();

	        // Cargar nodos del 1 al 9 de manera aleatoria
	        System.out.println("Insertando nodos del 1 al 9 de manera aleatoria:");
	        for (int i = 1; i <= 9; i++) {
	            System.out.println("Insertando nodo con valor: " + i);
	            addNode(binaryTree, i);
	        }

	        // Cargar nodos del 10 al 14 al final de la rama izquierda
	        System.out.println("\nInsertando nodos del 10 al 14 al final de la rama izquierda:");
	        for (int i = 10; i <= 14; i++) {
	            System.out.println("Insertando nodo con valor: " + i);
	            addToLeftMost(binaryTree, i);
	        }

	        // Cargar nodos del 15 al 18 al final de la rama derecha
	        System.out.println("\nInsertando nodos del 15 al 18 al final de la rama derecha:");
	        for (int i = 15; i <= 18; i++) {
	            System.out.println("Insertando nodo con valor: " + i);
	            addToRightMost(binaryTree, i);
	        }

	        // Mostrar recorrido en orden del árbol
	        System.out.println("\nRecorrido InOrden del árbol:");
	        binaryTree.recorridoInOrden();
	        
	        //TESTEO REAL;
	        
	        System.out.println("parte 1");
	        ParcialArboles7 p = new ParcialArboles7(binaryTree);
	        System.out.println("Hay mas ramas hijos en la parte iz quierda: "+p.isLeftTree(10));
	    }

	    /**
	     * Método auxiliar para agregar nodos al árbol binario de manera aleatoria.
	     */
	    private static void addNode(BinaryTree<Integer> root, int value) {
	        if (root.isEmpty()) {
	            root.setData(value);
	        } else {
	            BinaryTree<Integer> current = root;
	            while (true) {
	                if (Math.random() < 0.5) {
	                    // Intentar insertar en el hijo izquierdo
	                    if (current.hasLeftChild()) {
	                        current = current.getLeftChild();
	                    } else {
	                        current.addLeftChild(new BinaryTree<>(value));
	                        break;
	                    }
	                } else {
	                    // Intentar insertar en el hijo derecho
	                    if (current.hasRightChild()) {
	                        current = current.getRightChild();
	                    } else {
	                        current.addRightChild(new BinaryTree<>(value));
	                        break;
	                    }
	                }
	            }
	        }
	    }

	    /**
	     * Método para agregar un nodo al final de la rama izquierda.
	     */
	    private static void addToLeftMost(BinaryTree<Integer> root, int value) {
	        BinaryTree<Integer> current = root;
	        while (current.hasLeftChild()) {
	            current = current.getLeftChild();
	        }
	        current.addLeftChild(new BinaryTree<>(value));
	    }

	    /**
	     * Método para agregar un nodo al final de la rama derecha.
	     */
	    private static void addToRightMost(BinaryTree<Integer> root, int value) {
	        BinaryTree<Integer> current = root;
	        while (current.hasRightChild()) {
	            current = current.getRightChild();
	        }
	        current.addRightChild(new BinaryTree<>(value));
	    }
	}

