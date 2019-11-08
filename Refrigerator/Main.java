package com.refrigerator;

import java.util.ArrayList;
import java.util.List;

// Main program
public class Main {
	public static void main(String[] args) {

		// List of shelves present inside the Refrigerator
        List<Shelf> shelves=new ArrayList<Shelf>();
        shelves.add(new Shelf(1,10));
        shelves.add(new Shelf(2,12));
        shelves.add(new Shelf(3,13));
        shelves.add(new Shelf(4,14));
        
        //Refrigerator object
		Refrigerator refrigerator=new Refrigerator(shelves);
		
		try {
			//Adding items inside the refrigerator
			 refrigerator.addItem(new Item(101, "Milk"));
			refrigerator.addItem(new Item(102, "apple"));
			refrigerator.addItem(new Item(103, "cake"));
			refrigerator.addItem(new Item(104, "drink"));
			
			//Items inside the Refrigerator.
			System.out.println("Items inside the refrigerator : "+refrigerator);
			
			System.out.println("\n");
			
			//Taking out an item from the Refrigerator by item id.
			System.out.println("item taken out by the user by item id "+refrigerator.getItemById(102));
			
			//taking out an item from the Refrigerator by item name
			System.out.println("item taken out by the user by item name "+refrigerator.getItemByName("cake"));
			
			System.out.println("\n");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//Remaining items inside the refrigerator
		System.out.println("Remaining Items inside the refrigerator : "+refrigerator);
	}

}
