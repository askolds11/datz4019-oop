package jtm.activity03;

public class RandomPerson {

	// Create _private_ structure of random person to store values:
	// name as String,
	// age as int,
	// weight as float,
	// isFemale as boolean;
	// smile as char
	// HINT: use Alt+Shift+A to switch to Block selection (multi-line cursor)
	// to edit list of all properties at once
	
	private String name;
	private int age;	
	private float weight;	
	private boolean isFemale;
	private char smile;
	
	// Select menu "Source — Generate Getters and Setters..." then select
	// all properties and generate _public_ getters and setters for all of them
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public boolean isFemale() {
		return isFemale;
	}
	public void setFemale(boolean isFemale) {
		this.isFemale = isFemale;
	}
	public char getSmile() {
		return smile;
	}
	public void setSmile(char smile) {
		this.smile = smile;
	}
}
