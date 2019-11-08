package com.refrigerator;

public class Item {
	int id;
	String name;
	Float capacity = (float) (Math.random()*10)+1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "\n  Item [itemId=" + id + ", name=" + name + ", ItemCapacity=" + capacity + "]";
	}
	
}
