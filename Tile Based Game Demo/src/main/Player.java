package main;

public class Player {
	
	GamePanel gp;
	private int xPosition, yPosition;
	private int height, width;
	private int speed;
	
	public Player(GamePanel gp) {
		this.gp = gp;
		xPosition = 100;
		yPosition = 100;
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
	
}
