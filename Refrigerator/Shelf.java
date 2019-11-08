package com.refrigerator;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
	
	int id;
	float remainingCapacity;
	List<Item> items=new ArrayList<Item>();

	
	public Shelf(int id,float remainingCapacity) {
		this.id = id;
		this.remainingCapacity=remainingCapacity;
	}
	

	public int getId() {
		return id;
	}


	public void setShelfId(int id) {
		this.id = id;
	}


	public float getRemainingCapacity() {
		return remainingCapacity;
	}


	public void setRemainingCapacity(float remainingCapacity) {
		this.remainingCapacity = remainingCapacity;
	}


	@Override
	public String toString() {
		return "\n Shelf [shelfId=" + id + ", remainingCapacity="
				+ remainingCapacity + ", items=" + items + "]";
	}

}
