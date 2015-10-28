package data;
import data.Boot;

public class Coins extends Thread{
	private int x,y,value;
	private long appear_time;
	
	public Coins(long appear_time, int value, int x, int y) {
		
		this.appear_time = appear_time;
		this.value = value;
		this.x = x;
		this.y = y;
	}
	public void run(){
		long appear_t=System.currentTimeMillis();
		while(System.currentTimeMillis()<=appear_t+appear_time){
			appear();
		}
		disappear();
	}
public void appear(){
	Boot.map[y][x]=5;
}

public void disappear(){
	Boot.map[y][x]=0;
}
}
