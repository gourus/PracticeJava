package dontKnow;

/**
 * 
 * @author sgouru
 *
 *	I think this solution is O(n2) one. we can optimize this also like, 
 *	
 *	if a node is BST, then every children of the node is BST only.
 *
 *
 */

public class CalculateNumberOfBSTs {
	
	public static int preValue = Integer.MIN_VALUE;
	
	
	private boolean isBst(Node root)
	{
		preValue = Integer.MIN_VALUE;
		return isBSTUtil(root);
		
	}

	private boolean isBSTUtil(Node root) {
		
		if(root != null)
		{	
			if( !isBSTUtil (root.left))
			{
				return false;
			}
				
			if( preValue > root.data )
			{
				return false;
			}
		
			preValue = root.data;
				
			if( !isBSTUtil (root.right))
			{
				return false;
			}
		}
		
		return true;
	}
	
	
	private int getNumberOfNodes(Node root)
	{
		if(root == null)
		{
			return 0;
		}
		
		return 1 + getNumberOfNodes(root.left) + getNumberOfNodes(root.right);
	}
	
	private int calcNumberOfBsts(Node root)
	{
		if(root == null)
		{
			return 0;
		}
		
		
		if( !isLeaf(root) && isBst(root))
		{
			return 1 + calcNumberOfBsts(root.left) + calcNumberOfBsts(root.right);
		}
		
		return calcNumberOfBsts(root.left) + calcNumberOfBsts(root.right);
	}
	
	private boolean isLeaf(Node root) {
		
		if(root != null && (root.left == null && root.right == null))
		{
			return true;
		}
		
		return false;
	}

	private int calcTotalBSTs(Node root)
	{
		int res = 0;
		
		int nNodes = getNumberOfNodes(root);
		
		int nBsts = calcNumberOfBsts(root);
		
		res = nNodes + nBsts;
		
		return res;
	}
	
	
	public static void main(String[] args) {
		
		
	    /*
				  5
			     /  \
			    9    3
			   /   	   \
			  6      	4
			 / \
			8   7
		
		*/
		
		Node root = new Node(5); 
	    root.left = new Node(9); 
	    root.right = new Node(3); 
	    root.left.left = new Node(6); 
	    root.right.right = new Node(4); 
	    root.left.left.left = new Node(8); 
	    root.left.left.right = new Node(7); 
	  
	    CalculateNumberOfBSTs cnb = new CalculateNumberOfBSTs();
	    
	    System.out.println( cnb.calcTotalBSTs(root)); 
	    
	    /*
	     			  11
				     /  \
				    8    10
				   /    /  \
				  5    9    8
				 / \
				4   6
	     
	     */
	    
	    Node root1 = new Node(11);
	    
	    root1.left = new Node(8);
	    root1.right = new Node(10);
	    
	    root1.left.left = new Node(5);
	    root1.right.left = new Node(9);
	    root1.right.right = new Node(8);
	    
	    root1.left.left.left = new Node(4);
	    root1.left.left.right = new Node(6);
	    
	    System.out.println( cnb.calcTotalBSTs(root1)); 

	    
	}
	
	
	

}
