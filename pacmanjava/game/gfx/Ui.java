/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 12 Sep 2019 at 03:19:00
 */
package gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import models.Input;
import pacmanjava.GamePanel;

public class Ui {
	
	public Input i;
	public Pacman p ;
	static Ui inerface;

	
	public Ui(Pacman p) {
		
		this.p = p;
			
		
	}
	
	

	public static  void render(Graphics g, Pacman p) {
		
		

		List<BufferedImage> images = new ArrayList<BufferedImage>();


		//20 size , x= 0 , y=50  
		Maze m= new Maze(20, 0, 0, images, g);


		Font f=new Font();

		

		f.draw(g, "LIVES ",5, 750,images,15);

		f.draw(g, "FPS ",450, 750,images,15);

		f.draw(g, String.valueOf(GamePanel.FontFps),500, 750,images,15);

		inerface = new Ui(p);
		
		
		p.draw(g, p.direction);
		
		
		
		
		
	}

}







