package tp2.ejercicio1;

public class Ejercicio_8 {

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2)
    {
        if(arbol1==null)return true;
        return esPrefijo2(arbol1,arbol2);
    }

    public boolean esPrefijo2(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2)
    {
        if(arbol1==null)return true;
        if(arbol2==null)return false;
        if(arbol1.getData()!=arbol2.getData())return false;
        return this.esPrefijo(arbol1.getLeftChild(),arbol2.getLeftChild())&&this.esPrefijo(arbol1.getRightChild(),arbol2.getRightChild());
    }

    /*
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
     */
}
