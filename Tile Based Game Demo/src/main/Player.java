package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player {
	
	GamePanel gp;
	Input input;
	private int xPosition, yPosition;
	private int height, width;
	private int speed;
	
	public Player(GamePanel gp, Input input) {
		this.gp = gp;
		this.input = input;
		xPosition = gp.screenWidth/2;
		yPosition = gp.screenHeight/2;
		height = gp.tileSize;
		width = gp.tileSize;
		speed = 3;
	}
	
	//getters and setters
	
	public int getXPosition() {
		return this.xPosition;
	}
	
	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	
	public int getYPosition() {
		return this.yPosition;
	}
	
	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
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
		
		g2.fillRect(getXPosition() - getWidth()/2, getYPosition() - getHeight()/2, getWidth(), getHeight());
	}
	
}
