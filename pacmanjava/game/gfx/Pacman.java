
package gfx;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;


//import models.Maze;
import pacmanjava.Sprite;
import gfx.Maze;
import models.GameState;
import models.Input;

/**
 * @author yassine
 *
 */
public class Pacman extends Sprite{





	public final static  int  TILESIZE =96;
	public static List<BufferedImage> images ;
	boolean img=false ;
	public boolean changed=false ;
	public static String direction="STOP";
	int speed=0	;
	private int dirX = 0;
	private int dirY = 0;
	public int psize =30;
	//public static int score =0 ;
	public static Score score =new Score();

	public static boolean upp=true; 
	public static boolean downn=true; 
	public static boolean leftt=true; 
	public static boolean rightt=true; 


	public Dead dd;

	public Pacman() {

		this.posX =285;
		this.posY=476;
		this.direction="STOP";		
		images = new ArrayList<BufferedImage>();
		try {
			BufferedImage originalImgage = ImageIO.read(new File("res/pacmanTiles.png"));
			for (int i = 0; i < originalImgage.getHeight()/TILESIZE; i++) {
				for (int j = 0; j <originalImgage.getWidth()/TILESIZE; j++) {
					BufferedImage SubImgage = originalImgage.getSubimage(TILESIZE*j,i*TILESIZE , TILESIZE, TILESIZE);
					images.add(SubImgage);
				}

			}	


		} catch (IOException e) {
			e.printStackTrace();
		}




	}







	public void draw(Graphics g , String d  ) {


		dd=new Dead(g, this);
		int 	aa = (int)(((posX +25  )/20)%30);
		int 	bb = (int)(((posY+25)/20)%33);

		int x,y,a,b;
		int frameIndex =  (int) (System.nanoTime() * 0.000000006) % 2;


		if(!Ui.nextlevel) {



			switch (d) {



			case "STOP": 
				g.drawImage(images.get(24),posX,posY,psize, psize,null);
				break;


			case "DEAD": 


				for (int i = 0; i < 12; i++) {
					g.drawImage(images.get(32+i),posX,posY,psize, psize,null);

					try{Thread.sleep(100);}catch(Exception e) {}

				}


				break;


			case "RIGHT":






				a = (int)(((posX  +psize -5)/20)%30);
				b = (int)(((posY+15)/20)%33);



				if(frameIndex ==1) {
					g.drawImage(images.get(30),posX,posY,psize, psize,null);


				}
				else if(frameIndex ==0) {
					g.drawImage(images.get(28),posX,posY,psize, psize,null);

				}

				if(!Input.pause&&!Input.inputResume&&!GameState.lostfocus&&!GameState.resume) {
					Ui.status="PLAY";




					if(Maze.maze[b][a] >= 30 || Maze.maze[b][a]==0) {






						speed=2;

						this.setPosX(this.getPosX()+speed);
						if (Maze.maze[bb+1][aa] >0 || Maze.maze[bb+1][aa]<30)
						{
							downn=false;
						}

						else {
							downn=true;
						}

						if (Maze.maze[bb-1][aa] >0 || Maze.maze[bb-1][aa]<30)
						{
							upp=false;
						}
						else {
							upp=true;
						}

						if(Maze.foods[b][a].isVisible) {
							Maze.foods[b][a].isVisible=false;

							switch (Maze.foods[b][a].type) {
							case 1:
								score.bonusGum();
								break;
							case 2:
								score.bonusPacGum();
								break;

							}

						}



					}
				}




				break;



			case "LEFT":







				a = (int)(((posX - speed+5  )/20)%30);
				b = (int)(((posY+5)/20)%33);




				if(frameIndex ==1) {
					g.drawImage(images.get(24),posX,posY,psize, psize,null);

				}
				else if(frameIndex ==0) {
					g.drawImage(images.get(26),posX,posY,psize, psize,null);
				}

				if(!Input.pause&&!Input.inputResume&&!GameState.lostfocus&&!GameState.resume) {
					Ui.status="PLAY";




					if(Maze.maze[b][a] >= 30 || Maze.maze[b][a]==0) {





						speed=2;

						this.setPosX(this.getPosX()-speed);

						if (Maze.maze[bb+1][aa] >0 || Maze.maze[bb+1][aa]<30)
						{
							downn=false;
						}

						else {
							downn=true;
						}

						if (Maze.maze[bb-1][aa] >0 || Maze.maze[bb-1][aa]<30)
						{
							upp=false;
						}
						else {
							upp=true;
						}

						if(Maze.foods[b][a].isVisible) {
							Maze.foods[b][a].isVisible=false;

							switch (Maze.foods[b][a].type) {
							case 1:
								score.bonusGum();
								break;
							case 2:
								score.bonusPacGum();
								break;

							}
						}

					}



				}



				else {
					g.drawImage(images.get(24),posX,posY,psize, psize,null);
				}
				break;


			case "DOWN":

				a = (int)(((posX + speed +10 )/20)%30);
				b = (int)(((posY+psize-5)/20)%33);




				if(frameIndex ==1) {
					g.drawImage(images.get(29),posX,posY,psize, psize,null);


				}
				else if(frameIndex ==0) {
					g.drawImage(images.get(31),posX,posY,psize, psize,null);
				}


				if(!Input.pause&&!Input.inputResume&&!GameState.lostfocus&&!GameState.resume) {
					Ui.status="PLAY";



					if(Maze.maze[b][a] >= 30 || Maze.maze[b][a]==0) {
						speed=2;




						this.setPosY(this.getPosY()+speed);
						if(Maze.foods[b][a].isVisible) {
							Maze.foods[b][a].isVisible=false;

							switch (Maze.foods[b][a].type) {
							case 1:
								score.bonusGum();
								break;
							case 2:
								score.bonusPacGum();
								break;

							}
						}



					}
				}

				break;


			case "UP":

				a = (int)(((posX +10 )/20)%30);
				b = (int)(((posY-speed)/20)%33);





				if(frameIndex ==1) {
					g.drawImage(images.get(25),posX,posY,psize, psize,null);

				}
				else if(frameIndex ==0) {
					g.drawImage(images.get(27),posX,posY,psize, psize,null);
				}

				if(!Input.pause&&!Input.inputResume&&!GameState.lostfocus&&!GameState.resume) {
					Ui.status="PLAY";

					if(Maze.maze[b][a] >= 30 || Maze.maze[b][a]==0) {
						speed=2;


						this.setPosY(this.getPosY()-speed);
						if(Maze.foods[b][a].isVisible) {
							Maze.foods[b][a].isVisible=false;
							switch (Maze.foods[b][a].type) {
							case 1:
								score.bonusGum();
								break;
							case 2:
								score.bonusPacGum();
								break;

							}
						}


					}
				}

				break;

			}


		}

		else if(Ui.nextlevel) {
			this.posX=285;
			this.posY=476;
			g.drawImage(images.get(32),posX,posY,psize, psize,null);

		}
	}




	public void setDirection(String direction) {
		this.direction=direction;
		this.changed=!changed;
	}


	public String getDirection() {
		return this.direction ;

	}















	public void setPosX(int val) {
		this.posX=(val+600)%600;

	}


	public void setPosY(int val) {
		this.posY=(val+800)%800;

	}

}






