package com.ref;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

	public void listToMap() {
		
		List<Computer> list=new ArrayList<>();
		list.add(new Computer(1,"Apple",100000));
		list.add(new Computer(2,"Dell",70000));
		list.add(new Computer(3,"HP",60000));
		list.add(new Computer(4,"Acer",40000));
		list.add(new Computer(5,"Asus",65000));
		list.add(new Computer(6,"Apple",90000));
		
		Map result1 = list.stream()
                .sorted(Comparator.comparingLong(Computer::getPrice).reversed())
                .collect(
                        Collectors.toMap(
                                Computer::getName, Computer::getPrice, 
                                (oldValue, newValue) -> oldValue,       
                                LinkedHashMap::new                      
                        ));System.out.println("Result 1 : " + result1);
		
	}

}
// Main in Stream function