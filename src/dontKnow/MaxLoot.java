package dontKnow;

/*
 * 
 * Find maximum possible stolen value from houses
 * 
 * There are n houses build in a line, each of which contains some value in it.
 * A thief is going to steal the maximal value of these houses, but he can’t steal in two adjacent houses 
 * because owner of the stolen houses will tell his two neighbor left and right side. 
 * 
 * 
 * What is the maximum stolen value?
 * 
 * 
 * NOTE: This solution also solves, "Maximum sum such that no two elements are adjacent" problem.
 * 
 */

public class MaxLoot {
	
	
	
	public static void main(String args[])
	{
		int a[] = {6, 7, 1, 3, 8, 2, 4}; 
		
		int arr[] = {5, 5, 10, 100, 10, 5}; 
		
		int size = a.length;
		
		System.out.println(	solution(a,size));
		System.out.println(solution(arr,arr.length));
		
	}

	private static int solution(int[] a, int size) {
		
		if(size == 0)
			return 0;
		
		if(size == 1)
			return a[0];
		
		if(size == 2)
			return Math.max(a[0], a[1]);
		
		int dp[] = new int[size];
		
		
		dp[0] = a[0];
		dp[1] = Math.max(a[0], a[1]);
		
		for(int i=2; i<size; i++)
		{
			dp[i] = Math.max(a[i]+dp[i-2], dp[i-1]);
		}
		
		return dp[size-1];		
	}

}
