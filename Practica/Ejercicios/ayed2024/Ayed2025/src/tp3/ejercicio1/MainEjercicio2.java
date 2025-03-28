package tp3.ejercicio1;

import java.util.List;

public class MainEjercicio2 {

	    public static void main(String[] args) {
	        // Crear nodos
	        GeneralTree<Integer> root = new GeneralTree<>(1);

	        GeneralTree<Integer> child1 = new GeneralTree<>(2);
	        GeneralTree<Integer> child2 = new GeneralTree<>(3);
	        GeneralTree<Integer> child3 = new GeneralTree<>(4);

	        GeneralTree<Integer> grandchild1 = new GeneralTree<>(5);
	        GeneralTree<Integer> grandchild2 = new GeneralTree<>(6);
	        GeneralTree<Integer> grandchild3 = new GeneralTree<>(7);
	        GeneralTree<Integer> grandchild4 = new GeneralTree<>(8);
	        GeneralTree<Integer> grandchild5 = new GeneralTree<>(9);

	        GeneralTree<Integer> greatGrandchild1 = new GeneralTree<>(10);
	        GeneralTree<Integer> greatGrandchild2 = new GeneralTree<>(11);
	        GeneralTree<Integer> greatGrandchild3 = new GeneralTree<>(12);
	        GeneralTree<Integer> greatGrandchild4 = new GeneralTree<>(13);
	        GeneralTree<Integer> greatGrandchild5 = new GeneralTree<>(14);
	        GeneralTree<Integer> greatGrandchild6 = new GeneralTree<>(15);
	        GeneralTree<Integer> greatGrandchild7 = new GeneralTree<>(16);
	        GeneralTree<Integer> greatGrandchild8 = new GeneralTree<>(17);
	        GeneralTree<Integer> greatGrandchild9 = new GeneralTree<>(18);
	        GeneralTree<Integer> greatGrandchild10 = new GeneralTree<>(19);
	        GeneralTree<Integer> greatGrandchild11 = new GeneralTree<>(20);

	        // Construir la jerarquía
	        child1.addChild(grandchild1);
	        child1.addChild(grandchild2);

	        child2.addChild(grandchild3);
	        child2.addChild(grandchild4);

	        child3.addChild(grandchild5);

	        grandchild1.addChild(greatGrandchild1);
	        grandchild1.addChild(greatGrandchild2);

	        grandchild2.addChild(greatGrandchild3);

	        grandchild3.addChild(greatGrandchild4);
	        grandchild3.addChild(greatGrandchild5);

	        grandchild4.addChild(greatGrandchild6);
	        grandchild4.addChild(greatGrandchild7);

	        grandchild5.addChild(greatGrandchild8);
	        grandchild5.addChild(greatGrandchild9);
	        grandchild5.addChild(greatGrandchild10);
	        grandchild5.addChild(greatGrandchild11);

	        root.addChild(child1);
	        root.addChild(child2);
	        root.addChild(child3);

	        // Mostrar recorridos
	        RecorridosAG r = new RecorridosAG();
	        List<Integer> l = r.numerosImparesMayoresQuePreOrden(root, 2);
	        System.out.println("La cantidad de elementos en l es de: "+l.size());
	        l.stream().forEach(a->System.out.println(a));
	        l = r.numerosImparesMayoresQuePostOrden(root, 2);
	        System.out.println("La cantidad de elementos en l es de: "+l.size());
	        l.stream().forEach(a->System.out.println(a));
	        l = r.numerosImparesMayoresQuePorNiveles(root, 2);
	        System.out.println("La cantidad de elementos en l es de: "+l.size());
	        l.stream().forEach(a->System.out.println(a));
	  
	       System.out.println("El elemento que se busca existe: "+root.esAncestro(6,12));
	       System.out.println("El Minimo caudal es de : "+root.minimoCaudal(1000));
	       
	       Caminos c = new Caminos(root);
	       List<Integer> f = c.caminoAHojaMasLejana();
	       System.out.println("El mayor camino es de : "+f.size());
	       f.stream().forEach(a->System.out.println(a));
	       
	    }
}
