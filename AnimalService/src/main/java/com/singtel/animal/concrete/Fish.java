package com.singtel.animal.concrete;

public class Fish extends WaterBased{
	public static final String SHARK_SIZE = "large";
	public static final String CLOWNFISH_SIZE = "small";
	public static final String SHARK_COLOR = "grey";
	public static final String CLOWNFISH_COLOR = "orange";
	public static final String SHARK_DOES = "eat other fish";
	public static final String CLOWNFISH_DOES = "make jokes";
	
	private String size;
	private String color;
	private String does;
	
	public Fish(String size, String color, String does) {
		this.setSize(size);
		this.setColor(color);
		this.setDoes(does);
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDoes() {
		return does;
	}

	public void setDoes(String does) {
		this.does = does;
	}
	
}
