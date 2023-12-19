package game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Object_Boulder extends CharacterBase{

	public Object_Boulder(GameWindow window) {
		super(window);
		name = "boulder";
		image = setUpImage("/images/objects/boulder.png");
		collisionOn = true;
		type = 5; //5 for boulder
//		area = new Rectangle(window.tileSize * 74, window.tileSize * 38, 48, 48);
		//maybe think of this as a tile instead
		
	}

}
