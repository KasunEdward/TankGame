package data;

import org.lwjgl.opengl.Display;

import data.Boot;

public class Draw extends Thread {
	
	

	public void draw(){
		TileGrid grid=new TileGrid(Boot.map);
	
		
			grid.Draw();
			Display.update();
			Display.sync(60);
		//new Thread().start();
		
	}
	public void run(){
		while(true){
			Display.update();
			Display.sync(60);
			
		}
	}
}
