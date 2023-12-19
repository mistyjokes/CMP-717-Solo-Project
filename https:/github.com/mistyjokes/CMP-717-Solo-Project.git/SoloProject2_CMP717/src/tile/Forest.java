package tile;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import game.Camera;
import game.GameWindow;

public class Forest {
	
	GameWindow window;
	public Tile[] tile;
	public int mapForestTileMap[][];
	
	public Forest(GameWindow window) {
		this.window = window;
		tile = new Tile[28];
		mapForestTileMap = new int [window.maxForestCol][window.maxForestRow];
		
		getForestTileImages();
		loadMap();
	}

	public void getForestTileImages() {
		
		//collision is false by default
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream(""));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/grass.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/grass_fruitTree_a.png"));
			tile[2].collision = true;
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/grassCornerBottomLeft.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/grassCornerBottomRight.png"));
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/grassCornerTopLeft.png"));
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/grassCornerTopRight.png"));
			
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/groundGrassBottom.png"));
			
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/groundGrassLeft.png"));
			
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/groundGrassRight.png"));
			
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/groundGrassTop.png"));
			
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/ground.png"));
			
			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/invertedGrassyCornerBottomRight.png"));
			
			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/invertedGrassyCornerBottomLeft.png"));
			
			tile[14] = new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/invertedGrassyCornerTopLeft.png"));
			
			tile[15] = new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/invertedGrassyCornerTopRight.png"));
			
			tile[16] = new Tile();
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/water.png"));
			
			tile[17] = new Tile();
			tile[17].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/waterBottom.png"));
			tile[17].collision = true;
			
			tile[18] = new Tile();
			tile[18].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/waterCorner_BottomLeft.png"));
			tile[18].collision = true;
			
			tile[19] = new Tile();
			tile[19].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/waterCorner_BottomRight.png"));
			tile[19].collision = true;
			
			tile[20] = new Tile();
			tile[20].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/waterCorner_TopLeft.png"));
			tile[20].collision = true;
			
			tile[21] = new Tile();
			tile[21].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/waterCorner_TopRight.png"));
			tile[21].collision = true;
			
			tile[22] = new Tile();
			tile[22].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/waterLeft.png"));
			tile[22].collision = true;
			
			tile[23] = new Tile();
			tile[23].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/waterRight.png"));
			tile[23].collision = true;
			
			tile[24] = new Tile();
			tile[24].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/waterTop.png"));
			tile[24].collision = true;
			
			tile[25] = new Tile();
			tile[25].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/rock_in_water_01.png"));
			
			tile[26] = new Tile();
			tile[26].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/wall_16x16.png"));
			
			tile[27] = new Tile();
			tile[27].image = ImageIO.read(getClass().getResourceAsStream("/images/tiles/sideWall_16x16.png"));
			
			
		}catch(IOException e) {
			//see if you change this to an error log -- minor change
			e.printStackTrace();
		}
		
	}

	public void loadMap() {
		try {
			InputStream is = getClass().getResourceAsStream("/resources/ForestMap.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			
			int col = 0;
			int row = 0;
			
			while(col < window.maxForestCol && row < window.maxForestRow) {
				String line = br.readLine();
				while(col < window.maxForestCol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					mapForestTileMap[col][row] = num;
					col++;
				}
				if(col == window.maxForestCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
		}catch(Exception e) {
			//see if you change this to an error log -- minor change
			e.printStackTrace();
		}
		
	}
	
	public void draw(Graphics pen) {
		
			
		int forestCol = 0;
		int forestRow = 0;
		
		while(forestCol < window.maxForestCol && forestRow < window.maxForestRow) {
			
			int tileNum = mapForestTileMap[forestCol][forestRow];
			
			int w = window.warrior.forestX + (window.screenWidth + Camera.x);
			int x = window.warrior.forestX - (window.screenWidth + Camera.x);
			int y = window.warrior.forestY + (window.screenHeight + Camera.y);
			int z = window.warrior.forestY - (window.screenHeight + Camera.y);
//			
			int forestX = forestCol * window.tileSize;
			int forestY = forestRow * window.tileSize;
			int screenX = forestX - window.warrior.forestX + Camera.x;
			int screenY = forestY - window.warrior.forestY + Camera.y;
			

			
			if(forestX + window.tileSize > x &&
			   forestX - window.tileSize < w &&
			   forestY + window.tileSize > z &&
			   forestY - window.tileSize < y) {
				
				pen.drawImage(tile[tileNum].image, screenX, screenY, window.tileSize, window.tileSize, null);
			}
				
//			}

			forestCol++;
			
			if(forestCol == window.maxForestCol) {
				forestCol = 0;
				forestRow++;
				
			}

			
		}
		
	}

		

}
