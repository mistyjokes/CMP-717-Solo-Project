//package game;
//
//import java.awt.Graphics;
//import java.awt.image.BufferedImage;
//
//public class SuperObject {
//
//	public BufferedImage image;
//	public String name;
//	public boolean collision = false;
//	public int forestX, forestY;
//	
//	public void draw(Graphics pen, GameWindow window) {
//		
//		int screenX = (int)(forestX - window.warrior.forestX + Camera.x);
//		int screenY = (int)(forestY - window.warrior.forestY + Camera.y);
//		
//		pen.drawImage(image, screenX, screenY, window.tileSize, window.tileSize, null);
//
//	}
//}
