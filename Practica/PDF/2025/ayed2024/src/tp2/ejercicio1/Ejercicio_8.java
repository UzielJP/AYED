package tp2.ejercicio1;

public class Ejercicio_8 {

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2)
    {
        boolean b = true;
        return esPrefijo(arbol1,arbol2,b);
    }

    private boolean esPrefijo(BinaryTree<Integer> ab1, BinaryTree<Integer> ab2, boolean b)
    {
        if(ab1.getData()!=ab2.getData())
        {
            b=false;
        }
        else
        {
            if(!ab1.isLeaf())
            {
                if(ab1.hasLeftChild()&&ab2.hasLeftChild())
                {
                    b = this.esPrefijo(ab1.getLeftChild(), ab2.getLeftChild(),b);
                }
                else
                {
                    if(ab2.hasLeftChild())
                    {
                        b=false;
                    }
                }
                if(ab1.hasRightChild()&&ab2.hasRightChild())
                {
                    b = this.esPrefijo(ab1.getRightChild(), ab2.getRightChild(),b);
                }
                else
                {
                    if(ab2.hasRightChild())
                    {
                        b=false;
                    }
                }
            }
        }
        return b;
    }
}
