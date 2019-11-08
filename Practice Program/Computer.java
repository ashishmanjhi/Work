package com.ref;

public class Computer {
	private int Id;
	private String name;
	private long price;
	
	public Computer(int id, String name, long price) {
		
		Id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Computer [Id=" + Id + ", name=" + name + ", price=" + price + "]";
	}

	
}
