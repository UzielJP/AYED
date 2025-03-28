package tp2.ejercicio1;

public class segunChatGpt {

	/*
	 public class Transformacion {

    BinaryTree<Integer> arbol;

    // Constructor que inicializa el árbol binario
    public Transformacion(BinaryTree<Integer> ab) {
        this.arbol = ab;
    }

    // Método que transforma el árbol y devuelve un nuevo árbol con los valores modificados
    public BinaryTree<Integer> suma() {
        // Crear un árbol nuevo que copiará y transformará el original
        BinaryTree<Integer> nuevoArbol = new BinaryTree<>();
        nuevoArbol.setRoot(clonarYTransformar(arbol.getRoot()));
        return nuevoArbol;
    }

    // Método recursivo que clona y transforma cada nodo
    private Node<Integer> clonarYTransformar(Node<Integer> nodo) {
        if (nodo == null) {
            return null;
        }

        // Crear un nuevo nodo para el árbol transformado
        Node<Integer> nuevoNodo = new Node<>(0);

        // Clonar y transformar el subárbol izquierdo
        Node<Integer> hijoIzquierdo = clonarYTransformar(nodo.getLeftChild());

        // Clonar y transformar el subárbol derecho
        Node<Integer> hijoDerecho = clonarYTransformar(nodo.getRightChild());

        // Calcular la suma de los valores de los subárboles izquierdo y derecho
        int sumaIzquierda = (hijoIzquierdo != null) ? hijoIzquierdo.getValue() : 0;
        int sumaDerecha = (hijoDerecho != null) ? hijoDerecho.getValue() : 0;

        // Actualizar el valor del nodo actual con la suma de sus hijos
        nuevoNodo.setValue(sumaIzquierda + sumaDerecha);

        // Vincular los hijos al nuevo nodo
        nuevoNodo.setLeftChild(hijoIzquierdo);
        nuevoNodo.setRightChild(hijoDerecho);

        // Retornar el nodo transformado
        return nuevoNodo;
    }
}
	 */
}
