package tp2.ejercicio1;

public class Main {

	 public static void main(String[] args) {
	        // Crear el árbol binario
	        BinaryTree<Integer> root = new BinaryTree<>(1);

	        // Nivel 1
	        BinaryTree<Integer> left1 = new BinaryTree<>(2);
	        BinaryTree<Integer> right1 = new BinaryTree<>(3);
	        root.addLeftChild(left1);
	        root.addRightChild(right1);

	        // Nivel 2
	        BinaryTree<Integer> left2a = new BinaryTree<>(4);
	        BinaryTree<Integer> right2a = new BinaryTree<>(5);
	        BinaryTree<Integer> left2b = new BinaryTree<>(6);
	        BinaryTree<Integer> right2b = new BinaryTree<>(7);
	        left1.addLeftChild(left2a);
	        left1.addRightChild(right2a);
	        right1.addLeftChild(left2b);
	        right1.addRightChild(right2b);

	        // Nivel 3
	        BinaryTree<Integer> left3a = new BinaryTree<>(8);
	        BinaryTree<Integer> right3a = new BinaryTree<>(9);
	        BinaryTree<Integer> left3b = new BinaryTree<>(10);
	        BinaryTree<Integer> right3b = new BinaryTree<>(11);
	        BinaryTree<Integer> left3c = new BinaryTree<>(12);
	        BinaryTree<Integer> right3c = new BinaryTree<>(13);
	        BinaryTree<Integer> left3d = new BinaryTree<>(14);
	        BinaryTree<Integer> right3d = new BinaryTree<>(15);

	        left2a.addLeftChild(left3a);
	        left2a.addRightChild(right3a);
	        right2a.addLeftChild(left3b);
	        right2a.addRightChild(right3b);
	        left2b.addLeftChild(left3c);
	        left2b.addRightChild(right3c);
	        right2b.addLeftChild(left3d);
	        right2b.addRightChild(right3d);

	        // Agregar el nodo 16 y 17 en el último nivel
	        BinaryTree<Integer> node16 = new BinaryTree<>(16);
	        BinaryTree<Integer> node17 = new BinaryTree<>(17);
	        left3a.addLeftChild(node16);
	        left3a.addRightChild(node17);

	        // Pruebas de métodos
	        //System.out.println("Cantidad de hojas: " + root.contarHojas());
	        
	        root.recorridoInOrden();
	        
	       System.out.println("Arbol espejo:");
	       BinaryTree<Integer> mirror = root.espejo();
	       mirror.recorridoInOrden();
	       
	        ///System.out.println("Elementos entre niveles 1 y 2:");
	       // root.entreNiveles(1, 2);
	        System.out.println("Segunda parte");
	        ProfundidaDeArbolBinario a = new ProfundidaDeArbolBinario(root);
	        System.out.println("La cantidad de nodos en la produndidad 2 es de: "+a.sumaElementosProfundidad(2));
	        
	        System.out.println("Tercera parte");
	        RedBinariaLlena b = new RedBinariaLlena(root);
	        System.out.println("El camino mas largo es de: "+b.entreNiveles());
	        
	        System.out.println("cuarta parte");
	        BinaryTree<Integer> arbol = root.getArbol();
	        arbol.recorridoInOrden();
	        Transformacion t = new Transformacion(arbol);
	        BinaryTree<Integer> s = t.suma();
	        s.recorridoInOrden();
	    }
}
