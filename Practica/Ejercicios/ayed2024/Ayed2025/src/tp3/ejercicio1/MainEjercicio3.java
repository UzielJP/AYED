package tp3.ejercicio1;
import java.util.LinkedList;
import java.util.List;

public class MainEjercicio3 {
	
	public static void main(String[] args) {
		
        // Crear nodos individuales
        GeneralTree<String> root = new GeneralTree<>("Root");
        GeneralTree<String> child1 = new GeneralTree<>("Child1");
        GeneralTree<String> child2 = new GeneralTree<>("Child2");
        GeneralTree<String> child3 = new GeneralTree<>("Child3");
        GeneralTree<String> grandchild1 = new GeneralTree<>("GrandChild1");
        GeneralTree<String> grandchild2 = new GeneralTree<>("GrandChild2");

        // Construir el árbol
        child1.addChild(grandchild1);
        child1.addChild(grandchild2);

        root.addChild(child1);
        root.addChild(child2);
        root.addChild(child3);

        // Probar el método altura
        int altura = root.altura();
        int ancho = root.ancho();
        int nivel = root.nivel("GrandChild1");
        System.out.println("La altura del árbol es: " + altura);
        System.out.println("El ancho del árbol es: " + ancho);
        System.out.println("El nivel del árbol es: " + nivel);
    }
	
}
