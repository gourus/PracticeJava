package dontKnow;

class bNode
{
	public int data;
	bNode left;
	bNode right;
	
	public bNode(int d)
	{
		data = d;
		left = right = null;
	}
}

public class SortedArrayToBinaryTree {
	
	bNode r = null;
	
	int [] arr;
		
	public SortedArrayToBinaryTree(int [] a)
	{
		arr = new int[a.length];
		
		for(int i=0; i<a.length ; i++)
		{
			arr[i] = a[i];
		}
		
	}
	
	public void convert()
	{
		r = sortedArrayToBinaryTreeConversionUtil( 0 , arr.length-1);
	}

	private bNode sortedArrayToBinaryTreeConversionUtil( int i, int j) {
		
		if(i > j)
		{
			return null;
		}
		
		int mid = i + (j-i)/2;
		
		bNode root = new bNode(arr[mid]);
		
		
		root.left = sortedArrayToBinaryTreeConversionUtil( i , mid-1);
		root.right = sortedArrayToBinaryTreeConversionUtil( mid+1 , j);
		
		return root;
		
	}
	
	private void inorder(bNode root)
	{
		if(root != null)
		{
			inorder(root.left);
			System.out.print(root.data + "  ");
			inorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		
		int a[] = {1,2,3,4,6,7,8};
		
		SortedArrayToBinaryTree sbt = new SortedArrayToBinaryTree(a);
		
		// Converts Array to BST
		sbt.convert();
		
		// To print the BST
		sbt.inorder(sbt.r);
		
		
	}
	
}
