package basictest;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class BFS {
	
	private int vertices;
	private LinkedList<Integer> graph[];
	
	@SuppressWarnings("unchecked")
	public BFS(int v)
	{
		vertices = v;
		graph = new LinkedList[v];
		
		for (int i=0; i<vertices; i++)
		{
			graph[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w)
	{
		graph[v].add(w);
	}
	
	/*
	 * Parses through graph from given start node.
	 * This will be like level order traversal.
	 */
	public void bfs(int s)
	{
		
		boolean [] visited = new boolean[vertices];
		Arrays.fill(visited, false);
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		queue.add(s);
		visited[s] = true;
		
		while(queue.size() != 0)
		{
			int data = queue.poll();
			System.out.println(data + " ");
			
			/*
			 * We need to visit all nodes of "data".
			 */
			
			ListIterator<Integer> it = graph[data].listIterator();
			while(it.hasNext())
			{
				int d = it.next();
				if(!visited[d])
				{
					queue.add(d);
					visited[d] = true;
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		BFS g = new BFS(4);
		
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        
        g.bfs(2);
		
	}
	
}
