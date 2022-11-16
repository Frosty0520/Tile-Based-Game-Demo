package tile;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
		
	GamePanel gp;
	Tile[] tiles;
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
		tiles = new Tile[10];
		
		getTileImage();
	}
	
	//load tile images here
	public void getTileImage() {
		
		try {
			
			tiles[0] = new Tile();
			tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/Pics/MiddleDirtPath.png"));
			
			tiles[1] = new Tile();
			tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/Pics/LeftCornerDirtPath.png"));
			
			tiles[2] = new Tile();
			tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/Pics/RightCornerDirtPath.png"));
			
			tiles[3] = new Tile();
			tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/Pics/BLeftCornerDirtPath.png"));
			
			tiles[4] = new Tile();
			tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/Pics/BRightCornerDirtPath.png"));
			
			tiles[5] = new Tile();
			tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/Pics/StraightDirtPath.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void draw(Graphics2D g2) {
		//48 pixel difference between tiles on the gamescreen
		g2.drawImage(tiles[1].image, 0, 0, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tiles[2].image, 48, 0, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tiles[3].image, 0, 48, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tiles[4].image, 48, 48, gp.tileSize, gp.tileSize, null);
		
	}
	
}
