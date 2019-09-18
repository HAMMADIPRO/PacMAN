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

	public static Input i;
	public static  Pacman p ;
	static Ui inerface;
	static List<BufferedImage> images;
	static Maze m;
	public static int lives =3;
	public static GameState gamestate ;
	public static boolean dresume=false;
	public static int level=1;
	public static String status ="PLAY";
	public static int  foc=0;
	public static GamePanel gp ;
	public static boolean nextlevel =false;


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
		for (int i = 0; i < p.score.getNbLife(); i++) {
			g.drawImage(Pacman.images.get(30),100+40*i,740 ,30, 30,null);
		}


		f.draw(g, "LIVES ",5, 750,images,15);


		f.draw(g, "FPS ",370, 750,images,15);


		f.draw(g, String.valueOf(GamePanel.FontFps),500, 750,images,15);

		f.draw(g, "Level ",5, 670,images,15); 



		int a=0;


		switch (p.score.getScore()) {

		case 282:
			nextlevel=true;
			p.score.setScore(282+1);
			level+=1;
			p=new Pacman();
			inerface = new Ui(p);
			gamestate =new GameState();
			p.draw(g, p.direction);
			m= new Maze(20, 0, 0, images);

			m.draw(g);

			break;

		case 565:
			nextlevel=true;
			p.score.setScore(565+1);
			level+=1;
			p=new Pacman();
			inerface = new Ui(p);
			gamestate =new GameState();
			p.draw(g, p.direction);
			m= new Maze(20, 0, 0, images);

			m.draw(g);

			break;

		case  282+1 : 

			nextlevel=false;
		p.setPosX (285);
		p.setPosY(476);
		p.setDirection("STOP");
		status="STOP";


		case  565+1 : 

			nextlevel=false;
		p.setPosX (285);
		p.setPosY(476);
		p.setDirection("STOP");
		status="STOP";
		}





		String s= ""+level;	





		String ss=""+p.score ;




		f.draw(g, s ,120, 670,images,15); 



		f.draw(g, "SCORE",5, 710,images,15); 
		f.draw(g, ss,120, 710,images,15); 





		f.draw(g, status ,500, 670,images,15); 
		f.draw(g, "status" ,370, 670,images,15);


		inerface = new Ui(p);
		gamestate =new GameState();

		p.draw(g, p.direction);






		if(i.pause) {
			f.draw(g, "Pause" ,180, 340,images,50);
			status="pause";
		}

		if(gamestate.lostfocus&&!gamestate.iconified) {
			f.draw(g, "Pause" ,180, 340,images,50);
			status="Resume";
		}

		if(i.inputResume||gamestate.resume) {
			f.draw(g, "Resume" ,180, 340,images,50);
			status="Resume";
		}


	}
	public static boolean  tunneright() {

		if(p.getPosX()>460&&p.getPosY()<310&&p.getPosY()>270&&p.getDirection()=="LEFT") {
			return false ;
		}

		return true;



	}



	public static boolean  tunnelleft() {

		if(p.getPosX()<120&&p.getPosY()<310&&p.getPosY()>270&&p.getDirection()=="RIGHT") {
		
			return false ;
		}

		return true;



	}





}






