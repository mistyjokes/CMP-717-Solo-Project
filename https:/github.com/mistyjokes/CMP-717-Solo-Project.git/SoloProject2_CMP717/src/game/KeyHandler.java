package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	boolean[] pressing = new boolean[1024];
	
	public final int UP          = KeyEvent.VK_UP;
	public final int DN          = KeyEvent.VK_DOWN;
	public final int LT          = KeyEvent.VK_LEFT;
	public final int RT          = KeyEvent.VK_RIGHT;
	
	public final int _A          = KeyEvent.VK_A;
	public final int _B          = KeyEvent.VK_B;
	public final int _C          = KeyEvent.VK_C;
	public final int _D          = KeyEvent.VK_D;
	public final int _E          = KeyEvent.VK_E;
	public final int _F          = KeyEvent.VK_F;
	public final int _G          = KeyEvent.VK_G;
	public final int _H          = KeyEvent.VK_H;
	public final int _I          = KeyEvent.VK_I;
	public final int _J          = KeyEvent.VK_J;
	public final int _K          = KeyEvent.VK_K;
	public final int _L          = KeyEvent.VK_L;
	public final int _M          = KeyEvent.VK_M;
	public final int _N          = KeyEvent.VK_N;
	public final int _O          = KeyEvent.VK_O;
	public final int _P          = KeyEvent.VK_P;
	public final int _Q          = KeyEvent.VK_Q;
	public final int _R          = KeyEvent.VK_R;
	public final int _S          = KeyEvent.VK_S;
	public final int _T          = KeyEvent.VK_T;
	public final int _U          = KeyEvent.VK_U;
	public final int _V          = KeyEvent.VK_V;
	public final int _W          = KeyEvent.VK_W;
	public final int _X          = KeyEvent.VK_X;
	public final int _Y          = KeyEvent.VK_Y;
	public final int _Z          = KeyEvent.VK_Z;

	public final int _1          = KeyEvent.VK_1;
	public final int _2          = KeyEvent.VK_2;
	public final int _3          = KeyEvent.VK_3;
	public final int _4          = KeyEvent.VK_4;
	public final int _5          = KeyEvent.VK_5;
	public final int _6          = KeyEvent.VK_6;
	public final int _7          = KeyEvent.VK_7;
	public final int _8          = KeyEvent.VK_8;
	public final int _9          = KeyEvent.VK_9;
	
	public final int CTRL        = KeyEvent.VK_CONTROL;
	public final int SHFT        = KeyEvent.VK_SHIFT;
	public final int ALT         = KeyEvent.VK_ALT;
	
	public final int SPACE       = KeyEvent.VK_SPACE;
	
	public final int COMMA       = KeyEvent.VK_COMMA;
	public final int PERIOD      = KeyEvent.VK_PERIOD;
	public final int SLASH       = KeyEvent.VK_SLASH;
	public final int SEMICOLON   = KeyEvent.VK_SEMICOLON;
	public final int COLON       = KeyEvent.VK_COLON;
	public final int QUOTE       = KeyEvent.VK_QUOTE;
	public final int ENTER		 = KeyEvent.VK_ENTER;
	
	public final int F1          = KeyEvent.VK_F1;
	public final int F2          = KeyEvent.VK_F2;
	public final int F3          = KeyEvent.VK_F3;
	public final int F4          = KeyEvent.VK_F4;
	public final int F5          = KeyEvent.VK_F5;
	public final int F6          = KeyEvent.VK_F6;
	public final int F7          = KeyEvent.VK_F7;
	public final int F8          = KeyEvent.VK_F8;
	public final int F9          = KeyEvent.VK_F9;
	public final int F10         = KeyEvent.VK_F10;
	public final int F11         = KeyEvent.VK_F11;
	public final int F12         = KeyEvent.VK_F12;
	
	GameWindow window;
	
	public KeyHandler(GameWindow window) {
		this.window = window;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		pressing[e.getKeyCode()] = true;
		
		if(pressing[_P]) {
			if(window.gameState == window.playState) {
				window.gameState = window.pauseState;
			} else {
				window.gameState = window.playState;
			}
		}
		
		if(window.gameState == window.titleState) {
			if(pressing[_B]) {
				window.ui.commandNum--;
				if(window.ui.commandNum < 1) {
					window.ui.commandNum = 2;
				}
			}
			
			if(pressing[_N]) {
				window.ui.commandNum++;
				if(window.ui.commandNum > 2) {
					window.ui.commandNum = 1;
				}
			}
			
			if(pressing[ENTER]) {
				if(window.ui.commandNum == 1) { 
					window.gameState = window.playState;
					window.ui.commandNum = 0;
					window.playMusic(4);
				}
				
				if(window.ui.commandNum == 2) { 
					System.exit(0);
				}
			}
			
		}
		
		
		if(pressing[ENTER]) {
			
			
			
			//play music
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		//int code = e.getKeyCode();
		
		pressing[e.getKeyCode()] = false;
		
	}

}
