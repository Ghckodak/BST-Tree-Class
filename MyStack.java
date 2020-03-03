package lab3;

public class MyStack
{
    private Node top;
  
    public boolean IsEmpty()
    {
        return (top==null);
    }
          
    public void push(TNode element)
    {
        top = new Node(element,top);
    }
  
    public TNode pop()
    {
        if (IsEmpty())
            System.out.println("Stack Empty");
        TNode element = top.element;
        top = top.next;
        return element;
    }
  
    public TNode top()
    {
        return top.element;
    }
}
