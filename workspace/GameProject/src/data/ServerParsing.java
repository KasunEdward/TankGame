package data;

public class ServerParsing extends Thread{
	static public String[] brick_cordinates,stone_cordinates,water_cordinates,player_info,brick_damage,coin_info,life_info;
    static public int direction,health,points,coins,dead;
     Boot boot=new Boot();
    
     
	public  void identifyString(String str2){
		String[] types;
		if(str2.startsWith("I:")){
		    types=parseMessageInitiation(str2);
		
		    String delimiter="[;]";
		    System.out.println("length"+types.length);
		    brick_cordinates=types[2].split(delimiter);
		    stone_cordinates=types[3].split(delimiter);
		    water_cordinates=types[4].split(delimiter);
		    boot.BootGame();
		    
		    }
		else if(str2.startsWith("S:")){
			String str=str2.substring(2,str2.length()-1);
			String delimiter="[;]";
			player_info=str.split(delimiter);
		boot.playerHandle();
			
		}
		else if(str2.startsWith("G:")){
			//G: and # characters not included
			String str=str2.substring(2,str2.length()-1);
			String delimiter="[:]";
			types=str.split(delimiter);
			player_info=types[0].split("[;]");
			direction=Integer.valueOf(player_info[2]);
			dead=Integer.valueOf(player_info[3]);
			health=Integer.valueOf(player_info[4]);
			coins=Integer.valueOf(player_info[5]);
			points=Integer.valueOf(player_info[6]);
			brick_damage=types[1].split("[;]");
			
			
			
		}
		else if(str2.startsWith("C:")){
			//C: and # characters not included
			String str=str2.substring(2,str2.length()-1);
			coin_info=str.split("[:]");
		boot.coinHandle();
		}
		else if(str2.startsWith("L:")){
			//L: and # characters not included
			String str=str2.substring(2,str2.length()-1);
			life_info=str.split("[:]");
		   boot.lifeHandle();
		}
	}
	
	public String[] parseMessageInitiation(String str){
	    
	    String[] types;
	    String delimiter="[:]";
	    types=str.split(delimiter);
	    for(int i=0;i<types.length;++i){
	        System.out.println(types[i]);
	    }
	   
	    return types;
	}

}
