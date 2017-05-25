package network;

import java.util.stream.IntStream;

import item.Item;

public class Crypter extends Program{
	
	private String key;
	private int generatedKey;
	
	public Crypter (String name, double value, String algorithm){
		super(name,value,"Security");
		this.key = algorithm ;
		}
	public void generateKey(String key){
		generatedKey = key.length();
	}
	
	
	
	public void cryptPack(Pack p , int bit){
		p.setData( cryptText(p.getData() , bit));
	}
	
	public void deCryptPack(Pack p , int bit){
		p.setData( deCryptText(p.getData() , bit));
	}
	
	public String cryptText(String data , int bit){
		if ( bit <= 0) return data;
		String out = "";
		for(int i = 0 ; i< data.length() ; i++){
			out += data.charAt(i) + generatedKey;
			}
		
		return cryptText(out,bit-1);
	}
	
	public String deCryptText(String data, int bit){
		if ( bit <= 0) return data;
		String out = "";
		for(int i = 0 ; i< data.length() ; i++){
			out += data.charAt(i) - generatedKey;
			}
		
		return cryptText(out,bit-1);
	}
	
	
}



