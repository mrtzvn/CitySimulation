package item;

import network.Pack;
import program.Antivirus;
import program.Crypter;

import java.util.ArrayList;

import main.City;
import network.Network;

public class Computer extends Item {
	
	private String ipAdress;
	
	private double processorSpeed;
	
	private Network internetConnection;
	
	private Antivirus securityProgram;
	
	private ArrayList<Crypter> cryptoPrograms;
	
	private ArrayList<Pack> receivedPacks;
	
	private String [] baseCommands;
	
	private ArrayList < String > ipAdressList;
	
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
	
	
	public boolean transmitPack(Pack A,Computer B){
		if(!isConnectedInternet()){
			System.out.println("No Internet..");
			return false;
		}
		return internetConnection.transmitPack(A,B);
	}
	
	public void scanIpAdress(String ipAdress){
		
		
		if(internetConnection == null) return;
		
	}
	
	public boolean receivePack(Pack A){
		
		if(A == null) return false;
		
		receivedPacks.add(A);
		
		if(securityProgram != null && securityProgram.isHarmful(A)) return false;
		
		if(!isReadable(A.getData())) {
			for(Crypter tmp : cryptoPrograms )
			if(tmp.isMathFound(A.getData(), baseCommands)) {
				tmp.deCryptPack(A);
				return true;
			}
			
		}
		
		return false;
		
	}
	
	public boolean isReadable(String A){
		for(String tmp : baseCommands){
			
			if (tmp.toLowerCase().equals(A.toLowerCase())) return true;  
		
		}
		return false;
	}
	
	
}
