/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 14 Sep 2019 at 01:14:48
 */
package gfx;

import java.awt.Graphics;


public class GameAnime extends Thread {

	private Pacman p;
	private Graphics g;

	private volatile boolean isRunning = false;



	public GameAnime(Pacman p,Graphics g) {
		this.p = p;
		this.g=g;
	}
	public void stopThread() {

		isRunning= false;
	}
	boolean a=false;
	public void run() {

		isRunning= true;
		while(isRunning) {
		
		//	p.draw(g);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}