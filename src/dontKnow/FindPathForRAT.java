package dontKnow;

public class FindPathForRAT {

	
	private static int N = 4;
	
	// Idea is to USE Back Tracing
	static void solution(int a[][])
	{
		int sol[][] = {{0, 0, 0, 0}, 
	            {0, 0, 0, 0}, 
	            {0, 0, 0, 0}, 
	            {0, 0, 0, 0} 
	        };
		
		if(solutionHelper(a,0,0,sol) == true)
		{
			printSolution(sol);
		}
		else
		{
			System.out.println("No possible solutiuon :-( ");
		}
	}
	
	private static void printSolution(int[][] sol) {
		
		for(int i=0; i< N; i++)
		{
			for(int j=0; j<N ; j++)
			{
				System.out.print(" " + sol[i][j] +  " "); 
			}
			System.out.println(); 
		}
		
	}

	private static boolean solutionHelper(int[][] a, int x, int y, int[][] sol) {
		
		if(x==N-1 && y == N-1)
		{
			sol[x][y] = 1;
			return true;
		}
		
		if(isSafe(x,y,a))
		{
			
			sol[x][y] = 1;
			
			if(solutionHelper (a, x+1, y, sol) == true)
			{
				return true;
			}
			
			if(solutionHelper(a,x,y+1,sol) == true)
			{
				return true;
			}
			
			sol[x][y] = 0;
			
		}
		
		return false;
	}

	private static boolean isSafe(int x,int y, int m[][])
	{
		
		if(x >= 0 && x < N && y >= 0 && y < N && m[x][y]==1)
		{
			return true;
		}
		
		return false;
	}
	
	
	public static void main(String args[])
	{
		int arr[][] = {	{1,0,0,0},
						{1,1,0,1},
						{0,1,1,1},
						{0,0,0,1},
						};
		
		
		solution(arr);
	}
}
