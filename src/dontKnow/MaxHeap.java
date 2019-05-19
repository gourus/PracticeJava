package dontKnow;

public class MaxHeap {

	private int [] heap;
	private int size;
	private int maxSize; 
	
	public MaxHeap(int size)
	{
		this.heap = new int[size];
		this.maxSize = size;
		this.size = 0;
	}
	
	private void swap(int i, int j)
	{
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
		
	}
	
	private int parent(int i)
	{
		return (i-1)/2;
	}
	
	private int left(int i)
	{
		return 2*i+1;
	}
	
	private int right(int i)
	{
		return i*i +2;
	}
	
	//Insert.
	//Insert last and compare with parent.
	// If it is greater, then swap and do the same until current == root
	// NOTE: For MAX_HEAP
	
	private void insert(int value)
	{
		if(size == maxSize)
		{
			new RuntimeException("Heap is full...");
		}
		
		heap[size] = value;
		
		int current = size;
		
		while(current != 0 && heap[current] > heap[parent(current)])
		{
			swap(current , parent(current));
			current = parent(current);
		}
		
		size++;
		
	}
	
	// Heapify the value from given index
	private void maxHeapify( int i)
	{
		int l = left(i);
		int r = right(i);
		
		int largest = i;
		
		if(l < size && heap[largest] < heap[l])
		{
			largest = l;
		}
		
		if(r < size && heap[largest] < heap[r] )
		{
			largest = r;
		}
		
		if(largest != i)
		{
			swap(largest,i);
			
			maxHeapify(largest);
		}
	}
	
	// Extract max value from heap
	// assign last value to root value and heapify root
	private int extractMax()
	{
		int res = heap[0];
		
		heap[0] = heap[size-1];
		size--;
		maxHeapify(0);
		return res;
	}
	
	public static void main(String[] args) {
		
		MaxHeap maxHeap = new MaxHeap(10);
		
		maxHeap.insert(10);
		maxHeap.insert(3);
		maxHeap.insert(55);
		maxHeap.insert(1);
		maxHeap.insert(23);
		maxHeap.insert(34);
		maxHeap.insert(0);
		maxHeap.insert(122);
		maxHeap.insert(9);
		
		for(int i=0; i<9; i++ )
		{
			System.out.print(maxHeap.extractMax() + " ");
		}
		
		System.out.println();
		
	}
	
}
