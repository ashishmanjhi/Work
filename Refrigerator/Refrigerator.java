package com.refrigerator;

import java.util.ArrayList;
import java.util.List;

//Refrigerator Model
public class Refrigerator {

	// List of shelves inside the refrigerator
	List<Shelf> shelves = new ArrayList<Shelf>();

	// Function to add item inside the refrigerator
	public int addItem(Item item) throws Exception {
		int id = -1;
		for (Shelf shelf : shelves) {
			if (shelf.remainingCapacity > item.capacity) {
				shelf.items.add(item);
				shelf.remainingCapacity -= item.capacity;
				id = shelf.id;
				break;
			}
		}
		if (id == -1) {
			throw new NotEnoughSpaceException("Not Enough Space.");
		}
		return id;
	}

	// Function to get an item from the refrigerator by item id.
	public Item getItemById(int id) throws Exception {
		Item itemRemoved = null;
		for (Shelf shelf : shelves) {
			List<Item> itemList = shelf.items;
			for (Item item : itemList) {
				if (item.id == id) {
					itemRemoved = item;
					shelf.remainingCapacity += itemRemoved.capacity;
					itemList.remove(item);
					break;
				}
			}
			
		}
		if (itemRemoved == null) {

			throw new ItemNotFoundException("Item not found by id: " + id);
		}
		return itemRemoved;
	}

	// Function to get an item from the refrigerator by item name.
	public Item getItemByName(String name) throws Exception {
		Item itemRemoved = null;
		int no = 0;
		for (Shelf shelf : shelves) {
			List<Item> itemList = shelf.items;
			for (Item item : itemList) {
				if (item.name == name) {
					no++;
					System.out.println(no);
					itemRemoved = item;
					shelf.remainingCapacity += itemRemoved.capacity;
					itemList.remove(item);
					break;
				}
			}			
		}
		if (itemRemoved == null) {

			throw new ItemNotFoundException("Item not found by name: " + name);
		}
		return itemRemoved;
	}

	@Override
	public String toString() {
		return "Refrigerator [shelves=" + shelves + ", maxNoOfShelves=" + shelves.size() + "]";
	}

	// Exception class for space
	@SuppressWarnings("serial")
	public class NotEnoughSpaceException extends Exception {
		public NotEnoughSpaceException(String msg) {
			super(msg);
		}
	}

	//Exception class for item not found
	@SuppressWarnings("serial")
	public class ItemNotFoundException extends Exception {
		public ItemNotFoundException(String msg) {
			super(msg);
		}
	}

	// Refrigerator Constructor
	public Refrigerator(List<Shelf> shelves) {
		this.shelves = shelves;
	}

}
