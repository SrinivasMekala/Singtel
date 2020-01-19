package com.singtel.animal.concrete;

import com.singtel.animal.Flyable;
import com.singtel.animal.Singable;
import com.singtel.animal.Walkable;

public class AirBased implements Flyable, Walkable, Singable{
	
	private String sound;

	public AirBased(String sound){
		this.sound = sound;
	}
	
	@Override
	public void sing() {
		System.out.println(sound);
	}
	
}
