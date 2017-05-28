package program;

import network.Pack;

public class Crypter extends Program{
	
	private String key;
	private int generatedKey;
	
	public Crypter (String name, double value, String algorithm){
		super(name,value,"Security");
		this.key = algorithm ;
		generateKey();
	}
	public void generateKey(){
		int sum = 0;
		for(char tmp : key.toCharArray()){
			sum += tmp;
		}
		generatedKey = sum / key.length();
	}
	
	public void cryptPack(Pack p){
		p.setData( cryptText(p.getData()));
	}
	
	public void deCryptPack(Pack p){
		p.setData( deCryptText(p.getData()));
	}
	
	public String cryptText(String data){
		String out = "";
		for(int i = 0 ; i< data.length() ; i++){
			out += data.charAt(i) + generatedKey;
			}
		
		return out;
	}
	
	public String deCryptText(String data){
		String out = "";
		for(int i = 0 ; i< data.length() ; i++){
			out += data.charAt(i) - generatedKey;
			}
		
		return out;
	}
	
	public boolean isMathFound(String A,String [] commands){
		for(String tmp : commands){
		if(tmp.toLowerCase().equals(deCryptText(A))) return true;		
		}
		return false;
	}
	
}



