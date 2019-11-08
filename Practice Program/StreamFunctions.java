package com.ref;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
	
	public static void main(String[] args) {
		
		//List of no.
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(60);
		list.add(68);
		list.add(35);
		list.add(86);
		list.add(2);
		System.out.println("list.= "+list);
		
		// List of even no
		List<Integer> even=list.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println("even no.="+even);
		
		// list after add 5 to each element
		List<Integer> updated=list.stream().map(i->i+5).collect(Collectors.toList());
		System.out.println("after adding 5 to each no.="+updated);
		
		// list of element less than 25
		long l=list.stream().filter(i->i<25).count();
		System.out.println("count of no less than 25 = "+l);
		
		//list in sorted order ascending
		List<Integer> sortedList=list.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted List ascending order ="+sortedList);
		
		//list in sorted order in descending
		List<Integer> sortedList1=list.stream().sorted((i1,i2)->(i1<i2)?1:(i1>i2)?-1:0).collect(Collectors.toList());
		System.out.println("Sorted List descending order ="+sortedList1);
		
		// smallest element in the list 
		Integer min=list.stream().min((i1,i2)->i1.compareTo(i2)).get();
		System.out.println("Min Value = "+min);
		
		//Largest element in the list
		Integer max=list.stream().max((i1,i2)->i1.compareTo(i2)).get();
		System.out.println("Max Value = "+max);
		
		//Print square of each element
		list.stream().forEach(i->{
			System.out.println("Square of element "+i+" is :"+(i*i));
		});
		
		//convert stream of element to array
		Integer[] i=list.stream().toArray(Integer[]::new);
		for(Integer i1:i) {
			System.out.println(i1);
		}
		
		
		System.out.println("\n");
		
		
		// List of names
		ArrayList<String> nameList=new ArrayList<String>();
		nameList.add("Ashish Manjhi");
		nameList.add("Pratyush Jha");
		nameList.add("Suyash Karkare");
		nameList.add("Chand");
		nameList.add("Ryan Singh");
		System.out.println("NameList ="+nameList);
		
		// Custom sorting by length of the name
		Comparator<String> comp=(s1,s2)->{
			int l1=s1.length();
			int l2=s2.length();
			if(l1<l2) return -1;
			else if(l1>l2) return 1;
			else return s1.compareTo(s2);
		};
		
		//List of  sorted name by length 
		List<String> sortByLength=nameList.stream().sorted(comp).collect(Collectors.toList());
		System.out.println("Names sorted by length ="+ sortByLength);
		
		
		
		
	}

}
