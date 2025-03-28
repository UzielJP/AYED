package tp1.listas;

import java.util.LinkedList;
import java.util.List;

public class Queue<T>
{
	List<T> dato;
	
	public Queue()
	{
		this.dato = new LinkedList<>();
	}
	
	 public void enqueue(T element) {
	        this.dato.add(element);
	 }
	 
	 public T dequeue() {
	        return this.dato.remove(0);
	 }
	 
	 public T head()
	 {
		 return this.dato.get(0);
	 }
	 
	 protected List<T> getDato()
	 {
		 return this.dato;
	 }

	 public int size() {
	        return this.dato.size();
	 }
	 
	 public boolean isEmpty() {
	        return this.dato.isEmpty();
	 }
	 
	 @Override
	 public String toString()
	 {
		 String st = "";
		 for(int i=0; i<this.size(); i++)
		 {
			 st+=","+this.dato.get(i);
		 }
		 return st;
	 }
}
