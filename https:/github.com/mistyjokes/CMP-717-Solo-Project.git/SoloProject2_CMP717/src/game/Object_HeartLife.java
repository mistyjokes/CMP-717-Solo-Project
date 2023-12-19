package game;

public class Object_HeartLife extends CharacterBase{

	public Object_HeartLife(GameWindow window) {
		super(window);
		name = "HeartLife";
		image = setUpImage("/images/objects/heart_blank.png");
		image2 = setUpImage("/images/objects/heart_half.png");
		image3 = setUpImage("/images/objects/heart_full.png");
	}

}
