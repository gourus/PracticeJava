package dontKnow;

public class TrappingRainWater {
	
    static int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; 

	
	int trappedRainWater(int[] a)
	{
		int w = 0;
		
		int l = a.length;
		
		int left_max [] = new int [l];
		int right_max [] = new int [l];
		
		left_max[0] = a[0];
		
		for(int i=1; i< l; i++)
		{
			left_max[i] = Math.max(a[i], left_max[i-1]);
		}
		
		right_max[l-1] = a[l-1];
		
		for(int i=l-2; i>=0; i--)
		{
			right_max[i] = Math.max(a[i], right_max[i+1]);
		}
		
		
		for(int i=0; i<l; i++)
		{
			w += Math.min(left_max[i], right_max[i]) - a[i];
		}
		
		return w;
	}
	
	public static void main(String[] args) {
		
		TrappingRainWater trw = new TrappingRainWater();
		
		System.out.println(trw.trappedRainWater(arr));
		
		//TODO: Need to work on O(1) Space complexity program
		
	}
	
	

}
