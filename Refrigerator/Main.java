package com.refrigerator;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

        List<Shelf> shelves=new ArrayList<Shelf>();
        Shelf shelf11=new Shelf(1,10);
        Shelf shelf12=new Shelf(2,12);
        Shelf shelf13=new Shelf(1,13);
        Shelf shelf14=new Shelf(1,14);
        shelves.add(shelf11);
        shelves.add(shelf12);
        shelves.add(shelf13);
        shelves.add(shelf14);
		Refrigerator refrigerator=new Refrigerator(shelves);
		
		Item item1=new Item(101, "Milk");
		Item item2=new Item(102, "apple");
		Item item3=new Item(103, "cake");
		Item item4=new Item(104, "drink");
		
		try {
			 refrigerator.addItem(item1);
			refrigerator.addItem(item2);
			refrigerator.addItem(item3);
			refrigerator.addItem(item4);
			System.out.println("item "+refrigerator.getItemById(102));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println(refrigerator);
	}

}
