package dontKnow;

import java.util.ArrayList;


/*
 * Question:
 * 	
 * 		Divide array into equal sized subsets and each subset should contain at least one peak.
 * 		Find max number of subsets ?
 * 			
 *  
 */


public class DivideBlockWithPeaks {
	
	
	public int solution (int [] a)
	{
		
		int aSize = a.length;
		
		ArrayList<Integer> peaks = new ArrayList<Integer>();
		
		// Calculate the peaks
		for(int i=1; i< aSize-1; i++)
		{
			if(a[i-1] < a[i] && a[i] > a[i+1])
			{
				peaks.add(i);
			}
		}
		
		// We can get the number of subsets as equal to number of peaks or less 
		// So run the loop  for number of peaks.
		
		// Calculate the block size with respect to peak size, and check each block consists at least one peak.
		// If any block without peak, then ignore them and continue loop by reducing the peak size.
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
