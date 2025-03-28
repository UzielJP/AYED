package tp2.ejercicio1;

public class Nodo
{
	
	private int suma;
	private int dif;
	
	public Nodo(int suma, int dif) {
		this.suma = suma;
		this.dif=dif;
	}

	public int getSuma() {
		return this.suma;
	}

	public void setSuma(int data) {
		this.suma = data;
	}
	
	public int getDif() {
		return dif;
	}

	public void setDif(int data) {
		this.dif = data;
	}
	
	@Override
	public String toString()
	{
		return this.getSuma()+ " | " +this.getDif();
	}
}
