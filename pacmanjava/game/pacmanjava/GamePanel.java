package pacmanjava;

import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import Threads.AudioThread;
import gfx.Blinky;
import gfx.Clyde;
import gfx.Ghost;
import gfx.Help;
import gfx.Inky;
import gfx.Pacman;
import gfx.Pinky;
import gfx.Menu;

import gfx.Ui;
import models.GameState;
import models.Input;



public class GamePanel extends Canvas implements Runnable{

	
	private static final long serialVersionUID = 1L;
	public static int WIDTH=600 ; 
	public static int HEIGHT=800;
	public static int FontFps =0;
	public static  Pacman p ;
	public static Ghost gh1;
	public static Ghost gh2;
	public static Ghost gh3;
	public static Ghost gh4;
	public Input i;
	//private Thread animator;
	public  static boolean running = false; 
	public static int r=0;
	Menu menu ;
	Help help ;
	public static AudioThread audiothreadMusic ;
	public static AudioThread audiothreadSound ;

	
	public static enum STATE {
		Menu,
		Game,
		Help
	};
	
	public static STATE state = STATE.Menu;
	
	
	
	
	
	public 	static boolean paused =false ;
	
	
	Ui inerface;
	
	public GamePanel() {
		p=new  Pacman();
		 gh1=new Blinky(280,260);
		 gh2=new Clyde(310,300);
		 gh3=new Inky(310,300);
		 gh4=new Pinky(310,300);
		
		inerface = new Ui(p, gh1, gh2, gh3, gh4);
		i=new Input(this,p);
	
		menu =new Menu() ;
		help = new Help() ;
		
		
		
	}
	
	
	
	
	

	@Override
	public void run() {
		int fps=0,tick=0;
		double fpsTimer=System.currentTimeMillis();

		double nsPerTick = 1000000000.0d/60; 
		double then=System.nanoTime();
		double unprocessed=0;
		
		
		Ui.init();



		while(running) {
			boolean canRender=false;
			
			double now=System.nanoTime();
			unprocessed+=(now-then)/nsPerTick;
			then=now; 
			while(unprocessed>=1) {
				tick++;
				if(state==STATE.Game) {
					tick();
				}
				
				canRender=true;
				--unprocessed;
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if(canRender) {
				fps++;
				render();
			}
			if(System.currentTimeMillis()-fpsTimer>1000) {
			//	System.out.printf("%d fps, %d tick %n" ,fps,tick );
				FontFps=fps;
				fps=0;tick=0;
				fpsTimer+=1000;
			
				
			
				
			}

		}
		
	
	}



	private void render() {
		
		BufferStrategy bs=getBufferStrategy();
		if(bs==null) {
			createBufferStrategy(3);
			requestFocus();
			return;
		}
		
		Graphics g=bs.getDrawGraphics();
		setBackground(Color.BLACK);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getHeight(),this.getHeight());

		if(state==STATE.Game) {
		Ui.render(g, p);
		
	
		
	//	audiothreadMusic=new AudioThread(".//res//pacman_beginning.wav");
	//	audiothreadMusic.setMusic(true);
	//	audiothreadMusic.start();
		
	//	audiothreadSound = new AudioThread(".//res//pacman_chomp.wav");
	//	audiothreadSound.setMusic(false);
		//  audiothreadSound.start();
		
		
		}
		
		if(state==STATE.Menu) {
			menu.Render(g);
			
		}
		
		else if (state==STATE.Help) {
			help.Render(g);
		}
		

		g.dispose(); 
		bs.show();

		
		
	
			
	
		
		
		
		
		
		
	}


	private void tick() {
	//	p.move();
		//System.out.println(1111);
		

	}

	public void start() {
		running =true;
		new Thread(this).start();

	}


	public void stop() {
		running=false;

	}

	
	
	
	public static void main(String[] args) {
		
	
		GamePanel game =new GamePanel();		
		Dimension demesion =new Dimension(WIDTH,HEIGHT);
		game.setMaximumSize(demesion);	 
		game.setMinimumSize(demesion);
		game.setSize(demesion);
		
		JFrame window=new JFrame();
		window.setTitle("PACMAN");
		window.add(game);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		GameState gamestate = new GameState();
		window.addWindowListener(gamestate);
		window.addWindowFocusListener(gamestate);
		window.addWindowStateListener(gamestate);
		
		
		
	
		game.start();
		
		


	}

}


