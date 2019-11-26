package com.refrigerator;

import java.util.ArrayList;
import java.util.List;

// Main program
public class Main {
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

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
			refrigerator.addItem(new Item(101, "Milk",1));
			refrigerator.addItem(new Item(102, "apple",2));
			refrigerator.addItem(new Item(103, "cake",5));
			refrigerator.addItem(new Item(104, "drink",9));
			refrigerator.addItem(new Item(105, "beer",6));
			refrigerator.addItem(new Item(106, "Banana",5));
			refrigerator.addItem(new Item(107, "Mango",4));
			refrigerator.addItem(new Item(108, "Ice",3));
			refrigerator.addItem(new Item(109, "Ice1",6));
			refrigerator.addItem(new Item(110, "Ice2",5));
			refrigerator.addItem(new Item(111, "Ice3",3));
			//refrigerator.addItem(new Item(112, "Ice4",2.0));
			//refrigerator.addItem(new Item(113, "lava",5.0));

		} catch (Exception e) {

			e.printStackTrace();
		}

		//Items inside the Refrigerator.
		System.out.println("Items inside the refrigerator : "+refrigerator);

		System.out.println("\n");

		//Taking out an item from the Refrigerator by item id.
		System.out.println("item taken out by the user by item id "+refrigerator.getItemById(102));

		//taking out an item from the Refrigerator by item name
		System.out.println("item taken out by the user by item name "+refrigerator.getItemByName("cake"));

		System.out.println("\n");
		//Remaining items inside the refrigerator
		System.out.println("Remaining Items inside the refrigerator : "+refrigerator);
	}

}
