package data;

public class Life extends Thread {
	
	private int x,y;
	private long appear_time;
	
	public Life(int x, int y, long appear_time) {
		this.x = x;
		this.y = y;
		this.appear_time = appear_time;
	}
	
	public void run(){
		long appear_t=System.currentTimeMillis();
		while(System.currentTimeMillis()<=appear_t+appear_time){
			appear();
		}
		disappear();
	}
public void appear(){
	Boot.map[y][x]=6;
}

public void disappear(){
	Boot.map[y][x]=0;
}
	
	

}
