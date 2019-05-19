package dontKnow.maxheapgeneric;


public class Key implements Comparable<Key>{
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
			return -1;
		else if(freq > o.freq)
			return 1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return ch + "-"+freq + "  "; 
	}

}
