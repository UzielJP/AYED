package tp1.listas;

public class DoubleEndedQueue<T> extends Queue<T> {
	
	public void enqueueFirst(T x)
	{
		for(int i=this.size(); i>0; i--)
		{
			T valor = this.getDato().get(i-1);
			this.getDato().add(i+1,this.getDato().get(i));
		}
		this.getDato().add(0,x);
	}
	
}
