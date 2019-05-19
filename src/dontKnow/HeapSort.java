package dontKnow;

import java.util.Arrays;

public class HeapSort {
	
	private void swap(int arr[] , int i, int j)
	{
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	
	public void heapify(int [] arr,int n, int i)
	{
		int l = 2*i + 1;
		int r = 2*i + 2;
		int largest = i;
		
		if(l < n && arr[largest] < arr[l])
		{
			largest = l;
		}
		
		if(r < n && arr[largest] < arr[r] )
		{
			largest = r;
		}
		
		if(largest != i)
		{
			swap(arr,largest,i);
			
			heapify(arr,n, largest);
		}
		
	}
	
	
	public void heapSort(int arr[], int n)
	{
		for(int i=n/2 ; i >=0 ; i--)
		{
			heapify(arr,n,i);
		}
		
		for(int i=n-1; i>=0; i--)
		{
			swap(arr, 0, i);
			
			heapify(arr, i, 0);
			
		}	
	}
	
	public static void main(String[] args) {
		
		HeapSort heapSort = new HeapSort();
		
		int [] arr = {2,11,5,22,9,0};
		
		Arrays.stream(arr).map(e->e).forEach(e-> System.out.print(e + " "));

		/*
		//Arrays.stream
        IntStream stream1 = Arrays.stream(arr);
        stream1.forEach(x -> System.out.println(x));
		*/

		System.out.println();
		
		heapSort.heapSort(arr, arr.length);
		
		Arrays.stream(arr).map(e->e).forEach(e-> System.out.print(e + " "));

	}
	

}
