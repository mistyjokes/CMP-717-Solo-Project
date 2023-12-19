package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

public class Warrior extends CharacterBase{
	
	KeyHandler key;
	Animation [] animation;
	static String[] pose = {"UP", "DN", "LT", "RT"};
	
	final int UP = Direction.UP.getNum();
	final int DN = Direction.DN.getNum();
	final int LT = Direction.LT.getNum();
	final int RT = Direction.RT.getNum();
	
	
	//WHERE WARRIOR IS ON THE SCREEN
	public final int screenX;
	public final int screenY;
	
	public Warrior(GameWindow window, KeyHandler key) {
		
		super(window);
		this.key = key;
		
//		screenX = window.screenWidth/2 - (window.tileSize/2);
//		screenY = window.screenHeight/2 - (window.tileSize/2);
		screenX = 100;
		screenY = 100;
		
		type = 0;
		
		
		area = new Rectangle(105, 126, 30, 20);
		areaDefaultX = area.x;
		areaDefaultY = area.y;
		
		characterDefaultValues();
		getCharacterImage();
		
		
//		getCharacterAttackImage();
//		getCharacterDeathImage();
		
	}
	
	public void characterDefaultValues() {
		forestX = window.tileSize*1;
		forestY = window.tileSize*1;
		speed = 3;
		imageDirection = DN;
		direction = "DN";
		maxLife = 6; // full heart = 2 lives;
		life = maxLife;
	}
	
	public void getCharacterImage() {
			
		animation = new Animation[pose.length];
		
//		isWeaponEquipped = imageCount == 1 ? true : false;
		
		
		
		if(isAttacking) { //&& isWeaponEquipped) {
			
//			imageCount = 2;
//			animation = new Animation[pose.length];
			
			for(int i = 0; i < pose.length; i ++)
			{
				animation[i] = new Animation("warriorAttackFM" + "_" + pose[i], 6, 0,  8, "png");
				
			}
			
			//isAttacking = false;
			
		} else {
			
			//Change the character image for attacking
			String fileName = isWeaponEquipped == true ? "warriorSwordFM" : "warriorFM";
			
			
			for(int i = 0; i < pose.length; i ++)
			{
				animation[i] = new Animation(fileName + "_" + pose[i], 9, 0,  8, "png");
				
			}
			
		}
			
			
	}
	
	public void getCharacterAttackImage() {
		
		//Fix attack images and rectangle for tile collision
		
		if(isAttacking) { //&& isWeaponEquipped) {
			
			animation = new Animation[pose.length];
			
			for(int i = 0; i < pose.length; i ++)
			{
				animation[i] = new Animation("warriorAttackFM" + "_" + pose[i], 6, 0,  8, "png");
				
			}
			
			//isAttacking = false;
			
		}
		
		
	}
	
	public void getCharacterDeathImage() {
		
//		animation = new Animation[pose.length];
		
		//create boolean for death
		
		if(isDead) {
			//Change the character image for death
			String fileName = isWeaponEquipped == true ? "warriorDeadSwordFM" : "warriorDeadFM";		
			for(int i = 0; i < 1; i ++)
			{
				animation[i] = new Animation(fileName, 6, 0,  8, "png");
				
			}
		}
		
	}
	
	public void update() {
		
		this.moving = false;
		
		//Tile Collision
		collisionOn = false;
		window.checker.checkTileCollision(this);
		
		//Object Collision
//		int objIndex = window.checker.checkObjectCollision(this, true);
		
		
		//Monster Collision
//		int monsterIndex = window.checker.checkCharacterCollision(this, window.monster);
//		interactMonster(monsterIndex);
		
		if(key.pressing[key._Q]) {
			isWeaponEquipped = true;
		} 
		
		if(key.pressing[key._A]) {
			isAttacking = true;
		}
		
		if(isAttacking) {
			attack();
			
		} else {
			warriorDirectionStatus(key, collisionOn);
		
		}
			
			
			

			
			
//			if(lifeTracker == true) {
//				lifeCounter++;
//				
//				//Add Hearts on the field so the warrior can collet them
//				if(lifeCounter > 120) {
//					lifeTracker = false;
//					lifeCounter = 0;
//				}
//			}
			
//		}
		
	}
	
	public void warriorDirectionStatus(KeyHandler key, boolean collisionOn) {
		
		if(key.pressing[key.UP]) {
			direction = "UP";
			imageDirection = UP;
			if(collisionOn == false) {
				goUP();
			}
			
		}
		
		if(key.pressing[key.DN]) {
			direction = "DN";
			imageDirection = DN;
			if(collisionOn == false) {
				goDN();
			}
			
		}
		
		if(key.pressing[key.LT]) {
			direction = "LT";
			imageDirection = LT;
			if(collisionOn == false) {
				goLT();
			}
			
		}
		
		if(key.pressing[key.RT]) {
			direction = "RT";
			imageDirection = RT;
			if(collisionOn == false) {
				goRT();
			}
			
		}
			
	}

	public void interactMonster(int i) {
		if(i != 999) {
			
			if(lifeTracker == false) {
				life -= 1;
				lifeTracker = true;
			}
		}
	}
	
	public void attack() {
		getCharacterAttackImage();
		isAttacking = false;
	}
	
	public void draw(Graphics pen) {
		
		Image temp;
		
				
		if (!moving)

			temp = animation[imageDirection].getStaticImage();
		
		else 
		
			temp = animation[imageDirection].getCurrentImage();
		
		pen.drawImage(temp, (int)(screenX - Camera.x), (int)(screenY - Camera.y), null);
		
	}

}
