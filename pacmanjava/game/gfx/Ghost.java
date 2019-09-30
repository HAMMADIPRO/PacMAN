package gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import models.GameState;
import models.Input;




public abstract class Ghost {

	protected ArrayList<BufferedImage> img;
	List<Integer> vg=new ArrayList<Integer>();

	protected final int LEFT=0;  
	protected final int UP=1;
	protected final int RIGHT=2;
	private final int DOWN=3;

	public int ghSize =30;
	private int SPEED=2;

	public int x;
	public int y;
	public int numImg ;
	Random rand;





	public Ghost (int x, int y) {
		this.x=x;
		this.y=y;
		loadGhostImg();
		rand = new Random(); 
		vg.add(0);vg.add(1);vg.add(2);vg.add(3);

	}





	public Ghost randomOut() {
		Ghost gh = null;
		int n=vg.size();
		while(n!=0) {

			int g = rand.nextInt(n);
			int ghost=vg.get(g);
			vg.remove(ghost);
			switch (ghost) {
			case 0:
				gh=new Blinky(280, 260);
				break;
			case 1:
				gh= new Clyde(280, 260);
				break;
			case 2:
				gh= new Inky(280, 260);
				;
				break;
			case 3:
				gh= new Pinky(280, 260);
				break;
			}

		}
		return gh;
	}
	private final int COUNT_MAX=40;
	private int count=COUNT_MAX;
	private int direction=0 ;

	public void randomDirect() {

		count=COUNT_MAX;
		direction= rand.nextInt(4); 	

	}




	public synchronized void draw(Graphics g  ) {

		int a,b;
		int frameIndex = (int) (System.nanoTime() * 0.000000006) % 2;
		count--;
		if(count<=0) { 
			randomDirect();
		}

	

		switch (direction) {

		case RIGHT:	
			a = (int)(((x +ghSize -5)/20)%30);
			b = (int)(((y+15)/20)%33);

			if(frameIndex ==1) {
				g.drawImage(img.get(numImg),x,y,ghSize,ghSize,null);

			}
			else if(frameIndex ==0) {
				g.drawImage(img.get(numImg+1),x,y,ghSize, ghSize,null);

			}
			if(!Input.pause&&!Input.inputResume&&!GameState.lostfocus&&!GameState.resume) {
			if(Maze.maze[b][a] >= 30 || Maze.maze[b][a]==0) {
				//SPEED=5;
				x+=SPEED;	
			}
			else {count=0;}}
			break;


		case DOWN:

			a = (int)(((x+ SPEED +10 )/20)%30);
			b = (int)(((y+ghSize-5)/20)%33);

			if(frameIndex ==1) {
				g.drawImage(img.get(numImg+2),x,y,ghSize,ghSize,null);

			}
			else if(frameIndex ==0) {
				g.drawImage(img.get(numImg+3),x,y,ghSize, ghSize,null);
			}
			if(!Input.pause&&!Input.inputResume&&!GameState.lostfocus&&!GameState.resume) {
			if(Maze.maze[b][a] >= 30 || Maze.maze[b][a]==0) {
				//SPEED=1;
				y+=SPEED;

			}
			else {count=0;}}

			break;


		case LEFT:

			a = (int)(((x- SPEED +5  )/20)%30);
			b = (int)(((y+5)/20)%33);

			if(frameIndex ==1) {
				g.drawImage(img.get(numImg+4),x,y,ghSize,ghSize,null);

			}
			else if(frameIndex ==0) {
				g.drawImage(img.get(numImg+5),x,y,ghSize, ghSize,null);
			}
			if(!Input.pause&&!Input.inputResume&&!GameState.lostfocus&&!GameState.resume) {

			if(Maze.maze[b][a] >= 30 || Maze.maze[b][a]==0) {
				//SPEED=1;
				x-=SPEED;	
			}
			else {count=0;}}
			break;


		case UP:

			a = (int)(((x +10 )/20)%30);
			b = (int)(((y-SPEED)/20)%33);

			if(frameIndex ==1) {
				g.drawImage(img.get(numImg+6),x,y,ghSize, ghSize,null);

			}
			else if(frameIndex ==0) {
				g.drawImage(img.get(numImg+7),x,y,ghSize, ghSize,null);
			}
			if(!Input.pause&&!Input.inputResume&&!GameState.lostfocus&&!GameState.resume) {

			if(Maze.maze[b][a] >= 30 || Maze.maze[b][a]==0) {
				//SPEED=1;
				y-=SPEED;

			}
			else {count=0;}
			}
			break;
		}

	}
	




	public void loadGhostImg() {
		int  TILESIZE =96;

		img = new ArrayList<BufferedImage>();
		try {
			BufferedImage originalImgage = ImageIO.read(new File("res/pacmanTiles.png"));
			for (int i = 0; i < originalImgage.getHeight()/TILESIZE; i++) {
				for (int j = 0; j <originalImgage.getWidth()/TILESIZE; j++) {
					BufferedImage SubImgage = originalImgage.getSubimage(TILESIZE*j,i*TILESIZE , TILESIZE, TILESIZE);
					img.add(SubImgage);
				}

			}	


		} catch (IOException e) {
			e.printStackTrace();
		}





	}



}