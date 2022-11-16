package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player {
	
	GamePanel gp;
	Input input;
	private int globalX, globalY;
	private final int screenX, screenY;
	private int height, width;
	private int speed;
	
	public Player(GamePanel gp, Input input) {
		this.gp = gp;
		this.input = input;
		globalX = gp.tileSize*20;
		globalY = gp.tileSize*20;
		screenX = gp.screenWidth/2 - (width/2);
		screenY = gp.screenHeight/2 - (height/2);
		height = gp.tileSize;
		width = gp.tileSize;
		speed = 4;
	}
	
	//getters and setters
	
	public int getXPosition() {
		return this.globalX;
	}
	
	public void setXPosition(int xPosition) {
		this.globalX = xPosition;
	}
	
	public int getYPosition() {
		return this.globalY;
	}
	
	public void setYPosition(int yPosition) {
		this.globalY = yPosition;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	//update player data
	public void update() {

		if(input.WPressed) setYPosition(getYPosition()-getSpeed()); //move up
		if(input.SPressed) setYPosition(getYPosition()+getSpeed()); //move down
		if(input.APressed) setXPosition(getXPosition()-getSpeed()); //move left
		if(input.DPressed) setXPosition(getXPosition()+getSpeed()); //move right
				
	}
	
	//render the player here
	public void draw(Graphics2D g2) {
		g2.setColor(Color.white);
		
		g2.fillRect(screenX, screenY, getWidth(), getHeight());
	}
	
}
