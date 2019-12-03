package com.refrigerator;

// Item Model
public class Item {

	//Item id ,name and a random capacity
	int id;
	String name;
	double capacity;



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
	 * @return capacity
	 */
	public double getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity
	 */
	public void setCapacity(double capacity) {
		this.capacity = capacity;
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
	public Item(int id, String name, double capacity) {
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
		return "Item [id=" + id + ", name=" + name + ", capacity=" + capacity + "]";
	}



}
