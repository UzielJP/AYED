package tp3.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class ParArboles10 {
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol)
	{
		List<Integer> actualLista = new ArrayList<Integer>();
		List<Integer> maximaLista = new ArrayList<Integer>();
		Maximo max = new Maximo(-1);
		listar(arbol,actualLista,maximaLista,max,0,0);
		return maximaLista;
	}
	
	private static void listar(GeneralTree<Integer> ab,List<Integer> actL,List<Integer> maxL,Maximo max, int valorMayor, int nivel)
	{
		List<Integer> lista = new ArrayList<Integer>(actL);
		int valorAct = valorMayor;
		
		System.out.println("ab = "+ab.getData());
		
		if(ab.getData()==1)
		{
			valorAct =  valorAct+ab.getData()*nivel;
			lista.add(ab.getData());
			System.out.println(lista);
		}
		
		System.out.println("valorMayor = "+valorMayor);
		System.out.println("valorAct = "+valorAct);
		
		if(ab.isLeaf())
		{
			System.out.println("Es hoja");
			System.out.println("valorAct es mayor que max: "+(max.getMax()<valorAct));
			if(max.getMax()<valorAct)
			{
				System.out.println("max = "+max.getMax());
				max.setMax(valorAct);
				System.out.println("max = "+max.getMax());
				maxL.removeAll(maxL);
				maxL.addAll(lista);
				System.out.println("maxL = "+maxL);
			}
		}
		else
		{
			for(GeneralTree<Integer> i : ab.getChildren())
			{
				listar(i,lista,maxL,max,valorAct,nivel+1);
				if(max.getMax()<valorAct)
				{
					System.out.println("Es mayor que el maximo");
					max.setMax(valorAct);
					maxL = lista;
				}
			}
		}
		
	}
	

	// Me base en lo siguiente para hacer mi codigo:
	/*
	private static void resolver(GeneralTree<Integer> arbol, List<Integer> camAct, List<Integer> camMax, Maximo max, int valorTotal, int nivel) {
        int datoActual = arbol.getData();
        boolean ok = (datoActual == 1);
        if(ok) {
            valorTotal+= datoActual * nivel;
            camAct.add(datoActual);
        }
        if(!arbol.isLeaf()) {
            for(GeneralTree<Integer>h: arbol.getChildren()) {
                resolver(h, camAct, camMax, max, valorTotal, nivel+1);
            }
        } else if (valorTotal > max.getMax()) {
            max.setMax(valorTotal);
            valorTotal = 0;
            camMax.removeAll(camMax);
            camMax.addAll(camAct);
        }
        if(ok) camAct.remove(camAct.size()-1);
    }
    */

}
