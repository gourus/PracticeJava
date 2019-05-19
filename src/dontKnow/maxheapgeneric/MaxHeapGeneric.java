package dontKnow.maxheapgeneric;


public class MaxHeapGeneric<E> {

	private Object [] heap;
	private int size;
	private int maxSize; 
	
	public Object[] getHeap() {
		return heap;
	}

	public int getSize() {
		return size;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setHeap(Object[] heap) {
		this.heap = heap;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public MaxHeapGeneric(int size)
	{
		this.heap = new Object[size];
		this.maxSize = size;
		this.size = 0;
	}
	
	private void swap(int i, int j)
	{
		Object temp = heap[i];
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
	
	public void insert(Object value)
	{
		
		if(size == maxSize)
		{
			new RuntimeException("Heap is full...");
		}

		Comparable<? super E> key;
		
		heap[size] = value;
		
		int current = size;
		
		while(current != 0 )
		{
			key = (Comparable<? super E>)heap[current];

			if( key.compareTo((E) heap[parent(current)]) > 0)
			{
				swap(current , parent(current));
				current = parent(current);
			}
			else
			{
				break;
			}

		}
		
		size++;
		
	}
	
	// Heapify the value from given index
	private void maxHeapify( int i)
	{
		int l = left(i);
		int r = right(i);
		Comparable<? super E> key;
		
		int largest = i;
		
		key = (Comparable<? super E>)heap[largest];
		
		if( l < size  && key.compareTo((E) heap[l]) < 0 )
		{	
			largest = l;
		}

		key = (Comparable<? super E>)heap[largest];
		
		if(r < size && key.compareTo((E) heap[r]) < 0)
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
	public Object extractMax()
	{
		Object res = heap[0];
		
		heap[0] = heap[size-1];
		size--;
		maxHeapify(0);
		return res;
	}
	
	public static void main(String[] args) {
		
		MaxHeapGeneric<Integer> maxHeap = new MaxHeapGeneric<Integer>(10);
		
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
	
		
		MaxHeapGeneric<Key> keyMaxHeap = new MaxHeapGeneric<Key>(3);
		
		// Testing with Key class
		keyMaxHeap.insert(new Key('a', 3));
		keyMaxHeap.insert(new Key('b',1));
		keyMaxHeap.insert(new Key('c',1));
		
		for(int i=0; i<3; i++ )
		{
			System.out.print(keyMaxHeap.extractMax());
		}
		
		System.out.println();
		
		
	}
		
		
	
}
