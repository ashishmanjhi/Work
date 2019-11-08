package com.ref;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LargestAndSecond {

	// Program for Second Largest no using sorting
public static	int secondHighest(int a[]) {

	int sh=0;
	if (a.length != 0) {
		for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if (a[j] > a[j+1])
                {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
		}
		}
	
		 sh=a[a.length-2];
	}
	else
	{
		sh=0;
		System.out.println("no element");
	}
		return sh;
	}


// Program for  Largest no
	public static int getMaxElement(int input[]) {
		int max = 0;
		if (input.length != 0) {
			max = input[0];
			for (int i = 1; i < input.length; i++) {
				if (max < input[i]) {
					max = input[i];
				}
			}

		}
		return max;
	}
	
	//Find the Largest no using stream
	public static int largestStream() {
		 List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
		 
	     Optional<Integer> maxNumber = list.stream().max((i, j) -> i.compareTo(j));
	     return maxNumber.get();
		} 

	
	// Find the second Largest no without sorting
	public static int printSecondLargest(int arr[])  throws Exception
	 { 
		 int size=arr.length;
	     int i, first, second; 
	     if (size < 2) 
	     { 
	        throw new Exception("less than two number in the array " +arr[size-1]); 
	     } 
	    
	     first = second = Integer.MIN_VALUE; 
	     for (i = 0; i < size ; i++) 
	     { 
	       
	         if (arr[i] > first) 
	         { 
	             second = first; 
	             first = arr[i]; 
	         } 

	         else if (arr[i] > second && arr[i] != first) 
	             second = arr[i]; 
	     } 
	       
	     if (second == Integer.MIN_VALUE) 
	          return 0;
	     else
	          return second; 
	 } 
	
	
	public static void main(String[] args) {
		
		int a[] = {22,14,55,77};
		System.out.println(getMaxElement(a));
		System.out.println(secondHighest(a));
		System.out.println(largestStream());
		try {
			System.out.println(printSecondLargest(a));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
