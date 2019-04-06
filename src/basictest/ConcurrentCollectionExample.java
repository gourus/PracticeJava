package basictest;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentCollectionExample {
	
	ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
	
	ReentrantLock rl = new ReentrantLock();
	
	ReentrantReadWriteLock rrl = new ReentrantReadWriteLock();
	
	
	public static void main(String args[])
	{
		ArrayList<Integer> al = new ArrayList<Integer>();

		CopyOnWriteArrayList<Integer> cal = new CopyOnWriteArrayList<Integer>();
		
	}

}
