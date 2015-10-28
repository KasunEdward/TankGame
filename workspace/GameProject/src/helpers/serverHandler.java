package helpers;


import data.Boot;
import data.Client;
import data.Coins;
import data.Life;
import data.ServerParsing;
import data.Player.*;
import data.TileGrid.*;


public class serverHandler {
	public static void initiate(){
		String[] parse;
		String delim="[,]";
		int x_cor,y_cor;
		
		for(int i=0;i<ServerParsing.brick_cordinates.length;++i){
			parse=ServerParsing.brick_cordinates[i].split(delim);
			x_cor=Integer.valueOf(parse[0]);
			y_cor=Integer.valueOf(parse[1]);
			Boot.map[y_cor][x_cor]=1;
			
			
		}
		for(int i=0;i<ServerParsing.stone_cordinates.length;++i){
			parse=ServerParsing.stone_cordinates[i].split(delim);
			x_cor=Integer.valueOf(parse[0]);
			y_cor=Integer.valueOf(parse[1]);
			Boot.map[y_cor][x_cor]=3;
			
		}
		
		for(int i=0;i<ServerParsing.water_cordinates.length;++i){
			parse=ServerParsing.water_cordinates[i].split(delim);
			x_cor=Integer.valueOf(parse[0]);
			//this part added because # mark at the end of last water coordinates
			if(i==ServerParsing.water_cordinates.length-1){
				String y=parse[1].substring(0, parse[1].length()-1);
				y_cor=Integer.valueOf(y);
					
			}
			else{
			y_cor=Integer.valueOf(parse[1]);
			
			}
			Boot.map[y_cor][x_cor]=2;
		}
		
		
	}
	
	public static void playerHandling(){
		String[] parse;
		int x_cor,y_cor;
		
		parse=ServerParsing.player_info[1].split("[,]");
		x_cor=Integer.valueOf(parse[0]);
		y_cor=Integer.valueOf(parse[1]);
		Boot.map[y_cor][x_cor]=4;
		ServerParsing.direction=Integer.valueOf(ServerParsing.player_info[2]);
		switch(ServerParsing.direction){
		case 0:
			System.out.println("north");
			break;
		case 1:
			System.out.println("south");
			break;
		case 2:
			System.out.println("east");
			break;
		case 3:
			System.out.println("west");
			break;
		}
	}
	
	public static void coinHandling(){
		int x_cor,y_cor,value;
		long appear_time;
		x_cor=Integer.valueOf(ServerParsing.coin_info[0].substring(0, 1));
		y_cor=Integer.valueOf(ServerParsing.coin_info[0].substring(2));
		appear_time=Long.valueOf(ServerParsing.coin_info[1]);
		value=Integer.valueOf(ServerParsing.coin_info[2]);
		new Coins(appear_time, value, x_cor, y_cor).start();
		
		
	}
	public static void lifeHandling(){
		int x_cor,y_cor;
		long appear_time;
		x_cor=Integer.valueOf(ServerParsing.life_info[0].substring(0, 1));
		y_cor=Integer.valueOf(ServerParsing.life_info[0].substring(2));
		appear_time=Long.valueOf(ServerParsing.life_info[1]);
		new Life( x_cor, y_cor,appear_time).start();
		
		
	}

}
