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
import gfx.Ui;
import pacmanjava.GamePanel;
import pacmanjava.Sprite;
import pacmanjava.GamePanel.STATE;

public class Input implements ActionListener, KeyListener {


	Pacman pacman;

	public static boolean ESCAPE=false;

	public static boolean pause=false;
	public static boolean inputResume=false;
	private String musicOnOff ="ON";
	

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


		
		if(c==KeyEvent.VK_M) {
				if(musicOnOff.equals("OFF")) {
					GamePanel.audiothreadMusic.setMuteo(false);
					GamePanel.audiothreadMusic.setVol(40);
					musicOnOff="ON";
					
					
				}
				
				
				else if(musicOnOff.equals("ON")) {
					GamePanel.audiothreadMusic.setMuteo(true);
					GamePanel.audiothreadMusic.setVol(0);
					musicOnOff="OFF";
					
				}

		}

		if(c==KeyEvent.VK_P&&GamePanel.state==GamePanel.STATE.Game) {
			pause=true;

		}


		if(c==KeyEvent.VK_P&&GamePanel.state==GamePanel.STATE.Menu ) {
			GamePanel.state=GamePanel.STATE.Game;
			ESCAPE=false;



		}

		if(c==KeyEvent.VK_R&&GamePanel.state==GamePanel.STATE.Game  ) {
			pause=false;
			inputResume=true;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}	

		}

		inputResume=false;

		if(pause==false) {




			if(c==KeyEvent.VK_LEFT&&Ui.tunnelleft()) {
				pacman.setDirection("LEFT");	

			}


			if(c==KeyEvent.VK_RIGHT&&Ui.tunneright()) {
				pacman.setDirection("RIGHT");

			}


			if(c==KeyEvent.VK_UP) {
				pacman.setDirection("UP");	

			}


			if(c==KeyEvent.VK_DOWN) {
				pacman.setDirection("DOWN");

			}

		}



		if(c==KeyEvent.VK_ESCAPE) {

			GamePanel.state=GamePanel.STATE.Menu;
			ESCAPE=true;
		}


		if(c==KeyEvent.VK_H) {

			GamePanel.state=GamePanel.STATE.Help;
			
		}
		
		
		
		
		if(c==KeyEvent.VK_E) {

			System.exit(0);
			
		}
		
		if(c==KeyEvent.VK_R&&GamePanel.state==GamePanel.STATE.Menu  ) {
			GamePanel.state=GamePanel.STATE.Game;
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


