package dontKnow;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * 
 * This program is to find the sub array with sum Zero
 * 
 * NOTE: We can also modify this program to find the sub array with given sum as well.
 * 		Pass the given sun to the function and instead of checking for SUM in hashmap,
 * 		check for "CurrentSum - SUM"
 *  
 */


public class FindSubArrayWithSumZero {
	
		
	static void findSubArray(int arr[])
	{
		
		int sum = 0;
		ArrayList<Pair> output = new ArrayList<Pair>();
		
		HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int i=0; i<arr.length; i++)
		{
			sum += arr[i];
			
			if(sum == 0)
			{
				output.add(new Pair(0,i));
			}
			
			ArrayList<Integer> al = new ArrayList<Integer>();
			
			
			// If HashMap already contains the sum, then the addition of
			// values between last sum Index and current values will be ZERO.
			// i.e. after adding some elements to the previous sum, if we get the 
			// same value, then the potential difference will be zero only
			if(hashMap.containsKey(sum))
			{
				al = hashMap.get(sum);
				
				for(int it=0; it<al.size() ; it++)
				{
					output.add(new Pair(al.get(it)+1,i));
				}
				
			}
			
			al.add(i);
			hashMap.put(sum, al);
			
		}
		
		
		printList(output);
	}
	
	
	static void printList(ArrayList<Pair> out)
	{
		for(Pair p : out)
		{
			System.out.println(p.first + " to " + p.second);
		}
	}
	
	
	public static void main(String args[])
	{
		
		int arr[] = new int[] {1,2,3,-1,-2,-3,4,-4};
		findSubArray(arr);
		
	}
	

}


class Pair
{
	public int first;
	public int second;
	public Pair(int f, int s)
	{
		first = f;
		second = s;
	}
}