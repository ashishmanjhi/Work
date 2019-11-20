package com.refrigerator;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

//Refrigerator Model

/**
 * @author Ashish.manjhi
 *
 */

public class Refrigerator {

	// List of shelves inside the refrigerator
	List<Shelf> shelves = new ArrayList<Shelf>();

	/**
	 * 
	 * 
	 * @param Item object
	 * @return boolean
	 * @throws No space Exception
	 */
	public boolean addItem(Item item) throws Exception {
		boolean flag = false;
		int count=0;

		for (Shelf shelf : shelves) {
			flag = addItemToShelf(item, shelf);
			if (flag == true)
				break;
		}

		if (flag == false) {
			DoubleSummaryStatistics stats1 = shelves.stream()
					.collect(Collectors.summarizingDouble(Shelf::getRemainingCapacity));
			if ((item.capacity <= stats1.getSum())) {
				for (Shelf shelf1 : shelves) {
					for (Item i : shelf1.items) {
						if (rearrange(i, shelf1.id) == true) {
							shelf1.items.remove(i);
							shelf1.remainingCapacity += i.capacity;	
						}
						if((flag=addItemToShelf(item,shelf1))==true)
							break;
						else if((flag=addItemToShelf(item,shelf1))==false) {
							count++;	
						}
						if(count==4)
							throw new	NotEnoughSpaceException("Not Enough even after shuffle." + item.capacity);
					}
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
		for (Shelf shelf : shelves) {
			if (item.capacity <= shelf.remainingCapacity && shelfid != shelf.id) {
				shelf.items.add(item);
				shelf.remainingCapacity -= item.capacity;
				return out = true;
			}
		}
		return out;
	}

	/**
	 * @param item
	 * @param capacity
	 * @param shelf1
	 * @return boolean
	 */
	public boolean reshuff(Item item, Float capacity, Shelf shelf1) {
		boolean flag = false;
		for (Shelf shelf : shelves) {
			for (Item i : shelf.items) {
				if (capacity == i.capacity)
					;
				{
					shelf.items.remove(i);
					shelf.remainingCapacity += (i.capacity);
					shelf.items.add(item);
					shelf.remainingCapacity -= item.capacity;
					shelf1.items.remove(item);
					shelf1.remainingCapacity += item.capacity;
					shelf1.items.add(i);
					shelf1.remainingCapacity -= i.capacity;
					flag = true;
					break;
				}
			}
		}
		return flag;

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

	/**
	 * @param contain List of shelves
	 */
	public Refrigerator(List<Shelf> shelves) {
		this.shelves = shelves;
	}

}
