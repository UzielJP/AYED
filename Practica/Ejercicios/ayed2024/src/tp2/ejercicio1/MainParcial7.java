package tp2.ejercicio1;
import java.util.Random;

public class MainParcial7 {
	    public static void main(String[] args) {
	        // Crear el árbol binario
	        BinaryTree<Integer> binaryTree = new BinaryTree<>();
	        Random random = new Random();

	        // Crear y cargar 18 nodos con valores aleatorios
	        for (int i = 0; i < 18; i++) {
	            int value = random.nextInt(100); // Números aleatorios entre 0 y 99
	            System.out.println("Insertando nodo con valor: " + value);
	            addNode(binaryTree, value);
	        }

	        // Mostrar recorrido en orden del árbol
	        System.out.println("Recorrido InOrden del árbol:");
	        binaryTree.recorridoInOrden();
	    }

	    /**
	     * Método auxiliar para agregar nodos al árbol binario.
	     * Inserta el nodo en la primera posición vacía disponible.
	     */
	    private static void addNode(BinaryTree<Integer> root, int value) {
	        if (root.isEmpty()) {
	            root.setData(value);
	        } else {
	            BinaryTree<Integer> current = root;
	            while (true) {
	                // Decidir aleatoriamente si insertar en el hijo izquierdo o derecho
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
}
