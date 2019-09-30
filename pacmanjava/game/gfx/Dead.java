package gfx;

import java.awt.Graphics;

public class Dead extends Thread  {

	private int iCount =0;
	private volatile boolean isRunning=false;
	private boolean bPaused = false;

	Graphics g;
	Pacman p;
	
	public Dead (Graphics g, Pacman p) {
		
		this.g=g;
		
		this.p=p;
	}
	
	public synchronized int getiCount () {
		return iCount;
	}
	
	public synchronized void stopThread() {
		isRunning=false;
	}
	public synchronized boolean isPaused()
	{
		return bPaused;
	}
	
	public synchronized void Pause()
	{
		bPaused = true;
	}
	
	public synchronized void Resume()
	{
		bPaused = false;
	}
	
	

	
	
	@Override
	public void run() {
		isRunning=true;
		
		
		
		while (isRunning) {
			
			
		
				
			for (int i = 0; i < 12; i++) {
				g.drawImage(p.images.get(32+i),p.getPosX(),p.getPosY(),p.psize, p.psize,null);
				
				try{Thread.sleep(1000);}catch(Exception e) {}
				System.out.println(i);
			}
				
				
			
			
		
			
		}
			
		
		
		isRunning =false;
		
	}
}
