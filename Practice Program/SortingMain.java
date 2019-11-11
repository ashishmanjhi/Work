package com.ref;

import java.util.Arrays;

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
		 char arr1[]= {'g', 'e', 'e', 'k', 's', 'f', 'o', 
                 'r', 'g', 'e', 'e', 'k', 's'
                 }; 
		 
		 //Merge Sort object
		    MergeSort mergeSort = new MergeSort();
		    mergeSort.sort(arr, 0, arr.length-1); 
	        System.out.println("\n Merge Sorted array:"); 
	        printArray(arr);
	     
	        
	      //Heap Sort object
	        HeapSort heapSort = new HeapSort(); 
	        heapSort.sort(arr); 
	        System.out.println("\nHeap Sorted array is:"); 
	        printArray(arr); 
	        
	        
	      //Quick Sort object
	        QuickSort quickSort =new QuickSort(); 
	        quickSort.sort(arr, 0, arr.length-1); 
	        System.out.println("\nQuick sorted array:"); 
	        printArray(arr); 
	        
	        //Count Sort object
	        CountSort countSort=new CountSort();
	        countSort.sort(arr1);
	        System.out.println("\nCount sorting array is:");
	        for (int i=0; i<arr1.length; ++i) 
	            System.out.println(arr1[i]);
	        
	        //Shell Sort object
	        ShellSort shellSort=new ShellSort();
	        shellSort.sort(arr);
	        System.out.println("\nShell sort array is:");
	        printArray(arr);
	        
	        //Bucket Sort object
	        BucketSort bucketSort=new BucketSort();  
	        System.out.println("\nBucket sort array is:");
	        System.out.println(Arrays.toString(bucketSort.sort(arr, bucketSort.maxvalue(arr))));
	
	        
	        //Radix Sort object
	        RadixSort radixSort=new RadixSort();
	        System.out.println("\nRadix sort array is:");
	        radixSort.sort(arr);
	        printArray(arr);
	
	
	}

}
