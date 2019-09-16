/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 13 Sep 2019 at 21:13:57
 */
package gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

import pacmanjava.Sprite;

/**
 * @author yassine
 *
 */
public class Food  extends Sprite{
	
	protected boolean isVisible ;
	protected int value ;
	protected int type ; 
	
	public static String s="src/maze1.txt";
	public static  int[][] maze;
	public static int mazeWidth;
	public static int mazeHeight;
	public final static  int  TILESIZE =48;
		

	public Food(boolean isvisible, int type ){
		super();
		this.isVisible=isvisible;
		this.type=type ;
	}
	
	
	

	public static void draw(Graphics g, String msg,int posX,int posY,List<BufferedImage> images ,int size) {

		images = new ArrayList<BufferedImage>();


		try {
			BufferedImage originalImgage = ImageIO.read(new File("pacmanTiles.png"));

			//System.out.println("Original Image Dimension: "+originalImgage.getWidth()+"x"+originalImgage.getHeight());


			for (int i = 0; i < originalImgage.getHeight()/TILESIZE; i++) {
				for (int j = 0; j <originalImgage.getWidth()/TILESIZE; j++) {
					BufferedImage SubImgage = originalImgage.getSubimage(TILESIZE*j,i*TILESIZE , TILESIZE, TILESIZE);
					images.add(SubImgage);
				}

			}	


		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(s));
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


		for(int row=0; row <mazeHeight;row++) {
			for(int col =0;col<mazeWidth;col++) {

				int rc= maze[row][col];

				if (rc==30 ) {
					g.drawImage(images.get(12),col* size+posX,row* size+posY, size, size,null);	
				}

				else if (rc==40)
					g.drawImage(images.get(12),col* size+posX,row* size+posY, size, size,null);


				
			}
		}

	}

}


