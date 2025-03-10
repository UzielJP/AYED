package tp3.ejercicio1;

import java.util.List;

public class MainParcial10 {
	 public static void main(String[] args) {
	        // Crear un árbol general de ejemplo con valores 0 y 1
	        GeneralTree<Integer> root = new GeneralTree<>(1);
	        
	        GeneralTree<Integer> child1 = new GeneralTree<>(0);
	        GeneralTree<Integer> child2 = new GeneralTree<>(1);
	        GeneralTree<Integer> child3 = new GeneralTree<>(0);
	        
	        root.addChild(child1);
	        root.addChild(child2);
	        root.addChild(child3);
	        
	        GeneralTree<Integer> child2_1 = new GeneralTree<>(1);
	        GeneralTree<Integer> child2_2 = new GeneralTree<>(0);
	        child2.addChild(child2_1);
	        child2.addChild(child2_2);
	        
	        GeneralTree<Integer> child3_1 = new GeneralTree<>(1);
	        GeneralTree<Integer> child3_2 = new GeneralTree<>(1);
	        child3.addChild(child3_1);
	        child3.addChild(child3_2);
	        
	        // Invocar el método resolver
	        List<Integer> caminoFiltradoMaximo = ParArboles10.resolver(root);
	        
	        // Mostrar el resultado
	        System.out.println("Camino filtrado de valor máximo:");
	        System.out.println(caminoFiltradoMaximo);
	    }
}
