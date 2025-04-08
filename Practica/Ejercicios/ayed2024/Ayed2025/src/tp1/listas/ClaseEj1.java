package tp1.listas;

/**
 * ClaseEj1 provides methods to print numbers sequentially in a given range using different looping constructs.
 */
public class ClaseEj1 {
	
	/**
	 * Prints all integers in the range from the specified start value to the specified end value (inclusive)
	 * using a for loop.
	 *
	 * @param a the starting integer of the range
	 * @param b the ending integer of the range
	 */
	public static void contarFor(int a, int b)
	{
		for(int i=a; i<=b; i++)
		{
			System.out.println(i);
		}
	};
	
	/**
	 * Prints all integers in the range from the specified start value to the specified end value (inclusive)
	 * using a while loop.
	 *
	 * @param a the starting integer of the range
	 * @param b the ending integer of the range
	 */
	public static void contarWhile(int a,int b)
	{
		int i=a;
		while(i<=b)
		{
			System.out.println(i);
			i++;
		}
	}

}
