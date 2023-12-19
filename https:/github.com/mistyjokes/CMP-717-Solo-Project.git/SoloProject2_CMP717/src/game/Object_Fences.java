package game;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Object_Fences extends CharacterBase {

	public Object_Fences(GameWindow window) {
		super(window);
		
		name = "fences_horizontal";
		image = setUpImage("images/objects/fences_horizontal.png");
		
	}
}
