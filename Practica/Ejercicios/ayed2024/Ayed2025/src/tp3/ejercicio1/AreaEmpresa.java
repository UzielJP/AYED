package tp3.ejercicio1;

public class AreaEmpresa {
	
	String nombre;
	int tardanza;
	
	public AreaEmpresa(String nombre, int tardanza)
	{
		this.nombre=nombre;
		this.tardanza=tardanza;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getTardanza()
	{
		return this.tardanza;
	}
	
}
