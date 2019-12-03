package com.refrigerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

//Refrigerator Model

/**
 * @author Ashish.manjhi
 *
 */

public class Refrigerator {


	List<Shelf> shelves = new ArrayList<Shelf>();
	int count=0;

	/**
	 * 
	 * 
	 * @param Item object
	 * @return boolean
	 * @throws No space Exception
	 */
	public boolean addItem(Item item) throws Exception {
		boolean flag = false;


		for (Shelf shelf : shelves) {
			flag = addItemToShelf(item, shelf);
			if (flag == true)
				break;
		}
		if (flag == false) {
			DoubleSummaryStatistics stats1 = shelves.stream()
					.collect(Collectors.summarizingDouble(Shelf::getRemainingCapacity));

			if ((item.capacity <= stats1.getSum())) {
				for (Shelf shelf1 : shelves) 
				{
					for (Item i : shelf1.items) {
						if (rearrange(i, shelf1.id) == true) {
							shelf1.items.remove(i);
							shelf1.remainingCapacity += i.capacity;	
							if(addItem(item)==true)
								return true;
						}
					}			
					count++;	
					if(count==(stats1.getCount()*2))
						throw new	NotEnoughSpaceException("Not Enough even after shuffle the items. " + item.capacity);

				}
			} else
				throw new NotEnoughSpaceException("Not Enough Space." + item.capacity);
		}
		return flag;
	}

	/**
	 * @param item
	 * @param shelf
	 * @return boolean
	 */
	private boolean addItemToShelf(Item item, Shelf shelf) {
		boolean flag = false;
		if (shelf.remainingCapacity >= item.capacity) {
			shelf.items.add(item);
			shelf.remainingCapacity -= item.capacity;
			flag = true;
		}
		return flag;
	}

	/**
	 * @param Item    object
	 * @param shelfid
	 * @return boolean value
	 */
	public boolean rearrange(Item item, int shelfid) {
		boolean out = false;
		for (Shelf shelf : shelves.stream().sorted(Comparator.comparingDouble(Shelf::getRemainingCapacity)).collect(Collectors.toList())) {
			if (item.capacity <= shelf.remainingCapacity && shelfid != shelf.id) {
				shelf.items.add(item);
				shelf.remainingCapacity -= item.capacity;
				return out = true;

			}
		}
		return out;
	}

	/**
	 * @param Item id
	 * @return Item selected by user by id
	 * @throws Exception Item Not Found
	 */
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

	/**
	 * @param Item name
	 * @return Item selected by user by name
	 * @throws Exception Item Not Found
	 */
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

	// Exception class for item not found
	@SuppressWarnings("serial")
	public class ItemNotFoundException extends Exception {
		public ItemNotFoundException(String msg) {
			super(msg);
		}
	}



	public Refrigerator() {

	}

	/**
	 * @param contain List of shelves
	 */
	public Refrigerator(List<Shelf> shelves) {
		this.shelves = shelves;
	}

}
