package data;
import static helpers.Artist.*;

public class TileGrid {
	
	public Tile[][] map;

	public TileGrid() {
		map=new Tile[10][10];
		for(int i=0;i<map.length;++i){
			for(int j=0;j<map[i].length;++j){
				map[i][j]=new Tile(i*64,j*64,64,64,TileType.Grass);
				
			}
		}
	}
	
	public TileGrid(int[][] newMap){
		map=new Tile[10][10];
		for(int i=0;i<map.length;++i){
			for(int j=0;j<map[i].length;++j){
				if(newMap[j][i]==0){
					map[i][j]=new Tile(i*64,j*64,64,64,TileType.Grass);
				}
				else if(newMap[j][i]==1)
					map[i][j]=new Tile(i*64,j*64,64,64,TileType.Dirt);
				else if(newMap[j][i]==2){
					map[i][j]=new Tile(i*64,j*64,64,64,TileType.Water);
				}
				else if(newMap[j][i]==3){
					map[i][j]=new Tile(i*64,j*64,64,64,TileType.Stone);
				}
				else if(newMap[j][i]==4){
					map[i][j]=new Tile(i*64,j*64,64,64,TileType.Tank);
				}
				else if(newMap[j][i]==5){
					map[i][j]=new Tile(i*64,j*64,64,64,TileType.Coin);
				}
				else
					map[i][j]=new Tile(i*64,j*64,64,64,TileType.Life);
				
					
				
			/*switch(newMap[j][i]){
			
			case 0:
				map[i][j]=new Tile(i*64,j*64,64,64,TileType.Grass);
				break;
				
			case 1:
				map[i][j]=new Tile(i*64,j*64,64,64,TileType.Dirt);
				break;
				
			case 2:
				map[i][j]=new Tile(i*64,j*64,64,64,TileType.Water);
				break;
			
			}*/
			}
		}
	}
	
	public void setTile(int xcor,int ycor,TileType type){
		map[xcor][ycor]=new Tile(xcor*64,ycor*64,64,64,type);
		
	}
	
	public Tile getTile(int x,int y){
		return map[x][y];
	}
	public void Draw(){
		for(int i=0;i<map.length;++i){
			for(int j=0;j<map[i].length;++j){
				Tile t=map[i][j];
				//drawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(),t.getHeight());
				t.Draw();
				
			}
		}
		
	}
	

}
