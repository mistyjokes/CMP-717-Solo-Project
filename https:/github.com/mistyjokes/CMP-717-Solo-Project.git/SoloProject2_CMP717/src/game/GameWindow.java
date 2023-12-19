package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;
import javax.swing.text.html.parser.Entity;

import tile.Forest;

//import tile.Forest;

public class GameWindow extends JPanel implements Runnable {

	final int originalTileSize = 16;
	final int scale = 3;
	public final int tileSize = originalTileSize * scale; // 48x48 tile
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	Thread t;
	KeyHandler key = new KeyHandler(this);
	Sound sound = new Sound();
	
	//ENTITIES
	public Warrior warrior = new Warrior(this, key);
	public CharacterBase monster[] = new CharacterBase[5];
	public CharacterBase obj[] = new CharacterBase[7];
	ArrayList<CharacterBase> characters = new ArrayList<>();  //to control render order of characters 
	
	
	//FOREST SETTINGS
	public final int maxForestCol = 88;
	public final int maxForestRow = 48;
	public final int forestWidth = tileSize * maxForestCol;
	public final int forestHeight = tileSize * maxForestRow;
	Forest forest = new Forest(this);
	
	//COLLISION
	public CollisionChecker checker =  new CollisionChecker(this);
	
	//OBJECTS
	public AssetSetter asset = new AssetSetter(this);
	
	//UI
	public UI ui = new UI(this);

	//GAME STATE
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	
	
	public GameWindow() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(key);
		this.setFocusable(true);
	}
	
	public void setUpGame() {
		asset.setGoldObject();
		asset.setBoulderObjects();
		asset.setMonster();
//		playMusic(4);
		gameState = titleState;
//		gameState = playState; //Change this after
	}
	
	public void startGameThread() {
		t = new Thread(this);
		t.start();
	}
	

	@Override
	public void run() {
		while(true) {
			
			update();
			
			repaint();
			
			try
			{
				Thread.sleep(15);
			}
			catch(Exception x) {}	
		}
		
	}
	
	public void update() {
		
		if(gameState == playState) {
			warrior.update();
			
			for(int i = 0; i < monster.length; i++) {
				if(monster[i] != null) {
					monster[i].update();
				}
			}
			
		}
		else {
			//nothing happens 
		}
		
	}
	
	public void paint(Graphics pen) {
		

//		warrior.draw(pen);
		
//		if(gameState == titleState) {
//			ui.draw(pen);
			
//		} else {
			forest.draw(pen);
			
			//add characters to list
			characters.add(warrior);
			
			for(int i = 0; i < obj.length; i++) {
				if(obj[i] != null) {
					characters.add(obj[i]);
				}
			}
			
//			//see if this can change to stream
			for(int i = 0; i < monster.length; i++) {
				if(monster[i] != null) {
					characters.add(monster[i]);
				}
			}
			
			//sorted from lowest forestY to highest
			Collections.sort(characters, new Comparator<CharacterBase>() {
	
				@Override
				public int compare(CharacterBase o1, CharacterBase o2) {
					
					return Integer.compare(o1.forestY, o2.forestY);
				}
				
			});
			
			//draw characters for game
			for(int i = 0; i < characters.size(); i++) {
				characters.get(i).draw(pen);
			}
			
			//remove
			characters.clear(); //empty the list
//		}
			
			ui.draw(pen);
			
		
		pen.dispose();
	}
	
	public void playMusic(int i) {
		
		sound.setFile(i);
		sound.play();
		sound.loop();
	}
	
	public void stopMusic() {
		sound.stop();
	}
	
	public void playSoundEffect(int i) {
		sound.setFile(i);
		sound.play();
	}
}
