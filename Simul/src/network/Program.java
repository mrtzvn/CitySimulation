package network;

public abstract class Program {
	
	private String name;
	
	private double value;
	
	private String function;
	
	public Program (String name, double value , String function){
		this.name = name;
		this.value = value;
		this.function = function;
	}
	
	public Program ( String name, String function){ // Free programs
		this(name,0,function);
	}
	
	
}
