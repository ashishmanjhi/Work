package com.refrigerator;

import java.util.ArrayList;
import java.util.List;

public class Refrigerator {
	List<Shelf> shelves = new ArrayList<Shelf>();
	int maxNoOfShelves = 4;

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

	public Item getItemById(int itemId) throws Exception {
		Item itemRemoved = null;
		for (Shelf shelf : shelves) {
			List<Item> itemList = shelf.items;
			for (Item item : itemList) {
				if (item.id == itemId) {
					itemRemoved = item;
					itemList.remove(item);
					break;
				}
			}
		}
		return itemRemoved;
	}

	@Override
	public String toString() {
		return "Refrigerator [shelves=" + shelves + ", maxNoOfShelves=" + maxNoOfShelves + "]";
	}

	@SuppressWarnings("serial")
	public class NotEnoughSpaceException extends Exception {
		public NotEnoughSpaceException(String msg) {
			super(msg);
		}
	}

	public Refrigerator() {
		for (int i = 0; i < this.maxNoOfShelves; i++) {
			Shelf shelf = new Shelf(i, i);
			shelves.add(shelf);
		}
	}

	public Refrigerator(List<Shelf> shelves2) {
		this.shelves = shelves2;
	}

}
