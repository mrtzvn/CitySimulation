package network;

import java.util.ArrayList;

import item.Computer;

public class Network {
	
	private int capacity;
	
	private ArrayList<Computer> connectedComputers;
	
	private double rent;
	
	
	public int getCapacity(){
		return capacity;
	}
	
	public boolean isFull(){
		return capacity <= connectedComputers.size();
	}
	
	public int getConnectionCount(){
		return connectedComputers.size();
	}
	
	public boolean sendConnectionRequest(Computer A){
		if(isFull() || !A.getOwner().isAffordable(rent)) {
			return false;
		}
		A.getOwner().giveMoney(rent);
		A.connectInternet(this);
		connectedComputers.add(A);
		return true;
	}
	
	public Pack transmitPack(Pack A){
		
		
		
		
	}
	
	
	public void monitorComputer(Computer A){
		
		if(!isRegistered(A)) {
			System.out.println("This computer do not using this connection.");
			return;
		}
		
	}

	
	
	public boolean isRegistered(Computer A){
		
		return A.getInternetConnection() != this ;
	}
	
}
