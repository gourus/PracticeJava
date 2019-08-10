package dontKnow;

import java.util.ArrayList;
import java.util.Collections;

public class StringPermutations {
	
	public ArrayList<String> resList = new ArrayList<String>();
	
	
	
	public void calcPermutations(String s, int l, int r)
	{
		
		if(l == r)
		{
			resList.add(s);
			return;
		}
		
		for(int i=l ; i<=r ; i++)
		{
			s = swap(s,l,i);
			calcPermutations(s,l+1,r);
			s = swap(s,l,i);
		}
	}
	
	 /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    
    public static void main(String[] args) {
		
    	StringPermutations sp = new StringPermutations();
    	
    	sp.calcPermutations("ABC", 0, 2);
    	
    	System.out.println(sp.resList);
    	Collections.sort(sp.resList);
    	System.out.println(sp.resList);
    	
    	
	}

}
