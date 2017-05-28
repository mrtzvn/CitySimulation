package program;

import java.util.ArrayList;
import java.util.Comparator;

public class Logger {
	
	private ArrayList<Log> logs;
	
	public Logger(){
		logs = new ArrayList<Log>();
	}
	
	public void addLog(Log a){
		logs.add(a);
		
	}
	public void addLog(String start,String finish,int turn){
		logs.add(new Log(start,finish,turn));
	}
	
}

class Log{
	private String start,finish;
	private int turn;
	public Log(String start,String finish,int turn){	
		this.start = start;
		this.finish = finish;
		this.turn = turn;		
	}
	
	public int getTurn(){
		return turn;
	}
	
	public String getStart(){
		return start;
	}
	
	public String getFinish(){
		return finish;
	}
	
	public String toString(){
		return start + " to "+ finish + " at turn"+turn;
	}
	
	
}
