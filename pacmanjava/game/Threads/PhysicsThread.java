package Threads;



import java.awt.Rectangle;


public class PhysicsThread extends Thread{

	
	private volatile boolean isRunning=false;

	
	public synchronized void stopThread() {
		isRunning=false;
	}
	
	
	public static Rectangle sgh1() {
		return new Rectangle(RenderThread.gh1.x, RenderThread.gh1.y,30, 30);
	}

	public static Rectangle sgh2() {
		return new Rectangle(RenderThread.gh2.x, RenderThread.gh2.y,30, 30);
	}

	public static Rectangle sgh3() {
		return new Rectangle(RenderThread.gh3.x, RenderThread.gh3.y,30, 30);
	}

	public static Rectangle sgh4() {
		return new Rectangle(RenderThread.gh4.x, RenderThread.gh4.y,30, 30);
	}

	
	public static Rectangle pac() {
		return new Rectangle(RenderThread.p.getPosX(), RenderThread.p.getPosY(),30, 30);
	}

	
	
	@Override
	public void run() {
		
	}

public static  int collision() {
	
	
	

	

		if( pac().intersects(sgh1())|| pac().intersects(sgh2())|| pac().intersects(sgh3())|| pac().intersects(sgh4())) {
			
			return 1;
			
		}
			return 0;
	

	}

}