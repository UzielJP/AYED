package tp2.ejercicio1;

public class Ejercicio_9 {

    private BinaryTree<Integer> arbol;

    public BinaryTree<DobleEntero> sumAndDif(BinaryTree<Integer> arbol)
    {
        return this.sumAndDif(arbol,0,0);
    }

    public BinaryTree<DobleEntero> sumAndDif(BinaryTree<Integer> ab1, int sum, int dif)
    {
        DobleEntero ob = new DobleEntero(sum+ ab1.getData(), ab1.getData()-dif);
        BinaryTree<DobleEntero> ab2 = new BinaryTree<DobleEntero>(ob);

        if(!ab1.isLeaf())
        {

            if(ab1.hasLeftChild())
            {
                ab2.addLeftChild(this.sumAndDif(ab1.getLeftChild(), ob.getSum(), ab1.getData()) );
            }

            if(ab1.hasRightChild())
            {
                ab2.addRightChild(this.sumAndDif(ab1.getRightChild(), ob.getSum(), ab1.getData()) );
            }

        }

        return ab2;
    }
}
