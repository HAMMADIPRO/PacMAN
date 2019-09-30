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
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Threads.PhysicsThread;
import Threads.RenderThread;
import models.GameState;
import models.Input;

public class Ui {

	public static Input i;
	public static  Pacman p ;
	public static Ghost gh1;
	public static Ghost gh2;
	public static Ghost gh3;
	public static Ghost gh4;
	static Ui inerface;
	static List<BufferedImage> images;
	static Maze m;
	public static int lives =3;
	public static GameState gamestate ;
	public static boolean dresume=false;
	public static int level=1;
	public static String status ="PLAY";
	public static int  foc=0;
	public static RenderThread gp ;
	public static boolean nextlevel =false;
	public static int nbout=0;
	public static int fpss=0;
    public static int count =0;
	public Ui(Pacman p, Ghost gh1, Ghost gh2,  Ghost gh3 , Ghost gh4) {

		this.p = p;
		this.gh1=gh1;
		this.gh2=gh2;
		this.gh3=gh3;
		this.gh4=gh4;




	}

	public static  void init() {

		images = new ArrayList<BufferedImage>();



		//20 size , x= 0 , y=50  
		m= new Maze(20, 0, 0, images);

	}


	public static  void render(Graphics g, Pacman p) {

		count++;

		m.draw(g);


		Font f=new Font();

		


		f.draw(g, "LIVES ",370, 670,images,15);


		f.draw(g, "FPS ",370, 750,images,15);


		f.draw(g, String.valueOf(RenderThread.FontFps),500, 750,images,15);

		f.draw(g, "Level ",5, 670,images,15); 


		fpss=RenderThread.FontFps;
		
		String s= ""+level;	





		String ss=""+p.score ;




		f.draw(g, s ,100, 670,images,15); 



		f.draw(g, "SCORE",160, 670,images,15); 
		f.draw(g, ss,250, 670,images,15); 





		f.draw(g, "status", 5, 750,images,15); 
		f.draw(g, status ,120, 752 ,images,15);
		



		switch (p.score.getScore()) {

		case 282:
			nextlevel=true;
			p.score.setScore(282+1);
			level+=1;
			p=new Pacman();
			inerface = new Ui(p, gh1,gh2,gh3, gh4);
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
			inerface = new Ui(p, gh1,gh2,gh3, gh4);
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

		
		int col =PhysicsThread.collision();
		
		
		switch (col) {
		case 1:
			//p=new Pacman();
			
			p.setDirection("STOP");
			
			
			p.setPosX (285);
			p.setPosY(476);
			inerface = new Ui(p,gh1,gh2,gh3,gh4);
			
			 gamestate =new GameState();
		 	 p.draw(g, "STOP");
		 	
			m= new Maze(20, 0, 0, images);
			
			 
			gh1.draw(g);
			gh2.draw(g);
			gh3.draw(g);
			gh4.draw(g);

			m.draw(g);
			
			
			lives-=1;
			RenderThread.test=true;
			
			break;

		
			
			
		}
		


		//drraw pacman lives 
				for (int i = 0; i < lives; i++) {
					g.drawImage(Pacman.images.get(30),470+40*i,660 ,30, 30,null);
					
					
					
					
				}
		

		inerface = new Ui(p,gh1,gh2,gh3,gh4);
		gamestate =new GameState();

		p.draw(g, p.direction);
		gh1.draw(g);
		gh2.draw(g);
		gh3.draw(g);
		gh4.draw(g);



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

		
		if(lives<=0) {
			f.draw(g, "Game Over" ,40, 340,images,50);
			status="game over";
			
			
			RenderThread.state=RenderThread.STATE.Menu;
		}

	//if(p.score.getScore()==1||GamePanel.test) {

			
		if(count==50)	{
			count=0;

			boolean out[]=new boolean[4];

			while(nbout<4) {
				
				
				Random r=new Random();
				int rr=r.nextInt(4);
				
				
						
						if(rr==0 &&!out[0]) {
							gh1.x=280;
							gh1.y=260;
							out[0]=true;
							nbout++;
							
					}

						if(rr==1 &&!out[1]) {
							gh2.x=280;
							gh2.y=260;
							nbout++;
							out[1]=true;
						}

						if(rr==2 &&!out[2]) {
							gh3.x=280;
							gh3.y=260;
							nbout++;
							out[2]=true;
							
						}

						if(rr==3 &&!out[3]) {
							gh4.x=280;
							gh4.y=260;
							nbout++;
							out[3]=true;
						}
						}
						
					
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






