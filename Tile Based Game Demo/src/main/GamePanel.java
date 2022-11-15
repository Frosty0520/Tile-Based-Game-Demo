package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

//implementing Runnable interface allows the Thread to be utilized
public class GamePanel extends JPanel implements Runnable {
	
	//define screen settings
	final int tileSize = 48; //48x48 tiles
	final int maxColumns = 16;
	final int maxRows = 12;
	
	//768x576 px
	final int screenWidth = tileSize*maxColumns;
	final int screenHeight = tileSize*maxRows;
	int FPS = 60;
	
	//keeps the program running constantly
	Thread gameThread;
	
	Player p;
	
	Input input;
	
	//default constructor
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		//improves rendering performance
		this.setDoubleBuffered(true);
		
		p = new Player(this);
		
		input = new Input();
		
		//window can accept input
		this.addKeyListener(input);
		this.setFocusable(true);
	} 

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	//auto-generated, is called when the Thread object is "started"
	//houses the game loop
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {

			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			
			//current time is the new last time
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				
				//this is how we reference the paint component
				repaint();
				//set the delta back to 0
				delta--;
			}
			
		}
		
	} //end of run method
	
	//update game data
	public void update() {
		
		if(input.WPressed) p.setYPosition(p.getYPosition()-p.getSpeed()); //move up
		if(input.SPressed) p.setYPosition(p.getYPosition()+p.getSpeed()); //move down
		if(input.APressed) p.setXPosition(p.getXPosition()-p.getSpeed()); //move left
		if(input.DPressed) p.setXPosition(p.getXPosition()+p.getSpeed()); //move right
		
	}
	
	//built in method for drawing things on a JPanel
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		//Graphics2D is more useful for making games
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.white);
		
		g2.fillRect(p.getXPosition(), p.getYPosition(), p.getWidth(), p.getHeight());
		
		g2.dispose();
		
	}
	
} //end of GamePanel class