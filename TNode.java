package lab3;

public class TNode
{
    int element;
    TNode left;
    TNode right;
  
    public TNode (int i, TNode l, TNode r)
    {
        element = i;
        right = r;
        left = l;
    }
}

