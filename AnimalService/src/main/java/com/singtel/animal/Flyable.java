package com.singtel.animal;

public interface Flyable extends Animal {
	default void fly(){
		System.out.println("I am flying");
	}
}
