package game;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Animation {
	
	private Image[] image;
	
	private int current = 0;
	
	private int duration;
	private int delay;
	
	private int start = 0;
	
	public Animation(String name, int count, int start, int duration, String type) {
		
		try {
			this.start    = start;
			
			this.duration = duration;
			delay         = duration;
			
			
			image = new Image[count];
			
			for(int i = 0; i < count; i++) {

				System.out.println();
				image[i] = ImageIO.read(getClass().getResourceAsStream("/images/playerSprites/"+name + "_" + i + "." + type));
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Image getStaticImage()
	{
		return image[0];
	}

	public Image getCurrentImage()
	{
		delay--;
		
		if(delay == 0)
		{
			current++;
			
			if(current == image.length)  current = start;
			
			delay = duration;
		}
		
		return image[current];
	}
	

}
