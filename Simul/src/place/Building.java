package place;

import java.util.ArrayList;
import item.*;
import person.*;

public abstract class Building {

		private String name;
		private double value;
		private ArrayList<Person> inhabitants;
		private ArrayList<Item> items;
		
		public Building(String name, double value) {
			this.name = name;
			this.value = value;
			inhabitants = new ArrayList<Person>();
			items = new ArrayList<Item>();
		}
		
		public abstract Building clone();
		
		public void addItem(Item item) {
			if (!items.contains(item)) {
				items.add(item);
			}
		}
		
		public void addInhabitant(Person inhabitant) {
			if (!inhabitants.contains(inhabitant)) {
				inhabitants.add(inhabitant);
			}
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setValue(double value) {
			this.value = value;
		}

		public void setInhabitants(ArrayList<Person> inhabitants) {
			this.inhabitants = inhabitants;
		}

		public void setItems(ArrayList<Item> items) {
			this.items = items;
		}

		public String getName() {
			return name;
		}

		public double getValue() {
			return value;
		}

		public ArrayList<Person> getInhabitants() {
			return inhabitants;
		}

		public ArrayList<Item> getItems() {
			return items;
		}
		
		
}
