package com.ref;

public class SortingMain {
	
	//Function to print the array
	 static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	        System.out.println(); 
	    } 
	 
	public static void main(String[] args) {
		 int arr[] = {12, 11, 13, 5, 6, 7}; 
		 
		 //Merge Sort object
		    MergeSort ob = new MergeSort();
	        ob.sort(arr, 0, arr.length-1); 
	        System.out.println("\nSorted array"); 
	        printArray(arr);
	     
	        
	      //Heap Sort object
	        HeapSort ob1 = new HeapSort(); 
	        ob1.sort(arr); 
	        System.out.println("Sorted array is"); 
	        printArray(arr); 
	        
	        
	      //Quick Sort object
	        QuickSort ob2 =new QuickSort(); 
	        ob2.sort(arr, 0, arr.length-1); 
	        System.out.println("sorted array"); 
	        printArray(arr); 
	}
}
