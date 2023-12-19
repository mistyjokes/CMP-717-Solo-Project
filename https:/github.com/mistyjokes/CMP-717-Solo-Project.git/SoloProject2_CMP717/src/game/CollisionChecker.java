package game;

public class CollisionChecker {

	GameWindow window;

	public CollisionChecker(GameWindow window) {
		this.window = window;
	}

	public void checkTileCollision(CharacterBase base) {
		
		//Find the position of the area with respect to the forest map. The area is not of the whole base but
		//a part within the base image
		int leftForestX = base.forestX + base.area.x;
		int rightForestX = base.forestX + base.area.x + base.area.width;
		int topForestY = base.forestY + base.area.y;
		int bottomForestY = base.forestY + base.area.y + base.area.height;
		
//		System.out.println(leftForestX);
		
		//Find the column and row numbers of the coordinates above
		int leftCol = leftForestX / window.tileSize;
		int rightCol = rightForestX / window.tileSize;
		int topRow = topForestY / window.tileSize;
		int bottomRow = bottomForestY / window.tileSize;
		
//		System.out.println(leftCol);
		
		int tileNum1, tileNum2;
		
		switch(base.direction) {
		case "UP":
			topRow = (topForestY - base.speed)/window.tileSize;
			tileNum1 = window.forest.mapForestTileMap[leftCol][topRow];
			tileNum2 = window.forest.mapForestTileMap[rightCol][topRow];
			
			if(window.forest.tile[tileNum1].collision == true || 
					window.forest.tile[tileNum2].collision == true) {
				base.collisionOn = true;
			}
			break;
		case "DN":
			bottomRow = (bottomForestY + base.speed)/window.tileSize;
			tileNum1 = window.forest.mapForestTileMap[leftCol][bottomRow];
			tileNum2 = window.forest.mapForestTileMap[rightCol][bottomRow];
			
			if(window.forest.tile[tileNum1].collision == true || 
					window.forest.tile[tileNum2].collision == true) {
				base.collisionOn = true;
			}
			break;
		case "LT":
			leftCol = (leftForestX - base.speed)/window.tileSize;
			tileNum1 = window.forest.mapForestTileMap[leftCol][topRow];
			tileNum2 = window.forest.mapForestTileMap[leftCol][bottomRow];
			
//			System.out.println(leftCol + "tileNum 1: "+ tileNum1 + ", "+tileNum2);
			
			if(window.forest.tile[tileNum1].collision == true || 
					window.forest.tile[tileNum2].collision == true) {
				base.collisionOn = true;
			}
			break;
		case "RT":
			rightCol = (rightForestX + base.speed)/window.tileSize;
			tileNum1 = window.forest.mapForestTileMap[rightCol][topRow];
			tileNum2 = window.forest.mapForestTileMap[rightCol][bottomRow];
			
			if(window.forest.tile[tileNum1].collision == true || 
					window.forest.tile[tileNum2].collision == true) {
				base.collisionOn = true;
			}
			break;
		}


		
	}
	
	public int checkObjectCollision(CharacterBase base, boolean player) {
		int index = 999;
		
		for(int i = 0; i < window.obj.length; i++) {
			
			if(window.obj[i] != null) {
				base.area.x = base.forestX + base.area.x;
				base.area.y = base.forestY + base.area.y;
				
				//Get object position area
				window.obj[i].area.x = window.obj[i].forestX + window.obj[i].area.x;
				window.obj[i].area.y = window.obj[i].forestY + window.obj[i].area.y;
				
				switch(base.direction) {
				case "UP":
					base.area.y -= base.speed;
					break;
				case "DN":
					base.area.y += base.speed;
					break;
				case "LT":
					base.area.x -= base.speed;
					break;
				case "RT":
					base.area.x += base.speed;
					break;
				}
				
				if(base.area.intersects(window.obj[i].area)) {
					if(window.obj[i] != base) {
						base.collisionOn = true;
						index = i;
					}	
					
				}
				
				//reset numbers since the x and y will keep increasing on the world map
				base.area.x = base.areaDefaultX;
				base.area.y = base.areaDefaultY;
				window.obj[i].area.x = window.obj[i].areaDefaultX;
				window.obj[i].area.y = window.obj[i].areaDefaultY;
				
				
			}
			
		}
		
		return index;
		
	}
	
	public int checkCharacterCollision(CharacterBase character, CharacterBase[] target) {
		
		int index = 999;
		
		for(int i = 0; i < target.length; i++) {
			
			if(target[i] != null) {
				
				//Get area within character
				character.area.x = character.forestX + character.area.x;
				character.area.y = character.forestY + character.area.y;
				
				//Get monster/npc area within
				target[i].area.x = target[i].forestX + target[i].area.x;
				target[i].area.y = target[i].forestY + target[i].area.y;
				
				switch(character.direction) {
				case "UP":
					character.area.y -= character.speed;
					break;
				case "DN":
					character.area.y += character.speed;
					break;
				case "LT":
					character.area.x -= character.speed;
					break;
				case "RT":
					character.area.x += character.speed;
					break;
				}
				
				if(character.area.intersects(target[i].area)) {
					if(target[i] != character) {
						character.collisionOn = true;
						index = i;
					}	
					
				}
				character.area.x = character.areaDefaultX;
				character.area.y = character.areaDefaultY;
				target[i].area.x = target[i].areaDefaultX;
				target[i].area.y = target[i].areaDefaultY;

			}
			
		}
		return index;
	}
	
	public boolean checkPlayerCollision(CharacterBase character) {
		
		boolean playerContact = false;
		//Get area within character
		character.area.x = character.forestX + character.area.x;
		character.area.y = character.forestY + character.area.y;
		
		//Get monster/npc area within
		window.warrior.area.x = window.warrior.forestX + window.warrior.area.x;
		window.warrior.area.y = window.warrior.forestY + window.warrior.area.y;
		
		switch(character.direction) {
		case "UP":
			character.area.y -= character.speed;
			
			break;
		case "DN":
			character.area.y += character.speed;
		
			break;
		case "LT":
			character.area.x -= character.speed;
			
			break;
		case "RT":
			character.area.x += character.speed;
			
			break;
		}
		
		if(character.area.intersects(window.warrior.area)) {
			
			character.collisionOn = true;
			playerContact = true;
		}
		
		character.area.x = character.areaDefaultX;
		character.area.y = character.areaDefaultY;
		window.warrior.area.x = window.warrior.areaDefaultX;
		window.warrior.area.y = window.warrior.areaDefaultY;

		return playerContact;
	}

}
