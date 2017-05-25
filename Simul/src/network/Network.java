package network;

import java.util.ArrayList;

import item.Computer;

public class Network { /*Herhangi bir bilgisayar inteneti kullanabilmek i�in kiras�n� �demeli.
						* Kira kontrol� her ay ba��nda yap�l�r.
						* Intenete ba�lanma ko�ullar� s�ras�yla ->kira ve ->kapasitenin dolmam�� olmas�
 						* Network ve Computer aras�ndaki veri al��-veri�i Pack ' ler saysinde yap�l�yor.
						* Bir pack ileri seviye programlar ile �ifrelenip ��z�lebilir.
						* Polislerin kullanaca�� veri analizi Packleri analiz etmeye dayan�r. (deCrypt edebilmeye)
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
