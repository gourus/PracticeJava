package dontKnow;

import java.util.Stack;


/*
 * 
 * 
 * Sort stack without using another stack and memory ( We can use function stack)
 * 
 * Added : Reverse Stack
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
	
	
	public void reverseStack(Stack<Integer> s)
	{
		if(!s.isEmpty())
		{
			int temp = s.pop();
			
			reverseStack(s);
			
			insertAtBottom(s,temp);
			
		}
	}


	private void insertAtBottom(Stack<Integer> s, int temp) {

		if(s.isEmpty())
		{
			s.push(temp);
		}
		else
		{
			int x = s.pop();
			insertAtBottom(s, temp);
			s.push(x);
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
		
		sortStack.reverseStack(stack);
		
		/*
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
		*/
		
		System.out.println(stack.toString());
		
	}

}
