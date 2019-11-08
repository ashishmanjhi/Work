package com.ref;

//Quick Sort
public class QuickSort {
	
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
