package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {
	
	//movement
	boolean WPressed, APressed, SPressed, DPressed;
	
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		switch(keyCode) {
		case KeyEvent.VK_W: WPressed = true; break;
		case KeyEvent.VK_A: APressed = true; break;
		case KeyEvent.VK_S: SPressed = true; break;
		case KeyEvent.VK_D: DPressed = true; break;
		}
		
	}

	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		switch(keyCode) {
		case KeyEvent.VK_W: WPressed = false; break;
		case KeyEvent.VK_A: APressed = false; break;
		case KeyEvent.VK_S: SPressed = false; break;
		case KeyEvent.VK_D: DPressed = false; break;
		}
		
	}

}
