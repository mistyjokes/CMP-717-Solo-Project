package game;

public class Object_Gold extends CharacterBase{

	public Object_Gold(GameWindow window) {
		super(window);
		name = "gold";
		image = setUpImage("/images/objects/gold_pile_0.png");
		collisionOn = true;
		type = 79; //79 for gold	
	}
}
