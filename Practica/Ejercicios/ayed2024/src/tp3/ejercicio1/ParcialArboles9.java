package tp3.ejercicio1;

import java.util.Iterator;

public class ParcialArboles9 {
	
	public static boolean esDeSeleccion (GeneralTree<Integer> ab)
	{
		if(ab.isLeaf())
		{
			return true;
		}
		else
		{
			Iterator<GeneralTree<Integer>> iterador = ab.getChildren().iterator();
			int minimo = Integer.MAX_VALUE;
			
			while(iterador.hasNext())
			{
				GeneralTree<Integer> hijo = iterador.next();
				
				if (!esDeSeleccion(hijo)) 
				{
		                return false;
		        }
				 
				if (hijo.getData()<minimo) 
				{
		                minimo = hijo.getData();
		        }
			}
			
			return (minimo==ab.getData());
		}
	}
}
