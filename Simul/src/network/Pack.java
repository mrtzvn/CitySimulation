package network;

public class Pack {
	
	private String data;
	
	private int size;
	
	public Pack(String data){
		this.data = data;
		size = data.length();
	}
	
	public void setData(String newData){
		data = newData;
	}
	
	public String getData(){
		return data;
	}
	
	public int getSize(){
		return size;
	}
	
	
	
}
