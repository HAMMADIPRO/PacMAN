/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 13 Sep 2019 at 20:12:37
 */
package gfx;

import java.awt.Color;
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




public class Maze extends Sprite {

	public static String s="src/maze1.txt";
	public static  int[][] maze;
	public static int mazeWidth;
	public static int mazeHeight;
	public final static  int  TILESIZE =48;
	
	public static Food foods [][];
	public static boolean walls [][];

	

	public Maze(int size, int posX, int posY, List<BufferedImage> images) {
		super(size, posX, posY, images);

		//images = new ArrayList<BufferedImage>();


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
			foods =new Food [mazeHeight][mazeWidth];
			walls = new boolean[mazeHeight][mazeWidth];
			
			for(int row=0;row< mazeHeight ; row++) {
				st = new StringTokenizer(br.readLine(),",");
				for(int col=0;col<mazeWidth;col++) {
					maze[row][col]=Integer.parseInt(st.nextToken());
					
					
					if(maze[row][col]>0 && maze[row][col]<30) {
						walls [row][col]=true;
					}
					
					
				}
			}
		}
		catch(Exception e) { System.out.println("reading file");}


		
	
		
		for(int row=0;row< mazeHeight ; row++) {
			for(int col=0;col<mazeWidth;col++) {
				
				foods[row][col]=new Food(false,0);
				
				if(maze[row][col]==30) {
					foods[row][col].isVisible=true;
					foods[row][col].type=1;
				}
				
				if(maze[row][col]==40) {
					foods[row][col].isVisible=true;
					foods[row][col].type=2;
				}
				
			}
		}
	}
	public void draw(Graphics g) {
		
		
		for(int row=0; row <mazeHeight;row++) {
			for(int col =0;col<mazeWidth;col++) {

				int rc= maze[row][col];

				if (rc==0||rc==30||rc==40) {

					g.setColor(Color.BLACK);
					g.fillRect(col*size+posX,row*size+posY,size,size);
					
					if(foods[row][col].isVisible && foods[row][col].type==1) 	g.drawImage(images.get(12),col* size+posX,row* size+posY, size, size,null);
					if(foods[row][col].isVisible && foods[row][col].type==2) 	g.drawImage(images.get(14),col* size+posX,row* size+posY, size, size,null);

				}

				else if (rc <=12)
					g.drawImage(images.get(rc-1),col* size+posX,row* size+posY, size, size,null);


				else  {	
					g.drawImage(images.get(rc+3),col* size+posX,row* size+posY, size, size,null);

				}
			}
		}
		
		
		
	}
		
		
	


}
	
		
		
		
	








