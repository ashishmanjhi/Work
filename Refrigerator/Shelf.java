package com.refrigerator;

import java.util.ArrayList;
import java.util.List;

//Shelf Model
public class Shelf {

	//Shelf id , remaining capacity and list of items 
	int id;
	double remainingCapacity;
	List<Item> items=new ArrayList<Item>();


	/**
	 * @param id
	 * @param remainingCapacity
	 */
	public Shelf(int id,double remainingCapacity) {
		this.id = id;
		this.remainingCapacity=remainingCapacity;
	}


	// Getter and Setter
	/**
	 * @return Shelf id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setShelfId(int id) {
		this.id = id;
	}

	/**
	 * @return Shelf remaining space
	 */
	public double getRemainingCapacity() {
		return remainingCapacity;
	}

	/**
	 * @param Shelf remainingCapacity
	 */
	public void setRemainingCapacity(double remainingCapacity) {
		this.remainingCapacity = remainingCapacity;
	}


	@Override
	public String toString() {
		return "\n Shelf [shelfId=" + id + ", remainingCapacity="
				+ remainingCapacity + ", items=" + items + "]";
	}

}
