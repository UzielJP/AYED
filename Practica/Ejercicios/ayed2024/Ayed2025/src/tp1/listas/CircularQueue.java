package tp1.listas;

import java.util.List;

public class CircularQueue<T> extends Queue<T>
{
	public T Shift()
	{
		if(!this.isEmpty())
		{
				T valor =  this.dequeue();
				this.enqueue(valor);
				return this.head();
		};
		
		return null;
	}
}
