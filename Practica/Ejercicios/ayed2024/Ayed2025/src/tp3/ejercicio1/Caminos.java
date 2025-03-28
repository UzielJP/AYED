package tp3.ejercicio1;

import java.util.ArrayList;
import java.util.List;

import tp2.ejercicio1.BinaryTree;

public class Caminos {
	
	GeneralTree<Integer> ab = new GeneralTree<Integer>();
	
	public Caminos(GeneralTree<Integer> ab)
	{
		this.ab=ab;
	}

	public List<Integer> caminoAHojaMasLejana() {
        return caminoAHojaMasLejana(ab, new ArrayList<>());
    }

    private List<Integer> caminoAHojaMasLejana(GeneralTree<Integer> ab, List<Integer> l) {
        List<Integer> caminoActual = new ArrayList<>(l);
        caminoActual.add(ab.getData());

        if (ab.isLeaf()) {
            // Si es una hoja, devolvemos el camino actual
            return caminoActual;
        } else {
        	
            List<Integer> caminoMasLargo = new ArrayList<>();
            for (GeneralTree<Integer> hijo : ab.getChildren()) {
                // Calculamos el camino más largo para cada hijo
                List<Integer> caminoHijo = caminoAHojaMasLejana(hijo, caminoActual);
                if (caminoHijo.size() > caminoMasLargo.size()) {
                    caminoMasLargo = caminoHijo;
                }
            }
            
            return caminoMasLargo;
        }
    }
	
}
