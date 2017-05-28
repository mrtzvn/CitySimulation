package person;

import java.util.ArrayList;

import item.Item;
import place.Building;
import java.util.Random;

public abstract class Person {
	
	private String name;
	
	private int age , talent;
	
	private double wage;
	
	private Building home;
	
	private ArrayList<Item> itemsOwned ;
	
	private ArrayList<Person> contactList ;

	private Random randomVar;
	
	public Person(String name){
		
		this.name = name;
		itemsOwned = new ArrayList<Item>();
		setContactList(new ArrayList<Person>());
		
		talent = (int) (100 + 60 * randomVar.nextGaussian());
	}
	public Person (String name, Building home){
		this.name = name;
		this.home = home;
		setTalent((int) (100 + 60 * randomVar.nextGaussian()));
	}
	
	public Person (String name, int age , int talent){
		this.name = name;
		this.age = age;
		this.talent = talent;
	}
	
	public void remove(){
		try {
			this.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public Person copy(){
		
		try {
			return (Person) this.clone();
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String getName() {
		return name;
	}
	
	public double getWage(){
		return wage;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void buyItem(Item itemBought){ 
		if (!isAffordable(itemBought.getValue()) || itemBought.getOwner() == this ){
			System.out.println("Buying is not successful.");
			return;
		}
		giveMoney(itemBought.getValue());
		addItem(itemBought);
		
	}
	
	public void buyItem(Item itemBought,Person seller){ 
		if (!isAffordable(itemBought.getValue()) || itemBought.getOwner() == this ){ 
			System.out.println("Buying is not successful.");
			return;
		}
		double cost = itemBought.getValue();
		giveMoney(cost);
		seller.takeMoney(cost);
		seller.removeItem(itemBought);
		addItem(itemBought);
		
	}
	
	public void sellItem(Item itemSold){ // done
		
		if (! itemsOwned.contains(itemSold)){
			System.out.println("This person do not has this object");
			return;
		}
		wage += itemSold.getValue();
		itemSold.setOwner(null);
		
	}
	
	public void sellItem(Item itemSold , Person buyer){ // done
		
		if (! itemsOwned.contains(itemSold) || buyer.isAffordable(itemSold.getValue())){
			System.out.println("Selling is not successful.");
			return;
		}
		double gain= itemSold.getValue();
		buyer.giveMoney(gain);
		takeMoney(gain);
		itemsOwned.remove(itemSold);
		buyer.addItem(itemSold);
	}
	
	public void takeMoney(double money) {
		this.wage += money;
	}
	
	public void giveMoney(double money){
		this.wage -= money;
	}
	
	public boolean isAffordable(double money){
		return money <= wage;
	}
	
	public void addItem(Item newItem){
		if(newItem.getOwner() == this) return; 
		itemsOwned.add(newItem);
		newItem.setOwner(this);
	}
	public void removeItem(Item newItem){
		if(newItem.getOwner() != this) return; 
		itemsOwned.remove(newItem);
		newItem.setOwner(null);
	}
	
	public int getAge() {
		return age;
	}
	
	public int getTalent() {
		return talent;
	}
	
	public void setTalent(int talent) {
		this.talent = talent;
	}
	
	public Building getHome() {
		return home;
	}
	
	public void setHome(Building home) {
		this.home = home;
	}
	
	public ArrayList<Person> getContactList() {
		return contactList;
	}
	
	public void setContactList(ArrayList<Person> contactList) {
		this.contactList = contactList;
	}

	public abstract void earnMoney();
	
}
