package pacmanjava;

import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import gfx.Art;
import gfx.GameAnime;
import gfx.Pacman;
import gfx.Screen;
import gfx.Tile;
import gfx.Ui;
import models.Input;

public class GamePanel extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int WIDTH=600 ; 
	public static int HEIGHT=800;
	public static int FontFps =0;
	public Pacman p ;
	public Input i;
	//private Thread animator;
	private  boolean running = false; 

	
	
	Ui inerface;
	
	public GamePanel() {
		p=new  Pacman();
		inerface = new Ui(p);
		i=new Input(this,p);
		
	}
	

	@Override
	public void run() {
		int fps=0,tick=0;
		double fpsTimer=System.currentTimeMillis();

		double nsPerTick = 1000000000.0d/60; 
		double then=System.nanoTime();
		double unprocessed=0;



		while(running) {
			boolean canRender=false;
			
			double now=System.nanoTime();
			unprocessed+=(now-then)/nsPerTick;
			then=now; 
			while(unprocessed>=1) {
				tick++;
				tick();
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
		
	
		g.fillRect(0, 0, this.getHeight(),this.getHeight());
		setBackground(Color.BLACK);
		g.setColor(Color.BLACK);
		
		Ui.render(g, p);
		
		

		g.dispose(); 
		bs.show();

		
		
	
			
	
		
		
		
		
		
		
	}


	private void tick() {
	//	p.move();
		

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
		
		game.start();
		
		


	}

}


