package tp5.ejercicio1.adjList;

import java.util.List;

import tp5.ejercicio1.Graph;

public class MainEjercicio5 {
	  public static void main(String[] args) {
	        // Crear grafo de personas
	        Graph<Persona> grafo = new AdjListGraph<>();

	        // Crear empleado
	        Persona empleado1 = new Persona(false, "Empleado 1", "Calle 123");
	        var vEmpleado1 = grafo.createVertex(empleado1);

	        // Crear y agregar 70 jubilados dispersos en el grafo
	        for (int i = 1; i <= 70; i++) {
	            Persona jubilado = new Persona(true, "Jubilado " + i, "Calle " + (124 + i));
	            var vJubilado = grafo.createVertex(jubilado);

	            // Conectar jubilados de forma dispersa
	            if (i % 3 == 0) {
	                grafo.connect(vEmpleado1, vJubilado); // Conexión directa al empleado
	            } else if (i % 5 == 0 && i > 1) {
	                grafo.connect(grafo.getVertex(i - 2), vJubilado); // Conexión con otro jubilado
	            } else {
	                grafo.connect(vJubilado, vEmpleado1); // Conexión inversa al empleado
	            }
	        }

	        // Agregar otras personas
	        Persona otraPersona = new Persona(false, "Persona 1", "Calle 128");
	        var vOtraPersona = grafo.createVertex(otraPersona);
	        grafo.connect(vOtraPersona, vEmpleado1);

	        // Instanciar QuedateEnCasa y buscar jubilados
	        QuedateEnCasa quedateEnCasa = new QuedateEnCasa();
	        int gradoSeparacion = 2;
	        List<Persona> jubilados = quedateEnCasa.bfs(grafo, empleado1, gradoSeparacion);

	        // Imprimir resultados
	        System.out.println("Lista de jubilados para " + empleado1.getNombre() + ":");
	        for (Persona jubilado : jubilados) {
	            System.out.println(jubilado);
	        }
	    }
}
