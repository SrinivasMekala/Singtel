package com.singtel.animal.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.singtel.animal.Animal;
import com.singtel.animal.Flyable;
import com.singtel.animal.Singable;
import com.singtel.animal.Swimmable;
import com.singtel.animal.Walkable;
import com.singtel.animal.concrete.Fish;
import com.singtel.animal.concrete.LandBased;
import com.singtel.animal.concrete.Parrot;
import com.singtel.animal.concrete.WaterBased;

public class AnimalCounter {
	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<>();
		animals.add( new LandBased(LandBased.CHICKEN_SOUND) );
		animals.add( new LandBased(LandBased.ROOSTER_SOUND) );
		animals.add( new LandBased(LandBased.DUCK_SOUND) );
		
		animals.add( new Fish(Fish.CLOWNFISH_SIZE, Fish.CLOWNFISH_COLOR, Fish.CLOWNFISH_DOES));
		animals.add( new Fish(Fish.SHARK_SIZE, Fish.SHARK_COLOR, Fish.SHARK_DOES));
		animals.add( new WaterBased());
		
		animals.add( new Parrot(new LandBased(LandBased.ROOSTER_SOUND)));
		animals.add( new Parrot(new LandBased(LandBased.CAT_SOUND)));
		animals.add( new Parrot(new LandBased(LandBased.DOG_SOUND)));
		
		int [] counts = getCounts(animals);
		System.out.println("Flier count = " + counts[0]);
		System.out.println("Walker count = " + counts[1]);
		System.out.println("Swimmer count = " + counts[2]);
		System.out.println("Singer count = " + counts[3]);
	}
	
	public static int [] getCounts(List<Animal> animals){
		int flierCount = 0, walkerCount = 0, swimmerCount = 0, singerCount = 0;
		for (Animal animal : animals) {
			if(animal instanceof Flyable)
				flierCount++;
			if(animal instanceof Walkable)
				walkerCount++;
			if(animal instanceof Swimmable)
				swimmerCount++;
			if(animal instanceof Singable)
				singerCount++;
		}
		return new int[]{flierCount, walkerCount, swimmerCount, singerCount};
	}
}
