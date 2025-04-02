package tp2.ejercicio1;

public class Ejercicio_7
{
    private BinaryTree <Integer> a;

    public boolean isLeftTree(int n)
    {

        int iz=0;
        int der=0;

        BinaryTree<Integer> b = this.a.existe(n);

        if(this.a==null)
        {
            return false;
        };

        if(b.hasLeftChild())
        {
            iz=this.isLeftTree(b.getLeftChild());
        }
        else
        {
            iz = -1;
        }

        if (b.hasRightChild())
        {
            der = this.isLeftTree(b.getRightChild());
        }
        else
        {
            der = -1;
        }

        return iz>der;
    };

    private int isLeftTree(BinaryTree<Integer> b)
    {
        if(b.isLeaf())
        {
            return 0;
        }
        else
        {
            int num = 0;
            if(b.hasLeftChild() && b.hasRightChild())
            {
                num+=this.isLeftTree(b.getLeftChild());
                num+=this.isLeftTree(b.getRightChild());
            }
            else
            {
                if(b.hasLeftChild())
                {
                    return this.isLeftTree(b.getLeftChild())+1;
                }
                if(b.hasRightChild())
                {
                    return this.isLeftTree(b.getRightChild())+1;
                }
            }
            return num;
        }
    }
}
