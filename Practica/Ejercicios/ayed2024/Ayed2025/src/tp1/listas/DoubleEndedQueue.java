package tp1.listas;

public class DoubleEndedQueue<T> extends Queue<T> {
	
	public void enqueueFirst(T x)
	{
		this.getDato().addFirst(x);
	}
	
}
