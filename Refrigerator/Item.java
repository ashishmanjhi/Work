package com.refrigerator;

// Item Model
public class Item {
	
	//Item id ,name and a random capacity
	int id;
	String name;
	Float capacity = (float) (Math.random()*10)+1;

	
	// Getter and Setters
	/**
	 * @return Item id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param Item id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return Item name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param Item name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param Item id
	 * @param Item name
	 */
	public Item(int id, String name) {
		this.id = id;
		this.name = name;
	}
	

	//Constructor for Item model
	/**
	 * @param Item id
	 * @param Item name
	 * @param Item capacity
	 */
	public Item(int id, String name, Float capacity) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
	}
	
	//Default Constructor
	public Item()
	{		
	}

	@Override
	public String toString() {
		return "\n  Item [itemId=" + id + ", name=" + name + ", ItemCapacity=" + capacity + "]";
	}
	
}
