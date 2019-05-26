package dontKnow.knapsack;

public class Knapsack_0_1 {
	
	public int maxValue;
	
	public Knapsack_0_1()
	{
		maxValue = 0;
	}
	
	public int calMaxValue(int c, int wt[], int v[], int n)
	{
		if(c==0 || n == 0)
		{
			return 0;
		}
		
		if(c < wt[n-1])
		{
			return calMaxValue(c, wt, v, n-1);
		}
		
		return Math.max(calMaxValue(c, wt, v, n-1), v[n-1] + calMaxValue(c-wt[n-1], wt, v, n-1));	
	}
	
	
	public static void main(String[] args) {
		Knapsack_0_1 knapsack_0_1 = new Knapsack_0_1();
		int[] wt = {10, 40, 20, 30}; 
        int[] val = {60, 160, 100, 120}; 
        int capacity = 50; 

		knapsack_0_1.maxValue = knapsack_0_1.calMaxValue(capacity, wt, val, wt.length);
		
		System.out.println(knapsack_0_1.maxValue);
				
	}
	
	
	
	

}