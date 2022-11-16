package tile;

import java.io.IOException;

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
		
	}
}
