package com.singtel.animal.concrete;

import com.singtel.animal.Singable;

public class Parrot extends AirBased{
	
	private Singable singer;
	
	public Parrot(Singable singer) {
		super(null);
		this.singer = singer;
	}
	
	@Override
	public void sing() {
		singer.sing();
	}

}
