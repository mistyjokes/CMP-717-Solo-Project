package game;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Warrior's Quest");
		
		GameWindow gameWindow = new GameWindow();
		window.add(gameWindow);
		
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gameWindow.setUpGame();
		
		gameWindow.startGameThread();

	}

}
