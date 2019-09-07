package pacmanjava;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {
	
	
	protected int num;
	protected int x;
	protected int y;
	protected int tileSize;
	protected BufferedImage image;
	protected Graphics2D g;
	protected boolean isBlocked;
	protected static String path;
	
	public Tile(int x,int y, int num ,int tileSize,Graphics2D g) {
		this.num=num;
		this.tileSize=tileSize;
		this.x=x;
		this.y=y;
		this.g=g;
	}

	 
	 public  void draw() {
		
		 	
			
			//File f =new File(getClass().getClassLoader().getResource(path).getFile());
			try {
				
				image = ImageIO.read(new File(path));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
					
		 	g.drawImage(image,x,y,tileSize,tileSize,null);

		}

}
