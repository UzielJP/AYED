package tp3.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class MainParcial11 {
	
    public static void main(String[] args) {
        // Crear la raíz del árbol (nivel 0)
        GeneralTree<Integer> root = new GeneralTree<>(1); // Raíz arbitraria, valor 1 para la raíz
        
        // Crear el árbol con la estructura deseada
        crearArbolPersonalizado(root);
        
        // Imprimir el árbol para verificar su estructura
        ParcialArboles11 p = new ParcialArboles11();
        boolean ok = p.resolver(root);
        System.out.println("El arbol esta balanceado: "+ok);
    }

    // Método para crear el árbol con la estructura solicitada
    public static void crearArbolPersonalizado(GeneralTree<Integer> root) {
        // Nivel 1: La raíz tiene 2 hijos
        GeneralTree<Integer> child1 = new GeneralTree<>(1);
        GeneralTree<Integer> child2 = new GeneralTree<>(1);
        root.addChild(child1);
        root.addChild(child2);

        // Nivel 2: El primer hijo de la raíz tiene 2 hijos, el segundo tiene 1 hijo
        GeneralTree<Integer> child1_1 = new GeneralTree<>(1);
        GeneralTree<Integer> child1_2 = new GeneralTree<>(1);
        child1.addChild(child1_1);
        child1.addChild(child1_2);

        GeneralTree<Integer> child2_1 = new GeneralTree<>(1);
        child2.addChild(child2_1);

        // Nivel 3: El primer hijo del primer nodo tiene 3 hijos, el segundo tiene 1 hijo
        GeneralTree<Integer> child1_1_1 = new GeneralTree<>(1);
        GeneralTree<Integer> child1_1_2 = new GeneralTree<>(1);
        GeneralTree<Integer> child1_1_3 = new GeneralTree<>(1);
        child1_1.addChild(child1_1_1);
        child1_1.addChild(child1_1_2);
        child1_1.addChild(child1_1_3);

        GeneralTree<Integer> child2_1_1 = new GeneralTree<>(1);
        child2_1.addChild(child2_1_1);

        // Nivel 4: El primer hijo de `child1_1_1` tiene 1 hijo, el segundo tiene 1 hijo y así sucesivamente
        GeneralTree<Integer> child1_1_1_1 = new GeneralTree<>(1);
        child1_1_1.addChild(child1_1_1_1);
        
        GeneralTree<Integer> child1_1_2_1 = new GeneralTree<>(1);
        child1_1_2.addChild(child1_1_2_1);

        GeneralTree<Integer> child1_1_3_1 = new GeneralTree<>(1);
        child1_1_3.addChild(child1_1_3_1);

        GeneralTree<Integer> child2_1_1_1 = new GeneralTree<>(1);
        child2_1_1.addChild(child2_1_1_1);

        // Asegurar que el árbol tenga 5 nodos en el último nivel
        GeneralTree<Integer> child2_1_1_2 = new GeneralTree<>(1);
        child2_1_1.addChild(child2_1_1_2);
    }

}
