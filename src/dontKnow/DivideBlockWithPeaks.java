package dontKnow;

import java.util.ArrayList;


/*
 * 
 *  1 2 3 4 5 6 7 8
 *  
 *  4 blocks and Block Size is 2
 *  
 *  
 * 
 * 
 */


public class DivideBlockWithPeaks {
	
	
	public int solution (int [] a)
	{
		
		int aSize = a.length;
		
		ArrayList<Integer> peaks = new ArrayList<Integer>();
		
		for(int i=1; i< aSize-1; i++)
		{
			if(a[i-1] < a[i] && a[i] > a[i+1])
			{
				peaks.add(i);
			}
		}
		
		for(int i = peaks.size(); i>0; i--)
		{
			int blockSize = aSize / i;
			
			boolean foundArr[] = new boolean[blockSize];
			
			int found = 0;
			
			for(int peakIndex : peaks)
			{
				int blockIndex = peakIndex / blockSize;
				
				if(foundArr[blockIndex] == false)
				{
					foundArr[blockIndex] = true;
					found++;
				}
			
			}
			
			if(found == i)
			{
				return found;
			}
			
		}
		
		return 0;
	}
	
	public static void main(String args[])
	{
		
		DivideBlockWithPeaks divideBlockWithPeaks = new DivideBlockWithPeaks();
		int a[] = new int[] { 1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
		
		System.out.println("Max Number of blocks : " + divideBlockWithPeaks.solution(a));
		
	}
	
}
