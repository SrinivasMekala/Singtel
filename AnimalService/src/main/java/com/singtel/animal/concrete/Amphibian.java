package com.singtel.animal.concrete;

import com.singtel.animal.Singable;
import com.singtel.animal.Swimmable;
import com.singtel.animal.Walkable;

public class Amphibian implements Walkable, Swimmable, Singable {
	
	private String sound;
	
	public Amphibian(String sound) {
		this.sound = sound;
	}
	
	@Override
	public void sing() {
		System.out.println(sound);
	}
}
