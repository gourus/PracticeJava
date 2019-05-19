package dontKnow.maxheapgeneric;

/**
 * @author sgouru
 *
 *	Geeks For Geeks
 *
 *	Create a string from existing string with no adjacent characters should be same
 *
 *	One approach is to use library function PriorityQueue
 *
 *	Here we used MaxHeap to store the values of character and its frequency.
 *	
 *	Re create String by arranging the characters in the Queue by taking the highest repeating 
 *	character first and reduce the frequency and repeat the same until mHeap is empty.
 *	
 *
 *	Finally, compare the original string with newly created string, if the length same, 
 *	then print it, else print no.
 *	
 */


public class NoAdjacentCharacterInString {
	
	
	static String modifyStrAlgo(String str)
	{
		//PriorityQueue<Key> pQueue = new PriorityQueue<Key>();
		MaxHeapGeneric<Key> mHeap = new MaxHeapGeneric<Key>(26);
		
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
				mHeap.insert(new Key(c, charFreq[index]));
			}
		}
		
		Key prev = new Key('$',-1);
		String res = "";
		
		while(mHeap.getSize() != 0)
		{
			Key k = (Key) mHeap.extractMax();
			
			res = res + k.ch;
			
			if(prev.freq > 0)
				mHeap.insert(prev);
			
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
