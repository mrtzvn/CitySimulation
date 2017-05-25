package network;

import java.util.ArrayList;

import item.Computer;

public class Network { /*Herhangi bir bilgisayar inteneti kullanabilmek için kirasýný ödemeli.
						* Kira kontrolü her ay baþýnda yapýlýr.
						* Intenete baðlanma koþullarý sýrasýyla ->kira ve ->kapasitenin dolmamýþ olmasý
 						* Network ve Computer arasýndaki veri alýþ-veriþi Pack ' ler saysinde yapýlýyor.
						* Bir pack ileri seviye programlar ile þifrelenip çözülebilir.
						* Polislerin kullanacaðý veri analizi Packleri analiz etmeye dayanýr. (deCrypt edebilmeye)
						*/
	
	private int capacity;
	
	private ArrayList<Pack> transmittedPacks;
	
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
	
	public boolean transmitPack(Pack A ,Computer dest){ // this method will transmit a pack for a tunnel,
												   // (Computer) controller -----------> (Computer) victim  
												   // 					  via Network
		if ( dest.getInternetConnection() != this || A == null) return false;
		transmittedPacks.add(A);
		return true;
	}
	
	
	public void monitorComputer(Computer A){
		
		if(!isRegistered(A)) {
			System.out.println("This computer do not using this connection.");
			return;
		}
		
		
		//Monitoring codes.
		
		
	}

	
	
	public boolean isRegistered(Computer A){
		
		return A.getInternetConnection() != this ;
	}
	
}
