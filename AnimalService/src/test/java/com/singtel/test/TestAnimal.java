package com.singtel.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.singtel.animal.Animal;
import com.singtel.animal.Flyable;
import com.singtel.animal.Swimmable;
import com.singtel.animal.Walkable;
import com.singtel.animal.code.AnimalCounter;
import com.singtel.animal.concrete.AirBased;
import com.singtel.animal.concrete.Bird;
import com.singtel.animal.concrete.Fish;
import com.singtel.animal.concrete.LandBased;
import com.singtel.animal.concrete.Parrot;
import com.singtel.animal.concrete.WaterBased;

import static org.junit.Assert.*;

public class TestAnimal {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	@Test
	public void testBirdSing(){
		Bird bird = new Bird();
		bird.sing();
		assertEquals("I am singing\r\n", outContent.toString());
	}
	
	@Test
	public void testSwimmable(){
		Swimmable swimmable = new WaterBased();
		swimmable.swim();
		assertEquals("I am swimming\r\n", outContent.toString());
	}
	
	@Test
	public void testWalkable(){
		Walkable walkable = new LandBased(LandBased.CAT_SOUND);
		walkable.walk();
		assertEquals("I am walking\r\n", outContent.toString());
	}
	
	@Test
	public void testFlyable(){
		Flyable flyable = new AirBased("Kaw, kaw");//Crow
		flyable.fly();
		assertEquals("I am flying\r\n", outContent.toString());
	}
	
	@Test
	public void testParrotWithLandBased(){
		Parrot parrotRooster = new Parrot(new LandBased(LandBased.ROOSTER_SOUND));//Parrot near rooster
		parrotRooster.sing();
		assertEquals(LandBased.ROOSTER_SOUND + "\r\n", outContent.toString());
	}
	
	@Test
	public void testParrotWithAirBased(){
		Parrot parrotCrow = new Parrot(new AirBased("Kaw, kaw"));//Parrot near crow
		parrotCrow.sing();
		assertEquals("Kaw, kaw\r\n", outContent.toString());
	}
	
	@Test
	public void testAnimalCounts(){
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
		
		int [] counts = AnimalCounter.getCounts(animals);
		int [] expected = {3, 6, 6 ,6};
		
		assertArrayEquals(expected, counts);
	}
}
