package item;

import network.Network;

public class Computer extends Item {
	
	private String ipAdress;
	private double processorSpeed;
	private Network internetConnection;
	
	public Computer(double processorSpeed){
		super("Computer" ,processorSpeed * 300);
		this.processorSpeed = processorSpeed;
	}
	
	public void connectInternet(Network A){
		if(A.sendConnectionRequest(this)) System.out.println("Connection successful");
		
	}
	
	public void setProcessorSpeed(double processorSpeed){
		this.processorSpeed = processorSpeed;
	}
	
	public double getProcessorSpeed(){
		return processorSpeed;
	}
	
	public String getIpAdress(){
		return ipAdress;
	}
	
	public boolean isConnectedInternet(){
		return internetConnection != null;
	}
	
	public Network getInternetConnection(){
		return internetConnection;
	}
	
}
