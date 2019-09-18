package gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

public class Help {
	
	
	static List<BufferedImage> images;
	Font f=new Font();
	public  void Render(Graphics g) {
		f.draw(g, "HELP",200, 140,images,30);
		f.draw(g, "appuyer sur Echap pour reafficher le MENU",20, 240,images,10);
		f.draw(g, "les fleches de clavier servent a deplacer le pac man ",20,280,images,10);
		f.draw(g, "pendant le jeu",20, 310,images,10);
		f.draw(g, "stop le jeu par P",20, 340,images,10);
		f.draw(g, "Resume le jeu par R",20, 370,images,10);

	}



}