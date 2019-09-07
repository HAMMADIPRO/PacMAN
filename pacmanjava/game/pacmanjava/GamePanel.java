package pacmanjava;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	static Window w ;
	public static int WIDTH=600 ; //size of the window
	public static int HEIGHT=800;
	
	public static int pWIDTH = 600; //size of the panel
	public static int pHEIGHT= 800;
	
	private Thread animator;
	private volatile boolean running = false; // stops the animation
	
	// global variables for off-screen rendering
	private Graphics2D g;
	private BufferedImage image ;
	
	private int FPS=60;
	//period in milliseconds
	private int period=1000/FPS;
	
	private TileMap tileMap;
	private Pacman pac;
	
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(pWIDTH,pHEIGHT));
		setFocusable(true); 
		requestFocus();	
	}
	
	public void addNotify( )
	// Wait for the JPanel to be added to the JFrame before starting. 
	{	
		super.addNotify( ); 
		startGame( );

	}
	
	private void startGame( )
	{
		if (animator == null || !running)
		{	
			animator = new Thread(this);
			animator.start( );
		}
	}
	
	public void stopGame( )
	{ running = false; }

	@Override
	public void run() {
		
		init();
		
		long startTime, timeDiff, sleepTime;
		
		while(running) {
			startTime=System.nanoTime();
			w =Window.getWindows()[0];
			WIDTH=w.getWidth() ; //size of the window
			HEIGHT=w.getHeight();
			
			gameUpdate( ); 
			gameRender( ); 
			draw(); 
			// time difference in milliseconds
			timeDiff= (System.nanoTime()-startTime)/1000000;
			sleepTime=period-timeDiff;
			if(sleepTime>0) {
			try {
				Thread.sleep(sleepTime); // sleep a bit
			}
			catch(InterruptedException ex){System.out.println("threaD PROB");}
			}
		}
	}
	
	private void init() {
		running = true;
		image= new BufferedImage(pWIDTH, pHEIGHT, BufferedImage.TYPE_INT_RGB);
		g= (Graphics2D) image.getGraphics();
		pac = new Pacman();
		tileMap = new TileMap(20);
		tileMap.loadMap();
		
		
	}
	//////////////////////////////////////////////
	
	
	private void gameUpdate() {
		
		tileMap.update();
		pac.update();
	}
	
	private void gameRender() {
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 1000, 600);
		tileMap.draw(g);
		pac.draw(g);
	
		
			
	}
	
	private void draw() {
		
		Graphics2D g2 =(Graphics2D) getGraphics();
		g2.drawImage(image, (WIDTH/2)-(pWIDTH/2), 0, null);
		//System.out.println(WIDTH+"  "+HEIGHT);
		g2.dispose();
	
		
	
	}
	
	
	

	


	
}
