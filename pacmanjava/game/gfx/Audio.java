package gfx;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

import models.Input;

public class Audio {
	static List<BufferedImage> images;
	Font f=new Font();
	public Rectangle A1= new Rectangle(200,210,235,40);
	public Rectangle A2= new Rectangle(200,280,235,40);
	public Rectangle A3= new Rectangle(200,350,235,40);
	public Rectangle A4= new Rectangle(200,420,235,40);
	public Rectangle BACK= new Rectangle(220,550,165,50);
	public  void Render(Graphics g) {
	Graphics2D g2=(Graphics2D) g;
	g2.setColor(Color.ORANGE);
	g2.draw(A1);
	g2.draw(A2);
	g2.draw(A3);
	g2.draw(A4);
	if(Input.P) g2.fillRect(200, 210, 235, 40);
	if(Input.A) g2.fillRect(200, 280, 235, 40);
	if(Input.H) g2.fillRect(200, 350, 235, 40);
	if(Input.E) g2.fillRect(200, 420, 235, 40);
	f.draw(g, "AUDIO",230, 140,images,30);
	f.draw(g, "MUSIC ",210, 220,images,18);
	f.draw(g, "SOUND ",210, 290,images,18);
	f.draw(g, "MUSIC ",210, 360,images,18);
	f.draw(g, "SOUND ",210, 430,images,18);
	
	f.draw(g, "         "+Input.musicOnOff,210, 360,images,18);
	f.draw(g, "         "+Input.musicOnOffS,210, 430,images,18);
	
	f.draw(g, "        "+Input.son,210, 220,images,18);
	f.draw(g, "        "+Input.sonS,210, 290,images,18);
	g2.draw(BACK);
	  g2.fillRect(220,550,165,50);
	  f.draw(g, "BACK",245, 560,images,30);
	}

	
}
