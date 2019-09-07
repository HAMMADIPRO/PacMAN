package pacmanjava;

import java.awt.Graphics2D;

public class Food extends Tile{

	public Food(int x, int y, int num, int tileSize, Graphics2D g) {
		super(x, y, num, tileSize, g);
		isBlocked=false;
	}

	
	public void setPath() {
		String path = "src//gums//";
		path+=num;
		path+=".png";

	}
}
