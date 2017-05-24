package item;

import person.Person;

public abstract class Item {
	
	private String name;
	private double value;
	private Person owner;
	
	public void setOwner(Person newOwner){
		this.owner = newOwner;
	}
	
	public Person getOwner(){
		return owner;
	}
	
	public void setValue(double value){
		this.value = value;
	}
	
	public double getValue(){
		return value;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name + " " + value + " TL.";
	}
	
	
}
