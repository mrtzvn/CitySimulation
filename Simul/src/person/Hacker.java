package person;

import item.Computer;

public class Hacker extends Person {

	private Computer personalComputer;
	
	public Hacker(String name, int age, int talent) {
	
		super(name, age, talent);
		
	
	
	}
	
	@Override
	public void earnMoney() {
		
		
		
	}
	
	public Computer getPersonalComputer(){
		return personalComputer;
	}
	
	public void setPersonalComputer(Computer newPC){
		personalComputer = newPC;
	}
	
	
	
	
}
