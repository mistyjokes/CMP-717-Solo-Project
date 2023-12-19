package game;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	Clip clip;
	URL soundURLS[] = new URL[6];

	public Sound() {
		soundURLS[0] = getClass().getResource("/sounds/ChiptuneAdventure.wav");
		soundURLS[1] = getClass().getResource("/sounds/Game-over-you-lose-fantasy.wav");
		soundURLS[2] = getClass().getResource("/sounds/happy_adveture.wav");
		soundURLS[3] = getClass().getResource("/sounds/Knightly-sword-swing-fast.wav");
		soundURLS[4] = getClass().getResource("/sounds/little town - orchestral.wav");
		soundURLS[5] = getClass().getResource("/sounds/mixkit-arcade-space-shooter-dead-notification-272.wav");
		
	}
	
	public void setFile(int i) {
		
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURLS[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void play() {   clip.start();                       }
	
	public void loop() {   clip.loop(Clip.LOOP_CONTINUOUSLY);  }
	
	public void stop() {   clip.stop();                        }
}
