package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
import static helpers.Clock.*;

public class Enemy {

	private float x,y;
	private int width,height,speed;
	private Texture texture;
	private Tile starttile;
	private boolean first=true;
	public Enemy(Texture texture, Tile starttile,int width, int height,int speed) {
		super();
		this.width = width;
		this.height = height;
		this.x=starttile.getX();
		this.y=starttile.getY();
		this.texture = texture;
		this.starttile = starttile;
		this.speed=speed;
	}
	public void Update(){
		if(first)
			first=false;
		else
			x+=Delta()*speed;
	}
	
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Texture getTexture() {
		return texture;
	}
	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	public Tile getStarttile() {
		return starttile;
	}
	public void setStarttile(Tile starttile) {
		this.starttile = starttile;
	}
	public boolean isFirst() {
		return first;
	}
	public void setFirst(boolean first) {
		this.first = first;
	}
	public void Draw() {
	 drawQuadTex(texture,x,y,width,height);
		 
	 }
	
	
}
