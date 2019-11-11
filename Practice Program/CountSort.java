package com.ref;

public class CountSort {
	void sort(char arr[]) 
    { 
        int n = arr.length; 
  
        // The sorted array 
        char output[] = new char[n]; 
  
        // Create a count array and initialize count array as 0 
        int count[] = new int[256]; 
        for (int i=0; i<256; ++i) 
            count[i] = 0; 
  
        // store count of each character 
        for (int i=0; i<n; ++i) 
            ++count[arr[i]]; 
  
        //  count[i] now contains actual position of this character  
        for (int i=1; i<=255; ++i) 
            count[i] += count[i-1]; 
  
        // Build the output character array 
        for (int i = n-1; i>=0; i--) 
        { 
            output[count[arr[i]]-1] = arr[i]; 
            --count[arr[i]]; 
        } 
  
        //  arr contain sorted characters 
        for (int i = 0; i<n; ++i) 
            arr[i] = output[i]; 
    }
}
