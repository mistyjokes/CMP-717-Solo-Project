package monster;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import game.Animation;
import game.Camera;
import game.CharacterBase;
import game.Direction;
import game.GameWindow;

public class MonsterSlime extends CharacterBase {
	
	static String[] pose = {"UP", "DN", "LT", "RT"};
	
	public MonsterSlime(GameWindow window ) {
		super(window);
		
		name = "Slime";
		speed = 2;
		maxLife = 0;
		life = maxLife;
		type = 1; // for slime
//	    area = new Rectangle(334, 194, 30, 30);
//		areaDefaultX = area.x;
//		areaDefaultY = area.y;
		imageDirection = Direction.DN.getNum();
		direction = "DN";
		
		getImage();
		//getSlimeDeathImage();
	}
	
	public void getImage() {
		
		animation = new Animation[pose.length];
		
		for(int i = 0; i < pose.length; i ++) {
			
			animation[i] = new Animation("monsterSlime"+ "_" + pose[i], 4, 0,  8, "png");
			
		}
		
	}
	
	public void getSlimeDeathImage() {
		
		
		//create boolean for death
		
		
		for(int i = 0; i < pose.length; i ++)
		{
			animation[i] = new Animation("monsterSlimeDeath" + "_" + pose[i], 5, 0,  8, "png");
			
		}
		
	}
	
	public void action() {
		
		actionLockCounter++;
		
		if(actionLockCounter == 120 ) { // ~2 seconds --> 60 FPS
			Random r = new Random();
			int i = r.nextInt(60)+1;
			
			if(i <= 15) {
				imageDirection = Direction.UP.getNum();
				direction = "UP";
				
			}
			if(i > 15 && i <= 30) {
				imageDirection = Direction.DN.getNum();
				direction = "DN";
			}
			if(i > 30 && i <= 45) {
				imageDirection = Direction.LT.getNum();
				direction = "LT";
			}
			if(i > 45 && i <= 60) {
				imageDirection = Direction.RT.getNum();
				direction = "RT";
			}
			
			actionLockCounter = 0;
		}
		

		
	}
	
	
}
