package dontKnow;

import java.util.PriorityQueue;

/**
 * @author sgouru
 *
 *	Geeks For Geeks
 *	
 *	Approach is to create a queue (PQ) , to store the elements with frequency as priority.
 *	Re create String by arranging the characters in the Queue by taking the highest repeating 
 *	character first and reduce the frequency and repeat the same until Queue is empty.		
 *
 *	Finally, compare the original string with newly created string, if the length same, 
 *	then print it, else print no.
 *	
 */


class Key implements Comparable<Key>
{
	int freq;
	char ch;
	
	public Key(char c, int f)
	{
		ch = c;
		freq = f;
	}
	
	@Override
	public int compareTo(Key o) {
		
		if(freq < o.freq)
			return 1;
		else if(freq > o.freq)
			return -1;
		else
			return 0;
	}
	
}


public class NoAdjacentCharacterInString {
	
	
	static String modifyStrAlgo(String str)
	{
		PriorityQueue<Key> pQueue = new PriorityQueue<Key>();
		
		// Count the character frequency
		
		int charFreq [] = new int[26];
		

		for(int i=0; i<str.length();i++)
		{
			charFreq[str.charAt(i)-'a']++; // Assuming string contains only lower case characters	
		}
		
		// Form priority queue
		for(char c = 'a' ; c<='z' ; c++ )
		{
			int index = c - 'a';
			
			if(charFreq[index] != 0 )
			{
				pQueue.add(new Key(c, charFreq[index]));
			}
		}
		
		Key prev = new Key('$',-1);
		String res = "";
		
		while(!pQueue.isEmpty())
		{
			Key k = pQueue.peek();
			pQueue.poll();
			
			res = res + k.ch;
			
			if(prev.freq > 0)
				pQueue.add(prev);
			
			(k.freq)--;
			prev = k;
			
		}
		
		if(str.length() == res.length())
		{
			return res;
		}
		else
		{
			return "Not Possible";
		}
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("input String (aa) : "+modifyStrAlgo("aa"));
		System.out.println("input String (aaabc) : "+modifyStrAlgo("aaabc"));
		System.out.println("input String (abcd) : "+modifyStrAlgo("abcd"));
		System.out.println("input String (aaabbbbbb) : "+modifyStrAlgo("aaaabbbbbb"));

	}

}
