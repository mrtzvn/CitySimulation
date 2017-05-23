
import java.util.ArrayList;

public abstract class Person {
	
	private String name;
	private int age;
	private Building home;
	private double wage;
	private ArrayList<Item> itemsOwned;
	private ArrayList<Person> contactList;
	
	
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Building getHome() {
		return home;
	}

	public void setHome(Building home) {
		this.home = home;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public ArrayList<Item> getItemsOwned() {
		return itemsOwned;
	}

	public void setItemsOwned(ArrayList<Item> itemsOwned) {
		this.itemsOwned = itemsOwned;
	}

	public ArrayList<Person> getContactList() {
		return contactList;
	}

	public void addContact(Person A) {
		if (!contactList.contains(A)) contactList.add(A);
		
	}

	
	
	
	
}
