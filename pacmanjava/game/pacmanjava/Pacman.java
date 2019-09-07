package pacmanjava;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Pacman extends JPanel implements Runnable{
	
	private int x,y;
	
	private int dx,dy,speed;
	
	private boolean left,right,up,down;
	
	private int lives;
	private Color color;
	
	public Pacman() {
		x=100;
		y=200;
		
		dx=0;
		dy=0;
		speed=20;
		
		lives =4;
		color= Color.RED;
	}
	
	public void setLeft(boolean b) {left=b;}
	public void setRight(boolean b) {right=b;}
	public void setUp(boolean b) {up=b;}
	public void setDown(boolean b) {down=b;}
	
	public void update() {
		
		if(left) dx=-speed;
		if(right) dx= speed;
		if(up) dy=-speed;
		if(down) dy=speed;
		
		x+=dx;
		y+=dy;
		if(x<25) x=25;
		if(y<25) y = 25;
		dx=0;
		dy=0;
		
	}
	public void draw (Graphics2D g) {
		g.setColor(color);
		g.fillOval(x, y,25, 25);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	

}
