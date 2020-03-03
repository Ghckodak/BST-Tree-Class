/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

*******************************************Constructor**************************************************
public class BSTSet{
	private TNode root; 


	public BSTSet() {
		root=null;
	}
*******************************************Constructor**************************************************	
	public BSTSet (int[] input){
		int size = input.length;
		for(int i=0;i<size;i++){
			this.add(input[i]);
		}
	}
*******************************************Method**************************************************
	public boolean isEmpty() {
		return root==null;
	}
*******************************************Method**************************************************
	public boolean isIn(int v) {
		
		TNode node=this.root;
		while(node!=null){
			if (node.element==v){
				return true;
			}
			else if(node.element<v){
				node=node.right;
			}
			else if(node.element>v){
				node=node.left;
			}
		}
		return false;
	} 	
*******************************************Method**************************************************	
	public void add(int v) {
		root = add(root,v) ;
	}
	
	private TNode add(TNode node, int v) {
		// location finded
		if (node == null) {

			return new TNode(v,null,null) ;
		}
		
		// input smaller than current node, go left child
		if (node.element>v) {
			node.left = add(node.left,v) ;
			// input larger than current node, go right child
		} else if (node.element< v) {
			node.right = add(node.right,v) ;
		}
		
		return node ;
	}

*******************************************Method**************************************************
	public boolean remove(int v){
		//node does not exist
		
		boolean inIt=false;
		if (!isIn(v)){
			inIt=false;
			System.out.println(inIt);
			
		}
		if(inIt){
			//node finded
			root=delete(root,v);
		}
		return inIt;
		
	}
	
*******************************************Method**************************************************
	private TNode delete(TNode node, int v){
		if (node == null) {
			return null;
		}
		
		// node.e > e
		if (node.element>v) {
			node.left=delete(node.left,v);
			return node;
		} 
		// node.e < e	
		else if (node.element<v) {
			node.right=delete(node.right,v);
			return node;
		} 
		else { 
			// e == node.e
			// the node does not have left child
			if (node.left==null) {
				TNode rightNode = node.right;
				node.right = null;
				return rightNode;
			}
			
			// the node does not have right child
			else if (node.right == null) {
				TNode leftNode = node.left;
				node.left = null;
				return leftNode;
			}
			
			//find the min value from right child

			TNode newNode=node.right;
			

			while (newNode.left != null){
				newNode=newNode.left;
			}

			// make the min node as new node
			newNode.right =removeMin(newNode.right);
			newNode.left = node.left;
			// delete the node
			node.left=null; 
			node.right=null;
			return newNode;
		}
	}
*******************************************Method**************************************************

    public int size()
    {
        return this.size(root);
    }
  
    private int size(TNode node)
    {
      if (node==null)
          return 0;
      else
          return 1+size(node.left)+size(node.right);
    }
  *******************************************Method**************************************************
	public TNode removeMin(TNode t)
	{
		if (t.left!=null)
		{
			t.left = removeMin(t.left);
			return t;
		}
		else
			return t.right;
	}
*******************************************Method**************************************************
	public void printBSTSet(){
		if(root==null)
			System.out.println("The set is empty");
		else{
			System.out.print("The set elements are: ");
			printBSTSet(root);
			System.out.print("\n");
		}
	}
*******************************************Method**************************************************
	private void printBSTSet(TNode t){
		if(t!=null){
		printBSTSet(t.left);
		System.out.print(" " + t.element + ", ");
		printBSTSet(t.right);
		}
	}
*******************************************Method**************************************************
	public BSTSet union(BSTSet s) throws Exception {
		int size1=s.size();
		int size2=this.size();
		MyStack temp1=new MyStack();
		MyStack temp2=new MyStack();
		toStack(s.root,temp1);
		toStack(this.root,temp2);
		BSTSet result=new BSTSet();
		for (int i=0;i<size1;i++){
			result.add(temp1.pop().element);
		}
		for (int j=0;j<size2;j++){
			result.add(temp2.pop().element);
		}
		return result;

	}
*******************************************Method**************************************************	
	public BSTSet intersection(BSTSet s) throws Exception {

		int size=s.size();
		MyStack temp=new MyStack();
		toStack(root,temp);
		BSTSet result=new BSTSet();
		while(!temp.IsEmpty()){
			int a=(temp.pop().element);
			if (s.isIn(a)==true){
                            result.add(a);
			}
		}
		return result;
	}
*******************************************Method**************************************************
	public BSTSet difference(BSTSet s) throws Exception {
		
		int size=s.size();
		MyStack temp=new MyStack();
		toStack(root,temp);
		BSTSet result=new BSTSet();
		for (int i=0;i<size;i++){
			int a=temp.pop().element;
			if (s.isIn(a)==false){
				result.add(a);
			}
		}
		return result;

	}
*******************************************Method**************************************************	
	public int height(){
		if(root==null){
			return -1;
		}
		return height(root);
	}

	private int height(TNode node){
		if (node==null){
			return 0;
		}
		int leftNode=height(node.left);
		int rightNode=height(node.right);
		if (leftNode>rightNode){
			return leftNode+1;
		}
		else{
			return rightNode+1;
		}
	}
*******************************************Method**************************************************
	public void toStack(TNode root, MyStack temp) throws Exception {
		if(root!=null){
			toStack(root.right,temp);
			temp.push(root);
			toStack(root.left,temp);			
		}
	}
        
*******************************************Method**************************************************
        public void printNonRec()throws Exception {
            int size=this.size();
            MyStack temp=new MyStack();
            toStack(root,temp);
		for (int i=0;i<size;i++){
			System.out.println(temp.pop().element);
			}
		}
  }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////