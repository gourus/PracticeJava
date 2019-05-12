package dontKnow;


/**
 *	
 *	This program is to find the max sum path from any leaf node 
 * 	to the root node in a tree. Tree may or may not contain binary
 * 	tree properties. But this tree should have max 2 children. 
 * 
 * 	Source : Geeks for geeks
 *
 */

// Tree node.
class Node
{
	public int data;
	public Node left;
	public Node right;
	
	public Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}

// To store Maximum Sum.
class MaximumNum
{
	public int max;
	
	public MaximumNum()
	{
		max = 0;
	}
}


public class MaxSumFromRootToLeafInATree {
	
	public Node targetLeaf = null;
	public MaximumNum maxNum = new MaximumNum();
	
	// To print the tree using Inorder traversal. 
	// Just added this function.
	public void printInorder(Node root)
	{
		if(root != null)
		{
			printInorder(root.left);
			System.out.print(root.data + "\t");
			printInorder(root.right);
		}
	}
	
	// Prints the path from leaf node to root.
	public boolean printPath(Node root, Node target)
	{
		if(root==null)
		{
			return false;
		}
		
		if(root == target || printPath(root.left, target) || printPath(root.right, target) )
		{
			System.out.print(root.data + " -> ");
			return true;
		}
		
		return false;
		
	}

	
	
	public static void main(String... args) {
		
		Node root = new Node (10);
		
		root.left = new Node (5);
		root.right = new Node (20);
		
		root.left.left = new Node(2);
		root.left.right = new Node (7);

		root.right.left = new Node(15);
		root.right.right = new Node (25);
		 
		
		MaxSumFromRootToLeafInATree  maxSum= new MaxSumFromRootToLeafInATree();
		
		//maxSum.printInorder(root);
		
		int sum = 0;
		int currentSum = 0;
		
		maxSum.maxSumFromRootToLeaf(root, sum, currentSum);
		
		System.out.println("Maximum Sum : " + maxSum.maxNum.max);
		System.out.print("Maximum Sum path is : ");
		maxSum.printPath(root, maxSum.targetLeaf);
		
		
	}


	// This method calculate the max sum from root to leaf and finds the leaf node.
	private void maxSumFromRootToLeaf(Node root, int sum, int currentSum) {

		if(root == null)
		{
			return;
		}
		
		// Store the sum
		currentSum = currentSum + root.data;
		
		// If you came across leaf node while parsing, then check whether this  
		// gives the max sum up to here. If yes, then store it.
		if(root.left == null && root.right == null)
		{
			if(currentSum > sum)
			{
				sum = currentSum;
				targetLeaf = root;
				maxNum.max = sum;
				return;
			}
		}
		
		maxSumFromRootToLeaf(root.left, sum , currentSum);
		maxSumFromRootToLeaf(root.right, sum, currentSum);
		
	}
	
}
