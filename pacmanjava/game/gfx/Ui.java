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

import models.GameState;
import models.Input;
import pacmanjava.GamePanel;

public class Ui {

	public Input i;
	public Pacman p ;
	static Ui inerface;
	static List<BufferedImage> images;
	static Maze m;
	public static int lives =3;
	public static GameState gamestate ;

	public Ui(Pacman p) {

		this.p = p;


	}

	public static  void init() {

		images = new ArrayList<BufferedImage>();


		//20 size , x= 0 , y=50  
		m= new Maze(20, 0, 0, images);

	}


	public static  void render(Graphics g, Pacman p) {




		m.draw(g);


		Font f=new Font();

		//drraw pacman lives 
		for (int i = 0; i < lives; i++) {
			g.drawImage(Pacman.images.get(30),100+40*i,740 ,30, 30,null);
		}


		f.draw(g, "LIVES ",5, 750,images,15);

		f.draw(g, "FPS ",450, 750,images,15);

		f.draw(g, String.valueOf(GamePanel.FontFps),500, 750,images,15);

		inerface = new Ui(p);
		gamestate =new GameState();

		p.draw(g, p.direction);




		if(!gamestate.focus) {

			f.draw(g, "PAUSE ",600/2-100, 800/2-45,images,40);

		}



		if(!gamestate.iconified) {

			int frameIndex =  (int) (System.nanoTime() * 0.0000000006) %3;
			System.out.println(frameIndex);
			
			switch (frameIndex) {
			
			case 0:f.draw(g,  "3",600/2-35, 800/2-45,images,70);	
			break;

			case 1:f.draw(g,  "2",600/2-35, 800/2-45,images,70);
			break;
			
			case 2 :f.draw(g,  "1",600/2-35, 800/2-45,images,70);
			gamestate.iconified=true;
			break;

			
			
		
				
			}

			


				


		}






	}










}







