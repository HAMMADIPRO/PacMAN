/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 12 Sep 2019 at 03:19:00
 */
package gfx;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

import java.io.BufferedReader;


import pacmanjava.GamePanel;
import pacmanjava.Shape;



public class Ui {

	public static String s="src/maze1.txt";
	public static  int[][] maze;
	public static int mazeWidth;
	public static int mazeHeight;
	public final static  int  TILESIZE =20;

	public static  void render(Graphics g) {

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



		

		
		
		
		
		

		for(int row=0; row <33;row++) {
			for(int col =0;col<30;col++) {
				
				int rc= maze[row][col];
				
				
				
					if (rc==0) {
									
						g.setColor(Color.BLACK);
						g.fillRect(col*TILESIZE,row*TILESIZE,TILESIZE,TILESIZE);
						
					}
						
					else if(rc==30)
						g.drawImage(Shape.images.get(12),col* TILESIZE,row* TILESIZE, TILESIZE, TILESIZE, null);
					
						
					else if (rc==40)						
						 g.drawImage(Shape.images.get(14),col* TILESIZE,row* TILESIZE, TILESIZE, TILESIZE,null);

				

					else if (rc <=12)
						 g.drawImage(Shape.images.get(rc-1),col* TILESIZE,row* TILESIZE, TILESIZE, TILESIZE,null);
					
						
			 		else  {	
						 g.drawImage(Shape.images.get(rc+3),col* TILESIZE,row* TILESIZE, TILESIZE, TILESIZE,null);

			 		}
			
			

			}
		
		
		  Font.draw(g, "Score u",40, 700);
		  Font.draw(g, "LIVES ",200, 700);
		  Font.draw(g, "FPS ",400, 700);

		  Font.draw(g, String.valueOf(GamePanel.FontFps),400, 750);

		

	}


}
	
}


