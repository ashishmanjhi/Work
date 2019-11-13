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
	 * @return Shelf id
	 * @throws No space Exception
	 */
	public int addItem(Item item) throws Exception {
		int id = -1;
		for (Shelf shelf : shelves) {
			if (shelf.remainingCapacity >= item.capacity) {
				shelf.items.add(item);
				shelf.remainingCapacity -= item.capacity;
				id = shelf.id;
				break;
			}		
		}
		DoubleSummaryStatistics stats = shelves.stream()
			      .collect(Collectors.summarizingDouble(Shelf::getRemainingCapacity));
		
		if (id == -1) {
			if((stats.getSum())>=item.capacity) {
				for (Shelf shelf : shelves) {
					for(Item i: shelf.items) {
						if(rearrange(i,shelf.id)==true) {
							shelf.remainingCapacity+=i.capacity;
						id=addItem(i);
						}
					}
				}
				
			}
			else
		throw new NotEnoughSpaceException("Not Enough Space."+item.capacity);
		}
		return id;
	}
	
	
	
	/**
	 * @param Item object
	 * @param shelfid
	 * @return boolean value 
	 */
	public boolean rearrange(Item item,int shelfid) {
		boolean out=true;
		for (Shelf shelf : shelves) {
		if(item.capacity<=shelf.remainingCapacity && shelfid!=shelf.id) {
			shelf.items.add(item);
		shelf.remainingCapacity -= item.capacity;
		break;
		}
		else
			out=false;
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

	//Exception class for item not found
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
