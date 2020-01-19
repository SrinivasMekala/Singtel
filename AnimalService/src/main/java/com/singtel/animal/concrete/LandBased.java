package com.singtel.animal.concrete;

import com.singtel.animal.Singable;
import com.singtel.animal.Swimmable;
import com.singtel.animal.Walkable;

public class LandBased implements Walkable, Singable, Swimmable{
	public static final String CAT_SOUND = "Meow";
	public static final String DOG_SOUND = "Woof, woof";
	public static final String DUCK_SOUND = "Quack, quack";
	public static final String CHICKEN_SOUND = "Cluck, cluck";
	public static final String ROOSTER_SOUND = "Cock-a-doodle-doo";
	
	private String sound;
	
	public LandBased(String sound) {
		this.sound = sound;
	}
	
	@Override
	public void sing() {
		System.out.println(sound);
	}
}
