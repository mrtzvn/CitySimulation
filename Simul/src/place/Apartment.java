package place;

public class Apartment extends Building {
	
	private String name;
	private double value;
	
	public Apartment(String name, double value) {
		super(name, value);
		this.name = name;
		this.value = value;
		value--;
		//Trial
		
	}
	
	public Building clone() {
		Building newBuilding = new Apartment(name, value);
		newBuilding.setInhabitants(this.getInhabitants());
		newBuilding.setItems(this.getItems());
		return newBuilding;
	}

}
