package gfx;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import models.Input;

public class Menu {
	static List<BufferedImage> images;
	Font f=new Font();
	public Rectangle playA= new Rectangle(250,210,165,50);
	public Rectangle playB= new Rectangle(250,280,165,50);
	public Rectangle playC= new Rectangle(250,350,165,50);
	public Rectangle playD= new Rectangle(250,420,165,50);
	
  public  void Render(Graphics g) {
	 Graphics2D g2=(Graphics2D) g;
	 g2.setColor(Color.ORANGE);
	 f.draw(g, "GAME MENU ",200, 140,images,28);
	 
	  g2.draw(playA);
         
	  
	 if(Input.P) g2.fillRect(250, 210, 165, 50);
	if(Input.A) g2.fillRect(250, 280, 165, 50);
	  if(Input.H) g2.fillRect(250, 350, 165, 50);
	 
	if(Input.E) g2.fillRect(250, 420, 165, 50);
     
	if(Input.ESCAPE==true && Input.play==true  )
	  f.draw(g, " RESUME",238, 220,images,25);
	if(Input.ESCAPE==true && Input.help==true && Input.play==false  )
		  f.draw(g, " PLAY",240, 220,images,25);
	if(Input.ESCAPE==true && Input.audio==true && Input.play==false  )
		  f.draw(g, " PLAY",240, 220,images,25);

	if(Input.ESCAPE==false  )
		  f.draw(g, " PLAY",240, 220,images,25);
	  g2.draw(playB);
	  f.draw(g, " AUDIO  ",240, 290,images,25);
	  
	  g2.draw(playC);
	  f.draw(g, " HELP ",240, 360,images,25);
	  g2.draw(playD);
	 f.draw(g, " EXIT ",240, 430,images,25);
  }
  

	
}