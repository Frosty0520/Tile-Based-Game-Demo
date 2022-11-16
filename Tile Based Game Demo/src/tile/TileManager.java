package tile;

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
			tiles[0].image = ImageIO.read(getClass().getResourceAsStream(""));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
