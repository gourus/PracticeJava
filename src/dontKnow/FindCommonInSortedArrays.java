package dontKnow;


/**
 * 
 *  Given 3 sorted arrays. Find the common element of all the arrays in O(N) time 
 *  and no extra space. If there is none, return false.
 *
 */

public class FindCommonInSortedArrays {

	
	public static boolean find(int a[], int b[], int c[])
	{
		boolean found = false;
		
		int sa = 0;
		int sb = 0;
		int sc = 0;
		
		while(sa != a.length && sb != b.length && sc != c.length)
		{
			if(a[sa] == b[sb] && b[sb] == c[sc])
			{
				found = true;
				break;
			}
			
			if(a[sa]>b[sb])
			{
				sb++;
			}
			else if (b[sb] > c[sc])
			{
				sc++;
			}
			else
			{
				sa++;
			}
			
		}
		
		return found;
	}
	
	public static void main(String[] args) {
			int a[] = {2, 4, 8};
			int b[] = {2, 3, 4};
			int c[] = {4, 8, 14};
			
			System.out.println(find(a,b,c));
			
			int aa[] = {1,2,3};
			int bb[] = {20,30,40};
			int cc[] = {33,44,55};
			System.out.println(find(aa,bb,cc));
		   
	}
	
}