package com.ref;

public class Sorting {
	
	//---------------------------------------------------------------------------------------------
	// Quick Sort
	class QuickSort 
	{ 
	   //Partition function
	    int partition(int arr[], int low, int high) 
	    { 
	    	//Last element as pivot
	        int pivot = arr[high];  
	        int i = (low-1); 
	        for (int j=low; j<high; j++) 
	        { 
	           //current element is smaller than pivot
	            if (arr[j] < pivot) 
	            { 
	                i++;  
	                int temp = arr[i]; 
	                arr[i] = arr[j]; 
	                arr[j] = temp; 
	            } 
	        } 
	   
	        int temp = arr[i+1]; 
	        arr[i+1] = arr[high]; 
	        arr[high] = temp; 
	  
	        return i+1; 
	    } 
	  
	  //Sort function
	    void sort(int arr[], int low, int high) 
	    { 
	        if (low < high) 
	        { 
	          // pi is partition index
	            int pi = partition(arr, low, high); 
	  
	           //sort element before and after partion
	            sort(arr, low, pi-1); 
	            sort(arr, pi+1, high); 
	        } 
	    } 
	  
	} 
//-----------------------------------------------------------------------------------------
	// Heap Sort
	public class HeapSort 
	{ 
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
	
	//-------------------------------------------------------------------------------------------------
	// Merge Sort
	class MergeSort 
	{ 
	  // Merge two sub arrays 
	    void merge(int arr[], int l, int m, int r) 
	    { 
	        // size of two sub array
	        int n1 = m - l + 1; 
	        int n2 = r - m; 
	  
	        //create two temp array
	        int L[] = new int [n1]; 
	        int R[] = new int [n2]; 
	  
	       // insert element in temp array
	        for (int i=0; i<n1; ++i) 
	            L[i] = arr[l + i]; 
	        for (int j=0; j<n2; ++j) 
	            R[j] = arr[m + 1+ j]; 	  
	  
	        //index of two sub array
	        int i = 0, j = 0; 
	  
	       // index of final array after merge
	        int k = l; 
	        while (i < n1 && j < n2) 
	        { 
	            if (L[i] <= R[j]) 
	            { 
	                arr[k] = L[i]; 
	                i++; 
	            } 
	            else
	            { 
	                arr[k] = R[j]; 
	                j++; 
	            } 
	            k++; 
	        } 
	  
	       //insert remaining elements
	        while (i < n1) 
	        { 
	            arr[k] = L[i]; 
	            i++; 
	            k++; 
	        } 
	  
	       
	        while (j < n2) 
	        { 
	            arr[k] = R[j]; 
	            j++; 
	            k++; 
	        } 
	    } 
	 
	  
	    // Sort function
	    void sort(int arr[], int l, int r) 
	    { 
	        if (l < r) 
	        { 
	          // middle index
	            int m = (l+r)/2; 
	  
	           // Sort two halves
	            sort(arr, l, m); 
	            sort(arr , m+1, r); 
	  
	            // Merge the two halves
	            merge(arr, l, m, r); 
	        } 
	    }   
	    
	} //----------------------------------------------------------------------------------------------
	
	//Function to print the array
	 static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	        System.out.println(); 
	    } 
	 
	 
	 // Main method
	public static void main(String[] args) {
		 int arr[] = {12, 11, 13, 5, 6, 7}; 
		 Sorting many=new Sorting();
		 
		 //Merge Sort object
		    MergeSort ob = many.new MergeSort();
	        ob.sort(arr, 0, arr.length-1); 
	        System.out.println("\nSorted array"); 
	        printArray(arr);
	     
	        
	      //Heap Sort object
	        HeapSort ob1 = many.new HeapSort(); 
	        ob1.sort(arr); 
	        System.out.println("Sorted array is"); 
	        printArray(arr); 
	        
	        
	      //Quick Sort object
	        QuickSort ob2 = many.new QuickSort(); 
	        ob2.sort(arr, 0, arr.length-1); 
	        System.out.println("sorted array"); 
	        printArray(arr); 
	}
}
