package pacmanjava;

import java.awt.Graphics2D;

public class Wall extends Tile {
	
	public Wall(int x, int y, int num, int tileSize, Graphics2D g) {
		super(x, y, num, tileSize, g);
		isBlocked = true ;
	}
 
	

}
