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
	final int maxColumns = 20;
	final int maxRows = 12;
	
	//960x576 px
	final int screenWidth = tileSize*maxColumns;
	final int screenHeight = tileSize*maxRows;
	int FPS = 60;
	
	//keeps the program running constantly
	public UI ui = new UI(this);
	Thread gameThread;
	
	Input input = new Input();
	
	Player p = new Player(this, input);

	//default constructor
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		//improves rendering performance
		this.setDoubleBuffered(true);		
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
		
		//timer and drawCount variables are used for displaying FPS in the console
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {

			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime-lastTime);
			
			//current time is the new last time
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				
				//this is how we reference the paint component
				repaint();
				//set the delta back to 0
				delta--;
				drawCount++;
			}
			
			if(timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
		
	} //end of run method
	
	//update game data
	public void update() {
		p.update();
	}
	
	//built in method for drawing things on a JPanel
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		//Graphics2D is more useful for making games
		Graphics2D g2 = (Graphics2D) g;
		
		p.draw(g2);
		
		//UI must be drawn over players and tiles, henceforth the placing AFTER p.draw
		ui.draw(g2);
		
		g2.dispose();
		
	}
	
} //end of GamePanel class
