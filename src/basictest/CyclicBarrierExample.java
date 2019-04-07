package basictest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 
 * Real time Example for Cyclic Barrier.
 * 
 * If 10 People planned to go for picnic or Vacation. They thought like to start from one place.
 * 
 * 2 persons are arrived at the place and waiting for the remaining people to arrive.
 * 
 * Here the place is barrier and people are threads.
 * 
 * 
 */


public class CyclicBarrierExample {
	
	public static void main(String args[])
	{
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		
		executorService.execute(new TaskCyclic(cyclicBarrier, "Thread 1"));
		executorService.execute(new TaskCyclic(cyclicBarrier, "Thread 2"));
		executorService.execute(new TaskCyclic(cyclicBarrier, "Thread 3"));
		
		// Main thread can perform its tasks...
		
	}

}


class TaskCyclic implements Runnable
{
	private CyclicBarrier cyclicBarrier;
	private String name;
	
	public TaskCyclic(CyclicBarrier c, String n) {
		cyclicBarrier = c;
		name = n;
	}
	
	@Override
	public void run() {
		
		//while(true)
		{
			System.out.println(name + " Executing... ");
			
			try {
				
				cyclicBarrier.await();
			
				Thread.sleep(1000);
				
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			
			// Code here will get executed when all threads are arrived.
			
			System.out.println(name + " Completed...");
			
			
		}
		
	}
	
}