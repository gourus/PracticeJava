package dontKnow;

import java.util.Stack;


/*
 * 
 * 
 * Sort stack without using another stack and memory ( We can use function stack)
 * 
 * 
 */


public class SortStack {
	
	public void sortStack(Stack<Integer> s)
	{
		if(!s.empty())
		{
			int temp = s.pop();
			
			sortStack(s);
			
			insertInSortedOrder(s,temp);
		}
	}
	
	
	private void insertInSortedOrder(Stack<Integer> s, int temp) {

		if(s.isEmpty() || temp > s.peek())
		{
			s.push(temp);
		}
		else
		{
			int a = s.pop();
			
			insertInSortedOrder(s, temp);
			
			s.push(a);
			
		}
		
	}


	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(30);
		stack.push(20);
		stack.push(60);
		stack.push(-10);
		stack.push(10);
		
		System.out.println(stack.toString());

		
		SortStack sortStack = new SortStack();
		
		sortStack.sortStack(stack);
		
		System.out.println(stack.toString());
		
	}

}
