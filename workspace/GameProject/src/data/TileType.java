package data;

public enum TileType {
	
	Grass("grass64",true),Dirt("dirt64",false),Water("water64",false),Stone("stone",false),Tank("tank",false),Coin("coins",false),Life("life",true);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName,boolean buildable){
		this.textureName=textureName;
		this.buildable=buildable;
	}

}
