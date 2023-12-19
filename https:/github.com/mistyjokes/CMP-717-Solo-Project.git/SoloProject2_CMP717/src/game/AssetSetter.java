package game;

import monster.MonsterSlime;

public class AssetSetter {
	
	GameWindow window;
	
	public AssetSetter(GameWindow window) {
		this.window = window;
	}

	
	public void setMonster() {
		window.monster[0] = new MonsterSlime(window);
		window.monster[0].forestX = window.tileSize * 8;
		window.monster[0].forestY = window.tileSize * 5;
		
		window.monster[1] = new MonsterSlime(window);
		window.monster[1].forestX = window.tileSize * 20;
		window.monster[1].forestY = window.tileSize * 22;
		
		window.monster[2] = new MonsterSlime(window);
		window.monster[2].forestX = window.tileSize * 33;
		window.monster[2].forestY = window.tileSize * 30;
		
		window.monster[3] = new MonsterSlime(window);
		window.monster[3].forestX = window.tileSize * 20;
		window.monster[3].forestY = window.tileSize * 35;
		
		window.monster[4] = new MonsterSlime(window);
		window.monster[4].forestX = window.tileSize * 74;
		window.monster[4].forestY = window.tileSize * 20;
	}
	
	public void setGoldObject() {
		window.obj[0] = new Object_Gold(window);
		window.obj[0].forestX = window.tileSize * 74;
		window.obj[0].forestY = window.tileSize * 29;
		
		window.obj[5] = new Object_Gold(window);
		window.obj[5].forestX = window.tileSize * 74;
		window.obj[5].forestY = window.tileSize * 30;
		
		window.obj[6] = new Object_Gold(window);
		window.obj[6].forestX = window.tileSize * 74;
		window.obj[6].forestY = window.tileSize * 31;
	}
	
	public void setBoulderObjects() {
		window.obj[1] = new Object_Boulder(window);
		window.obj[1].forestX = window.tileSize * 74;
		window.obj[1].forestY = window.tileSize * 37;
		
		window.obj[2] = new Object_Boulder(window);
		window.obj[2].forestX = window.tileSize * 75;
		window.obj[2].forestY = window.tileSize * 37;
		
		window.obj[3] = new Object_Boulder(window);
		window.obj[3].forestX = window.tileSize * 74;
		window.obj[3].forestY = window.tileSize * 38;
		
		window.obj[4] = new Object_Boulder(window);
		window.obj[4].forestX = window.tileSize * 75;
		window.obj[4].forestY = window.tileSize * 38;
	}

}
