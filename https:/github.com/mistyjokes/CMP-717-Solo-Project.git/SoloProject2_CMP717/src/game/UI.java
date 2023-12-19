package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import monster.MonsterSlime;

public class UI {
	
	GameWindow window;
	Graphics pen;
	Font arial_40, arial_80B;
	public int commandNum = 1;
	BufferedImage heart_blank, heart_half, heart_full;
	BufferedImage image;
	
	public UI(GameWindow window) {
		this.window = window;
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		arial_80B = new Font("Arial", Font.BOLD, 80);
		
		CharacterBase hearts = new Object_HeartLife(window);
		heart_blank = hearts.image;
		heart_half = hearts.image2;
		heart_full = hearts.image3;
		
		MonsterSlime s = new MonsterSlime(window);
		image = s.setUpImage("/images/playerSprites/monsterSlime_DN_0.png");
		
	}
	
	public void draw(Graphics pen) {
		this.pen = pen;
		pen.setFont(arial_40);
		pen.setColor(Color.white);
		
		
		//INITIAL
		if(window.gameState == window.titleState) {
			initialGameScreen();
		}
		
		//PLAY
		if(window.gameState == window.playState) {
			displayPlayerLife();
			pen.drawImage(image, window.tileSize + 200, window.tileSize/2, 40, 40, null);
			pen.drawString("x "+ window.monster.length, window.tileSize + 250, window.tileSize/2 + 30);
		}
		
		//PAUSE
		if(window.gameState == window.pauseState) {
			pauseScreen();
			displayPlayerLife();
			pen.drawImage(image, window.tileSize + 200, window.tileSize/2, 40, 40, null);
			pen.drawString("x "+ window.monster.length, window.tileSize + 250, window.tileSize/2 + 30);
		}
	}
	
	public void displayPlayerLife() {
		
		int x = window.tileSize/2;
		int y = window.tileSize/2;
		int i = 0;
		
		//Max Life
		while( i < window.warrior.maxLife/2) {
			pen.drawImage(heart_blank, x, y, window.tileSize, window.tileSize, null);
			i++;
			x += window.tileSize;
		}
		
		//Reset
		x = window.tileSize/2;
		y = window.tileSize/2;
		i = 0;
		
		//Current Life
		while( i < window.warrior.life) {
			pen.drawImage(heart_half, x, y, window.tileSize, window.tileSize, null);
			i++;
			if( i < window.warrior.life) {
				pen.drawImage(heart_full, x, y, window.tileSize, window.tileSize, null);
			}
			i++;
			x += window.tileSize;
		}
		
	}
	
	public void pauseScreen() {
		//Display text to display on Screen
		String text = "GAME PAUSED";
		
		//Draw Rectangle for Background
		
		int x = getScreenXValue(text);
		int y = window.screenHeight/2;
		
		pen.drawString(text, x, y);
		
		
	}
	
	public void initialGameScreen() {
		
		//Game Title
		pen.setFont(arial_80B);
		String text = "Warrior's Quest";
		
		int x = getScreenXValue(text);
		int y = window.tileSize * 3;
		
		//SHADOW TEXT
		pen.setColor(Color.BLACK);
		pen.drawString(text, x + 5, y + 5);
		//Change color when I change BACKGROUND color, can be done here
		pen.setColor(Color.white);
		
		pen.drawString(text, x, y);
		
		
		//Image
		x = window.screenWidth/2;
		y += window.tileSize * 2;
		
		//add down image for character
//		pen.drawImage(image, x, y, window.tileSize * 2, window.tileSize * 2);
		
		
		//Menu
		pen.setFont(arial_40);
		
		text = "START GAME";
		x = getScreenXValue(text);
		y += window.tileSize*4;
		pen.drawString(text, x, y);
		if(commandNum == 1) {
			pen.drawString(">", x - window.tileSize, y);
		}
		
		text = "QUIT";
		x = getScreenXValue(text);
		y += window.tileSize;
		pen.drawString(text, x, y);
		if(commandNum == 2) {
			pen.drawString(">", x - window.tileSize, y);
		}
		
		
		
		
	}
	
	public int getScreenXValue(String text) {
		int length = (int) pen.getFontMetrics().getStringBounds(text, pen).getWidth();
		return window.screenWidth/2 - length/2;
	}
}
