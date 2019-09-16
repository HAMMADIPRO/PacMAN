/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 15 Sep 2019 at 09:55:57
 */
package models;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import gfx.Pacman;
import pacmanjava.GamePanel;
import pacmanjava.Sprite;

public class Input implements ActionListener, KeyListener {
	
	
	Pacman pacman;
	
	public Input(GamePanel game, Pacman pacman) {
			
		game.addKeyListener(this);
		this.pacman=pacman;
		
	}
	
	

	
	public enum Direction{
		stop, up,down,right,left
	}
	public Direction dir;

	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub


	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		int c =e.getKeyCode();
		
		
		
		
		
			
		if(c==KeyEvent.VK_R) {
			
			GameState.iconified=!GameState.iconified;
		}
		
	
		
	
		if(c==KeyEvent.VK_LEFT) {
			pacman.setDirection("LEFT");	
			
		}
		
		
		if(c==KeyEvent.VK_RIGHT) {
			pacman.setDirection("RIGHT");
			
		}
		
		
		if(c==KeyEvent.VK_UP) {
			pacman.setDirection("UP");	
			
		}
		
		
		if(c==KeyEvent.VK_DOWN) {
			pacman.setDirection("DOWN");
			
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		pacman.changed=false;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	

	}


}


