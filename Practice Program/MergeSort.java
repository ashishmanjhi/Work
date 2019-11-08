package com.ref;

public class MergeSort {

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
}
