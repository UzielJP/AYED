package tp5.ejercicio1.adjList;

public class Persona {

	private boolean jubilado;
	private String nombre;
	private String domicilio;
	
	public Persona(boolean jubilado, String nombre, String domicilio)
	{
		this.jubilado=jubilado;
		this.nombre=nombre;
		this.domicilio=domicilio;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public boolean esJubilado()
	{
		return this.jubilado;
	}
	
	public String getDomicilio()
	{
		return this.domicilio;
	}
	
	@Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", jubilado=" + jubilado +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }
}
