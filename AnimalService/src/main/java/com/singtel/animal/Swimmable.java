package com.singtel.animal;

public interface Swimmable extends Animal {
	default void swim(){
		System.out.println("I am swimming");
	}
}
