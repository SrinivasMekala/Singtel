package com.singtel.animal;

public interface Walkable extends Animal{
	default void walk(){
		System.out.println("I am walking");
	}
}
