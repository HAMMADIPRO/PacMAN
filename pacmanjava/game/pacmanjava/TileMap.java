package pacmanjava;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TileMap extends JPanel {

	private int tileSize;
	private int[][] maze;
	private int mazeWidth;
	private int mazeHeight;
	
	private BufferedImage image;
	private String  mapFile="src//maze.txt";

	public Tile tile;

	public TileMap( int tileSize) {
		this.tileSize=tileSize;
		// fill the maze matrix 
	
	}

	public void loadMap()
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(mapFile));
			StringTokenizer st = new StringTokenizer(br.readLine(),",");
			mazeWidth = Integer.parseInt(st.nextToken());
			mazeHeight =Integer.parseInt(st.nextToken());
			maze = new int[mazeHeight][mazeWidth];

			for(int row=0;row< mazeHeight ; row++) {
				st = new StringTokenizer(br.readLine(),",");
				for(int col=0;col<mazeWidth;col++) {
					maze[row][col]=Integer.parseInt(st.nextToken());
				}
			}
		}   
		catch(Exception e) { System.out.println("reading file");}
	}
	
	
	public void update() {

	}

	public void draw(Graphics2D g) {

		for(int row=0; row <mazeHeight;row++) {
			for(int col =0;col<mazeWidth;col++) {
				int rc = maze[row][col];
				if(rc==30) {

					try { image = ImageIO.read(new File("src//gums//gum.png"));}
					catch(Exception e) {e.printStackTrace();}

					g.drawImage(image,col*tileSize,row*tileSize,tileSize,tileSize,null);}

				else if(rc==40) {
					
						tile = new Food(col*tileSize, row*tileSize, rc,tileSize,g);}
				else { 
					if(rc==0) { }
					else {
						tile=new Wall(col*tileSize,row*tileSize, rc ,tileSize,g) ;
						
					}
						tile.draw();


				}
			}

		}
	}

}