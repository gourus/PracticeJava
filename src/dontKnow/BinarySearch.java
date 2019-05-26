package dontKnow;

public class BinarySearch {
	
	private int [] a;
	
	public BinarySearch(int [] arr, int size)
	{
		a = new int[size];
		
		for(int i=0; i<arr.length; i++)
		{
			a[i] = arr[i];
		}
	}
	
	public boolean search(int data)
	{
		
		return binarySearchUtil(data, 0, a.length-1);
		
	}

	private boolean binarySearchUtil(int data, int s, int e) {
		
		boolean res = false;
		
		if(s > e)
		{
			return false;
		}
		
		int mid = s+ (e-s)/2;
		
		if(data == a[mid])
		{
			res = true;
		}
		else if(data < a[mid])
		{
			res = binarySearchUtil(data, s, mid-1);
		}
		else
		{
			res = binarySearchUtil(data, mid+1, e);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		int arr [] = {1,3,5,6,8,10,22,44,77,100};
		
		BinarySearch binarySearch = new BinarySearch(arr, arr.length);
		
		//System.out.println("22 - "+binarySearch.search(22));
		//System.out.println("2333 - "+ binarySearch.search(2333));
		System.out.println("-1 - "+ binarySearch.search(-1));
		
		
		
	}
	

}