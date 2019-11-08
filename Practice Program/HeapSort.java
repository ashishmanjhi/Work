package com.ref;

public class HeapSort {
	
	//Sort function
    public void sort(int arr[]) 
    { 
        int n = arr.length; 
  
       //Create Heap
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        //Extract element from heap
        for (int i=n-1; i>=0; i--) 
        { 
            
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            //heap function on updated heap 
            heapify(arr, i, 0); 
        } 
    } 
  
   //Heap function
    void heapify(int arr[], int n, int i) 
    { 
    	//largest as root, l as left, r as right
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2; 
  
        //left is larger than root
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        //right larger than root
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        //largest is not root
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            
            heapify(arr, n, largest); 
        } 
    }

}
