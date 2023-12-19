package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.text.Utilities;

public class CharacterBase {
	
	//GENERAL
	public Animation [] animation;
	public int forestX, forestY;
	public int speed;
	public String direction = "DN";
	public boolean moving = false;
	public int imageDirection;
	public String name;
	public BufferedImage image, image2, image3;
	
	//For AI action, to change direction of monster/npc
	public int actionLockCounter = 0;
//	public boolean collision = false;
//	static int scale = 1;
	
	//CHARACTER STATUS
	public int maxLife;
	public int life;
	//to prevent the player from losing life quickly in the game
	public boolean lifeTracker = false;
	public int lifeCounter = 0;
	boolean isDead = false;
	
	//CHARACTER TYPE
	public int type;
	
	//COLLISION
	public boolean collisionOn = false;
	
	//AREA WITHIN SPRITE TO CHECK FOR COLLISION
	public Rectangle area = new Rectangle(0, 0, 48, 48);
	
	public int areaDefaultX, areaDefaultY;
	
	//CHARACTER ATTACK
	boolean isAttacking = false;
	boolean isWeaponEquipped = false;
//	public Rectangle attackArea = new Rectangle(0,0,48,48);
	
	
	public GameWindow window;
	
	public CharacterBase(GameWindow window) {
		
		this.window = window;
		
	}
	
	public void action() {};
	
	public void update() {
		
		action();
		
		checkingCollision();
	}
	
	public void checkingCollision() {
		//Check tile collision
		
//		if(type == 0) {
			
			collisionOn = false;
			window.checker.checkTileCollision(this);

//			window.checker.checkPlayerCollision(this);
			
			//make sprite move if collision is false
			if(collisionOn == false) {
				switch(direction) {
				case "UP":
					goUP(); break;
				case "DN":
					goDN(); break;
				case "LT":
					goLT(); break;
				case "RT":
					goRT(); break;
				}
//			}
			
		}
		
		
		

	}
	
	public void goLT()
	{
		forestX -= speed;
		moving = true;
	}
	
	public void goRT()
	{
		forestX += speed;
		moving = true;
	}
	
	public void goUP()
	{
		forestY -= speed;
		moving = true;
	}
	
	public void goDN()
	{
		forestY += speed;
		moving = true;
	}
	
	
	public BufferedImage setUpImage(String filePath) {
		
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(filePath));
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public void draw(Graphics pen) {

		Image temp;
		
		int w = window.warrior.forestX + (window.screenWidth + Camera.x);
		int x = window.warrior.forestX - (window.screenWidth + Camera.x);
		int y = window.warrior.forestY + (window.screenHeight + Camera.y);
		int z = window.warrior.forestY - (window.screenHeight + Camera.y);
		
		int screenX = forestX - window.warrior.forestX + Camera.x;
		int screenY = forestY - window.warrior.forestY + Camera.y;
		
		
		if(forestX + window.tileSize > x &&
		   forestX - window.tileSize < w &&
		   forestY + window.tileSize > z &&
		   forestY - window.tileSize < y) {
			
			if(type != 79) {
				
				if(type == 5) {
					pen.drawImage(image, screenX, screenY, window.tileSize, window.tileSize, null);
				} else {
					temp = animation[imageDirection].getCurrentImage();
					pen.drawImage(temp, screenX, screenY, 30, 30, null);
				}
				
			} else {
				pen.drawImage(image, screenX, screenY, 100, 100, null);
			}
			
			
		}

	}

}
