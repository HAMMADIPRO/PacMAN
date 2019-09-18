/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 17 Sep 2019 at 20:54:03
 */
package gfx;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

import models.Input;

public class Menu {
	
	
	
	static List<BufferedImage> images;
	Font f=new Font();
	public Rectangle playB= new Rectangle(230,210,165,50);
	public Rectangle playC= new Rectangle(230,280,165,50);
	public Rectangle playD= new Rectangle(230,350,165,50);
	public Rectangle playE= new Rectangle(230,420,165,50);
	public Rectangle playF= new Rectangle(230,490,165,50);
	
	
	
	
	
  public  void Render(Graphics g) {
	  
	 Graphics2D g2=(Graphics2D) g;
	 g2.setColor(Color.WHITE);;
	 
	 
	 
	 f.draw(g, "GAME MENU ",200-20, 140,images,28);
	  g2.draw(playB);
	 
	if(Input.ESCAPE==true)
	  f.draw(g, " RESUME",238-20, 220,images,25);
	if(Input.ESCAPE==false)
		  f.draw(g, " PLAY",250-20, 220,images,25);
	  g2.draw(playC);
	  f.draw(g, " SOUND  ",240-20, 290,images,25);
	  
	  g2.draw(playD);
	  f.draw(g, " MUSIC ",240-20, 360,images,25);
	  g2.draw(playE);
	  f.draw(g, " HELP ",245-20, 430,images,25);
	  g2.draw(playF);
	  f.draw(g, " EXIT ",245-20, 500,images,25);
	  
	  for (int i = 0; i < 4; i++) {
		  g2.drawImage(Pacman.images.get(20+i),135+80*i,40,80, 80,null);
	

	}
	 
  }

	
}