package basictest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatchExample {
	
	public static void main(String args[]) throws InterruptedException
	{
		CountDownLatch countDownLatch = new CountDownLatch(3);
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		executorService.execute(new Task(countDownLatch,"Thread 1"));
		executorService.execute(new Task(countDownLatch,"Thread 2"));
		executorService.execute(new Task(countDownLatch,"Thread 3"));

		countDownLatch.await();
		
		
		System.out.println("All remaining threads are completed there countdown... ");
		System.out.println("Completing main now...");
		
		
		executorService.shutdown(); 
		
	}

}


class Task implements Runnable
{
	private CountDownLatch countDownLatch;
	private String name;
	
	public Task(CountDownLatch cl, String n) {
		countDownLatch = cl;
		name = n;
	}
	

	@Override
	public void run() {
		
		System.out.println(name + " Executing...");
		
		countDownLatch.countDown();
		
		// Do countdown and continue to do other operations
		
		System.out.println(name + " Completed...");
		
		
	}
	
}