package tp1.listas;

public class CircularQueue<T> extends Queue<T>
{
	public T Shift()
	{
		T valor = null;
		for(int i=0; i<this.size(); i++)
		{
			valor = this.getDato().get(i+1);
			this.getDato().add(i+1,this.getDato().get(i));
		}
		this.getDato().add(0,valor);
		return this.head();
	}
}
