package data;

import java.util.ArrayList;
import static helpers.Clock.*;

public class Wave {
	
	private float timeSliceLastSpawn,spawnTime;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;
	public Wave(float spawnTime, Enemy enemyType) {
	
		this.spawnTime = spawnTime;
		this.enemyType = enemyType;
		timeSliceLastSpawn=0;
		enemyList=new ArrayList<Enemy>();
		
	}
	public void update(){
		timeSliceLastSpawn+=Delta();
		if(timeSliceLastSpawn>spawnTime){
			spawn();
			timeSliceLastSpawn=0;
		}
		for(Enemy e:enemyList){
			e.Update();
			e.Draw();
		}
	}
	
	private void spawn(){
		enemyList.add(new Enemy(enemyType.getTexture(),enemyType.getStarttile(),64,64,enemyType.getSpeed()));
	}
	

}
