package toptal;

public class Test {
	
	
	public static int solution(String s)
	{
		int res=0;
		
		
		String sarr[] = s.split(",");
		
		if(sarr.length == 0 || sarr.length == 1)
		{
			return 0;
		}
		
		if(sarr.length == 2)
		{
			String s1 = sarr[0];
			String s2 = sarr[1];
			
			if(s1.charAt(s1.length()-1) == s2.charAt(0))
			{
				return 2;
			}
			else
			{
				return 0;
			}
		}
		
		
		// Size greater than 2
		
		int previous = -1;
		
		for(int i=0; i< sarr.length-1 ; i++)
		{
			String s1 = sarr[i];
			String s2 = sarr[i+1];
			
			if(s1.charAt(s1.length()-1) == s2.charAt(0))
			{
				if(previous != i)
				{
					res += 2;
				}
				else
				{
					res += 1;
				}
				previous = i+1;
				//i +=1;
			}
		}

		return res;
	}
	
	
	
	public static void main(String[] args) {

//		System.out.println(solution("1-1"));
//		System.out.println(solution("1-1,1-2,2-1,3-3"));
//		System.out.println(solution("1-1,1-2,1-1,1-2,2-3"));
		
		System.out.println(solution("1-1,3-5,5-2,2-3,2-4"));
//		
		//System.out.println(solution("1-1")); // 1
	//	System.out.println(solution("1-2,1-2")); // 1
		
		System.out.println(solution("3-2,2-1,1-4,4-4,5-4,4-2,2-1")); // 4
		
		System.out.println(solution("5-5,5-5,4-4,5-5,5-5,5-5,5-5,5-5,5-5,5-5")); // 7
		
		System.out.println(solution("1-1,3-5,5-5,5-4,4-2,1-3")); // 4
		
		System.out.println(solution("1-2,2-2,3-3,3-4,4-5,1-1,1-2")); // 3
		

	}

}
