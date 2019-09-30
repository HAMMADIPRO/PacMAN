


package gfx;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

public class Help {
	static List<BufferedImage> images;
	Font f=new Font();
	public Rectangle BACK= new Rectangle(220,650,165,50);
	public  void Render(Graphics g) {
	Graphics2D g2=(Graphics2D) g;
	g2.setColor(Color.BLUE);
	f.draw(g, "HELP",200, 140,images,30);
	f.draw(g, "Echap to redesplay the MENU",20, 250,images,10);
	f.draw(g, "In game Right Arrow - pacman moves to the right ",20,280,images,10);
	f.draw(g, "In Game Left Arrow - pacman moves to the left",20, 310,images,10);
	f.draw(g, "In Game Up Arrow  - pacman moves up",20, 340,images,10);
	f.draw(g, "In Game Down Arrow - pacman moves down",20, 370,images,10);
	f.draw(g, "Key 'P' - Pause",20, 400,images,10);
	f.draw(g, "Key 'R' - Resume",20, 430,images,10);
	f.draw(g, "Key 'M' - Mute",20, 460,images,10);
	f.draw(g, "Key 'E' - Exit",20, 500,images,10);
	f.draw(g, "Right Arrow - increases sound",20, 530,images,10);
	f.draw(g, "left Arrow - decreases sound",20, 560,images,10);
	f.draw(g, "Key H - Display the HELP",20, 600,images,10);
	  
	  
	
	  g2.draw(BACK);
	  
	  g2.fillRect(220,650,165,50);
	  f.draw(g, "BACK",245, 660,images,30);
	  
	}
	
	
	
}

