package com.ref;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Item Model
public class Item {
	private int id;
	private String name;
	private int size;
	
	//Constructor
	public Item(int id, String name, int size) {
		this.id = id;
		this.name = name;
		this.size = size;
	}

    //Constructor
	public Item() {
	}

	//Getter and Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
     
	//ToString
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", size=" + size + "]";
	}

//Function to sort and print Items in sorted order by size
	public void printItems() {
		
		List<Item> items=Arrays.asList(
				new Item(100,"Apple",5),
				new Item(101,"Milk",8),
				new Item(102,"Water Bottle",10),
				new Item(103,"Bread",4),
				new Item(104,"Eggs",2));
		
		//Sorting the item list in ascending order by size using stream
		List<Item> itemList=items.stream().sorted(Comparator.comparingInt(Item::getSize)).collect(Collectors.toList()); 
		itemList.forEach(System.out::println);
	}
}
// Main is in StreamFunction