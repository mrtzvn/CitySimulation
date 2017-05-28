package program;

import network.Pack;

public class Antivirus extends Program{

	
	public Antivirus(String name, double value, String function) {
		super(name, value, function);
		// TODO Auto-generated constructor stub
	}

	
	public boolean isHarmful(Pack A){
		return true;	
	}
	
	
}
